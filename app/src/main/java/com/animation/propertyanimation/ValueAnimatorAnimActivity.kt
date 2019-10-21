package com.animation.propertyanimation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.animation.R
import com.animation.view.AnimView

/**
 * 创建时间: 2019/07/25 20:10 <br>
 * 作者: qiudengjiao <br>
 * 描述: ValueAnimator
 */
class ValueAnimatorAnimActivity : AppCompatActivity() {

  private var animView: AnimView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_value_animator_anim)

    initUI()
  }

  private fun initUI() {
    animView = findViewById(R.id.anim_view)
    val startValueAnim = findViewById<Button>(R.id.start_value_anim_btn)

    setListener(startValueAnim)
  }

  private fun setListener(button: Button) {
    button.setOnClickListener {
      animView?.startValueAnimation()
    }
  }

}