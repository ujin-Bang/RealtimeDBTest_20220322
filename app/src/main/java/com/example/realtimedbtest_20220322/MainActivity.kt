package com.example.realtimedbtest_20220322

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.realtimedbtest_20220322.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase

class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
//        DB연결 > 값 기록 연습
        val db = FirebaseDatabase.getInstance("https://realtimedbtest-2022032200-default-rtdb.asia-southeast1.firebasedatabase.app/") // 싱가폴 DB주소 대입

//        DB의 하위 항목 설정(Reference) 설정
        val testRef = db.getReference("test")

//        test항목에 "Hello World!!" 기록
        testRef.setValue("Hello World")
    }
}