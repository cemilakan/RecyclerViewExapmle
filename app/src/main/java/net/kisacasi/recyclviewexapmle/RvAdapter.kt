package net.kisacasi.recyclviewexapmle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item.view.*

class RvAdapter(
private val responseList:List<RvItem>
) :RecyclerView.Adapter<RvAdapter.AdapterViewHolder>(){

    inner class AdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.AdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
        return AdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return responseList.size

    }

    override fun onBindViewHolder(holder: RvAdapter.AdapterViewHolder, position: Int) {
        val currentValue=responseList[position]
        holder.itemView.apply {
            rv_item_img.setImageResource(currentValue.imageResource)
            rv_item_title.text=currentValue.title
            rv_item_subtitle.text=currentValue.subTitle
            rv_item_root.setOnClickListener {
                onItemClickListener?.let {
                    it(responseList[position])
                }
            }
        }
    }

    private var onItemClickListener: ((RvItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (RvItem) -> Unit) {
        onItemClickListener = listener
    }

}