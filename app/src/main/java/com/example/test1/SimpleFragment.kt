package com.example.test1

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.test1.databinding.FragmentSimpleBinding

private const val ARG_TEXT = "arg_text"
/**
 * A simple [Fragment] subclass.
 */
class SimpleFragment : Fragment() {

    private var text: String? = null
    lateinit var binding: FragmentSimpleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            text = it.getString(ARG_TEXT)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_simple, container, false);
        binding.text = text
        binding.background = Color.WHITE
        binding.fragment.setOnClickListener {
            Toast.makeText( context, binding.text, Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(text: String) =
            SimpleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TEXT, text)
                }
                retainInstance = true
            }
    }
}
