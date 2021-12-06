package com.example.appdreiplusvier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2

private const val IMG_INDEX = "param1"

class ImageSwapFragment : Fragment() {
    private var imgIndex: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imgIndex = it.getInt(IMG_INDEX)
        }
        MainActivity.supActBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_swap, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPagerAdapter = ImagePagerAdapter(this)

        val viewPager: ViewPager2 = view.findViewById(R.id.image_view_pager)
        viewPager.adapter = viewPagerAdapter

        val frame: ImageView = view.findViewById(R.id.selected_image)
        val storedIndex = Storage.loadIntData(requireActivity(), Storage.HOME_IMAGE_INDEX)
        frame.setImageResource(ImageFragment.images[storedIndex])
        viewPager.setCurrentItem(storedIndex, false)

        val setButton: Button = view.findViewById(R.id.img_swap_set_button)
        setButton.setOnClickListener { view ->
            val item_number = viewPager.currentItem
            val myBundle = Bundle()
            myBundle.putInt(Storage.SELECT_NEW_IMAGE_INDEX, item_number)
            parentFragmentManager.setFragmentResult(Storage.SELECT_NEW_IMAGE, myBundle)
            frame.setImageResource(ImageFragment.images[item_number])
        }

//        parentFragmentManager.setFragmentResultListener("SEL_IMG", viewLifecycleOwner) { key, bundle ->
//            val index = bundle.getInt("IMG", 0)
//            frame.setImageResource(ImageFragment.images[index])
//        }
    }



    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            ImageSwapFragment().apply {
                arguments = Bundle().apply {
                    putString(IMG_INDEX, param1)
                }
            }
    }
}