package com.test.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnNext.setOnClickListener{
            val request = NavDeepLinkRequest.Builder
                .fromUri("android-app://com.test.ItemFragment".toUri())
                .build()
            findNavController().navigate(request)
//            findNavController().popBackStack()
        }

    }



}