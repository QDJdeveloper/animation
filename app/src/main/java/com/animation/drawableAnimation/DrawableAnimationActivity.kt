package com.animation.drawableAnimation

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import com.animation.R

/**
 * 创建时间: 2019/07/23 12:00 <br>
 * 作者: qiudengjiao <br>
 * 描述: Drawable 动画
 */
class DrawableAnimationActivity : AppCompatActivity(){

  private var mPuppet: ImageView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_drawable_animation)
    initToolbar()
    mPuppet = findViewById(R.id.img_puppet)
  }

  private fun initToolbar() {
    val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
    setSupportActionBar(toolbar)
    supportActionBar!!.setDisplayHomeAsUpEnabled(true)
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_on_off, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    val itemId = item?.itemId
    when (itemId) {
      android.R.id.home -> finish()
      R.id.action_do -> doAnimation(getAnimationDrawable(false), true)
      R.id.action_stop -> doAnimation(getAnimationDrawable(true), false)
    }
    return super.onOptionsItemSelected(item)
  }

  /**
   * 动画开始/结束
   */
  private fun doAnimation(animationDrawable: AnimationDrawable, doIt: Boolean) {
    if (animationDrawable.isRunning) {
      animationDrawable.stop()
    }

    if (doIt) {
      animationDrawable.start()
    }
  }

  /**
   * xml/code
   */
  private fun getAnimationDrawable(fromXml: Boolean): AnimationDrawable {
    return if (fromXml) {
      mPuppet?.drawable as AnimationDrawable
    } else {
      val animationDrawable = AnimationDrawable()
      for (i in 1..7) {
        val id = resources.getIdentifier("run$i", "drawable", packageName)
        val drawable = getDrawable(id)
        if (null != drawable) {
          animationDrawable.addFrame(drawable, 100)
        }
      }
      mPuppet?.setImageDrawable(animationDrawable)
      animationDrawable
    }
  }
}