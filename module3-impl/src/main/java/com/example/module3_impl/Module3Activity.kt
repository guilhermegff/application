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
        setContentView(
            MyView(
                resources.displayMetrics.heightPixels, resources.displayMetrics.widthPixels, this
            )
        )
    }
}

class MyView(context: Context) : View(context) {
    private var mHeight: Int = 0
    private var mWidth: Int = 0
    private val cubeVertices = Array(8) { Coordinate() }
    private var drawCubeVertices = arrayOf<Coordinate>()
    private var drawCubeVertices2 = arrayOf<Coordinate>()
    private var drawCubeVertices3 = arrayOf<Coordinate>()

    private var drawCubeVertices4 = arrayOf<Coordinate>()
    private var drawCubeVertices5 = arrayOf<Coordinate>()
    private var drawCubeVertices6 = arrayOf<Coordinate>()

    private var drawCubeVertices7 = arrayOf<Coordinate>()
    private var drawCubeVertices8 = arrayOf<Coordinate>()
    private var drawCubeVertices9 = arrayOf<Coordinate>()

    constructor(screenHeight: Int, screenWidth: Int, context: Context) : this(context) {
        mHeight = screenHeight
        mWidth = screenWidth

        with(cubeVertices) {
            this[0] = Coordinate(-1.0, -1.0, -1.0, 1.0)
            this[1] = Coordinate(-1.0, -1.0, 1.0, 1.0)
            this[2] = Coordinate(-1.0, 1.0, -1.0, 1.0)
            this[3] = Coordinate(-1.0, 1.0, 1.0, 1.0)
            this[4] = Coordinate(1.0, -1.0, -1.0, 1.0)
            this[5] = Coordinate(1.0, -1.0, 1.0, 1.0)
            this[6] = Coordinate(1.0, 1.0, -1.0, 1.0)
            this[7] = Coordinate(1.0, 1.0, 1.0, 1.0)
        }

        drawCubeVertices = translate3D(cubeVertices, 20.0, 20.0, 40.0)
        drawCubeVertices = scale3D(drawCubeVertices, 40.0, 40.0, 40.0)
        drawCubeVertices = rotateZ(drawCubeVertices, 80.0)
        drawCubeVertices = rotateY(drawCubeVertices, 30.0)

        drawCubeVertices2 = translate3D(cubeVertices, 25.0, 20.0, 40.0)
        drawCubeVertices2 = scale3D(drawCubeVertices2, 40.0, 40.0, 40.0)
        drawCubeVertices2 = rotateZ(drawCubeVertices2, 85.0)
        drawCubeVertices2 = rotateY(drawCubeVertices2, 30.0)

        drawCubeVertices3 = translate3D(cubeVertices, 30.0, 20.0, 40.0)
        drawCubeVertices3 = scale3D(drawCubeVertices3, 40.0, 40.0, 40.0)
        drawCubeVertices3 = rotateZ(drawCubeVertices3, 90.0)
        drawCubeVertices3 = rotateY(drawCubeVertices3, 30.0)

        drawCubeVertices4 = translate3D(cubeVertices, 20.0, 15.0, 40.0)
        drawCubeVertices4 = scale3D(drawCubeVertices4, 40.0, 40.0, 40.0)
        drawCubeVertices4 = rotateZ(drawCubeVertices4, 80.0)
        drawCubeVertices4 = rotateY(drawCubeVertices4, 30.0)

        drawCubeVertices5 = translate3D(cubeVertices, 20.0, 10.0, 40.0)
        drawCubeVertices5 = scale3D(drawCubeVertices5, 40.0, 40.0, 40.0)
        drawCubeVertices5 = rotateZ(drawCubeVertices5, 85.0)
        drawCubeVertices5 = rotateY(drawCubeVertices5, 30.0)

        drawCubeVertices6 = translate3D(cubeVertices, 20.0, 5.0, 40.0)
        drawCubeVertices6 = scale3D(drawCubeVertices6, 40.0, 40.0, 40.0)
        drawCubeVertices6 = rotateZ(drawCubeVertices6, 90.0)
        drawCubeVertices6 = rotateY(drawCubeVertices6, 30.0)

        drawCubeVertices7 = translate3D(cubeVertices, 20.0, 20.0, 35.0)
        drawCubeVertices7 = scale3D(drawCubeVertices7, 40.0, 40.0, 40.0)
        drawCubeVertices7 = rotateZ(drawCubeVertices7, 80.0)
        drawCubeVertices7 = rotateY(drawCubeVertices7, 30.0)

        drawCubeVertices8 = translate3D(cubeVertices, 20.0, 20.0, 30.0)
        drawCubeVertices8 = scale3D(drawCubeVertices8, 40.0, 40.0, 40.0)
        drawCubeVertices8 = rotateZ(drawCubeVertices8, 85.0)
        drawCubeVertices8 = rotateY(drawCubeVertices8, 30.0)

        drawCubeVertices9 = translate3D(cubeVertices, 20.0, 20.0, 25.0)
        drawCubeVertices9 = scale3D(drawCubeVertices9, 40.0, 40.0, 40.0)
        drawCubeVertices9 = rotateZ(drawCubeVertices9, 90.0)
        drawCubeVertices9 = rotateY(drawCubeVertices9, 30.0)
        this.invalidate()
    }

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
        Point(500, 300), Point(500, 400), Point(600, 400), Point(600, 300)
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

