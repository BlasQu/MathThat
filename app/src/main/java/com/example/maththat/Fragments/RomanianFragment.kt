package com.example.maththat.Fragments

import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.maththat.MainActivity
import com.example.maththat.R
import com.example.maththat.RomanNumber
import kotlinx.android.synthetic.main.fragment_romanian.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.StringBuilder

class RomanianFragment : Fragment(R.layout.fragment_romanian) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity as MainActivity
        activity.vmp.setData(0)

        val numberText = StringBuilder()

        activity.vmp.data.observe(viewLifecycleOwner, Observer {
            numberResult.setText(it)
        })

        number0.setOnClickListener {
            if (numberText.isNotEmpty()) numberText.append(0)
            numberInput.setText(numberText)
        }
        number7.setOnClickListener {
            if (numberText.length < 6) numberText.append(1)
            numberInput.setText(numberText)
        }
        number8.setOnClickListener {
            if (numberText.length < 6) numberText.append(2)
            numberInput.setText(numberText)
        }
        number9.setOnClickListener {
            if (numberText.length < 6) numberText.append(3)
            numberInput.setText(numberText)
        }
        number4.setOnClickListener {
            if (numberText.length < 6) numberText.append(4)
            numberInput.setText(numberText)
        }
        number5.setOnClickListener {
            if (numberText.length < 6) numberText.append(5)
            numberInput.setText(numberText)
        }
        number6.setOnClickListener {
            if (numberText.length < 6) numberText.append(6)
            numberInput.setText(numberText)
        }
        number1.setOnClickListener {
            if (numberText.length < 6) numberText.append(7)
            numberInput.setText(numberText)
        }
        number2.setOnClickListener {
            if (numberText.length < 6) numberText.append(8)
            numberInput.setText(numberText)
        }
        number3.setOnClickListener {
            if (numberText.length < 6) numberText.append(9)
            numberInput.setText(numberText)
        }

        numberBack.setOnClickListener {
            if (numberText.isNotEmpty()) numberText.setLength(numberText.length-1)
            numberInput.setText(numberText)
        }
        numberClear.setOnClickListener {
            numberText.clear()
            numberInput.setText(numberText)
        }

        toDecimal.setOnClickListener {
            activity.supportFragmentManager.beginTransaction().apply {
                setCustomAnimations(R.anim.fragment_open_enter, R.anim.fragment_open_exit)
                replace(R.id.fragmentcontainer, Romanian2Fragment())
                commit()
            }
        }

        copyresult.setOnClickListener {
            val clb = activity.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            if (numberResult.text.isNotEmpty()) {
                clb.text = numberResult.text
                Toast.makeText(activity.applicationContext, "Copied successfully!", Toast.LENGTH_SHORT).show()
            } else Toast.makeText(activity.applicationContext, "There is nothing to copy!", Toast.LENGTH_SHORT).show()
        }

        numberInput.doOnTextChanged { text, start, before, count ->
            if (text!!.isNotEmpty()){
                lifecycleScope.launch(Dispatchers.IO) {
                    activity.vmp.setData(text.toString().toInt())
                }
            } else activity.vmp.setData(0)
        }
    }
}