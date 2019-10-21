package com.animation.evaluator

import android.animation.TypeEvaluator
import com.animation.model.Point

/**
 * 创建时间: 2019/07/25 20:11 <br>
 * 作者: qiudengjiao <br>
 * 描述: Evaluaotor 用于将从插值器返回的数值进度转换成对应值
 */
class PointEvaluator : TypeEvaluator<Point> {

  override fun evaluate(
    fraction: Float,
    startValue: Point?,
    endValue: Point?
  ): Point {

    //始末值强转为Point对象
    val startPoint = startValue as Point
    val endPoint = endValue as Point
    //通过fraction计算当前动画的坐标值x,y
    val x = startPoint.x + fraction * (endPoint.x - startPoint.x)
    val y = startPoint.y + fraction * (endPoint.y - startPoint.y)
    //返回以上述x,y组装的新的Point对象
    return Point(x, y)
  }

}