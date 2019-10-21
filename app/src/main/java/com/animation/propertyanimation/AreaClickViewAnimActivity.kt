package com.animation.propertyanimation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.animation.R

/**
 * 创建时间: 2019/07/24 11:03 <br>
 * 作者: qiudengjiao <br>
 * 描述:  View 动画 区域点击 Test
 */
class AreaClickViewAnimActivity : AppCompatActivity() , View.OnClickListener{

  private lateinit var mTv: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_area_click)

    initUI()
  }

  /**
   * 初始化 UI
   */
  private fun initUI() {
    (findViewById<Button>(R.id.btn_start)).setOnClickListener(this)
    mTv = findViewById(R.id.tv_content)
    mTv.setOnClickListener(this)
  }

  /**
   * 点击事件响应
   */
  override fun onClick(v: View?) {
    when (v?.id) {
      R.id.btn_start -> {
        clickTest()
      }

      R.id.tv_content -> {
        tVClick()
      }
    }
  }


  /**
   * 内容区点击测试
   */
  private fun tVClick() {
    Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
  }

  /**
   * 内容区点击测试
   */
  private fun clickTest() {
    val translateAnimation =
      TranslateAnimation(
        Animation.ABSOLUTE,
        0.0F, Animation.ABSOLUTE, 400F, Animation.ABSOLUTE, 0.0F, Animation.ABSOLUTE, 100F
      )
    translateAnimation.fillAfter = true
    translateAnimation.duration = 1000
    mTv.startAnimation(translateAnimation)
  }
}