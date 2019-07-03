package bry1337.github.io.cartalog.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by edwardbryan.abergas on 07/02/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
abstract class BaseActivity : AppCompatActivity() {

    protected abstract val isActionBarBackButtonEnabled: Boolean

    protected abstract fun setupActivityLayout()

    protected abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupActivityLayout()
        setupToolbar()
        initView()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        if (isActionBarBackButtonEnabled) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }
    }
}