package com.example.module3_impl

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.project.module3_impl.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class Module3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyView(this))
    }
}

class MyView(context: Context) : View(context) {
    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        color = 0xffff0000.toInt()
        strokeWidth = 5f
    }

    private val greenPaint = Paint().apply {
        setARGB(255, 0, 255, 0)
        style = Paint.Style.FILL
    }

    private val path: Path = Path().apply {
        moveTo(500f, 500f)
        lineTo(510f, 510f)
        lineTo(520f, 520f)
        lineTo(530f, 530f)
        lineTo(540f, 540f)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawRect(500f, 500f, 700f, 700f, paint)
        canvas?.drawRect(500f, 500f, 700f, 700f, greenPaint)
        canvas?.drawCircle(600f, 600f, 145f, paint)
        canvas?.drawCircle(500f, 450f, 50f, paint)

        canvas?.drawPath(path, paint)
    }
}