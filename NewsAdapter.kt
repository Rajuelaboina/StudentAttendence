package com.raju.multipleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.raju.multipleview.databinding.ItemFlashNewsBinding
import com.raju.multipleview.databinding.ItemLargeNewsBinding
import com.raju.multipleview.databinding.ItemShortNewsBinding
import com.raju.multipleview.model.*

class NewsAdapter(var newsList: List<News>) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {

      lateinit var bindingLargeNews: ItemLargeNewsBinding
      lateinit var bindingShortNews: ItemShortNewsBinding
    lateinit var bindingFlashNews: ItemFlashNewsBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
       when(viewType){
           NewsType.SHORT_NEWS.value -> {
              bindingShortNews = ItemShortNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
               ShortNewsViewHolder(bindingShortNews)
           }
           NewsType.LARGE_NEWS.value -> {
               bindingLargeNews = ItemLargeNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
               LargeNewsViewHolder(bindingLargeNews)
           }
           else -> {
               bindingFlashNews = ItemFlashNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
               FlashNewsViewHolder(bindingFlashNews)
           }
       }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(newsList[position]){
            is ShortNews -> {
                (holder as ShortNewsViewHolder).bind(newsList[position] as ShortNews)
            }
            is LargeNews ->{
                (holder as LargeNewsViewHolder).bind(newsList[position] as LargeNews)
            }
            else ->{
                (holder as FlashNewsViewHolder).bind(newsList[position] as FlashNews)
            }
        }
    }

    override fun getItemViewType(position: Int): Int =
        when(newsList[position]){
            is ShortNews ->{
                NewsType.SHORT_NEWS.value
            }
            is LargeNews ->{
                NewsType.LARGE_NEWS.value
            }
            else -> {
               NewsType.FLASH_NEWS.value
            }
        }
    }

    class LargeNewsViewHolder(var binding: ItemLargeNewsBinding) :ViewHolder(binding.root){
         fun bind(largeNews: LargeNews) {
           binding.largeNews =largeNews
         }
    }
    class ShortNewsViewHolder(var binding: ItemShortNewsBinding) :ViewHolder(binding.root){
        fun bind(shortNews: ShortNews) {
            binding.shortNews = shortNews
        }
    }
class FlashNewsViewHolder(var binding: ItemFlashNewsBinding) :ViewHolder(binding.root){
    fun bind(flashNews: FlashNews) {
        binding.flashNews = flashNews
    }
}
