package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

//Data Binding may replace findViewById
// findViewById<**>(id_name) = binding.id_name

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Data Binding needs to use DataBindingUtil to call content view
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

//        findViewById<Button>(R.id.done_button).setOnClickListener{
//            addNickname(it)     // "it" refers to the button
//        }

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

//        findViewById<TextView>(R.id.nickname_text).setOnClickListener{
//            updateNickname(it)     // "it" refers to the button
//        }

        binding.nicknameText.setOnClickListener{
            updateNickname(it)
        }

    }

    private fun addNickname(view: View){

//        //Two kinds of coding style
//        val editText: EditText = findViewById(R.id.nickname_edit)
//        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)



//        nicknameTextView.text = editText.text
        binding.nicknameText.text = binding.nicknameEdit.text

//        editText.visibility = View.GONE
//        view.visibility = View.GONE
        binding.nicknameEdit.visibility = View.GONE
        binding.doneButton.visibility = View.GONE

//        nicknameTextView.visibility = View.VISIBLE
        binding.nicknameText.visibility = View.VISIBLE

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }

    private fun updateNickname(view: View){
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val doneButton = findViewById<Button>(R.id.done_button)


//        editText.visibility = View.VISIBLE
//        doneButton.visibility = View.VISIBLE


//        view.visibility = View.GONE


//        // Set the focus to the edit text.
//        editText.requestFocus()


        //Can also apply as

        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE
            nicknameEdit.requestFocus()
        }





        // Show the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        inputMethodManager.showSoftInput(editText, 0)
        inputMethodManager.showSoftInput(binding.nicknameEdit, 0)

    }
}