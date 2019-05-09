package com.example.lecture13_kotlin

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View

class BouncingBallView(mContext: Context, attrs: AttributeSet) : View(mContext, attrs) {
    private val SIZE = 100f
    private var ballX = 0f
    private var ballY = 0f
    private var dx = 80f
    private var dy = 80f
    val ball_color = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if(canvas == null) return

        ball_color.setARGB(255, 255, 0, 255)
        ball_color.typeface = Typeface.create(Typeface.MONOSPACE, Typeface.BOLD)
        ball_color.textSize = 50f
        canvas.drawARGB(255, 255, 255,0)
        canvas.drawText("2D Game Development Testing", 100f, 400f, ball_color)
        canvas.drawOval(RectF(ballX, ballY, ballX + SIZE,ballY +SIZE), ball_color)

    }

    fun moveBall(){
        ballX += dx
        if(ballX + SIZE >= width || ballX <= 0){
            dx = -dx
        }
        ballY +=dy
        if(ballY + SIZE >= height || ballY <= 0){
            dy = -dy
        }
        postInvalidate()
    }

}