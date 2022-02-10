package hu.hm.ibm_rainbowcake.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(message: String?, length: Int = Toast.LENGTH_SHORT) {
    message ?: return
    Toast.makeText(context, message, length).show()
}

fun Fragment.isNetAvailable(): Boolean {
    val connectivityManager = requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return (activeNetworkInfo != null && activeNetworkInfo.isConnected)
}