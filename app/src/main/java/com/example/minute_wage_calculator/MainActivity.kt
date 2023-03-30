package com.example.minute_wage_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.minute_wage_calculator.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.tvWageInfo.text = "최저시급 : ${Wage.HOURLY_WAGE}원"

        binding.btnCalculate.setOnClickListener {
            var hour = 0
            Log.d("MYTAG", binding.etHour.text.toString())
            binding.etHour.text.toString().apply {
                if(this.isNotEmpty()) {
                    hour = binding.etHour.text.toString().toInt()
                }
            }

            var minute = 0
            binding.etMinute.text.toString().apply {
                if(this.isNotEmpty()) {
                    minute = binding.etMinute.text.toString().toInt()
                }
            }

            var wage = 0f

            wage = minute.toFloat() / 60 * Wage.HOURLY_WAGE + hour.toFloat() * Wage.HOURLY_WAGE

            val wageInInt = wage.roundToInt()

            binding.tvWage.text = "${wageInInt.toString()} 원"
        }


    }
}