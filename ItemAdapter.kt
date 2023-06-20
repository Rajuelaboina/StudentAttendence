package com.raju.multipleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ItemAdapter(private var itemList: ArrayList<Item>) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == TYPE_ONE){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_one,parent,false)
            return ViewHolderOne(view)
        }else if (viewType == TYPE_TWO){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_two,parent,false)
            return ViewHoderTwo(view)
        }else{
            return throw java.lang.RuntimeException("data Un-Available")
        }
    }

    class ViewHoderTwo(itemView: View) : ViewHolder(itemView) {
          val textView :TextView

        init {
            textView = itemView.findViewById(R.id.textView5) as TextView
        }
    }

    class ViewHolderOne(itemView: View) : ViewHolder(itemView) {
          val textView:TextView
          init {
              textView = itemView.findViewById(R.id.textView3) as TextView
          }
    }


    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       when(holder.itemViewType){
          TYPE_ONE -> bindOne(holder as ViewHolderOne,position)
           TYPE_TWO -> bindTwo(holder as ViewHoderTwo,position)
       }
    }

    private fun bindTwo(viewHoderTwo: ViewHoderTwo, position: Int) {
        val item = itemList[position] as Item.ItemTwo
        viewHoderTwo.textView.text = item.name
    }

    private fun bindOne(viewHolderOne: ViewHolderOne, position: Int) {
        val item = itemList[position] as Item.ItemOne
        viewHolderOne.textView.text = item.name
    }

    override fun getItemViewType(position: Int): Int {
        val item =itemList[position]
        return when(item){
            is Item.ItemOne -> TYPE_ONE
            is Item.ItemTwo -> TYPE_TWO
        }
    }
    companion object{
        private val TYPE_ONE = 1
        private val TYPE_TWO = 2
    }


}



    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       if (viewType == TYPE_ONE){
             val view = LayoutInflater.from(parent.context).inflate(R.layout.item_one,parent,false)
            return ViewHolderOne(view)
       }else if (viewType == TYPE_TWO){
           val view = LayoutInflater.from(parent.context).inflate(R.layout.item_two,parent,false)
           return ViewHolderTwo(view)
       }
        else throw java.lang.RuntimeException("no data")
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder.itemViewType){
          TYPE_ONE -> bindOne(holder as ViewHolderOne,position)
          TYPE_TWO -> bindTwo(holder as ViewHolderTwo,position)
        }
    }

    private fun bindOne(viewHolderOne: ViewHolderOne, position: Int) {
        val item = itemList[position] as Item.ItemOne
        viewHolderOne.item.text = item.name
    }

    private fun bindTwo(viewHolderTwo: ViewHolderTwo, position: Int) {
        val item = itemList[position] as Item.ItemTwo
        viewHolderTwo.item.text = item.name
    }

    override fun getItemViewType(position: Int): Int {
        val item = itemList[position]
        return when (item) {
            is Item.ItemOne -> TYPE_ONE
            is Item.ItemTwo -> TYPE_TWO
        }
    }

    class ViewHolderOne(itemView: View): RecyclerView.ViewHolder(itemView){
        var item:TextView
        init {
            item = itemView.findViewById(R.id.textView3) as TextView
        }
    }
    class ViewHolderTwo(itemView: View): RecyclerView.ViewHolder(itemView){
        var item:TextView
        init {
            item = itemView.findViewById(R.id.textView5) as TextView
        }
    }
    companion object {
        private val TYPE_ONE = 1
        private val TYPE_TWO = 2
    }
}*/