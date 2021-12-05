package com.example.appdreiplusvier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

private const val IMG_INDEX = "imgIndex"

class ImageFragment : Fragment() {
    private var imageIndex: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageIndex = it.getInt(IMG_INDEX)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView: ImageView = view.findViewById(R.id.gallery)
        imageView.setImageResource(images[imageIndex!!])
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
            ImageFragment().apply {
                arguments = Bundle().apply {
                    putInt(IMG_INDEX, param1)
                }
            }
        val images = intArrayOf(
            R.drawable.av1,
            R.drawable.av2,
            R.drawable.av3,
            R.drawable.av4,
            R.drawable.av5
        )
    }
}