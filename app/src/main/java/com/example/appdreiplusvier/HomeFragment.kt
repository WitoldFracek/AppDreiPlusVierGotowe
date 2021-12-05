package com.example.appdreiplusvier

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private var selectedImage: Int = -1

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        val profilePic: ImageView = view.findViewById(R.id.home_fragment_image)
        val storedIndex = Storage.loadIntData(requireActivity(), Storage.HOME_IMAGE_INDEX)
        profilePic.setImageResource(ImageFragment.images[storedIndex])

        val color = Storage.loadStringData(requireActivity(), Storage.HOME_BACKGROUD_COLOR, "#FFFFFFFF")
        val layout: LinearLayout = view.findViewById(R.id.home_main_layout)
        layout.setBackgroundColor(Color.parseColor(color))

        val invitation = Storage.loadStringData(requireActivity(), Storage.HOME_INVITATION, "Herzlich willkommen!")
        val invText: TextView = view.findViewById(R.id.home_fragment_invitation)
        invText.text = invitation

        val otherInf = Storage.loadStringData(requireActivity(), Storage.HOME_OTHER_TEXT, "")
        val otherText: TextView = view.findViewById(R.id.home_fragment_info)
        otherText.text = otherInf


        val btmNav: BottomNavigationView = requireActivity().findViewById(R.id.bottom_nav)
        btmNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_but_1 -> navController.navigate(R.id.action_global_homeFragment)
                R.id.nav_but_2 -> navController.navigate(R.id.action_global_RGBTabsFragment)
                R.id.nav_but_3 -> navController.navigate(R.id.action_global_unusedFragment)
                R.id.nav_but_4 -> navController.navigate(R.id.action_global_imageSwapFragment)
                else -> { }
            }
            true
        }

        parentFragmentManager.setFragmentResultListener(Storage.SELECT_NEW_IMAGE, viewLifecycleOwner) { key, bundle ->
            val selectedId = bundle.getInt(Storage.SELECT_NEW_IMAGE_INDEX, 0)
            profilePic.setImageResource(ImageFragment.images[selectedId])
            Storage.saveIntData(requireActivity(), Storage.HOME_IMAGE_INDEX, selectedId)
        }

        parentFragmentManager.setFragmentResultListener(Storage.COLOR_ID, viewLifecycleOwner) { key, bundle ->
            val storedColor = bundle.getString(Storage.COLOR_STRING, "#FFFFFFFF") as String
            val storedInvitation = bundle.getString(Storage.INVITATION_TEXT, "Herzlich willkommen!")
            val storedOtherTet = bundle.getString(Storage.OTHER_TEXT, "")
            layout.setBackgroundColor(Color.parseColor(storedColor))
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}