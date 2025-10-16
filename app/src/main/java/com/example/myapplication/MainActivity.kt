package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        private const val STATE_RESULT = "state_result"
    }
    private lateinit var etName : TextView
    //method called when the activity is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etName = findViewById(R.id.tv_name)
        val btnHitungLuas : Button = findViewById(R.id.btn_luas)
        btnHitungLuas.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_luas -> {
                val moveIntent = Intent(this@MainActivity, LuasActivity::class.java)
                moveIntent.putExtra( LuasActivity.EXTRA_NAME, etName.text.toString() )
                startActivity(moveIntent)
            }


        }




    }





    //onStart() method called when the activity is becoming visible to the user
    //onResume() method called when the activity will start interacting with the user
    //onPause() method called when the system is about to start resuming another activity
    //onStop() method called when the activity is no longer visible to the user
    //onDestroy() method called before the activity is destroyed


}