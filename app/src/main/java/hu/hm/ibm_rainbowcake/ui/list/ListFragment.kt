package hu.hm.ibm_rainbowcake.ui.list

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.hilt.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import dagger.hilt.android.AndroidEntryPoint
import hu.hm.ibm_rainbowcake.R
import hu.hm.ibm_rainbowcake.data.model.Item
import hu.hm.ibm_rainbowcake.databinding.FragmentListBinding
import hu.hm.ibm_rainbowcake.ui.detail.DetailFragment
import hu.hm.ibm_rainbowcake.utils.isNetAvailable
import hu.hm.ibm_rainbowcake.utils.toast
import timber.log.Timber

@AndroidEntryPoint
class ListFragment : RainbowCakeFragment<ListViewState, ListViewModel>(), ListAdapter.Listener {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_list

    private lateinit var adapter: ListAdapter
    private lateinit var binding: FragmentListBinding

    var loadingMore = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        setupToolbar()
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()

        if(isNetAvailable()){
            try {
                viewModel.load()
            } catch (e: Exception) {
                toast( e.localizedMessage)
            }
        } else {
            toast(getString(R.string.no_internet))
        }
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.toolbar.inflateMenu(R.menu.menu_list)
    }

    private fun setupRecyclerView() {
        adapter = ListAdapter()
        adapter.listener = this
        binding.rwItemList.addOnScrollListener(ListPagination {
            if(!loadingMore) {
                Timber.d("Loading more items")
                viewModel.loadMore()
            }
        })
        binding.rwItemList.adapter = adapter

        binding.swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.colorAccent))
        binding.swipeRefreshLayout.setOnRefreshListener {
            if(isNetAvailable()) viewModel.load()
            else {
                toast(getString(R.string.no_internet))
                binding.swipeRefreshLayout.isRefreshing = false
            }
        }
    }

    override fun render(viewState: ListViewState) {
        Timber.d("Received ${viewState.items.size} articles to display in list")
        adapter.submitList(viewState.items)
        binding.swipeRefreshLayout.isRefreshing = viewState.isRefreshing
        loadingMore = viewState.isLoadingMore
        if(loadingMore)
            binding.progressbar.visibility = ProgressBar.VISIBLE
        else binding.progressbar.visibility = ProgressBar.GONE
    }

    override fun onItemSelected(item: Item) {
        Timber.d("Item ${item.title} selected")
        navigator?.add(DetailFragment(item))
    }

}
