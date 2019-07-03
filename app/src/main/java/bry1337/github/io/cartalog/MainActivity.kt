package bry1337.github.io.cartalog

import bry1337.github.io.cartalog.base.BaseActivity

/**
 * Created by edwardbryan.abergas on 07/02/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
class MainActivity : BaseActivity() {

    override val isActionBarBackButtonEnabled: Boolean
        get() = true

    override fun setupActivityLayout() {
        setContentView(R.layout.activity_main)
    }

    override fun initView() {

    }
}
