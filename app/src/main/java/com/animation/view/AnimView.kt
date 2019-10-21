package com.animation.view

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import com.animation.evaluator.ColorEvaluator
import com.animation.evaluator.PointEvaluator
import com.animation.interpolator.DecelerateAccelerateInterpolator
import com.animation.model.Point

/**
 * 创建时间: 2019/07/26 10:36 <br>
 * 作者: qiudengjiao <br>
 * 描述: 自定义动画 View
 */
class AnimView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

  companion object {
    const val RADIUS = 70f
  }

  private var mCurrentPoint: Point? = null
  private val mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private var color: String? = null

  init {
    mPaint.color = Color.BLUE
  }

  override fun onDraw(canvas: Canvas?) {
    super.onDraw(canvas)

    if (mCurrentPoint == null) {
      mCurrentPoint = Point(RADIUS, RADIUS)
      drawCircle(canvas)
    } else {
      drawCircle(canvas)
    }
  }

  private fun drawCircle(canvas: Canvas?) {

    val x = mCurrentPoint?.x ?: 0f
    val y = mCurrentPoint?.y ?: 0f

    canvas?.drawCircle(x, y, RADIUS, mPaint)
  }

  /**
   * 开始 Value 动画
   */
  fun startValueAnimation() {
    val startPoint = Point(RADIUS, RADIUS)
    val endPoint = Point(width - RADIUS, height - RADIUS)
    val anim = ValueAnimator.ofObject(PointEvaluator(), startPoint, endPoint)
    anim.addUpdateListener {
      mCurrentPoint = it.animatedValue as Point
      invalidate()
      Log.e("ValueAnimator", "CurrentPoint::$mCurrentPoint")
    }
//    anim.interpolator = DecelerateInterpolator()
//    anim.interpolator = LinearInterpolator()
//    anim.interpolator = BounceInterpolator()
    anim.interpolator = AccelerateDecelerateInterpolator()
    anim.interpolator = DecelerateAccelerateInterpolator()
    anim.duration = 6000
    anim.start()
  }

  fun startObjectAnimation(animView: AnimView?) {
    val objectAnim =
      ObjectAnimator.ofObject(animView, "color", ColorEvaluator(), "#0000FF", "#FF0000")
    objectAnim.duration = 6000
    objectAnim.start()
  }

  /**
   * 开始 Value 和 Object 组合动画
   */
  fun startValueAndObjectAnimation() {
    val startPoint = Point(RADIUS, RADIUS)
    val endPoint = Point(width - RADIUS, height - RADIUS)
    val valueAnim = ValueAnimator.ofObject(PointEvaluator(), startPoint, endPoint)

    valueAnim.addUpdateListener {
      mCurrentPoint = it.animatedValue as Point
      invalidate()
    }

    val objectAnim = ObjectAnimator.ofObject(this, "color", ColorEvaluator(), "#0000FF", "#FF0000")
    val animSet = AnimatorSet()
    animSet.play(valueAnim).with(objectAnim)
    animSet.duration = 6000
    animSet.start()
  }

  fun getColor(): String? {
    return color
  }

  fun setColor(color: String) {
    this.color = color
    mPaint.color = Color.parseColor(color)
    invalidate()
  }
}