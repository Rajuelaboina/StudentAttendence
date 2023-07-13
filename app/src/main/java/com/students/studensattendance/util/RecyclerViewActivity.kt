package com.phycae.mycompositeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.phycae.mycompositeexample.ui.theme.MyCompositeExampleTheme

class RecyclerViewActivity : ComponentActivity() {
    val mainViewModel by viewModels<MovieViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCompositeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    mainViewModel.getMovies()
                    UserMovieList(movieList = mainViewModel.movieListResponse)
                    //Greeting3("Android")
                }
            }
        }
    }

    @Composable
    fun UserMovieList(movieList: List<Movie>) {
        var selectedIndex by remember { mutableStateOf(-1) }
        LazyColumn {
            itemsIndexed(items = movieList) { index, item ->
                UserMovieItem(movie = item, index, selectedIndex) { i ->
                    selectedIndex = i as Int
                }
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun UserMovieItem(movie: Movie, index: Int, selectedIndex: Int, onClick: (Int) -> Unit) {
        val backgroundColor =
            if (index == selectedIndex) androidx.compose.material3.MaterialTheme.colorScheme.primary else androidx.compose.material3.MaterialTheme.colorScheme.background
        var isPressed by remember { mutableStateOf(false) }
        Card(
            modifier = Modifier
                .fillMaxWidth()

                .padding(10.dp, 0.dp, 10.dp, 0.dp)
                .clickable { onClick(index) }, shape = RoundedCornerShape(2.dp),
            elevation = 2.dp,
            onClick = {
                // hide and show data logic
                isPressed = !isPressed

            }

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxHeight()

            ) {
                Text(
                    text = movie.category, modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp),
                    fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Red
                )
                //Spacer(modifier = Modifier.height(2.dp))
                hideAndShow(movie, isPressed)

            }


        }
    }

    @Composable
    fun hideAndShow(movie: Movie, isPressed: Boolean) {
        if (isPressed) {
            Row(
                modifier = Modifier
                    .padding(1.dp)
                    .height(110.dp)
            ) {

                Image(
                    painter = rememberImagePainter(data = movie.imageUrl,
                        builder = {
                            scale(Scale.FIT)
                            placeholder(R.drawable.ic_launcher_background)
                            transformations(CircleCropTransformation())

                        }),
                    contentDescription = movie.name,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = movie.name, modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp),
                        fontWeight = FontWeight.Bold, color = Color.Black
                    )
                    Text(
                        text = movie.desc, modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp),
                        fontWeight = FontWeight.SemiBold, color = Color.DarkGray
                    )
                }

            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview3() {
        MyCompositeExampleTheme {
            UserMovieList(movieList = mainViewModel.movieListResponse)
        }
    }
}