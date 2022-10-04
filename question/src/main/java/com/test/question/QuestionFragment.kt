package com.test.question

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.test.question.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment(){

    private lateinit var binding: FragmentQuestionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        Log.d("CREATEVIEW","CREATEVIEW")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("ONVC","ONVC")
        binding.btnNext.setOnClickListener{
            val request = NavDeepLinkRequest.Builder
                .fromUri("myapp://item".toUri())
                .build()
            findNavController().navigate(request)
//            parentFragmentManager.popBackStackImmediate()
        }

    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("VSR","VSR")
    }

    override fun onStart() {
        super.onStart()
        Log.d("ONSTART","ONSTART")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ONRESUME","ONRESUME")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ONPAUSE","ONPAUSE")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ONSTOP","ONST")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("ONSIS","ONSIS")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("ONDV","ONDV")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ONDES","ONDES")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("ONDETACH","ONDETACH")
    }


}