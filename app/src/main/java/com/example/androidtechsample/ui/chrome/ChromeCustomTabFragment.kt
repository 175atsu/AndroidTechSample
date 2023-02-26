package com.example.androidtechsample.ui.chrome

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import com.example.androidtechsample.databinding.FragmentChromeCustomTabBinding

class ChromeCustomTabFragment : Fragment() {

  companion object {
    private const val URL = "https://developer.android.com/"
  }

  private lateinit var binding: FragmentChromeCustomTabBinding

  private val startForResult =
    registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
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

      val builder = CustomTabsIntent.Builder()
        .setInitialActivityHeightPx(1000)
        .setToolbarCornerRadiusDp(16)
      val customTabsIntent = builder.build().intent.apply { data = Uri.parse(URL) }
      startForResult.launch(customTabsIntent)
    }
  }
}
