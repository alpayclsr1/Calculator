package com.example.mycalculatorjetpackcompose

class Model {

    private fun replaceN(string: String):String{

        val array=StringBuffer(string)

        if (array[0] =='-'){
            array.setCharAt(0,'n')

        }

        var i=0
        while (i <array.length){


            if (array[i]=='-'){
                //2+-3
                if(array[i-1]=='+'  ||
                    array[i-1]=='-' ||
                    array[i-1]=='/'  ||
                    array[i-1]=='*'
                        ){
                    array.setCharAt(i,'n')
                }

            }
            i++
        }

        return array.toString()

    }
}