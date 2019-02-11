package com.example.learning

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val m0nNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (item.itemId) {
            R.id.design_navigation_view -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_header_container -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }


    val button by lazy { findViewById<Button>(R.id.button_login) }
    val login by lazy { findViewById<TextInputLayout>(R.id.login) }
    val password by lazy { findViewById<TextInputLayout>(R.id.password) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.set0nNavigationItemSelectedListener(m0nNavigationItemSelectedListener)

        login.addTextChangeListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                button.isEnabled = login.text.isNotEmpty() && password.hint!!.isNotEmpty()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        password.addTextChangeListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                button.isEnabled = login.hint!!.isNotEmpty() && password.hint!!.isNotEmpty()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    fun login(view: View) {
        val intent = Intent(this, good_login::class.java)

        startActivity(intent)
    }
}
