package com.example.androidtechsample.ui.chrome

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import com.example.androidtechsample.databinding.FragmentChromeCustomTabBinding

class ChromeCustomTabFragment : Fragment() {

  companion object {
    private const val URL = "https://developer.android.com/"
  }

  private lateinit var binding: FragmentChromeCustomTabBinding

  private val activityResultLauncher: ActivityResultLauncher<String> =
    registerForActivityResult(object :
      ActivityResultContract<String, Int>() {
      override fun createIntent(
        context: Context,
        input: String
      ): Intent {
        val builder = CustomTabsIntent.Builder()
          .setInitialActivityHeightPx(800)
          .setToolbarCornerRadiusDp(16)
        val customTabsIntent = builder.build().intent
        customTabsIntent.data = Uri.parse(input)
        return customTabsIntent
      }

      override fun parseResult(
        resultCode: Int,
        intent: Intent?
      ): Int {
        return resultCode
      }
    }) { resultCode ->
      // 終了時に呼び出されるコールバック
    }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentChromeCustomTabBinding.inflate(inflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.openWebView.setOnClickListener {
      activityResultLauncher.launch(URL)
    }
  }
}
