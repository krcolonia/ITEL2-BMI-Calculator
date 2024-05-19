package com.finalproj.appdevbmicalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.finalproj.appdevbmicalculator.databinding.Activity2Binding
import java.text.DecimalFormat

class Activity2 : AppCompatActivity() {
    private lateinit var binding: Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val df = DecimalFormat("##.00")

        var passedGender = intent.getStringExtra("gender")

        when(passedGender) {
            "m" -> binding.genderText.text = "MR."
            "f" -> binding.genderText.text = "MS."
        }

        var passedFirstName = intent.getStringExtra("firstName")
        var passedMiddleInitial = intent.getStringExtra("middleInitial")
        var passedLastName = intent.getStringExtra("lastName")

        binding.nameText.text = "$passedFirstName $passedMiddleInitial $passedLastName"

        var passedBMI = intent.getStringExtra("bmi")
        var bmiFloat = passedBMI?.toFloat()

        binding.bmiCalc.text = df.format(bmiFloat)

        if (bmiFloat != null) {
            when {
                bmiFloat < 18.5 -> {
                    binding.bmiClass.text = "Underweight"
                    binding.bmiClass.setTextColor(resources.getColor(R.color.bmiYellow))

                    binding.underweightCard.setCardBackgroundColor(resources.getColor(R.color.bmiYellow))
                }
                bmiFloat >= 18.5 && bmiFloat < 25 -> {
                    binding.bmiClass.text = "Healthy Weight"
                    binding.bmiClass.setTextColor(resources.getColor(R.color.bmiGreen))

                    binding.healthyCard.setCardBackgroundColor(resources.getColor(R.color.bmiGreen))
                }
                bmiFloat >= 25 && bmiFloat < 30 -> {
                    binding.bmiClass.text = "Overweight"
                    binding.bmiClass.setTextColor(resources.getColor(R.color.bmiOrange))

                    binding.overweightCard.setCardBackgroundColor(resources.getColor(R.color.bmiOrange))
                }
                bmiFloat >= 30 -> {
                    binding.bmiClass.text = "Obese"
                    binding.bmiClass.setTextColor(resources.getColor(R.color.bmiRed))

                    binding.obeseCard.setCardBackgroundColor(resources.getColor(R.color.bmiRed))
                }
            }
        }
    }
}

