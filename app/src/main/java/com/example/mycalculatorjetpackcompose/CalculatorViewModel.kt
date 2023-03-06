package com.example.mycalculatorjetpackcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel as ViewModel

class CalculatorViewModel: ViewModel() {

    var uiState by mutableStateOf(UiState())

    fun onInfixChange(infix:String){

        uiState.apply {
            uiState=copy(infix=this.infix+infix)
        }
    }

    fun clearInfixExpression(){
        uiState=uiState.copy(infix="")
    }

    private fun onResultChange(result:String){
        uiState=uiState.copy(result=result)
    }

    fun  evaluateExpression(){

        if(uiState.infix.isNotBlank()){
            onResultChange(Model().result(uiState.infix))
        }
    }






}

