package com.animation.propertyanimation

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.animation.R

/**
 * 创建时间: 2019/01/16 21:02 <br>
 * 作者: qiudengjiao <br>
 * 描述: 属性动画
 */
class PropertyAnimActivity : AppCompatActivity(), View.OnClickListener {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_anim_property)

    initUI()
  }

  /**
   * 初始化 UI
   */
  private fun initUI() {
    (findViewById<Button>(R.id.area_click_btn)).setOnClickListener(this)
    (findViewById<Button>(R.id.area_property_click_btn)).setOnClickListener(this)
    (findViewById<Button>(R.id.value_property_click_btn)).setOnClickListener(this)
    (findViewById<Button>(R.id.object_property_click_btn)).setOnClickListener(this)
  }

  /**
   * 点击事件响应
   */
  override fun onClick(v: View?) {
    when (v?.id) {

      R.id.area_click_btn -> {
        startAreaClickActivty()
      }

      R.id.area_property_click_btn -> {
        startAreaClickPropertyActivty()
      }

      R.id.value_property_click_btn -> {
        startValuePropertyActivity()
      }

      R.id.object_property_click_btn -> {
        startObjectPropertyActivity()
      }
    }
  }

  private fun startAreaClickActivty() {
    startActivity(Intent(this, AreaClickViewAnimActivity::class.java))
  }

  private fun startAreaClickPropertyActivty() {
    startActivity(Intent(this, AreaClickPropertyAnimActivity::class.java))
  }

  private fun startValuePropertyActivity() {
    startActivity(Intent(this, ValueAnimatorAnimActivity::class.java))
  }

  private fun startObjectPropertyActivity() {
    startActivity(Intent(this, ObjectAnimatorActivity::class.java))
  }
}