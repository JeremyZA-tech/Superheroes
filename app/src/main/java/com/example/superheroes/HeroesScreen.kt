package com.example.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.Shapes


@Composable
fun SuperheroesItem(
    modifier: Modifier = Modifier,
    hero: Hero
){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(R.dimen.elevation_Size)),
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            SuperheroeInformation(
                nameRes = hero.nameRes,
                descriptionRes = hero.descriptionRes,
                modifier = Modifier.weight(1f) // Ajusta el peso según sea necesario
            )
            HeroIcon(
                heroIcon = hero.imageRes,
                modifier = Modifier// Ajusta el peso según sea necesario
            )
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
    Box(
        modifier = Modifier
            .size(dimensionResource(R.dimen.image_Size))
            .clip(shape = Shapes.medium)

    ) {
        Image(
            modifier = modifier,
            painter = painterResource(heroIcon),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.FillWidth,

        )
    }
}



@Preview
@Composable
fun SuperheroesItemPreview()
{
    SuperheroesItem(hero = HeroesRepository.heroes[0])

}