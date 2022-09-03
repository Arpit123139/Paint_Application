package com.example.paintapp

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.paintapp.PaintView.Companion.colorList
import com.example.paintapp.PaintView.Companion.currentBrush
import com.example.paintapp.PaintView.Companion.pathList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        var path=Path()
        val paintBrush=Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        red_color.setOnClickListener{

           // paintBrush.color = Color.RED
            currentBrush= Color.RED
            path= Path()

        }
        blue_color.setOnClickListener{

           // paintBrush.color = Color.BLUE
            currentBrush= Color.BLUE
            path= Path()
        }
        black_color.setOnClickListener{

           // paintBrush.color = Color.BLACK
            currentBrush= Color.BLACK
            path= Path()
        }
        white_color.setOnClickListener{

            pathList.clear()
            colorList.clear()
            path.reset()
        }
    }
}