package com.markz.redux

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.markz.redux.counter.CounterAction
import com.markz.redux.counter.store

class MainActivity : AppCompatActivity() {

    private lateinit var tvCount: TextView
    private lateinit var btnIncrement: Button
    private lateinit var btnDecrement: Button
    private lateinit var btnReset: Button

    private val mainHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvCount = findViewById<TextView>(R.id.tvCount)
        btnIncrement = findViewById<Button>(R.id.btnIncrement)
        btnDecrement = findViewById<Button>(R.id.btnDecrement)
        btnReset = findViewById<Button>(R.id.btnReset)

        btnIncrement.setOnClickListener {
            store.dispatch(CounterAction.Increment)
        }

        btnDecrement.setOnClickListener {
            store.dispatch(CounterAction.Decrement)
        }

        btnReset.setOnClickListener {
            store.dispatch(CounterAction.Reset)
        }


        // 订阅 store 的状态更新
        store.subscribe {
            // mainHandler.post {
            //     tvCount.text = "Count: ${store.state.count}"
            // }
            // 另外一种更新 UI 的方式
            runOnUiThread {
                tvCount.text = "Count: ${store.state.count}"
            }
        }
    }
}