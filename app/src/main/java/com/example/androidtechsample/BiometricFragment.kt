package com.example.androidtechsample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.androidtechsample.databinding.FragmentBiometricBinding
import java.util.concurrent.Executor

class BiometricFragment : Fragment() {

    private lateinit var binding: FragmentBiometricBinding
    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBiometricBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkBiometric()
        createBiometricPrompt()
        showId()
    }

    // 端末が生体認証に対応しているか確認
    private fun checkBiometric(): Boolean {
        val biometricManager = BiometricManager.from(requireContext())
        when (biometricManager.canAuthenticate()) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
                Log.d("TAG", "App can authenticate using biometrics.")
            }
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                Log.e("TAG", "Hardware not available")
            }
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                Log.e("TAG", "Biometric features are currently unavailable.")
            }
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                Log.e(
                    "TAG",
                    "The user hasn't associated any biometric credentials with their account."
                )
            }
            else -> {
                Log.e("TAG", "Nothing supported")
            }
        }
        return biometricManager.canAuthenticate() == BiometricManager.BIOMETRIC_SUCCESS
    }

    private fun createBiometricPrompt(): BiometricPrompt {
        executor = ContextCompat.getMainExecutor(requireContext())
        val callback = object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                Toast.makeText(
                    context,
                    "Authentication error: $errString", Toast.LENGTH_SHORT
                ).show()
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(
                    context, "Authentication failed",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Toast.makeText(
                    context,
                    "Authentication succeeded!", Toast.LENGTH_SHORT
                ).show()
            }
        }
        biometricPrompt = BiometricPrompt(this, executor, callback)
        return biometricPrompt
    }

    private fun showId() {
        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("指紋認証")
            .setSubtitle("サンプルです")
            .setConfirmationRequired(true)
            .setDeviceCredentialAllowed(true)
            .build()
        binding.buttonHand.setOnClickListener {
            biometricPrompt.authenticate(promptInfo)
        }
    }
}
