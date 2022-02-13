package alok.ranjan.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    var lastNumeric = false
    var lastDot = false
    var result = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View){
        tvInput.append((view as Button).text)
        lastNumeric = true
    }

    fun onDecimalPoint(view: View){
        if(lastNumeric && !lastDot){
            tvInput.append(".")
            lastDot = true
        }
    }

    fun onClear(view: View){
        tvInput.text = ""
        lastDot = false
        lastNumeric = false
    }

    fun onOperator(view: View){
        if(lastNumeric && !isOperatorAdded(tvInput.text.toString())){
            tvInput.append((view as Button).text)

            lastNumeric = false
            lastDot = false
        }
    }

    private fun isOperatorAdded(value: String) :Boolean{
        return if(value.startsWith("-")){
            false
        }else{
            value.contains('+') || value.contains('-') ||
                    value.contains('*') || value.contains('/')
        }
    }

    fun onEqual(view: View){
        var tvValue = tvInput.text.toString()
        var prefix = ""
        if(tvValue.startsWith("-")) {
            prefix = "-"
            tvValue = tvValue.substring(1)
        }
        if(lastNumeric){
            try{
                if(tvValue.contains('-')){
                    val splitValue = tvValue.split('-')
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if(!prefix.isEmpty())
                        one = prefix + one

                    tvInput.text = removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())
                }
                else if(tvValue.contains('+')){
                    val splitValue = tvValue.split('+')
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if(!prefix.isEmpty())
                        one = prefix + one

                    tvInput.text = removeZeroAfterDot((one.toDouble() + two.toDouble()).toString())
                }
                else if(tvValue.contains('*')){
                    val splitValue = tvValue.split('*')
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if(!prefix.isEmpty())
                        one = prefix + one

                    tvInput.text = removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())
                }
                else if(tvValue.contains('/')){
                    val splitValue = tvValue.split('/')

                    var one = splitValue[0]
                    var two = splitValue[1]

                    if(!prefix.isEmpty())
                        one = prefix + one

                    tvInput.text = removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())
                }
            }catch (e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }

    fun removeZeroAfterDot(result: String): String{
        var value = result
        if(result.contains(".0")){
            value = result.substring(0, result.length - 2)
        }

        return value
    }

}