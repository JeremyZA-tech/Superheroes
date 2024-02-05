package com.example.superheroes

import com.example.superheroes.ui.theme.SuperheroesTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.model.HeroesRepository.heroes


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SuperheroesApp()
                }
            }
        }
    }
}

@Composable
fun SuperheroesApp(modifier: Modifier = Modifier) {

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            HeroesTopAppBar()
        }
    ) {
        LazyColumn(contentPadding = it) {
            items(heroes) {
                SuperheroesItem(
                    hero = it,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesTopAppBar (modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge,
            )
        },
        modifier = modifier
    )
}





@Preview
@Composable
fun SuperheroesPreview() {
    SuperheroesTheme (darkTheme = false) {
        SuperheroesApp()
    }
}

@Preview
@Composable
fun SuperheroesDarkPreview() {
    SuperheroesTheme (darkTheme = false) {
        SuperheroesApp()
    }
}