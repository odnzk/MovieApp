package com.study.presentation.util

import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.slidingpanelayout.widget.SlidingPaneLayout

class SlidingPaneBackPressedCallback(private val slidingPane: SlidingPaneLayout) :
    OnBackPressedCallback(slidingPane.isSlideable && slidingPane.isOpen),
    SlidingPaneLayout.PanelSlideListener {
    override fun handleOnBackPressed() {
        slidingPane.closePane()
    }

    override fun onPanelSlide(panel: View, slideOffset: Float) {}

    override fun onPanelOpened(panel: View) {
        isEnabled = true
    }

    override fun onPanelClosed(panel: View) {
        isEnabled = false
    }

    init {
        slidingPane.addPanelSlideListener(this)
    }
}
