package dev.yelinaung.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.ActivityConstraintLayoutBinding

class ConstraintLayoutActivity : BaseActivity<ActivityConstraintLayoutBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, ConstraintLayoutActivity::class.java)
        }

    }

    override val pageTitle: String get() = "Constraint Layout"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityConstraintLayoutBinding {
        return ActivityConstraintLayoutBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var animated = false

        val constraint1 = ConstraintSet()
        constraint1.clone(binding.root)

        val constraint2 = ConstraintSet()
        constraint2.clone(this, R.layout.animation_final_layout)

        binding.btnAnimate.setOnClickListener {
            TransitionManager.beginDelayedTransition(binding.root)
            val constraint = if(animated) constraint1 else constraint2
            constraint.applyTo(binding.root)
            animated = !animated
        }
    }

}