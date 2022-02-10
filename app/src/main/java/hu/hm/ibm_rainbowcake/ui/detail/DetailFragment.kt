package hu.hm.ibm_rainbowcake.ui.detail

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.hilt.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import hu.hm.ibm_rainbowcake.R
import hu.hm.ibm_rainbowcake.data.model.Item
import hu.hm.ibm_rainbowcake.databinding.FragmentDetailBinding
import timber.log.Timber

@AndroidEntryPoint
class DetailFragment(
    private val item: Item
) : RainbowCakeFragment<DetailViewState, DetailViewModel>(){

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_detail

    private lateinit var binding: FragmentDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        setupToolbar()
    }

    override fun onStart() {
        super.onStart()
        viewModel.load(item)
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            navigator?.pop()
        }
    }

    override fun render(viewState: DetailViewState) {
        Timber.d("Received item to display")

        binding.tvTitle .text = item.title
        binding.dateIconImage.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_calendar, null))
        binding.tvUserName.text = item.userName
        binding.tvDate.text = item.created
        binding.tvDesc.text = item.description
        binding.tvDuration.text = item.durationInSec.toString()
        binding.tvEmail.text = item.email
        binding.tvType.text = item.mediaType
        Glide.with(binding.ivItemDetail)
            .load(item.avatarURL)
            .placeholder(R.drawable.default_image)
            .into(binding.ivItemDetail)
    }
}