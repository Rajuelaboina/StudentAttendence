package com.raju.multipleview

import android.content.Context
import androidx.core.content.ContextCompat
import com.raju.multipleview.model.FlashNews
import com.raju.multipleview.model.LargeNews
import com.raju.multipleview.model.News
import com.raju.multipleview.model.ShortNews

object DummyData {
    fun getDummyData(context: Context): List<News> {

        val newsList = arrayListOf<News>()

        val largeNews1 = LargeNews(
            "Large News Title 1",
            ContextCompat.getDrawable(context, R.drawable.baseline_note_24),
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Ut bibendum enim sit amet commodo ornare. Morbi sit amet urna felis."
        )
        val shortNews1 = ShortNews(
            "Short News Title 1",
            ContextCompat.getDrawable(context, R.drawable.baseline_note_alt_24),
            "23.01.2022"
        )
        val shortNews2 = ShortNews(
            "Short News Title 2",
            ContextCompat.getDrawable(context, R.drawable.baseline_notifications_24),
            "22.01.2022"
        )
        val largeNews2 = LargeNews(
            "Large News Title 2",
            ContextCompat.getDrawable(context, R.drawable.baseline_note_24),
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Ut bibendum enim sit amet commodo ornare. Morbi sit amet urna felis."
        )
        val shortNews3 = ShortNews(
            "Short News Title 3",
            ContextCompat.getDrawable(context, R.drawable.baseline_notifications_24),
            "21.01.2022"
        )
        val shortNews4 = ShortNews(
            "Short News Title 4",
            ContextCompat.getDrawable(context, R.drawable.baseline_note_alt_24),
            "20.01.2022"
        )
        val largeNews3 = LargeNews(
            "Large News Title 3",
            ContextCompat.getDrawable(context, R.drawable.baseline_note_24),
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Ut bibendum enim sit amet commodo ornare. Morbi sit amet urna felis."
        )
        val flashNews1 = FlashNews(
            "Flash News Title 1",
            ContextCompat.getDrawable(context, R.drawable.ic_launcher_background),
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Ut bibendum enim sit amet commodo ornare. Morbi sit amet urna felis."
        )
        val flashNews2 = FlashNews(
            "Flash News Title 1",
            ContextCompat.getDrawable(context, R.drawable.ic_launcher_background),
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Ut bibendum enim sit amet commodo ornare. Morbi sit amet urna felis."
        )
        val flashNews3 = FlashNews(
            "Flash News Title 1",
            ContextCompat.getDrawable(context, R.drawable.ic_launcher_background),
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Ut bibendum enim sit amet commodo ornare. Morbi sit amet urna felis."
        )

        newsList.add(largeNews1)
        newsList.add(shortNews1)
        newsList.add(shortNews2)
        newsList.add(flashNews1)
        newsList.add(largeNews2)
        newsList.add(shortNews3)
        newsList.add(flashNews2)
        newsList.add(shortNews4)
        newsList.add(flashNews3)
        newsList.add(largeNews3)
        return newsList
    }
}