    private val linePoints = arrayOf(11, 29, 10, 20, 12, 5, 31, 24, 21, 13)

    private fun createLinePath(input: Array<Int>, width: Int, height: Int): Path {
        var points = Array<Point>(input.size) { Point() }
        var minValue = 999999
        var maxValue = -999999
        input.forEachIndexed { index, _ ->
            points[index] = Point(index, input[index])
            minValue = Math.min(minValue, input[index])
            maxValue = Math.max(maxValue, input[index])
        }
        points = translate(points, 0, -minValue)
        val yScale: Double = (height / (maxValue - minValue).toDouble())
        val xScale: Double = (width / (input.size - 1).toDouble())
        points = scale(points, xScale, yScale)
        val result = Path()
        result.moveTo((points[0].x).toFloat(), (points[0].y).toFloat())
        points.forEachIndexed { index, point ->
            result.lineTo(point.x.toFloat(), point.y.toFloat())
        }
        return result
    }

    class Coordinate(
        var x: Double = 0.0, var y: Double = 0.0, var z: Double = 0.0, var w: Double = 1.0
    ) {
        fun normalise() {
            if (w != 0.0) {
                x /= w
                y /= w
                z /= w
                w = 1.0
            } else {
                w = 1.0
            }
        }
    }

    private val identityMatrix: Array<Double>
        get() = arrayOf(
            1.0, 0.0, 0.0, 0.0,
            0.0, 1.0, 0.0, 0.0,
            0.0, 0.0, 1.0, 0.0,
            0.0, 0.0, 0.0, 1.0,
           /* doubleArrayOf(1.0, 0.0, 0.0, 0.0),
            doubleArrayOf(0.0, 1.0, 0.0, 0.0),
            doubleArrayOf(0.0, 0.0, 1.0, 0.0),
            doubleArrayOf(0.0, 0.0, 0.0, 1.0)*/
        )

    private fun transformation(vertex: Coordinate, matrix: Array<Double>) = Coordinate(
        matrix[0] * vertex.x + matrix[1] * vertex.y + matrix[2] * vertex.z + matrix[3],
        matrix[4] * vertex.x + matrix[5] * vertex.y + matrix[6] * vertex.z + matrix[7],
        matrix[8] * vertex.x + matrix[9] * vertex.y + matrix[10] * vertex.z + matrix[11],
        matrix[12] * vertex.x + matrix[13] * vertex.y + matrix[14] * vertex.z + matrix[15]
    )

    private fun transformation(vertices: Array<Coordinate>, matrix: Array<Double>) =
        Array(vertices.size) {
            transformation(vertices[it], matrix).apply {
                normalise()
            }
        }

    private fun translate3D(
        vertices: Array<Coordinate>, tx: Double, ty: Double, tz: Double
    ): Array<Coordinate> = with(identityMatrix) {
        /*this[0][3] = tx
        this[1][3] = ty
        this[3][3] = tz*/
        this[3] = tx
        this[7] = ty
        this[11] = tz
        transformation(vertices, this)
    }

