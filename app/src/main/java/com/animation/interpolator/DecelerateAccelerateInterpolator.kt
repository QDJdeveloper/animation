package com.animation.interpolator

import android.animation.TimeInterpolator

/**
 * 创建时间: 2019/08/19 20:03 <br>
 * 作者: qiudengjiao <br>
 * 描述: 先减速后加速
 */
class DecelerateAccelerateInterpolator : TimeInterpolator {

  override fun getInterpolation(input: Float): Float {
    val result: Float

    result = if (input <= 0.5) {
      ((Math.sin(Math.PI * input)) / 2).toFloat()
    } else {
      ((2 - Math.sin(Math.PI * input)) / 2).toFloat()
    }

    return result
  }
}