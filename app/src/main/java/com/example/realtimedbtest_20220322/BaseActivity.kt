package com.example.realtimedbtest_20220322

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

abstract class BaseActivity: AppCompatActivity() {

    var messageCount = 0L

    lateinit var mContext: Context
    val realtimeDB = FirebaseDatabase.getInstance("https://realtimedbtest-2022032200-default-rtdb.asia-southeast1.firebasedatabase.app/") // 싱가폴 DB주소 대입


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mContext = this
    }
    abstract fun setupEvents()
    abstract fun setValues()
}