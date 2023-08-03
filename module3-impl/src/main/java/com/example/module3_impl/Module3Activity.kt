package com.example.module3_impl

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Shader
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class Module3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyView(this))
    }
}

class MyView(context: Context) : View(context) {
    private val paint1: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        color = 0xffff0000.toInt()
        strokeWidth = 5f
    }

    private val paint2 = Paint().apply {
        setARGB(100, 0, 255, 0)
        style = Paint.Style.FILL
    }

    private val path1: Path = Path().apply {
        moveTo(500f, 500f)
        lineTo(510f, 510f)
        lineTo(520f, 520f)
        lineTo(530f, 530f)
        lineTo(540f, 540f)
    }

    private val path2: Path = Path().apply {
        moveTo(500f, 800f)
        lineTo(600f, 800f)
        lineTo(600f, 700f)
        lineTo(500f, 700f)
        //lineTo(500f, 800f)
        //close()
    }

    private val path3: Path = Path().apply {
        moveTo(505f, 795f)
        lineTo(595f, 795f)
        lineTo(595f, 705f)
        lineTo(505f, 705f)
    }

    private val path4: Path = Path().apply {
        moveTo(50f, 300f)
        lineTo(160f, 280f)
        lineTo(300f, 380f)
        lineTo(380f, 370f)
        lineTo(280f, 450f)
        lineTo(100f, 390f)
        lineTo(160f, 380f)
        lineTo(50f, 300f)
        /*
        * The coordinates of the centroid of a triangle are found by averaging the x- and y-coordinates of the vertices.
        * This method will also find the centroid (center of mass) of any set of points on the x-y plane.
        * To find the centroid, follow these steps:
        * Step 1: Identify the coordinates of each vertex.
        * Step 2: Add all the x values from the three vertices coordinates and divide by 3 = 211.4 493.3.
        * Step 3: Add all the y values from the three vertices coordinates and divide by 3 = 407.1 950.
        * */
    }

    private val path5: Path = Path().apply {
        moveTo(50f, 1200f)
        lineTo(200f, 1180f)
        lineTo(175f, 1225f)
        lineTo(150f, 1210f)
        lineTo(100f, 1225f)
        close()
    /*

        lineTo(25f, 1050f)
        close()*/
    }

    private val linear = LinearGradient(
        100f, 220f, 150f, 240f, Color.BLUE, Color.RED, Shader.TileMode.MIRROR
    )

    private val paint3 = Paint().apply {
        style = Paint.Style.FILL
        shader = linear
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        /*canvas?.drawRect(500f, 500f, 700f, 700f, paint)
        canvas?.drawRect(500f, 500f, 700f, 700f, greenPaint)
        canvas?.drawCircle(600f, 600f, 145f, paint)
        canvas?.drawCircle(500f, 450f, 50f, paint)

        canvas?.drawPath(path, paint)*/

        //canvas?.drawPath(path3, paint2)
        //canvas?.drawPath(path2, paint1)
        //canvas?.drawPath(path3, paint1)
        canvas?.drawPath(path4, paint3)
        canvas?.drawPath(path4, paint1)
        canvas?.drawPath(path5, paint3)
        canvas?.drawCircle(211.4f, 407.1f, 250f, paint1)
    }
}