package com.raju.multipleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.raju.multipleview.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main3)
       /* val itemList = ArrayList<Item>()
        for (i in 0..10){
            if (i%2==0)
            itemList.add(Item.ItemOne("Item one: "+i))
            else itemList.add(Item.ItemTwo("Item two: "+i))
        }
       val adapter = ItemAdapter(itemList)*/
        val layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val newsList = DummyData.getDummyData(applicationContext)
        val adapter = NewsAdapter(newsList)
        binding.recyclerView2.adapter =adapter
        binding.recyclerView2.setHasFixedSize(true)
        binding.recyclerView2.addItemDecoration(DividerItemDecoration(this,layoutManager.orientation))
        //adapter.notifyDataSetChanged()


    }
}