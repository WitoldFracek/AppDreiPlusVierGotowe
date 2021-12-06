package com.example.appdreiplusvier

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.ContentInfo
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val IDENTIFIER = "rgb_frag1"
private const val TITLE = "title"


class RGBFragment1 : Fragment() {
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
        return inflater.inflate(R.layout.fragment_r_g_b1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val invitation: TextView = view.findViewById(R.id.input_invitation)
        val otherInfo: TextView = view.findViewById(R.id.input_other_info)

        val savedInvitation = Storage.loadStringData(requireActivity(), Storage.HOME_INVITATION, "")
        invitation.text = savedInvitation

        val savedOtherText = Storage.loadStringData(requireActivity(), Storage.HOME_OTHER_TEXT, "")
        otherInfo.text = savedOtherText

        val redBar: SeekBar = view.findViewById(R.id.red_bar)
        val greenBar: SeekBar = view.findViewById(R.id.green_bar)
        val blueBar: SeekBar = view.findViewById(R.id.blue_bar)
        val canvas: TextView = view.findViewById(R.id.color_screen)

        val saveButton: Button = view.findViewById(R.id.rgb_frag_save_button)

        val savedRedState = Storage.loadIntData(requireActivity(), Storage.RED_VAL, 0)
        redBar.progress = savedRedState
        val savedGreenState = Storage.loadIntData(requireActivity(), Storage.GREEN_VAL, 0)
        greenBar.progress = savedGreenState
        val savedBlueState = Storage.loadIntData(requireActivity(), Storage.BLUE_VAL, 0)
        blueBar.progress = savedBlueState

        canvas.setBackgroundColor(Color.parseColor(RGBConverter.toHex(
            RGBConverter.map(savedRedState, 0, 100, 0 ,255),
            RGBConverter.map(savedGreenState, 0, 100, 0 ,255),
            RGBConverter.map(savedBlueState, 0, 100, 0 ,255)
        )))

        canvas.text = "#${Storage.loadStringData(requireActivity(), Storage.HOME_BACKGROUD_COLOR, "#FFFFFFFF").substring(3)}"

        otherInfo.setOnKeyListener { _, _, _ ->
            val red = RGBConverter.map(redBar.progress, 0, 100, 0, 255)
            val green = RGBConverter.map(greenBar.progress, 0, 100, 0, 255)
            val blue = RGBConverter.map(blueBar.progress, 0 , 100, 0, 255)
            val color = RGBConverter.toHex(red, green, blue)
            val myBundle = Bundle()

            val newInvitation = invitation.text.toString()
            val newOther = otherInfo.text.toString()

            myBundle.putString(Storage.COLOR_STRING, color)
            myBundle.putString(Storage.INVITATION_TEXT, newInvitation)
            myBundle.putString(Storage.OTHER_TEXT, newOther)

            parentFragmentManager.setFragmentResult(Storage.COLOR_ID, myBundle)
            true
        }

        invitation.setOnKeyListener { _, _, _ ->
            val red = RGBConverter.map(redBar.progress, 0, 100, 0, 255)
            val green = RGBConverter.map(greenBar.progress, 0, 100, 0, 255)
            val blue = RGBConverter.map(blueBar.progress, 0 , 100, 0, 255)
            val color = RGBConverter.toHex(red, green, blue)
            val myBundle = Bundle()

            val newInvitation = invitation.text.toString()
            val newOther = otherInfo.text.toString()

            myBundle.putString(Storage.COLOR_STRING, color)
            myBundle.putString(Storage.INVITATION_TEXT, newInvitation)
            myBundle.putString(Storage.OTHER_TEXT, newOther)

            parentFragmentManager.setFragmentResult(Storage.COLOR_ID, myBundle)
            true
        }

        redBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val red = RGBConverter.map(progress, 0, 100, 0, 255)
                val green = RGBConverter.map(greenBar.progress, 0, 100, 0, 255)
                val blue = RGBConverter.map(blueBar.progress, 0 , 100, 0, 255)
                val color = RGBConverter.toHex(red, green, blue)
                canvas.setBackgroundColor(Color.parseColor(color))
                canvas.text = "#${color.substring(3)}"

                val myBundle = Bundle()

                val newInvitation = invitation.text.toString()
                val newOther = otherInfo.text.toString()

                myBundle.putString(Storage.COLOR_STRING, color)
                myBundle.putString(Storage.INVITATION_TEXT, newInvitation)
                myBundle.putString(Storage.OTHER_TEXT, newOther)

                parentFragmentManager.setFragmentResult(Storage.COLOR_ID, myBundle)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) { }
            override fun onStopTrackingTouch(seekBar: SeekBar?) { }
        })

        greenBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val green = RGBConverter.map(progress, 0, 100, 0, 255)
                val red = RGBConverter.map(redBar.progress, 0, 100, 0, 255)
                val blue = RGBConverter.map(blueBar.progress, 0 , 100, 0, 255)
                val color = RGBConverter.toHex(red, green, blue)
                canvas.setBackgroundColor(Color.parseColor(color))
                canvas.text = "#${color.substring(3)}"

                val myBundle = Bundle()

                val newInvitation = invitation.text.toString()
                val newOther = otherInfo.text.toString()

                myBundle.putString(Storage.COLOR_STRING, color)
                myBundle.putString(Storage.INVITATION_TEXT, newInvitation)
                myBundle.putString(Storage.OTHER_TEXT, newOther)

                parentFragmentManager.setFragmentResult(Storage.COLOR_ID, myBundle)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) { }
            override fun onStopTrackingTouch(seekBar: SeekBar?) { }
        })

        blueBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val blue = RGBConverter.map(progress, 0, 100, 0, 255)
                val green = RGBConverter.map(greenBar.progress, 0, 100, 0, 255)
                val red = RGBConverter.map(redBar.progress, 0 , 100, 0, 255)
                val color = RGBConverter.toHex(red, green, blue)
                canvas.setBackgroundColor(Color.parseColor(color))
                canvas.text = "#${color.substring(3)}"

                val myBundle = Bundle()

                val newInvitation = invitation.text.toString()
                val newOther = otherInfo.text.toString()

                myBundle.putString(Storage.COLOR_STRING, color)
                myBundle.putString(Storage.INVITATION_TEXT, newInvitation)
                myBundle.putString(Storage.OTHER_TEXT, newOther)

                parentFragmentManager.setFragmentResult(Storage.COLOR_ID, myBundle)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) { }
            override fun onStopTrackingTouch(seekBar: SeekBar?) { }
        })

        saveButton.setOnClickListener { _ ->
            val red = RGBConverter.map(redBar.progress, 0, 100, 0, 255)
            val green = RGBConverter.map(greenBar.progress, 0, 100, 0, 255)
            val blue = RGBConverter.map(blueBar.progress, 0, 100, 0, 255)
            val color = RGBConverter.toHex(red, green, blue)

            val newInvitation = invitation.text.toString()
            val newOther = otherInfo.text.toString()


            val sharedPrefs = requireActivity().getSharedPreferences(Storage.SHARED_PREFS, Context.MODE_PRIVATE)
            val editor = sharedPrefs.edit()
            editor.putString(Storage.HOME_BACKGROUD_COLOR, color)
            editor.putString(Storage.HOME_INVITATION, newInvitation)
            editor.putString(Storage.HOME_OTHER_TEXT, newOther)
            editor.putInt(Storage.RED_VAL, redBar.progress)
            editor.putInt(Storage.GREEN_VAL, greenBar.progress)
            editor.putInt(Storage.BLUE_VAL, blueBar.progress)
            editor.apply()
        }


    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RGBFragment1().apply {
                arguments = Bundle().apply {
                    putString(IDENTIFIER, param1)
                    putString(TITLE, param2)
                }
            }
    }

}