package com.example.mycalculatorjetpackcompose

import kotlin.math.pow

class ArithmeticEvolution {


    private fun notOperator(ch:Char):Boolean=when(ch ){

        '+','-','*','/','(',')','^'->false
        else ->true

    }

    fun evaluation(string: String):Double{

        var str=""
        val stack=ArrayDeque<Double>()

        for (ch in string){
            if (notOperator(ch) && ch !=' '){
                str+=ch
            }
            else if (ch == ' ' && str !=""){
                stack.push(str.replace('n','-').toDouble())
                str=""
            }
            else if (!notOperator(ch)){
                val val1=stack.pop()
                val val2=stack.pop()

                when(ch){
                    '+' ->stack.push(val2!! + val1!!)
                    '-' ->stack.push(val2!! - val1!!)
                    '/' ->stack.push(val2!! / val1!!)
                    '*' ->stack.push(val2!! * val1!!)
                    '^' ->stack.push(val2!!.pow(val1!!))
                }
            }

        }

        return stack.pop()!!
    }
}