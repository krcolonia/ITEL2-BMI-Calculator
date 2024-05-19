package com.finalproj.appdevbmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.finalproj.appdevbmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var MainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(MainBinding.root)

        var submit = MainBinding.submitBtn

        submit.setOnClickListener() {
            val intent = Intent(this, Activity2::class.java)

            var fName = MainBinding.fNameInput.text.toString()
            var midInit = MainBinding.midInitInput.text.toString()
            var lName = MainBinding.lNameInput.text.toString()

            var h = MainBinding.heightInput.text.toString()
            var w = MainBinding.weightInput.text.toString()

            var maleBtn = MainBinding.maleBtn
            var femaleBtn = MainBinding.femaleBtn

            val bmi = computeBMI(h.toFloat(),w.toFloat())
            var gender = genderCheck(maleBtn, femaleBtn)

            if(fName.isEmpty() || midInit.isEmpty() || lName.isEmpty()) {
                Toast.makeText(applicationContext, "Name Input is Incomplete", Toast.LENGTH_SHORT).show()
            }
            else if(!maleBtn.isChecked && !femaleBtn.isChecked) {
                Toast.makeText(applicationContext, "Gender is not selected", Toast.LENGTH_SHORT).show()
            }
            else if(h.isEmpty() || w.isEmpty()) {
                Toast.makeText(applicationContext, "Height and Weight Input is Incomplete", Toast.LENGTH_SHORT).show()
            }
            else {
                intent.putExtra("gender", gender)

                intent.putExtra("firstName", fName)
                intent.putExtra("middleInitial", midInit)
                intent.putExtra("lastName", lName)

                intent.putExtra("bmi",bmi)

                startActivity(intent)
                this.finish()
            }
        }
    }

    fun computeBMI(h:Float, w:Float): String {

        var hInM = h/100

        return (w / (hInM * hInM)).toString()
    }

    fun genderCheck(maleBtn: RadioButton, femaleBtn: RadioButton): String {
        if(maleBtn.isChecked) {
            return "m"
        }
        else if(femaleBtn.isChecked) {
            return "f"
        }
        return " "
    }

}