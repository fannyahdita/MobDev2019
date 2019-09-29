package com.example.youcantgoback

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_timer.*
import java.util.*

class CountDownActivity : AppCompatActivity() {
    private val startTimeInMillis: Long = 600000

    private var countDownTimer: CountDownTimer? = null

    private var timeLeft: Long = 0
    private var isRun: Boolean = false
    private var endTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        button_start_pause.setOnClickListener { onClickStartPauseButton() }
        button_reset.setOnClickListener { reset() }
    }

    private fun start() {
        endTime = System.currentTimeMillis() + timeLeft
        countDownTimer = object : CountDownTimer(timeLeft, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = millisUntilFinished
                updateCountDownText()
            }

            override fun onFinish() {
                isRun = false
                updateButtons()
            }
        }.start()

        isRun = true
        updateButtons()
    }

    private fun pause() {
        countDownTimer?.cancel()
        isRun = false
        updateButtons()
    }

    private fun reset() {
        timeLeft = startTimeInMillis
        updateCountDownText()
        updateButtons()
    }

    private fun updateCountDownText() {
        val minutes = (timeLeft / 1000) / 60
        val seconds = (timeLeft / 1000) % 60

        val stringTimeLeft = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
        text_view_countdown.text = stringTimeLeft
    }

    private fun updateButtons() {
        if (isRun) {
            button_reset.visibility = View.INVISIBLE
            button_start_pause.text = getString(R.string.buttonPauseText)
        } else {
            button_start_pause.text = getString(R.string.buttonStartText)
            if (timeLeft < 1000) {
                button_start_pause.visibility = View.INVISIBLE
            } else {
                button_start_pause.visibility = View.VISIBLE
            }

            if (timeLeft < startTimeInMillis) {
                button_reset.visibility = View.VISIBLE
            } else {
                button_reset.visibility = View.INVISIBLE
            }

        }
    }

    private fun onClickStartPauseButton() {
        if(isRun) {
            pause()
        } else {
            start()
        }
    }

    override fun onStop() {
        super.onStop()

        val sharedPreferences = getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putLong("timeLeft", timeLeft)
        editor.putBoolean("isRun", isRun)
        editor.putLong("endTime", endTime)

        editor.apply()

        if(countDownTimer != null) {
            countDownTimer?.cancel()
        }
    }

    override fun onStart() {
        super.onStart()

        val sharedPreferences = getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)

        timeLeft = sharedPreferences.getLong("timeLeft", startTimeInMillis)
        isRun = sharedPreferences.getBoolean("isRun", false)

        updateCountDownText()
        updateButtons()

        if(isRun) {
            endTime = sharedPreferences.getLong("endTime", 0)
            timeLeft = endTime - System.currentTimeMillis()

            if(timeLeft < 0) {
                timeLeft = 0
                isRun = false
                updateCountDownText()
                updateButtons()
            } else {
                start()
            }
        }
    }
}