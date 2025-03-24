package com.example.aroundegypt.common.ui

import android.view.View

object Loading : ILoading {
    override fun handleProgressBar(isLoading: Boolean, view: View) {
        view.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}