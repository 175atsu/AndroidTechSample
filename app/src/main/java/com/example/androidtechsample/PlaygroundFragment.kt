package com.example.androidtechsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidtechsample.databinding.FragmentPlaygroundBinding

class PlaygroundFragment : Fragment() {

    private lateinit var binding: FragmentPlaygroundBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaygroundBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonPlaygroundToBiometric.setOnClickListener {
            findNavController().navigate(R.id.to_fragment_biometric)
        }
        binding.buttonPlaygroundToCompose.setOnClickListener {
            findNavController().navigate(R.id.to_fragment_compose)
        }
        binding.buttonPlaygroundToComposeList.setOnClickListener {
            findNavController().navigate(R.id.to_fragment_compose_list)
        }
    }
}