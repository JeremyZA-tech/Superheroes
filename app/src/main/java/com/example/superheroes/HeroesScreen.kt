package com.example.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository


@Composable
fun SuperheroesItem(
    modifier: Modifier = Modifier,
    hero: Hero
){
    Card(modifier = modifier) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                SuperheroeInformation(
                    nameRes = hero.nameRes,
                    descriptionRes = hero.descriptionRes
                )
                HeroIcon(heroIcon = hero.imageRes)
            }
        }
    }
}

@Composable
fun SuperheroeInformation(
    @StringRes nameRes: Int,
    @StringRes descriptionRes: Int,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        Text(
            text = stringResource(nameRes),
            style = MaterialTheme.typography.displaySmall

            )
        Text(
            text = stringResource(descriptionRes),
            style = MaterialTheme.typography.bodyLarge
        )
    }

}

@Composable
fun HeroIcon(
    @DrawableRes heroIcon: Int,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_Size))
            .padding(dimensionResource(R.dimen.padding_medium))
            .clip(MaterialTheme.shapes.small)
        ,
        painter = painterResource(heroIcon),
        contentDescription = null
    )
}



@Preview
@Composable
fun SuperheroesItemPreview()
{
    SuperheroesItem(hero = HeroesRepository.heroes[0])

}