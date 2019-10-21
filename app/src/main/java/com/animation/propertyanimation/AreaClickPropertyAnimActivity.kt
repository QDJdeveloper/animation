package com.animation.propertyanimation

import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.animation.R

/**
 * 创建时间: 2019/07/24 11:25 <br>
 * 作者: qiudengjiao <br>
 * 描述: Property 动画 区域点击 Test
 */
class AreaClickPropertyAnimActivity : AppCompatActivity(), View.OnClickListener {

  private lateinit var mTv: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_area_click)

    initUI()
  }

  private fun initUI() {
    (findViewById<Button>(R.id.btn_start)).setOnClickListener(this)
    mTv = findViewById(R.id.tv_content)
    mTv.setOnClickListener(this)
  }

  override fun onClick(v: View?) {
    when (v?.id) {
      R.id.btn_start -> {
        doAnimation()
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
  private fun doAnimation() {
    val anim = ValueAnimator.ofInt(0, 400)
    anim.duration = 1000

    anim.addUpdateListener { animation ->
      val curValue = (animation?.animatedValue) as Int
      Log.e("AnimActivity", "curValue::$curValue")
      mTv.layout(curValue, curValue, curValue + mTv.width, curValue + mTv.height)
    }
    anim.start()
  }
}