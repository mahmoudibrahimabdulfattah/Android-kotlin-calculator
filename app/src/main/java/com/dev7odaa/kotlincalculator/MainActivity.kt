package com.dev7odaa.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit private var input : TextView
    lateinit private var result : TextView

    lateinit private var zero: Button
    lateinit private var one: Button
    lateinit private var two: Button
    lateinit private var three: Button
    lateinit private var four: Button
    lateinit private var five: Button
    lateinit private var six: Button
    lateinit private var seven: Button
    lateinit private var eight: Button
    lateinit private var nine: Button

    lateinit private var dot: Button

    lateinit private var plus: Button
    lateinit private var mince: Button
    lateinit private var multiply: Button
    lateinit private var divide: Button

    lateinit private var equal: Button
    lateinit private var remove: Button

    lateinit private var ac: Button
    lateinit private var modelus: Button

    private var checked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        zero.setOnClickListener(this)
        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)
        dot.setOnClickListener(this)
        plus.setOnClickListener(this)
        mince.setOnClickListener(this)
        multiply.setOnClickListener(this)
        divide.setOnClickListener(this)
        equal.setOnClickListener(this)
        remove.setOnClickListener(this)
        ac.setOnClickListener(this)
        modelus.setOnClickListener(this)


    }

    fun init() {
        input = findViewById(R.id.main_txt_input)
        result = findViewById(R.id.main_txt_result)

        zero = findViewById(R.id.main_btn_0)
        one = findViewById(R.id.main_btn_1)
        two = findViewById(R.id.main_btn_2)
        three = findViewById(R.id.main_btn_3)
        four = findViewById(R.id.main_btn_4)
        five = findViewById(R.id.main_btn_5)
        six = findViewById(R.id.main_btn_6)
        seven = findViewById(R.id.main_btn_7)
        eight = findViewById(R.id.main_btn_8)
        nine = findViewById(R.id.main_btn_9)
        dot = findViewById(R.id.main_btn_dot)
        plus = findViewById(R.id.main_btn_plus)
        mince = findViewById(R.id.main_btn_mince)
        multiply = findViewById(R.id.main_btn_multiply)
        divide = findViewById(R.id.main_btn_divide)
        equal = findViewById(R.id.main_btn_equal)
        remove = findViewById(R.id.main_btn_remove)
        ac = findViewById(R.id.main_btn_ac)
        modelus = findViewById(R.id.main_btn_modelus)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.main_btn_0 -> {
                main_txt_input.append("0")
                checked = false
            }
            R.id.main_btn_1 -> {
                main_txt_input.append("1")
                checked = false
            }
            R.id.main_btn_2 -> {
                main_txt_input.append("2")
                checked = false
            }
            R.id.main_btn_3 -> {
                main_txt_input.append("3")
                checked = false
            }
            R.id.main_btn_4 -> {
                main_txt_input.append("4")
                checked = false
            }
            R.id.main_btn_5 -> {
                main_txt_input.append("5")
                checked = false
            }

            R.id.main_btn_6 -> {
                main_txt_input.append("6")
                checked = false
            }
            R.id.main_btn_7 -> {
                main_txt_input.append("7")
                checked = false
            }
            R.id.main_btn_8 -> {
                main_txt_input.append("8")
                checked = false
            }
            R.id.main_btn_9 -> {
                main_txt_input.append("9")
                checked = false
            }

/////////////OPERATOR///////////////////////////////////////////////////////////////////////////////////////////////////

            R.id.main_btn_dot -> {
                main_txt_input.append(".")
                main_btn_dot.setClickable(false)
            }
            R.id.main_btn_plus -> {
                if(!checked){
                    main_txt_input.append("+")
                    checked = true
                }
            }
            R.id.main_btn_mince -> {
                if(!checked){
                    main_txt_input.append("-")
                    checked = true
                }
            }
            R.id.main_btn_multiply -> {
                if(!checked){
                    main_txt_input.append("*")
                    checked = true
                }
            }
            R.id.main_btn_divide -> {
                if(!checked){
                    main_txt_input.append("/")
                    checked = true
                }
            }
            R.id.main_btn_modelus ->{
                if(!checked){
                    main_txt_input.append("%")
                    checked = true
                }
            }
            R.id.main_btn_ac -> {
                main_txt_input.setText("")
                main_txt_result.setText("")
                checked = true
            }

            R.id.main_btn_remove -> {main_txt_input.setText("")}
            R.id.main_btn_equal -> {
                if(checked == false){

                    val txt = main_txt_input.text.toString()
                    // Create an Expression (A class from exp4j library)
                    val expression = ExpressionBuilder(txt).build()

                    // Calculate the result and display
                    val result = expression.evaluate()
                    main_txt_result.setText(result.toString())
                }
                else{
                    main_txt_result.setText("")
                }
            }
        }
    }


}