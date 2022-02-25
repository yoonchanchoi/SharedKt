package com.example.view.sharedkt

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
//   private lateinit var et_hello: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //TODO: 저장된 데이터를 로드
        loadData()              //edit text 저장되어있던 값을 setText

    }

    private fun loadData() {
        val et_hello:EditText
        et_hello=findViewById(R.id.et_hello)
        val pref = getSharedPreferences("pref", 0)
        et_hello.setText(pref.getString("name","")) //1번째 인자에서는 저장을 당시의 키 값을 적어줄, 2번째는 키 값에 데이터가 존재하지 않을 경우 대체값을 적어줍니다.
    }

    private fun saveData() {
        val et_hello:EditText
        val pref: SharedPreferences


        et_hello=findViewById(R.id.et_hello)
        pref = getSharedPreferences("pref", 0)
        val edit = pref.edit()  // 수정모드
        edit.putString("name", et_hello.text.toString())  // 1번째 인자에는 키 값을, 2번째 인자에는 실제로 담을 값
        edit.apply()            // 값을 저장 완료
    }

    override fun onDestroy() {  //액티비티 종료되는 시점이 다가올 때 호출
        super.onDestroy()

        saveData()              //edit text 값을 저장

    }


}