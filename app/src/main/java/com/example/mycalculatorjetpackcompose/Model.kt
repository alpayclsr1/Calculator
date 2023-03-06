package com.example.mycalculatorjetpackcompose

class Model {

    private fun replaceN(string: String): String {
        val array = StringBuffer(string)

        if (array[0] == '-') {
            array.setCharAt(0, 'n')
        }

        var i = 0
        while (i < array.length) {

            if (array[i] == '-') {
                if (
                    array[i - 1] == '+' ||
                    array[i - 1] == '-' ||
                    array[i - 1] == '/' ||
                    array[i - 1] == '*' ||
                    array[i - 1] == '('
                ) {
                    array.setCharAt(i, 'n')
                }
            }

            i++

        }

        return array.toString()

    }

    fun result(string: String): String {
        val stringN = replaceN(string)
        val postFix = InfixToPostFix().postFixConversion(stringN)

        if (postFix == "Error") {
            return postFix
        }
        return try {
            val evaluation = ArithmeticEvaluation().evaluation(postFix)
            evaluation.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            "Error"
        }


    }

}