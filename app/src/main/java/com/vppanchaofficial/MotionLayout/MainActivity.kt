package com.vppanchaofficial.MotionLayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)


        val button_layout = findViewById<MotionLayout>(R.id.button_layout)
        val answerImage = findViewById<ImageView>(R.id.answerImage)
        val answerText = findViewById<TextView>(R.id.answerText)
        button_layout.setTransitionListener(object : MotionLayout.TransitionListener{
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {}

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {}

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentState: Int) {
                /* Check if user completely transitioned to the right */
                if (currentState == motionLayout?.endState) {
                    answerImage.setImageBitmap(null)
                    answerImage.setBackgroundResource(R.drawable.ic_baseline_done_outline_24)
                    answerText.setText("Swiped")
                    button_layout.isInteractionEnabled = false

                    //Save answer, make a network request, etc
                }
            }
        })


        /*val motionLayout = findViewById<MotionLayout>(R.id.motion_layout);
        motionLayout.startViewTransition(motionLayout);
        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                startActivity(Intent(this@MainActivity, SecondActivity::class.java))
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) { }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) { }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) { }
        })*/

    }

}