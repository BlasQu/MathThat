package com.example.maththat.Fragments

import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import kotlinx.android.synthetic.main.fragment_romanian.copyresult
import kotlinx.android.synthetic.main.fragment_romanian.numberInput
import kotlinx.android.synthetic.main.fragment_romanian.numberResult
import kotlinx.android.synthetic.main.fragment_romanian.toRoman
import kotlinx.android.synthetic.main.fragment_romanian2.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.util.*

class Romanian2Fragment : Fragment(R.layout.fragment_romanian2) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity as MainActivity
        activity.vmp.setData2("")

        val numberText = StringBuilder()

        activity.vmp.data2.observe(viewLifecycleOwner, Observer {
            if (it == 0) numberResult2.setText("")
            else numberResult2.setText(it.toString())
        })

        numberI.setOnClickListener {
            if (numberText.length < 14) numberText.append("I")
            numberInput2.setText(numberText)
        }
        numberV.setOnClickListener {
            if (numberText.length < 14) numberText.append("V")
            numberInput2.setText(numberText)
        }
        numberX.setOnClickListener {
            if (numberText.length < 14) numberText.append("X")
            numberInput2.setText(numberText)
        }
        numberL.setOnClickListener {
            if (numberText.length < 14) numberText.append("L")
            numberInput2.setText(numberText)
        }
        numberC.setOnClickListener {
            if (numberText.length < 14) numberText.append("C")
            numberInput2.setText(numberText)
        }
        numberD.setOnClickListener {
            if (numberText.length < 14) numberText.append("D")
            numberInput2.setText(numberText)
        }
        numberM.setOnClickListener {
            if (numberText.length < 14) numberText.append("M")
            numberInput2.setText(numberText)
        }

        numberBack2.setOnClickListener {
            if (numberText.isNotEmpty()) numberText.setLength(numberText.length-1)
            numberInput2.setText(numberText)
        }
        numberClear2.setOnClickListener {
            numberText.clear()
            numberInput2.setText(numberText)
        }

        toRoman.setOnClickListener {
            activity.supportFragmentManager.beginTransaction().apply {
                setCustomAnimations(R.anim.fragment_open_enter, R.anim.fragment_open_exit)
                replace(R.id.fragmentcontainer, RomanianFragment())
                commit()
            }
        }

        copyresult.setOnClickListener {
            val clb = activity.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            if (numberResult2.text.isNotEmpty()) {
                clb.text = numberResult2.text
                Toast.makeText(activity.applicationContext, "Copied successfully!", Toast.LENGTH_SHORT).show()
            } else Toast.makeText(activity.applicationContext, "There is nothing to copy!", Toast.LENGTH_SHORT).show()
        }

        numberInput2.doOnTextChanged { text, start, before, count ->
            if (text!!.isNotEmpty()){
                lifecycleScope.launch(Dispatchers.IO) {
                    activity.vmp.setData2(text.toString().toUpperCase(Locale.ROOT))
                }
            } else activity.vmp.setData2("")
        }
    }
}