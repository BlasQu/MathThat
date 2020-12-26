package com.example.maththat.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.maththat.MainActivity
import com.example.maththat.R
import kotlinx.android.synthetic.main.fragment_calculator.*
import java.lang.StringBuilder

class CalculatorFragment : Fragment(R.layout.fragment_calculator) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity as MainActivity
        activity.vmp.setcalcData("")

        val calcStringData = StringBuilder()

        activity.vmp.calcData.observe(viewLifecycleOwner, Observer {
            calcResult.text = it
            var sign : String = ""
            var data2 : String = ""
            when (activity.vmp.calcSign.value!!.toInt()) {
                0 -> {
                    sign = ""
                }
                1 -> {
                    sign = " + "
                }
                2 -> {
                    sign = " - "
                }
                3 -> {
                    sign = " x "
                }
                4 -> {
                    sign = " / "
                }
                5 -> {
                    sign = " % "
                }
            }
            data2 = if (activity.vmp.calcData2.value!!.toString().toDouble().equals(0.0)) ""
            else activity.vmp.calcData2.value!!.toString()
            calcHint.text = activity.vmp.calcData1.value!!.toString() + sign + data2
        })

        calc0.setOnClickListener {
            if (calcStringData.isNotEmpty()) calcStringData.append("0")
            activity.vmp.setcalcData(calcStringData.toString())
        }
        calc1.setOnClickListener {
            if (calcStringData.length < 9) calcStringData.append("1")
            activity.vmp.setcalcData(calcStringData.toString())
        }
        calc2.setOnClickListener {
            if (calcStringData.length < 9) calcStringData.append("2")
            activity.vmp.setcalcData(calcStringData.toString())
        }
        calc3.setOnClickListener {
            if (calcStringData.length < 9) calcStringData.append("3")
            activity.vmp.setcalcData(calcStringData.toString())
        }
        calc4.setOnClickListener {
            if (calcStringData.length < 9) calcStringData.append("4")
            activity.vmp.setcalcData(calcStringData.toString())
        }
        calc5.setOnClickListener {
            if (calcStringData.length < 9) calcStringData.append("5")
            activity.vmp.setcalcData(calcStringData.toString())
        }
        calc6.setOnClickListener {
            if (calcStringData.length < 9) calcStringData.append("6")
            activity.vmp.setcalcData(calcStringData.toString())
        }
        calc7.setOnClickListener {
            if (calcStringData.length < 9) calcStringData.append("7")
            activity.vmp.setcalcData(calcStringData.toString())
        }
        calc8.setOnClickListener {
            if (calcStringData.length < 9) calcStringData.append("8")
            activity.vmp.setcalcData(calcStringData.toString())
        }
        calc9.setOnClickListener {
            if (calcStringData.length < 9) calcStringData.append("9")
            activity.vmp.setcalcData(calcStringData.toString())
        }
        calcdot.setOnClickListener {
            if (!calcStringData.contains(".") && calcStringData.isNotEmpty() && calcStringData.length < 8) calcStringData.append(".")
            activity.vmp.setcalcData(calcStringData.toString())
        }

        calcClearOne.setOnClickListener {
            activity.vmp.setcalcData("")
            calcStringData.clear()
        }

        calcplusminus.setOnClickListener {
            when (activity.vmp.calcSign.value!!.toInt()) {
                0 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() / calcStringData.toString().toDouble())
                    }
                }
                1 -> {
                    if (calcStringData.isNotEmpty()){
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() + calcStringData.toString().toDouble())
                    }
                }
                2 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() - calcStringData.toString().toDouble())
                    }
                }
                3 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() * calcStringData.toString().toDouble())
                    }
                }
                4 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() / calcStringData.toString().toDouble())
                    }
                }
                5 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() / calcStringData.toString().toDouble())
                    }
                }
            }
            activity.vmp.setcalcSign(5)
            calcStringData.clear()
            activity.vmp.setcalcData("")
        }

        calceequal.setOnClickListener {
            if (calcStringData.isNotEmpty()){
            when (activity.vmp.calcSign.value!!.toInt()){
                1 -> {
                    val result = calcStringData.toString().toDouble() + activity.vmp.calcData1.value!!.toDouble()
                    activity.vmp.setcalcData2(calcStringData.toString().toDouble())
                    activity.vmp.setcalcData(result.toString())
                }
                2 -> {
                    val result = activity.vmp.calcData1.value!!.toDouble() - calcStringData.toString().toDouble()
                    activity.vmp.setcalcData2(calcStringData.toString().toDouble())
                    activity.vmp.setcalcData(result.toString())
                }
                3 -> {
                    val result = calcStringData.toString().toDouble() * activity.vmp.calcData1.value!!.toDouble()
                    activity.vmp.setcalcData2(calcStringData.toString().toDouble())
                    activity.vmp.setcalcData(result.toString())
                }
                4 -> {
                    val result = activity.vmp.calcData1.value!!.toDouble() / calcStringData.toString().toDouble()
                    activity.vmp.setcalcData2(calcStringData.toString().toDouble())
                    activity.vmp.setcalcData(result.toString())
                }
                5 -> {
                    val result = activity.vmp.calcData1.value!!.toDouble() / calcStringData.toString().toDouble()
                    activity.vmp.setcalcData2(calcStringData.toString().toDouble())
                    activity.vmp.setcalcData(result.toString())
                }
            }
            }
        }

        calcplus.setOnClickListener {
            when (activity.vmp.calcSign.value!!.toInt()) {
                0 -> {
                    if (calcStringData.isNotEmpty()){
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() + calcStringData.toString().toDouble())
                    }
                }
                1 -> {
                    if (calcStringData.isNotEmpty()){
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() + calcStringData.toString().toDouble())
                    }
                }
                2 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() - calcStringData.toString().toDouble())
                    }
                }
                3 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() * calcStringData.toString().toDouble())
                    }
                }
                4 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() / calcStringData.toString().toDouble())
                    }
                }
                5 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() / calcStringData.toString().toDouble())
                    }
                }
            }
            activity.vmp.setcalcSign(1)
            activity.vmp.setcalcData2(0.0)
            calcStringData.clear()
            activity.vmp.setcalcData("")
        }

        calcminus.setOnClickListener {
            when (activity.vmp.calcSign.value!!.toInt()) {
                0 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() - calcStringData.toString().toDouble())
                    }
                }
                1 -> {
                    if (calcStringData.isNotEmpty()){
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() + calcStringData.toString().toDouble())
                    }
                }
                2 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() - calcStringData.toString().toDouble())
                    }
                }
                3 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() * calcStringData.toString().toDouble())
                    }
                }
                4 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() / calcStringData.toString().toDouble())
                    }
                }
                5-> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() / calcStringData.toString().toDouble())
                    }
                }
            }
            activity.vmp.setcalcSign(2)
            activity.vmp.setcalcData2(0.0)
            calcStringData.clear()
            activity.vmp.setcalcData("")
        }

        calcmultiply.setOnClickListener {
            when (activity.vmp.calcSign.value!!.toInt()) {
                0 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() * calcStringData.toString().toDouble())
                    }
                }
                1 -> {
                    if (calcStringData.isNotEmpty()){
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() + calcStringData.toString().toDouble())
                    }
                }
                2 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() - calcStringData.toString().toDouble())
                    }
                }
                3 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() * calcStringData.toString().toDouble())
                    }
                }
                4 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() / calcStringData.toString().toDouble())
                    }
                }
                5 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() / calcStringData.toString().toDouble())
                    }
                }
            }
            activity.vmp.setcalcSign(3)
            calcStringData.clear()
            activity.vmp.setcalcData("")
        }

        calcdivide.setOnClickListener {
            when (activity.vmp.calcSign.value!!.toInt()) {
                0 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() / calcStringData.toString().toDouble())
                    }
                }
                1 -> {
                    if (calcStringData.isNotEmpty()){
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() + calcStringData.toString().toDouble())
                    }
                }
                2 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() - calcStringData.toString().toDouble())
                    }
                }
                3 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() * calcStringData.toString().toDouble())
                    }
                }
                4 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() / calcStringData.toString().toDouble())
                    }
                }
                5 -> {
                    if (calcStringData.isNotEmpty()) {
                        if (activity.vmp.calcData1.value!!.toDouble().equals(0.0)) activity.vmp.setcalcData1(calcStringData.toString().toDouble())
                        else activity.vmp.setcalcData1(activity.vmp.calcData1.value!!.toDouble() / calcStringData.toString().toDouble())
                    }
                }
            }
            activity.vmp.setcalcSign(4)
            calcStringData.clear()
            activity.vmp.setcalcData("")
        }

        calcClear.setOnClickListener {
            calcStringData.clear()
            activity.vmp.setcalcSign(0)
            activity.vmp.setcalcData1(0.0)
            activity.vmp.setcalcData2(0.0)
            activity.vmp.setcalcData("")
        }

    }
}