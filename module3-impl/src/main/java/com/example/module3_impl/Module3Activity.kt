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
        moveTo(300f, 800f)
        lineTo(550f, 500f)
        lineTo(800f, 800f)
        close()
    }

    private val points: Array<Point> = arrayOf(
        Point(300, 800),
        Point(550, 500),
        Point(800, 800),
    )

    private val squarePoints: Array<Point> = arrayOf(
        Point(500, 300),
        Point(500, 400),
        Point(600, 400),
        Point(600, 300)
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

    private fun updatePath(oldPoints: Array<Point>, newPoints: Array<Point>, path: Path) {
        path.reset()
        val centralized = addCentroid(oldPoints, newPoints)
        val initialX = (centralized[0].x).toFloat()
        val initialY = (centralized[0].y).toFloat()
        newPoints.forEachIndexed { point, _ ->
            if (point == 0) {
                path.moveTo(initialX, initialY)
            } else {
                val x = (centralized[point].x).toFloat()
                val y = (centralized[point].y).toFloat()
                path.lineTo(x, y)
            }
        }
        path.close()
    }

    private fun subtractCentroid(points: Array<Point>): Array<Point> {
        var x: Int = 0
        var y: Int = 0
        points.forEach {
            x += it.x
            y += it.y
        }
        x /= points.size
        y /= points.size
        val result = arrayListOf<Point>()
        for (p in points) {
            result.add(Point(p.x - x, p.y - y))
        }
        return result.toTypedArray()
    }

    private fun addCentroid(from: Array<Point>, to: Array<Point>): Array<Point> {
        var x: Int = 0
        var y: Int = 0
        from.forEach {
            x += it.x
            y += it.y
        }
        x /= from.size
        y /= from.size
        val result = arrayListOf<Point>()
        for (p in to) {
            result.add(Point(p.x + x, p.y + y))
        }
        return result.toTypedArray()
    }

    private fun affineTransforms(
        vertices: Array<Point>, matrix: Array<DoubleArray>
    ): Array<Point> {
        val result = Array(vertices.size) { Point() }
        vertices.forEachIndexed { n, _ ->
            val t =
                (matrix[0][0] * vertices[n].x + matrix[0][1] * vertices[n].y + matrix[0][2]).toInt()
            val u =
                (matrix[1][0] * vertices[n].x + matrix[1][1] * vertices[n].y + matrix[1][2]).toInt()
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
        return affineTransforms(input, matrix)
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
        return affineTransforms(points, matrix)
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
        return affineTransforms(points, matrix)
    }

    private fun rotate(points: Array<Point>, degrees: Double): Array<Point> {
        val matrix = Array(3) { DoubleArray(3) }
        matrix[0][0] = cos(Math.toRadians(degrees))
        matrix[0][1] = -sin(Math.toRadians(degrees))
        matrix[0][2] = 0.0
        matrix[1][0] = sin(Math.toRadians(degrees))
        matrix[1][1] = cos(Math.toRadians(degrees))
        matrix[1][2] = 0.0
        matrix[2][0] = 0.0
        matrix[2][1] = 0.0
        matrix[2][2] = 1.0
        return affineTransforms(subtractCentroid(points), matrix)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawPath(path5, paint3)
        canvas?.drawPath(path5, paint1)
        val newPoints3 = rotate(points, 180.0)
        updatePath(points, newPoints3, path5)
        canvas?.drawPath(path5, paint1)
        canvas?.drawPath(path5, paint3)

        canvas?.drawPath(squarePath, paint1)
        canvas?.drawPath(squarePath, paint3)
        val newSquarePoints = rotate(squarePoints, 45.0)
        updatePath(squarePoints, newSquarePoints, squarePath)
        canvas?.drawPath(squarePath, paint1)
        canvas?.drawPath(squarePath, paint3)
    }
}