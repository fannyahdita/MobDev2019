package com.example.youcantgoback

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonExit.setOnClickListener { onExitButtonClick() }
        buttonTimer.setOnClickListener { onTimerButtonClick() }
    }

    override fun onBackPressed() {
        val toast = Toast.makeText(applicationContext, "You can't go back", Toast.LENGTH_LONG)
        toast.show()
    }

    private fun onExitButtonClick() {
        super.onBackPressed()
    }

    private fun onTimerButtonClick() {
        val intent = Intent(this@MainActivity, CountDownActivity::class.java)
        startActivity(intent)
    }
}