    private fun scale3D(
        vertices: Array<Coordinate>, sx: Double, sy: Double, sz: Double
    ): Array<Coordinate> = with(identityMatrix) {
        /*this[0][0] = sx
        this[1][1] = sy
        this[2][2] = sz*/
        this[0] = sx
        this[5] = sy
        this[10] = sz
        transformation(vertices, this)
    }

    private fun shear3D(
        vertices: Array<Coordinate>, hx: Double, hy: Double
    ): Array<Coordinate> = with(identityMatrix) {
        /*this[0][0] = cos(Math.toRadians(degrees))
        this[0][1] = -sin(Math.toRadians(degrees))
        this[1][0] = sin(Math.toRadians(degrees))
        this[1][1] = cos(Math.toRadians(degrees))*/
        //this[1] = cos(Math.toRadians(degrees))
        this[2] = hx
        //this[4] = sin(Math.toRadians(degrees))
        this[6] = hy
        //this[8] = cos(Math.toRadians(degrees))
        //this[9] = cos(Math.toRadians(degrees))
        transformation(vertices, this)
    }

    private fun rotateX(
        vertices: Array<Coordinate>, degrees: Double
    ): Array<Coordinate> = with(identityMatrix) {
        /*this[1][1] = cos(Math.toRadians(degrees))
        this[1][2] = -sin(Math.toRadians(degrees))
        this[2][1] = sin(Math.toRadians(degrees))
        this[2][2] = cos(Math.toRadians(degrees))*/
        this[5] = cos(Math.toRadians(degrees))
        this[6] = -sin(Math.toRadians(degrees))
        this[9] = sin(Math.toRadians(degrees))
        this[10] = cos(Math.toRadians(degrees))
        transformation(vertices, this)
    }

    private fun rotateY(
        vertices: Array<Coordinate>, degrees: Double
    ): Array<Coordinate> = with(identityMatrix) {
        /*this[0][0] = cos(Math.toRadians(degrees))
        this[0][2] = sin(Math.toRadians(degrees))
        this[2][0] = -sin(Math.toRadians(degrees))
        this[2][2] = cos(Math.toRadians(degrees))*/
        this[0] = cos(Math.toRadians(degrees))
        this[2] = sin(Math.toRadians(degrees))
        this[8] = -sin(Math.toRadians(degrees))
        this[10] = cos(Math.toRadians(degrees))
        transformation(vertices, this)
    }

    private fun rotateZ(
        vertices: Array<Coordinate>, degrees: Double
    ): Array<Coordinate> = with(identityMatrix) {
        /*this[0][0] = cos(Math.toRadians(degrees))
        this[0][1] = -sin(Math.toRadians(degrees))
        this[1][0] = sin(Math.toRadians(degrees))
        this[1][1] = cos(Math.toRadians(degrees))*/
        this[0] = cos(Math.toRadians(degrees))
        this[1] = -sin(Math.toRadians(degrees))
        this[4] = sin(Math.toRadians(degrees))
        this[5] = cos(Math.toRadians(degrees))
        transformation(vertices, this)
    }

