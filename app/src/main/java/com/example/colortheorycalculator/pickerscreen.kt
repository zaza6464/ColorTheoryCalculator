package com.example.colortheorycalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.ConstraintLayout
import yuku.ambilwarna.AmbilWarnaDialog
import android.util.Log


class pickerscreen : AppCompatActivity() {
    lateinit var mLayout: RelativeLayout;
    var mDefaultColor: Int = 0;
    lateinit var mButton: Button;
    lateinit var editText: EditText;
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pickerscreen)




        mDefaultColor =
            ContextCompat.getColor(this@pickerscreen, R.color.design_default_color_primary_dark);
        mLayout = findViewById(R.id.layout) as RelativeLayout
        mButton = findViewById(R.id.button)
        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)

        mButton.setOnClickListener {
            openColorPicker();
        }

    }

    fun openColorPicker() {
        val colorPicker =
            AmbilWarnaDialog(this, mDefaultColor, object : AmbilWarnaDialog.OnAmbilWarnaListener {
                override fun onCancel(dialog: AmbilWarnaDialog?) {

                }

                override fun onOk(dialog: AmbilWarnaDialog?, color: Int) {
                    println(color)
                    mDefaultColor = (color)
                    mLayout.setBackgroundColor(mDefaultColor)
                }
            })
        colorPicker.show()
    }
}