package com.animation.viewanimation

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import android.view.animation.CycleInterpolator
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.TextView
import com.animation.R
import com.animation.drawableAnimation.DrawableAnimationActivity

/**
 * 创建时间: 2018/12/28 21:23 <br>
 * 作者: qiudengjiao <br>
 * 描述: View 动画
 */
class ViewAnimActivity : AppCompatActivity(), View.OnClickListener {

  private lateinit var mTvAnim: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_view_animation)

    initUI()
  }

  /**
   * 初始化 UI
   */
  private fun initUI() {
    val alpha = findViewById<Button>(R.id.alpha)
    val scale = findViewById<Button>(R.id.scale)
    val translate = findViewById<Button>(R.id.translate)
    val rotate = findViewById<Button>(R.id.rotate)
    val set = findViewById<Button>(R.id.set)
    mTvAnim = findViewById(R.id.tv_anim)

    alpha.setOnClickListener(this)
    scale.setOnClickListener(this)
    translate.setOnClickListener(this)
    rotate.setOnClickListener(this)
    set.setOnClickListener(this)
    (findViewById<Button>(R.id.btn_drawable_anim)).setOnClickListener(this)
  }

  /**
   * 点击事件响应
   */
  override fun onClick(v: View?) {
    when (v?.id) {

      R.id.alpha -> {
        xmlAlphaAnimation()
      }

      R.id.scale -> {
//        xmlScaleAnimation()
        codeScaleAnimation()
      }

      R.id.translate -> {
        xmlTranslateAnimation()
      }

      R.id.rotate -> {
        xmlRotateAnimation()
      }

      R.id.set -> {
//        xmlSetAnimation()
        codeSetAnimation()
      }

      R.id.btn_drawable_anim -> {
        jumpToDrawableAnimActivity()
      }

    }
  }

  /**
   * XML 渐变透明变化动画效果
   */
  private fun xmlAlphaAnimation() {
    val anim = AnimationUtils.loadAnimation(this, R.anim.alphaanim)
    mTvAnim.startAnimation(anim)
  }

  /**
   * XML 渐变尺寸伸缩动画效果
   */
  private fun xmlScaleAnimation() {
    val anim = AnimationUtils.loadAnimation(this, R.anim.scaleanim)
    mTvAnim.startAnimation(anim)
  }

  /**
   * 代码实现 渐变尺寸伸缩动画效果
   */
  private fun codeScaleAnimation() {
    val scaleAnimation = ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f)
    scaleAnimation.duration = 700
    mTvAnim.startAnimation(scaleAnimation)
  }

  /**
   * XML 画面转移旋转动画效果
   */
  private fun xmlRotateAnimation() {
    val anim = AnimationUtils.loadAnimation(this, R.anim.rotateanim)
    mTvAnim.startAnimation(anim)
  }

  /**
   * XML 画面变换位置移动动画效果
   */
  private fun xmlTranslateAnimation() {
    val anim = AnimationUtils.loadAnimation(this, R.anim.translateanim)
    mTvAnim.startAnimation(anim)
  }

  /**
   * XML set 动画集
   */
  private fun xmlSetAnimation() {
    val anim = AnimationUtils.loadAnimation(this, R.anim.setanimation)
    mTvAnim.startAnimation(anim)
  }

  /**
   * code set 动画集
   */
  private fun codeSetAnimation() {

    val alphaAnim = AlphaAnimation(0.0f, 1.0f)
    val scaleAnim = ScaleAnimation(
      0.0f,
      1.4f,
      0.0f,
      1.4f,
      Animation.RELATIVE_TO_SELF,
      0.5f,
      Animation.RELATIVE_TO_SELF,
      0.5f
    )
    val rotateAnim = RotateAnimation(
      0.0f,
      720.0f,
      Animation.RELATIVE_TO_SELF,
      0.5f,
      Animation.RELATIVE_TO_SELF,
      0.5f
    )

    val setAnim = AnimationSet(true)

    setAnim.addAnimation(alphaAnim)
    setAnim.addAnimation(scaleAnim)
    setAnim.addAnimation(rotateAnim)

    setAnim.duration = 3000
    setAnim.fillAfter = true

    mTvAnim.startAnimation(setAnim)
  }

  /**
   * Drawable Animation
   */
  private fun jumpToDrawableAnimActivity() {
    startActivity(Intent(this, DrawableAnimationActivity::class.java))
  }
}




