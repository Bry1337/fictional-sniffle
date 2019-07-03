package bry1337.github.io.cartalog.base

import android.content.Intent
import bry1337.github.io.cartalog.MainActivity
import bry1337.github.io.cartalog.R

/**
 * Created by edwardbryan.abergas on 07/02/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
class SplashActivity : BaseActivity() {

  override val isActionBarBackButtonEnabled: Boolean
    get() = false

  override fun setupActivityLayout() {
    setContentView(R.layout.activity_splash_screen)
  }

  override fun initView() {
    launchHomeScreen()
  }

  private fun launchHomeScreen() {
    startActivity(Intent(this, MainActivity::class.java))
    finish()
  }
}