package com.example.module3_impl

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.cos
import kotlin.math.sin

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
    }

    private val path5: Path = Path().apply {
        moveTo(550f, 1200f)
        lineTo(850f, 1180f)
        lineTo(1125f, 1225f)
        lineTo(1400f, 1210f)
        lineTo(1600f, 1225f)
        close()
    }

    private val points: Array<Point> = arrayOf(
        Point(550, 1200), Point(850, 1180), Point(1125, 1225), Point(1400, 1210), Point(1600, 1225)
    )

    private val square: Array<Point> = arrayOf(
        Point(-50, -50),
        Point(-50, 40),
        Point(50, 50),
        Point(50, -50),//550 350
    )

    private val squarePath: Path = Path().apply {
        moveTo(500f, 300f)
        lineTo(500f, 400f)
        lineTo(600f, 400f)
        lineTo(600f, 300f)
        close()
    }

    private val linear = LinearGradient(
        100f, 220f, 150f, 240f, Color.BLUE, Color.RED, Shader.TileMode.MIRROR
    )

    private val paint3 = Paint().apply {
        style = Paint.Style.FILL
        shader = linear
    }

    private fun updatePath(newPoints: Array<Point>) {
        path5.reset()
        val x = (newPoints[0].x).toFloat()
        val y = (newPoints[0].y).toFloat()
        newPoints.forEachIndexed { n, _ ->
            if (n == 0) {
                path5.moveTo(x, y)
            } else {
                val a = (newPoints[n].x).toFloat()
                val b = (newPoints[n].y).toFloat()
                path5.lineTo(a, b)
            }
        }
        path5.close()
    }

    private fun updateSquarePath(newPoints: Array<Point>) {
        squarePath.reset()
        val x = (newPoints[0].x).toFloat()
        val y = (newPoints[0].y).toFloat()
        newPoints.forEachIndexed { n, _ ->
            if (n == 0) {
                squarePath.moveTo(x, y)
            } else {
                val a = (newPoints[n].x).toFloat()
                val b = (newPoints[n].y).toFloat()
                squarePath.lineTo(a, b)
            }
        }
        squarePath.close()
    }

    private fun updateSquarePath2(newPoints: Array<Point>) {
        squarePath.reset()
        val x = (newPoints[0].x + 550).toFloat()
        val y = (newPoints[0].y + 350).toFloat()
        newPoints.forEachIndexed { n, _ ->
            if (n == 0) {
                squarePath.moveTo(x, y)
            } else {
                val a = (newPoints[n].x + 550).toFloat()
                val b = (newPoints[n].y + 350).toFloat()
                squarePath.lineTo(a, b)
            }
        }
        squarePath.close()
    }

    private fun affineTransformsTranslation(
        vertices: Array<Point>, matrix: Array<DoubleArray>
    ): Array<Point> {
        val result = Array<Point>(vertices.size) { Point() }
        vertices.forEachIndexed { n, _ ->
            val t =
                (matrix[0][0] * vertices[n].x + matrix[0][1] * vertices[n].y + matrix[0][2]).toInt()
            val u =
                (matrix[1][0] * vertices[n].x + matrix[1][1] * vertices[n].y + matrix[1][2]).toInt()
            result[n] = Point(t, u)
        }
        return result
    }

    private fun affineTransformsScale(
        points: Array<Point>, matrix: Array<DoubleArray>
    ): Array<Point> {
        val result = Array<Point>(points.size) { Point() }
        points.forEachIndexed { n, _ ->
            val t = (matrix[0][0] * points[n].x).toInt()
            val u = (matrix[1][1] * points[n].y).toInt()
            result[n] = Point(t, u)
        }
        return result
    }

    private fun affineTransformsShear(
        points: Array<Point>, matrix: Array<DoubleArray>
    ): Array<Point> {
        val result = Array<Point>(points.size) { Point() }
        points.forEachIndexed { n, _ ->
            val t = (matrix[0][0] * points[n].x + matrix[0][1] * points[n].x).toInt()
            val u = (matrix[1][0] * points[n].y + matrix[1][1] * points[n].y).toInt()
            result[n] = Point(t, u)
        }
        return result
    }

    private fun affineTransformsRotate(
        points: Array<Point>, matrix: Array<DoubleArray>
    ): Array<Point> {
        val result = Array<Point>(points.size) { Point() }
        points.forEachIndexed { n, _ ->
            val t = (matrix[0][0] * points[n].x + matrix[0][1] * points[n].x).toInt()
            val u = (matrix[1][0] * points[n].y + matrix[1][1] * points[n].y).toInt()
            result[n] = Point(t, u)
        }
        return result
    }

    private fun translate(input: Array<Point>, px: Int, py: Int): Array<Point> {
        val matrix = Array(3) { DoubleArray(3) }
        matrix[0][0] = 1.0
        matrix[0][1] = 0.0
        matrix[0][2] = px.toDouble()
        matrix[1][0] = 0.0
        matrix[1][1] = 1.0
        matrix[1][2] = py.toDouble()
        matrix[2][0] = 0.0
        matrix[2][1] = 0.0
        matrix[2][2] = 1.0
        return affineTransformsTranslation(input, matrix)
    }

    private fun scale(points: Array<Point>, px: Double, py: Double): Array<Point> {
        val matrix = Array(3) { DoubleArray(3) }
        matrix[0][0] = px
        matrix[0][1] = 0.0
        matrix[0][2] = 0.0
        matrix[1][0] = 0.0
        matrix[1][1] = py
        matrix[1][2] = 0.0
        matrix[2][0] = 0.0
        matrix[2][1] = 0.0
        matrix[2][2] = 1.0

        return affineTransformsTranslation(points, matrix)
    }

    private fun shear(points: Array<Point>, px: Double, py: Double): Array<Point> {
        val matrix = Array(3) { DoubleArray(3) }
        matrix[0][0] = 1.0
        matrix[0][1] = px
        matrix[0][2] = 0.0
        matrix[1][0] = py
        matrix[1][1] = 1.0
        matrix[1][2] = 0.0
        matrix[2][0] = 0.0
        matrix[2][1] = 0.0
        matrix[2][2] = 1.0

        return affineTransformsTranslation(points, matrix)
    }

    private fun rotate(points: Array<Point>, px: Double, py: Double): Array<Point> {
        val matrix = Array(3) { DoubleArray(3) }
        matrix[0][0] = cos(Math.toRadians(px))
        matrix[0][1] = -sin(Math.toRadians(px))
        matrix[0][2] = 0.0
        matrix[1][0] = sin(Math.toRadians(px))
        matrix[1][1] = cos(Math.toRadians(px))
        matrix[1][2] = 0.0
        matrix[2][0] = 0.0
        matrix[2][1] = 0.0
        matrix[2][2] = 1.0

        return affineTransformsTranslation(points, matrix)
    }



    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        /*
        canvas?.drawRect(500f, 500f, 700f, 700f, paint)
        canvas?.drawRect(500f, 500f, 700f, 700f, greenPaint)
        canvas?.drawCircle(600f, 600f, 145f, paint)
        canvas?.drawCircle(500f, 450f, 50f, paint)

        canvas?.drawPath(path, paint)

        canvas?.drawPath(path3, paint2)
        canvas?.drawPath(path2, paint1)
        canvas?.drawPath(path3, paint1)
        canvas?.drawPath(path4, paint3)
        canvas?.drawPath(path4, paint1)
        canvas?.drawPath(path5, paint3)
        canvas?.drawCircle(211.4f, 407.1f, 250f, paint1)
        */

        canvas?.drawPath(path5, paint3)
        canvas?.drawPath(path5, paint1)
        //var newPoints3 = shear(points, 2.0, .0)
        //updatePath(newPoints3)
        var newPoints3 = rotate(points, 45.0 ,2.0)
        updatePath(newPoints3)
        canvas?.drawPath(path5, paint1)

        canvas?.drawPath(squarePath, paint1)
        canvas?.drawPath(squarePath, paint3)
        val newSquarePath = rotate(square, 45.0, 2.0)
        updateSquarePath(newSquarePath)
        updateSquarePath2(newSquarePath)
        canvas?.drawPath(squarePath, paint1)
        canvas?.drawPath(squarePath, paint3)
    }
}