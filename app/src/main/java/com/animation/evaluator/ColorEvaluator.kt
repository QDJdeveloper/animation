package com.animation.evaluator

import android.animation.TypeEvaluator

/**
 * 创建时间: 2019/07/26 15:00 <br>
 * 作者: qiudengjiao <br>
 * 描述: 颜色选择估值器
 */
class ColorEvaluator : TypeEvaluator<String> {

  private var mCurrentRed = -1
  private var mCurrentGreen = -1
  private var mCurrentBlue = -1

  override fun evaluate(fraction: Float, startValue: String?, endValue: String?): String {

    val startColor = startValue as String
    val endColor = endValue as String

    val startRed = Integer.parseInt(startColor.substring(1, 3), 16)
    val startGreen = Integer.parseInt(startColor.substring(3, 5), 16)
    val startBlue = Integer.parseInt(startColor.substring(5, 7), 16)

    val endRed = Integer.parseInt(endColor.substring(1, 3), 16)
    val endGreen = Integer.parseInt(endColor.substring(3, 5), 16)
    val endBlue = Integer.parseInt(endColor.substring(5, 7), 16)

    if (mCurrentRed == -1) {
      mCurrentRed = startRed
    }
    if (mCurrentGreen == -1) {
      mCurrentGreen = startGreen
    }
    if (mCurrentBlue == -1) {
      mCurrentBlue = startBlue
    }

    val redDiff = Math.abs(startRed - endRed)
    val greenDiff = Math.abs(startGreen - endGreen)
    val blueDiff = Math.abs(startBlue - endBlue)
    val colorDiff = redDiff + greenDiff + blueDiff

    when {
      mCurrentRed != endRed -> mCurrentRed = getCurrentColor(
        startRed, endRed, colorDiff, 0,
        fraction
      )
      mCurrentGreen != endGreen -> mCurrentGreen = getCurrentColor(
        startGreen, endGreen, colorDiff,
        redDiff, fraction
      )
      mCurrentBlue != endBlue -> mCurrentBlue = getCurrentColor(
        startBlue, endBlue, colorDiff,
        redDiff + greenDiff, fraction
      )
    }

    return "#" + getHexString(mCurrentRed) + getHexString(mCurrentGreen) + getHexString(mCurrentBlue)
  }

  /**
   * 根据fraction值来计算当前的颜色。
   */
  private fun getCurrentColor(
    startColor: Int, endColor: Int, colorDiff: Int,
    offset: Int, fraction: Float
  ): Int {

    var currentColor: Int

    if (startColor > endColor) {
      currentColor = (startColor - (fraction * colorDiff - offset)).toInt()
      if (currentColor < endColor) {
        currentColor = endColor
      }
    } else {
      currentColor = (startColor + (fraction * colorDiff - offset)).toInt()
      if (currentColor > endColor) {
        currentColor = endColor
      }
    }
    return currentColor
  }

  /**
   * 将10进制颜色值转换成16进制
   */
  private fun getHexString(value: Int): String {
    var hexString = Integer.toHexString(value)
    if (hexString.length == 1) {
      hexString = "0$hexString"
    }
    return hexString
  }



}