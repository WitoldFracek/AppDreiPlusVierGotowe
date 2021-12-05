package com.example.appdreiplusvier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

private const val IDENTIFIER = "rgb_frag1"
private const val TITLE = "title"


class RGBFragment3 : Fragment() {
    private var identifier: String? = null
    private var title: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            identifier = it.getString(IDENTIFIER)
            title = it.getString(TITLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_r_g_b3, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RGBFragment3().apply {
                arguments = Bundle().apply {
                    putString(IDENTIFIER, param1)
                    putString(TITLE, param2)
                }
            }
    }
}