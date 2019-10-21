package com.animation.propertyanimation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.animation.R
import com.animation.view.AnimView




/**
 * 创建时间: 2019/07/26 15:45 <br>
 * 作者: qiudengjiao <br>
 * 描述: ObjectAnimator
 */
class ObjectAnimatorActivity : AppCompatActivity() {

  private var animView: AnimView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_value_animator_anim)

    initUI()
  }

  private fun initUI() {
    animView = findViewById(R.id.anim_view)
    val startValueAnim = findViewById<Button>(R.id.start_value_anim_btn)
    startValueAnim.text = "StartObjectAnimator"

    setListener(startValueAnim)
  }

  private fun setListener(button: Button) {
    button.setOnClickListener {
//      startAlphaAnimator(animView, "alpha")
//      startScaleAnimator(animView)

//      animView?.startObjectAnimation(animView)
      animView?.startValueAndObjectAnimation()

    }
  }

  /**
   * 实现类似于视图动画的旋转淡入淡出
   */
  private fun startAlphaAnimator(view: View?, type: String) {
    val animator = ObjectAnimator.ofFloat(view, type, 1f, 0f, 1f)
    animator.duration = 5000
    animator.start()
  }

  private fun startScaleAnimator(view: View?){
    val animator = ObjectAnimator.ofFloat(view, "scaleY", 1f, 3f, 1f)
    animator.duration = 5000
    animator.start()
  }
}