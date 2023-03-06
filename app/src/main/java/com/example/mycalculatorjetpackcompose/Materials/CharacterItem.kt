package com.example.mycalculatorjetpackcompose.Materials

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CharacterItem(
    char:String,
    modifier: Modifier=Modifier,
    color: Color     =MaterialTheme.colors.surface,
    onClick:() ->Unit

){
    Surface(
        shape= CircleShape,
        color=color,
        modifier = modifier
            .clip(CircleShape)
            .clickable {
                onClick.invoke()
            }
    ) {
        Box(contentAlignment = Alignment.Center){
            Text(
                text = char,
                modifier = Modifier.padding(8.dp),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.button
            )
        }

    }

}