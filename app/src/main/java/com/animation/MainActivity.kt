package com.animation

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import com.animation.drawableAnimation.DrawableAnimationActivity
import com.animation.propertyanimation.PropertyAnimActivity
import com.animation.viewanimation.ViewAnimActivity

/**
 * 创建时间: 2018/12/20 16:46 <br>
 * 作者: qiudengjiao <br>
 * 描述: 动画演示主页面
 */
class MainActivity : AppCompatActivity(), OnClickListener {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    initUI()
  }

  private fun initUI() {
    (findViewById<Button>(R.id.btn_property_anim)).setOnClickListener(this)
    (findViewById<Button>(R.id.btn_view_anim)).setOnClickListener(this)
  }

  /**
   * 点击事件响应
   */
  override fun onClick(v: View?) {

    when (v?.id) {
      R.id.btn_view_anim -> {
        jumpToViewAnimActivity()
      }

      R.id.btn_property_anim -> {
        jumpToPropertyAnimActivity()
      }
    }
  }

  /**
   * Property Animation
   */
  private fun jumpToPropertyAnimActivity() {
    startActivity(Intent(this, PropertyAnimActivity::class.java))
  }

  /**
   * View Animation
   */
  private fun jumpToViewAnimActivity() {
    startActivity(Intent(this, ViewAnimActivity::class.java))
  }

}