package hu.hm.ibm_rainbowcake.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hu.hm.ibm_rainbowcake.R
import hu.hm.ibm_rainbowcake.data.model.Item
import hu.hm.ibm_rainbowcake.databinding.RowItemBinding

class ListAdapter : ListAdapter<Item, hu.hm.ibm_rainbowcake.ui.list.ListAdapter.ViewHolder>(
    ArticlePreviewComparator
) {

    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.item = item

        holder.titleText.text = item.title
        holder.dateText.text = item.created
        holder.bylineText.text = item.userName

        Glide.with(holder.articleImage)
            .load(item.avatarURL)
            .placeholder(R.drawable.default_image)
            .into(holder.articleImage)
    }

    inner class ViewHolder(binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val titleText: TextView = binding.tvTitle
        val bylineText: TextView = binding.tvUserName
        val dateText: TextView = binding.dateText
        val articleImage: ImageView = binding.ivItem

        var item: Item? = null

        init {
            itemView.setOnClickListener {
                item?.let { item -> listener?.onItemSelected(item) }
            }
        }
    }

    interface Listener {
        fun onItemSelected(item: Item)
    }

}
