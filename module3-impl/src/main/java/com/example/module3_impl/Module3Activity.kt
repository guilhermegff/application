package com.example.module3_impl

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.Timer
import java.util.TimerTask
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

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

    private var drawCube1Vertices = arrayOf<Coordinate>()
    private var drawCube2Vertices = arrayOf<Coordinate>()
    private var drawCube3Vertices = arrayOf<Coordinate>()

    private var drawCube4Vertices = arrayOf<Coordinate>()
    private var drawCube5Vertices = arrayOf<Coordinate>()
    private var drawCube6Vertices = arrayOf<Coordinate>()

    private var drawCube7Vertices = arrayOf<Coordinate>()
    private var drawCube8Vertices = arrayOf<Coordinate>()
    private var drawCube9Vertices = arrayOf<Coordinate>()

    private var drawCube10Vertices = arrayOf<Coordinate>()
    private var drawCube11Vertices = arrayOf<Coordinate>()
    private var drawCube12Vertices = arrayOf<Coordinate>()

    private var drawCube13Vertices = arrayOf<Coordinate>()
    private var drawCube14Vertices = arrayOf<Coordinate>()

    private var drawCube15Vertices = arrayOf<Coordinate>()
    private var drawCube16Vertices = arrayOf<Coordinate>()

    private var drawRobotHeadVertices = arrayOf<Coordinate>()
    private var drawRobotNeckVertices = arrayOf<Coordinate>()
    private var drawRobotTorsoVertices = arrayOf<Coordinate>()

    private var drawRobotLeftLegVertices = arrayOf<Coordinate>()

    constructor(screenHeight: Int, screenWidth: Int, context: Context) : this(context) {
        mHeight = screenHeight
        mWidth = screenWidth

        defineInitialCubeVertices()

        /*cube1Transforms()
        cube2Transforms()
        cube3Transforms()
        cube4Transforms()
        cube5Transforms()
        cube6Transforms()
        cube7Transforms()
        cube8Transforms()
        cube9Transforms()*/

        /*val timer = Timer()
        var reset = false
        val task = object : TimerTask() {
            var angleX = 0.0
            var angleY = 0.0
            var angleZ = 0.0
            override fun run() {
                drawCube10Vertices = scale3D2(cubeVertices, 90.0, 90.0, 90.0)
                drawCube10Vertices = euler(drawCube10Vertices, angleX, angleY, angleZ)
                drawCube10Vertices = translate3D2(drawCube10Vertices, 200.0, 200.0, 0.0)
                this@MyView.invalidate()

                if (!reset) {
                    if (angleX in 200.0..250.0) {
                        angleZ += 1.0
                        angleX += 1.0
                    } else {
                        angleX += 1.0
                    }
                    if (angleX == 360.0) reset = true
                }

                if (reset) {
                    if (angleX in 200.0..250.0) {
                        angleZ -= 1.0
                        angleX -= 1.0
                    } else {
                        angleX -= 1.0
                    }
                    if (angleX == 0.0) reset = false
                }
            }
        }
        timer.scheduleAtFixedRate(task, 100, 150)
        this.invalidate()*/

        /*val timer2 = Timer()
        val task2 = object : TimerTask() {
            var angle = 0.0
            override fun run() {
                drawCube11Vertices = translate3D2(cubeVertices, 2.0, 2.0, 2.0)
                drawCube11Vertices = scale3D2(drawCube11Vertices, 40.0, 40.0, 40.0)
                drawCube11Vertices = rotateX2(drawCube11Vertices, 90.0)
                drawCube11Vertices = rotateZ2(drawCube11Vertices, angle)
                drawCube11Vertices = rotateY2(drawCube11Vertices, 60.0)
                drawCube11Vertices = translate3D2(drawCube11Vertices, 200.0, 200.0, 0.0)
                this@MyView.invalidate()
                angle += 10.0
                if (angle >= 360) angle = 0.0
            }
        }
        timer2.scheduleAtFixedRate(task2, 750, 150)
        this.invalidate()*/

        /*val timer3 = Timer()
        val task3 = object : TimerTask() {
            var angle = 0.0
            override fun run() {
                drawCube12Vertices = translate3D2(cubeVertices, 2.0, 2.0, 2.0)
                drawCube12Vertices = scale3D2(drawCube12Vertices, 40.0, 40.0, 40.0)
                drawCube12Vertices = rotateX2(drawCube12Vertices, angle)
                drawCube12Vertices = rotateY2(drawCube12Vertices, 60.0)
                drawCube12Vertices = rotateZ2(drawCube12Vertices, 90.0)
                drawCube12Vertices = translate3D2(drawCube12Vertices, 200.0, 200.0, 0.0)

                this@MyView.invalidate()
                angle += 10.0
                if (angle >= 360) angle = 0.0
            }
        }
        timer3.scheduleAtFixedRate(task3, 500, 200)
        this.invalidate()*/

        val timer4 = Timer()
        drawCube13Vertices = translate3D2(cubeVertices, 2.0, 2.0, 2.0)
        drawCube13Vertices = scale3D2(drawCube13Vertices, 40.0, 40.0, 40.0)
        /*val task4 = object : TimerTask() {
            var positionX = 0f
            var dir = true
            override fun run() {
                if (positionX + 120 >= width && dir) {
                    dir = false
                } else if (!dir && positionX + 40 <= 0) {
                    dir = true
                }
                if (dir) {
                    drawCube13Vertices = translate3D2(drawCube13Vertices, 1.0, 0.0, 0.0)
                    positionX += 1f
                } else {
                    drawCube13Vertices = translate3D2(drawCube13Vertices, -1.0, 0.0, 0.0)
                    positionX -= 1f
                }
                this@MyView.invalidate()
            }
        }
        timer4.scheduleAtFixedRate(task4, 100, 20)*/
        this.invalidate()

        /*val timer5 = Timer()
        drawCube14Vertices = translate3D2(cubeVertices, 2.0, 2.0, 2.0)
        drawCube14Vertices = scale3D2(drawCube14Vertices, 40.0, 40.0, 40.0)
        val task5 = object : TimerTask() {
            var positionY = 0f
            var dir = true
            override fun run() {
                if (positionY + 120 >= height && dir) {
                    dir = false
                } else if (!dir && positionY + 40 <= 0) {
                    dir = true
                }
                if (dir) {
                    drawCube14Vertices = translate3D2(drawCube14Vertices, 0.0, 1.0, 0.0)
                    positionY += 1f
                } else {
                    drawCube14Vertices = translate3D2(drawCube14Vertices, 0.0, -1.0, 0.0)
                    positionY -= 1f
                }
                this@MyView.invalidate()
            }
        }
        timer5.scheduleAtFixedRate(task5, 100, 20)
        this.invalidate()*/

        /*val timer6 = Timer()
        drawCube15Vertices = translate3D2(cubeVertices, 35.0, 15.0, 2.0)
        drawCube15Vertices = scale3D2(drawCube15Vertices, 90.0, 90.0, 90.0)
        drawCube15Vertices = euler(drawCube15Vertices, 30.0, 60.0, 0.0)
        val task6 = object : TimerTask() {
            var positionY = 0f
            var dir = true
            override fun run() {
                drawCube15Vertices = quaternion2(drawCube15Vertices, -0.006, 0.0, 0.0)
                this@MyView.invalidate()
            }
        }
        timer6.scheduleAtFixedRate(task6, 0, 50)*/


        /*val timer7 = Timer()
        drawCube16Vertices = translate3D2(cubeVertices, 350.0, 250.0, 0.0)
        drawCube16Vertices = scale3D2(drawCube16Vertices, 90.0, 90.0, 90.0)
        drawCube16Vertices = euler(drawCube16Vertices, 30.0, 60.0, 0.0)
        val task7 = object : TimerTask() {
            override fun run() {
                drawCube16Vertices = quaternion2(drawCube16Vertices, -0.0065, 0.0, 0.0)
                this@MyView.invalidate()
            }
        }
        timer7.scheduleAtFixedRate(task7, 0, 51)
        this.invalidate()*/

        //robotHead()

        //robotNeck()

        val timerHead = Timer()
        //drawRobotHeadVertices = rotateY2(cubeVertices, 30.0)
        //drawRobotHeadVertices = rotateX2(drawRobotHeadVertices,  45.0)
        // translate3D2(drawRobotHeadVertices, 11.0, 10.0, 2.0)
        //drawRobotHeadVertices = addCuboidCentroid(drawRobotHeadVertices, scale3D2(drawRobotHeadVertices, 45.0, 45.0, 45.0))

        //drawRobotHeadVertices = scale3D2(drawRobotHeadVertices, 45.0, 45.0, 45.0)
        //drawRobotHeadVertices = translate3D2(drawRobotHeadVertices, 200.0, 200.0, 0.0)

        val taskHead = object : TimerTask() {
            var countY = 0.0
            var reset = false
            override fun run() {
                drawRobotHeadVertices = translate3D2(cubeVertices, 2.0, 2.0, 2.0)
                //drawRobotHeadVertices = projection(drawRobotHeadVertices, 1.1, 1.0, -1.0, 30.0)
                drawRobotHeadVertices = rotateX2(drawRobotHeadVertices,  countY * 4)
                drawRobotHeadVertices = quaternion2(drawRobotHeadVertices, -countY, countY, countY/4)//projection(drawRobotHeadVertices, 1.1, 1.0, -1.0, countY)
                drawRobotHeadVertices = addCuboidCentroid(translate3D2(drawRobotHeadVertices, 200.0, 200.0, 0.0), scale3D2(drawRobotHeadVertices, 45.0, 90.0, 45.0))
                if (!reset) {
                    if (countY < 1.0) {
                        countY += 0.1
                    }
                    if (countY > 1.0) reset = true
                }

                if (reset) {
                    if (countY > -1.0) {
                        countY -= 0.1
                    }
                    if (countY < -1.0) reset = false
                }
                this@MyView.invalidate()
            }
        }
        timerHead.scheduleAtFixedRate(taskHead, 0, 60)
        this.invalidate()

        val timerNeck = Timer()

        val taskNeck = object : TimerTask() {
            var countY = 0.0
            var reset = false
            override fun run() {
                drawRobotNeckVertices = rotateY2(cubeVertices,  countY)
                //drawRobotNeckVertices = rotateX2(drawRobotNeckVertices,  45.0)
                countY ++
                drawRobotNeckVertices = translate3D2(drawRobotNeckVertices, 21.5, 22.5, 2.0)
                drawRobotNeckVertices = addCuboidCentroid(drawRobotNeckVertices, scale3D2(drawRobotNeckVertices, 45.0, 45.0, 45.0))

                /*if (!reset) {
                    if (countY < 1.0) {
                        countY += 0.01
                    }
                    if (countY > 1.0) reset = true
                }

                if (reset) {
                    if (countY > -1.0) {
                        countY -= 0.01
                    }
                    if (countY < -1.0) reset = false
                }*/

                this@MyView.invalidate()
            }
        }
        timerNeck.scheduleAtFixedRate(taskNeck, 0, 60)

        val timerTorso = Timer()
        val taskTorso = object : TimerTask() {
            var countY = 0.0
            override fun run() {
                drawRobotTorsoVertices = rotateY2(cubeVertices,  countY)
                //drawRobotTorsoVertices = rotateX2(drawRobotTorsoVertices,  45.0)
                countY ++
                drawRobotTorsoVertices = translate3D2(drawRobotTorsoVertices, 8.0, 7.25, 2.0)
                drawRobotTorsoVertices = addCuboidCentroid(drawRobotTorsoVertices, scale3D2(drawRobotTorsoVertices, 125.0, 175.0, 75.0))

                this@MyView.invalidate()
            }
        }
        timerTorso.scheduleAtFixedRate(taskTorso, 0, 60)

        this.invalidate()

        val timerLeftLeg = Timer()
        val taskLeftLeg = object : TimerTask() {
            var countY = 0.0
            override fun run() {

                //drawRobotLeftLegVertices = rotateX2(drawRobotLeftLegVertices,  45.0)
                countY ++
                drawRobotLeftLegVertices = translate3D2(cubeVertices, 20.0, 10.22, 2.0)
                drawRobotLeftLegVertices = rotateY2(drawRobotLeftLegVertices,  countY)
                drawRobotLeftLegVertices = addCuboidCentroid(drawRobotLeftLegVertices, scale3D2(drawRobotLeftLegVertices, 45.0, 155.0, 75.0))

                this@MyView.invalidate()
            }
        }
        timerLeftLeg.scheduleAtFixedRate(taskLeftLeg, 0, 60)

        this.invalidate()
    }

    private fun defineInitialCubeVertices() {
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
    }

    private fun cube1Transforms() {
        drawCube1Vertices = translate3D(cubeVertices, 20.0, 20.0, 40.0)
        drawCube1Vertices = scale3D(drawCube1Vertices, 40.0, 40.0, 40.0)
        drawCube1Vertices = rotateZ(drawCube1Vertices, 80.0)
        drawCube1Vertices = rotateY(drawCube1Vertices, 30.0)
    }

    private fun cube2Transforms() {
        drawCube2Vertices = translate3D(cubeVertices, 25.0, 20.0, 40.0)
        drawCube2Vertices = scale3D(drawCube2Vertices, 40.0, 40.0, 40.0)
        drawCube2Vertices = rotateZ(drawCube2Vertices, 85.0)
        drawCube2Vertices = rotateY(drawCube2Vertices, 30.0)
    }

    private fun cube3Transforms() {
        drawCube3Vertices = translate3D(cubeVertices, 30.0, 20.0, 40.0)
        drawCube3Vertices = scale3D(drawCube3Vertices, 40.0, 40.0, 40.0)
        drawCube3Vertices = rotateZ(drawCube3Vertices, 90.0)
        drawCube3Vertices = rotateY(drawCube3Vertices, 30.0)
    }

    private fun cube4Transforms() {
        drawCube4Vertices = translate3D(cubeVertices, 20.0, 15.0, 40.0)
        drawCube4Vertices = scale3D(drawCube4Vertices, 40.0, 40.0, 40.0)
        drawCube4Vertices = rotateZ(drawCube4Vertices, 80.0)
        drawCube4Vertices = rotateY(drawCube4Vertices, 30.0)
    }

    private fun cube5Transforms() {
        drawCube5Vertices = translate3D(cubeVertices, 20.0, 10.0, 40.0)
        drawCube5Vertices = scale3D(drawCube5Vertices, 40.0, 40.0, 40.0)
        drawCube5Vertices = rotateZ(drawCube5Vertices, 85.0)
        drawCube5Vertices = rotateY(drawCube5Vertices, 30.0)
    }

    private fun cube6Transforms() {
        drawCube6Vertices = translate3D(cubeVertices, 20.0, 5.0, 40.0)
        drawCube6Vertices = scale3D(drawCube6Vertices, 40.0, 40.0, 40.0)
        drawCube6Vertices = rotateZ(drawCube6Vertices, 90.0)
        drawCube6Vertices = rotateY(drawCube6Vertices, 30.0)
    }

    private fun cube7Transforms() {
        drawCube7Vertices = translate3D(cubeVertices, 20.0, 20.0, 35.0)
        drawCube7Vertices = scale3D(drawCube7Vertices, 40.0, 40.0, 40.0)
        drawCube7Vertices = rotateZ(drawCube7Vertices, 80.0)
        drawCube7Vertices = rotateY(drawCube7Vertices, 30.0)
    }

    private fun cube8Transforms() {
        drawCube8Vertices = translate3D(cubeVertices, 20.0, 20.0, 30.0)
        drawCube8Vertices = scale3D(drawCube8Vertices, 40.0, 40.0, 40.0)
        drawCube8Vertices = rotateZ(drawCube8Vertices, 85.0)
        drawCube8Vertices = rotateY(drawCube8Vertices, 30.0)
    }

    private fun cube9Transforms() {
        drawCube9Vertices = translate3D(cubeVertices, 20.0, 20.0, 25.0)
        drawCube9Vertices = scale3D(drawCube9Vertices, 40.0, 40.0, 40.0)
        drawCube9Vertices = rotateZ(drawCube9Vertices, 90.0)
        drawCube9Vertices = rotateY(drawCube9Vertices, 30.0)
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

    private val paint3 = Paint().apply {
        style = Paint.Style.FILL
        shader = linear
    }

    private val paint4: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        color = Color.BLACK
        strokeWidth = 5f
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

    private fun updatePath2(
        oldPoints: Array<Coordinate>, newPoints: Array<Coordinate>
    ): Array<Coordinate> {
        return addCuboidCentroid(oldPoints, newPoints)
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

    private fun subtractCuboidCentroid(points: Array<Coordinate>): Array<Coordinate> {
        var x: Double = 0.0
        var y: Double = 0.0
        var z: Double = 0.0
        points.forEach {
            x += it.x
            y += it.y
            z += it.z
        }
        x /= points.size
        y /= points.size
        z /= points.size
        val result = arrayListOf<Coordinate>()
        for (p in points) {
            result.add(Coordinate(p.x - x, p.y - y, p.z - z))
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

    private fun addCuboidCentroid(
        from: Array<Coordinate>, to: Array<Coordinate>
    ): Array<Coordinate> {
        var x: Double = 0.0
        var y: Double = 0.0
        var z: Double = 0.0
        from.forEach {
            x += it.x
            y += it.y
            z += it.z
        }
        x /= points.size
        y /= points.size
        z /= points.size
        val result = arrayListOf<Coordinate>()
        for (p in to) {
            result.add(Coordinate(p.x + x, p.y + y, p.z + z))
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

    private fun euler(
        vertices: Array<Coordinate>, sx: Double, sy: Double, sz: Double
    ): Array<Coordinate> = with(identityMatrix2) {
        this[0][0] = cos(
            Math.toRadians(sx) * cos(Math.toRadians(sz)) + (sin(Math.toRadians(sx)) * cos(
                Math.toRadians(sy) * -sin(Math.toRadians(sz))
            ))
        )
        this[0][1] =
            cos(Math.toRadians(sx)) * sin(Math.toRadians(sz)) + (sin(Math.toRadians(sx)) * cos(
                Math.toRadians(sy)
            )) * cos(Math.toRadians(sz))
        this[0][2] = sin(Math.toRadians(sx)) * sin(Math.toRadians(sy))
        this[1][0] =
            -sin(Math.toRadians(sx)) * cos(sz) + (cos((Math.toRadians(sx))) * cos(Math.toRadians(sy))) * -sin(
                Math.toRadians(sz)
            )
        this[1][1] = -sin(Math.toRadians(sx)) * sin(
            Math.toRadians(sz) + (cos(Math.toRadians(sx)) * cos(
                Math.toRadians(sy)
            )) * cos(Math.toRadians(sz))
        )
        this[1][2] = cos(Math.toRadians(sx)) * cos(Math.toRadians(sy))
        this[2][0] = -sin(Math.toRadians(sy)) * -sin(Math.toRadians(sz))
        this[2][1] = -sin(Math.toRadians(sy)) * cos(Math.toRadians(sz))
        this[2][2] = cos(Math.toRadians(sy))
        transformation2(vertices, this)
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

        override fun toString(): String {
            return "${this.x} + ${this.y} + ${this.z} + ${this.w}"
        }
    }

    private val identityMatrix: Array<Double>
        get() = arrayOf(
            1.0, 0.0, 0.0, 0.0,
            0.0, 1.0, 0.0, 0.0,
            0.0, 0.0, 1.0, 0.0,
            0.0, 0.0, 0.0, 1.0,
        )

    private val identityMatrix2: Array<DoubleArray>
        get() = arrayOf(
            doubleArrayOf(1.0, 0.0, 0.0, 0.0),
            doubleArrayOf(0.0, 1.0, 0.0, 0.0),
            doubleArrayOf(0.0, 0.0, 1.0, 0.0),
            doubleArrayOf(0.0, 0.0, 0.0, 1.0)
        )

    private fun transformation(vertex: Coordinate, matrix: Array<Double>) = Coordinate(
        matrix[0] * vertex.x + matrix[1] * vertex.y + matrix[2] * vertex.z + matrix[3],
        matrix[4] * vertex.x + matrix[5] * vertex.y + matrix[6] * vertex.z + matrix[7],
        matrix[8] * vertex.x + matrix[9] * vertex.y + matrix[10] * vertex.z + matrix[11],
        matrix[12] * vertex.x + matrix[13] * vertex.y + matrix[14] * vertex.z + matrix[15]
    )

    private fun transformation2(vertex: Coordinate, matrix: Array<DoubleArray>) = Coordinate(
        matrix[0][0] * vertex.x + matrix[0][1] * vertex.y + matrix[0][2] * vertex.z + matrix[0][3],
        matrix[1][0] * vertex.x + matrix[1][1] * vertex.y + matrix[1][2] * vertex.z + matrix[1][3],
        matrix[2][0] * vertex.x + matrix[2][1] * vertex.y + matrix[2][2] * vertex.z + matrix[2][3],
        matrix[3][0] * vertex.x + matrix[3][1] * vertex.y + matrix[3][2] * vertex.z + matrix[3][3]
    )

    private fun transformation(vertices: Array<Coordinate>, matrix: Array<Double>) =
        Array(vertices.size) {
            transformation(vertices[it], matrix).apply {
                normalise()
            }
        }

    private fun transformation2(vertices: Array<Coordinate>, matrix: Array<DoubleArray>) =
        Array(vertices.size) {
            transformation2(vertices[it], matrix).apply {
                normalise()
            }
        }

    private fun translate3D(
        vertices: Array<Coordinate>, tx: Double, ty: Double, tz: Double
    ): Array<Coordinate> = with(identityMatrix) {
        this[3] = tx
        this[7] = ty
        this[11] = tz
        transformation(vertices, this)
    }

    private fun translate3D2(
        vertices: Array<Coordinate>, tx: Double, ty: Double, tz: Double
    ): Array<Coordinate> = with(identityMatrix2) {
        this[0][3] = tx
        this[1][3] = ty
        this[3][3] = tz
        transformation2(vertices, this)
    }

    private fun scale3D(
        vertices: Array<Coordinate>, sx: Double, sy: Double, sz: Double
    ): Array<Coordinate> = with(identityMatrix) {
        this[0] = sx
        this[5] = sy
        this[10] = sz
        transformation(vertices, this)
    }

    private fun scale3D2(
        vertices: Array<Coordinate>, sx: Double, sy: Double, sz: Double
    ): Array<Coordinate> = with(identityMatrix2) {
        this[0][0] = sx
        this[1][1] = sy
        this[2][2] = sz
        transformation2(vertices, this)
    }

    private fun shear3D(
        vertices: Array<Coordinate>, hx: Double, hy: Double
    ): Array<Coordinate> = with(identityMatrix) {
        //this[0][2] = hx
        //this[1][2] = hy
        transformation(vertices, this)
    }

    private fun quaternion(
        vertices: Array<Coordinate>, ax: Double, ay: Double, az: Double
    ): Array<Coordinate> = with(identityMatrix) {
        this[0] = 1.0 + (ax * ax) - (ay * ay) - (az * az)
        this[1] = 2 * ax * ay - 2 * 1 * az
        this[2] = 2 * ax * az + 2 * 1 * ay
        this[4] = 2 * ax * ay + 2 * 1 * az
        this[5] = 1.0 + (ay * ay) - (ax * ax) - (az * az)
        this[6] = 2 * ay * az - 2 * 1 * ax
        this[8] = 2 * ax * az - 2 * 1 * ay
        this[9] = 2 * ay * az + 2 * 1 * ax
        this[10] = 1 + (az * az) - (ax * ax) - (ay * ay)
        transformation(vertices, this)
    }

    private fun quaternion2(
        vertices: Array<Coordinate>, ax: Double, ay: Double, az: Double
    ): Array<Coordinate> = with(identityMatrix2) {
        this[0][0] = 1.0 + (ax * ax) - (ay * ay) - (az * az)
        this[0][1] = 2 * ax * ay - 2 * 1 * az
        this[0][2] = 2 * ax * az + 2 * 1 * ay
        this[1][0] = 2 * ax * ay + 2 * 1 * az
        this[1][1] = 1.0 + (ay * ay) - (ax * ax) - (az * az)
        this[1][2] = 2 * ay * az - 2 * 1 * ax
        this[2][0] = 2 * ax * az - 2 * 1 * ay
        this[2][1] = 2 * ay * az + 2 * 1 * ax
        this[2][2] = 1 + (az * az) - (ax * ax) - (ay * ay)
        transformation2(vertices, this)
    }

    private fun projection(
        vertices: Array<Coordinate>, far: Double, near: Double, ar: Double, angle: Double
    ): Array<Coordinate> = with(identityMatrix2) {
        this[0][0] = 1.0 / (ar) * tan(angle / 2)
        this[1][1] = 1.0 / tan(angle / 2)
        this[2][2] = - (far + near / far - near)
        this[2][3] = - (2 * far * (near) / far - near)
        this[3][2] = - 1.0
        transformation2(vertices, this)
    }

    private fun rotateX(
        vertices: Array<Coordinate>, degrees: Double
    ): Array<Coordinate> = with(identityMatrix) {
        this[5] = cos(Math.toRadians(degrees))
        this[6] = -sin(Math.toRadians(degrees))
        this[9] = sin(Math.toRadians(degrees))
        this[10] = cos(Math.toRadians(degrees))
        transformation(vertices, this)
    }

    private fun rotateX2(
        vertices: Array<Coordinate>, degrees: Double
    ): Array<Coordinate> = with(identityMatrix2) {
        this[1][1] = cos(Math.toRadians(degrees))
        this[1][2] = -sin(Math.toRadians(degrees))
        this[2][1] = sin(Math.toRadians(degrees))
        this[2][2] = cos(Math.toRadians(degrees))
        transformation2(vertices, this)
    }

    private fun rotateY(
        vertices: Array<Coordinate>, degrees: Double
    ): Array<Coordinate> = with(identityMatrix) {
        this[0] = cos(Math.toRadians(degrees))
        this[2] = sin(Math.toRadians(degrees))
        this[8] = -sin(Math.toRadians(degrees))
        this[10] = cos(Math.toRadians(degrees))
        transformation(vertices, this)
    }

    private fun rotateY2(
        vertices: Array<Coordinate>, degrees: Double
    ): Array<Coordinate> = with(identityMatrix2) {
        this[0][0] = cos(Math.toRadians(degrees))
        this[0][2] = sin(Math.toRadians(degrees))
        this[2][0] = -sin(Math.toRadians(degrees))
        this[2][2] = cos(Math.toRadians(degrees))
        transformation2(vertices, this)
    }

    private fun rotateZ(
        vertices: Array<Coordinate>, degrees: Double
    ): Array<Coordinate> = with(identityMatrix) {
        this[0] = cos(Math.toRadians(degrees))
        this[1] = -sin(Math.toRadians(degrees))
        this[4] = sin(Math.toRadians(degrees))
        this[5] = cos(Math.toRadians(degrees))
        transformation(vertices, this)
    }

    private fun rotateZ2(
        vertices: Array<Coordinate>, degrees: Double
    ): Array<Coordinate> = with(identityMatrix2) {
        this[0][0] = cos(Math.toRadians(degrees))
        this[0][1] = -sin(Math.toRadians(degrees))
        this[1][0] = sin(Math.toRadians(degrees))
        this[1][1] = cos(Math.toRadians(degrees))
        transformation2(vertices, this)
    }

    private fun drawLinePairs(
        canvas: Canvas, vertices: Array<Coordinate>, start: Int, end: Int, paint: Paint
    ) {
        if (vertices.isNotEmpty()) {
            canvas.drawLine(
                vertices[start].x.toFloat(),
                vertices[start].y.toFloat(),
                vertices[end].x.toFloat(),
                vertices[end].y.toFloat(),
                paint
            )
        }
    }

    private fun drawCube(canvas: Canvas, coordinates: Array<Coordinate>, paint: Paint) {
        drawLinePairs(canvas, coordinates, 0, 1, paint)
        drawLinePairs(canvas, coordinates, 1, 3, paint)
        drawLinePairs(canvas, coordinates, 3, 2, paint)
        drawLinePairs(canvas, coordinates, 2, 0, paint)
        drawLinePairs(canvas, coordinates, 4, 5, paint)
        drawLinePairs(canvas, coordinates, 5, 7, paint)
        drawLinePairs(canvas, coordinates, 7, 6, paint)
        drawLinePairs(canvas, coordinates, 6, 4, paint)
        drawLinePairs(canvas, coordinates, 0, 4, paint)
        drawLinePairs(canvas, coordinates, 1, 5, paint)
        drawLinePairs(canvas, coordinates, 2, 6, paint)
        drawLinePairs(canvas, coordinates, 3, 7, paint)
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
            /*drawCube(it, drawCube11Vertices, paint1)
            drawCube(it, drawCube12Vertices, paint1)
            drawCube(it, drawCube10Vertices, paint4)
            drawCube(it, drawCube13Vertices, paint1)
            drawCube(it, drawCube14Vertices, paint1)
            drawCube(it, drawCube15Vertices, paint1)
            drawCube(it, drawCube16Vertices, paint4)*/

            drawCube(it, drawRobotHeadVertices, paint4)
            //drawCube(it, drawRobotNeckVertices, paint1)
            //drawCube(it, drawRobotTorsoVertices, paint4)
            //drawCube(it, drawRobotLeftLegVertices, paint1)
            drawCube(it, drawCube13Vertices, paint1)
        }

        /*val graph = createLinePath(linePoints, mWidth, mHeight)
        canvas?.drawPath(graph, paint1)*/
    }
}