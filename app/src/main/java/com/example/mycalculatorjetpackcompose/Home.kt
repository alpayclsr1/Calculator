package com.example.mycalculatorjetpackcompose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycalculatorjetpackcompose.Materials.CharacterItem


@Composable
fun HomeCalculator(calculatorViewModel: CalculatorViewModel?){
    val uiState= calculatorViewModel?.uiState

    Box(modifier = Modifier.fillMaxSize()){
        val contentMargin=16.dp


        Column(modifier = Modifier.align(Alignment.BottomCenter)) {

            Column(modifier = Modifier
                .padding(horizontal = contentMargin)
                .align(Alignment.End)) {

                Text(
                    text = uiState?.infix ?:"-20+60/-5*(20-5)",
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Black

                )
                Spacer(modifier = Modifier.size(contentMargin))
                Text(
                    text = uiState?.result ?: "-200",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.End)
                )
                Spacer(modifier = Modifier.size(contentMargin))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.size(contentMargin))
                    CharacterItem(
                        char = "(",
                        modifier = Modifier
                            .padding(4.dp)
                            .weight(1f, true)
                    ) {
                        calculatorViewModel?.onInfixChange("(")

                    }
                    Spacer(modifier = Modifier.size(contentMargin))
                    CharacterItem(
                        char = ")",
                        modifier = Modifier
                            .padding(4.dp)
                            .weight(1f, true)
                    ) {
                        calculatorViewModel?.onInfixChange(")")

                    }
                    Spacer(modifier = Modifier.size(contentMargin))
                }
                Spacer(modifier = Modifier.size(contentMargin))
                Row() {
                    val numbers= listOf(
                        "7","8","9","4","5","6","1","2","3",".","C"
                    )
                    LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = Modifier.weight(1f)){
                        items(numbers){ number ->

                            CharacterItem(char = number, modifier =Modifier.padding(contentMargin)) {

                                if (number !="C"){
                                    calculatorViewModel?.onInfixChange(number)
                                }else{
                                    calculatorViewModel?.clearInfixExpression()
                                }
                            }

                        }
                    }
                    
                }

                

                
            }

        }
    }

}


@Preview(showBackground = true)
@Composable
fun PrevHomeCalculator(){

        HomeCalculator(calculatorViewModel = null)

    
}