    private fun drawLinePairs(
        canvas: Canvas, vertices: Array<Coordinate>, start: Int, end: Int, paint: Paint
    ) {
        canvas.drawLine(
            vertices[start].x.toFloat(),
            vertices[start].y.toFloat(),
            vertices[end].x.toFloat(),
            vertices[end].y.toFloat(),
            paint
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        /*canvas?.drawPath(path5, paint3)
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
        canvas?.drawPath(squarePath, paint3)*/

        canvas?.let {
            drawLinePairs(it, drawCubeVertices, 0, 1, paint1)
            drawLinePairs(it, drawCubeVertices, 1, 3, paint1)
            drawLinePairs(it, drawCubeVertices, 3, 2, paint1)
            drawLinePairs(it, drawCubeVertices, 2, 0, paint1)
            drawLinePairs(it, drawCubeVertices, 4, 5, paint1)
            drawLinePairs(it, drawCubeVertices, 5, 7, paint1)
            drawLinePairs(it, drawCubeVertices, 7, 6, paint1)
            drawLinePairs(it, drawCubeVertices, 6, 4, paint1)
            drawLinePairs(it, drawCubeVertices, 0, 4, paint1)
            drawLinePairs(it, drawCubeVertices, 1, 5, paint1)
            drawLinePairs(it, drawCubeVertices, 2, 6, paint1)
            drawLinePairs(it, drawCubeVertices, 3, 7, paint1)

            drawLinePairs(it, drawCubeVertices2, 0, 1, paint1)
            drawLinePairs(it, drawCubeVertices2, 1, 3, paint1)
            drawLinePairs(it, drawCubeVertices2, 3, 2, paint1)
            drawLinePairs(it, drawCubeVertices2, 2, 0, paint1)
            drawLinePairs(it, drawCubeVertices2, 4, 5, paint1)
            drawLinePairs(it, drawCubeVertices2, 5, 7, paint1)
            drawLinePairs(it, drawCubeVertices2, 7, 6, paint1)
            drawLinePairs(it, drawCubeVertices2, 6, 4, paint1)
            drawLinePairs(it, drawCubeVertices2, 0, 4, paint1)
            drawLinePairs(it, drawCubeVertices2, 1, 5, paint1)
            drawLinePairs(it, drawCubeVertices2, 2, 6, paint1)
            drawLinePairs(it, drawCubeVertices2, 3, 7, paint1)

            drawLinePairs(it, drawCubeVertices3, 0, 1, paint1)
            drawLinePairs(it, drawCubeVertices3, 1, 3, paint1)
            drawLinePairs(it, drawCubeVertices3, 3, 2, paint1)
            drawLinePairs(it, drawCubeVertices3, 2, 0, paint1)
            drawLinePairs(it, drawCubeVertices3, 4, 5, paint1)
            drawLinePairs(it, drawCubeVertices3, 5, 7, paint1)
            drawLinePairs(it, drawCubeVertices3, 7, 6, paint1)
            drawLinePairs(it, drawCubeVertices3, 6, 4, paint1)
            drawLinePairs(it, drawCubeVertices3, 0, 4, paint1)
            drawLinePairs(it, drawCubeVertices3, 1, 5, paint1)
            drawLinePairs(it, drawCubeVertices3, 2, 6, paint1)
            drawLinePairs(it, drawCubeVertices3, 3, 7, paint1)

            drawLinePairs(it, drawCubeVertices4, 0, 1, paint1)
            drawLinePairs(it, drawCubeVertices4, 1, 3, paint1)
            drawLinePairs(it, drawCubeVertices4, 3, 2, paint1)
            drawLinePairs(it, drawCubeVertices4, 2, 0, paint1)
            drawLinePairs(it, drawCubeVertices4, 4, 5, paint1)
            drawLinePairs(it, drawCubeVertices4, 5, 7, paint1)
            drawLinePairs(it, drawCubeVertices4, 7, 6, paint1)
            drawLinePairs(it, drawCubeVertices4, 6, 4, paint1)
            drawLinePairs(it, drawCubeVertices4, 0, 4, paint1)
            drawLinePairs(it, drawCubeVertices4, 1, 5, paint1)
            drawLinePairs(it, drawCubeVertices4, 2, 6, paint1)
            drawLinePairs(it, drawCubeVertices4, 3, 7, paint1)

            drawLinePairs(it, drawCubeVertices5, 0, 1, paint1)
            drawLinePairs(it, drawCubeVertices5, 1, 3, paint1)
            drawLinePairs(it, drawCubeVertices5, 3, 2, paint1)
            drawLinePairs(it, drawCubeVertices5, 2, 0, paint1)
            drawLinePairs(it, drawCubeVertices5, 4, 5, paint1)
            drawLinePairs(it, drawCubeVertices5, 5, 7, paint1)
            drawLinePairs(it, drawCubeVertices5, 7, 6, paint1)
            drawLinePairs(it, drawCubeVertices5, 6, 4, paint1)
            drawLinePairs(it, drawCubeVertices5, 0, 4, paint1)
            drawLinePairs(it, drawCubeVertices5, 1, 5, paint1)
            drawLinePairs(it, drawCubeVertices5, 2, 6, paint1)
            drawLinePairs(it, drawCubeVertices5, 3, 7, paint1)

            drawLinePairs(it, drawCubeVertices6, 0, 1, paint1)
            drawLinePairs(it, drawCubeVertices6, 1, 3, paint1)
            drawLinePairs(it, drawCubeVertices6, 3, 2, paint1)
            drawLinePairs(it, drawCubeVertices6, 2, 0, paint1)
            drawLinePairs(it, drawCubeVertices6, 4, 5, paint1)
            drawLinePairs(it, drawCubeVertices6, 5, 7, paint1)
            drawLinePairs(it, drawCubeVertices6, 7, 6, paint1)
            drawLinePairs(it, drawCubeVertices6, 6, 4, paint1)
            drawLinePairs(it, drawCubeVertices6, 0, 4, paint1)
            drawLinePairs(it, drawCubeVertices6, 1, 5, paint1)
            drawLinePairs(it, drawCubeVertices6, 2, 6, paint1)
            drawLinePairs(it, drawCubeVertices6, 3, 7, paint1)

            drawLinePairs(it, drawCubeVertices7, 0, 1, paint1)
            drawLinePairs(it, drawCubeVertices7, 1, 3, paint1)
            drawLinePairs(it, drawCubeVertices7, 3, 2, paint1)
            drawLinePairs(it, drawCubeVertices7, 2, 0, paint1)
            drawLinePairs(it, drawCubeVertices7, 4, 5, paint1)
            drawLinePairs(it, drawCubeVertices7, 5, 7, paint1)
            drawLinePairs(it, drawCubeVertices7, 7, 6, paint1)
            drawLinePairs(it, drawCubeVertices7, 6, 4, paint1)
            drawLinePairs(it, drawCubeVertices7, 0, 4, paint1)
            drawLinePairs(it, drawCubeVertices7, 1, 5, paint1)
            drawLinePairs(it, drawCubeVertices7, 2, 6, paint1)
            drawLinePairs(it, drawCubeVertices7, 3, 7, paint1)

            drawLinePairs(it, drawCubeVertices8, 0, 1, paint1)
            drawLinePairs(it, drawCubeVertices8, 1, 3, paint1)
            drawLinePairs(it, drawCubeVertices8, 3, 2, paint1)
            drawLinePairs(it, drawCubeVertices8, 2, 0, paint1)
            drawLinePairs(it, drawCubeVertices8, 4, 5, paint1)
            drawLinePairs(it, drawCubeVertices8, 5, 7, paint1)
            drawLinePairs(it, drawCubeVertices8, 7, 6, paint1)
            drawLinePairs(it, drawCubeVertices8, 6, 4, paint1)
            drawLinePairs(it, drawCubeVertices8, 0, 4, paint1)
            drawLinePairs(it, drawCubeVertices8, 1, 5, paint1)
            drawLinePairs(it, drawCubeVertices8, 2, 6, paint1)
            drawLinePairs(it, drawCubeVertices8, 3, 7, paint1)

            drawLinePairs(it, drawCubeVertices9, 0, 1, paint1)
            drawLinePairs(it, drawCubeVertices9, 1, 3, paint1)
            drawLinePairs(it, drawCubeVertices9, 3, 2, paint1)
            drawLinePairs(it, drawCubeVertices9, 2, 0, paint1)
            drawLinePairs(it, drawCubeVertices9, 4, 5, paint1)
            drawLinePairs(it, drawCubeVertices9, 5, 7, paint1)
            drawLinePairs(it, drawCubeVertices9, 7, 6, paint1)
            drawLinePairs(it, drawCubeVertices9, 6, 4, paint1)
            drawLinePairs(it, drawCubeVertices9, 0, 4, paint1)
            drawLinePairs(it, drawCubeVertices9, 1, 5, paint1)
            drawLinePairs(it, drawCubeVertices9, 2, 6, paint1)
            drawLinePairs(it, drawCubeVertices6, 3, 7, paint1)
        }

        /*val graph = createLinePath(linePoints, mWidth, mHeight)
        canvas?.drawPath(graph, paint1)*/
    }
}