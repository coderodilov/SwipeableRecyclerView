package uz.coderodilov.swipeablerecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apachat.swipereveallayout.core.SwipeLayout
import com.apachat.swipereveallayout.core.ViewBinder
import uz.coderodilov.swipeablerecyclerview.R
import uz.coderodilov.swipeablerecyclerview.model.SampleModel
import uz.coderodilov.swipeablerecyclerview.databinding.ItemSampleBinding

class Adapter(private var list: List<SampleModel>):RecyclerView.Adapter<Adapter.ViewHolder>() {

    //Object of ViewBinder class of library to set auto close settings
    private val viewBinderHelper: ViewBinder = ViewBinder()

    inner class ViewHolder(private val binding: ItemSampleBinding):RecyclerView.ViewHolder(binding.root){
        //Object of swipe able layout for controlling open,close
        val swipeLayout: SwipeLayout = itemView.findViewById(R.id.swipeLayout)
        fun onBind(sampleModel: SampleModel){
            binding.tvItemSample.text = sampleModel.sample
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSampleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])

        //Setting auto close other layout items
        viewBinderHelper.setOpenOnlyOne(true)

        //Binding item details to controlling specific item
        viewBinderHelper.bind(holder.swipeLayout, list[position].sample)
        viewBinderHelper.closeLayout(list[position].sample)
    }
}

