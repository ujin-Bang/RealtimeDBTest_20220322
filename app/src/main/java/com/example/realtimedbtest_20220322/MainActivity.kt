package com.example.realtimedbtest_20220322

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.realtimedbtest_20220322.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

//        realtimeDb의 항목 중 message 항목에 변화가 생길 때
        realtimeDB.getReference("message").addValueEventListener( object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

//                파이어 베이스의 DB내용 변경 => 이 함수를 실행시켜줌

//                snapshot변수 : 현재 변경된 상태 => 자녀가 몇 개인지 추출

                messageCount = snapshot.childrenCount



            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

        binding.btnSend.setOnClickListener {
            val inputMessage = binding.edtContent.text.toString()

//            임시 :DB의 하위 목록으로 => message 항목 => 0번 항목의 =>content 항목 : 입력내용
            realtimeDB.getReference("message").child(messageCount.toString()).child("content").setValue(inputMessage)

//            추가기록 : 현재 시간값을 "2022년 3월 5일 ㅎ오후 5:05"양식으로 기록
            val now= Calendar.getInstance()
            val sdf = SimpleDateFormat("yyyy년 M월 d일 a h:m")
            val nowStr = sdf.format(now.time)

            realtimeDB.getReference("message").child(messageCount.toString()).child("createdAt").setValue(nowStr)

        }

    }

    override fun setValues() {



    }
}