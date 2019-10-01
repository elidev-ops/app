package com.example.apptestenumero38

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apptestenumero38.activity.MainActivity
import kotlinx.android.synthetic.main.activity_cad_service_code.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import android.net.wifi.WifiInfo
import android.content.Context.WIFI_SERVICE
import androidx.core.content.ContextCompat.getSystemService
import android.net.wifi.WifiManager
import androidx.core.app.ComponentActivity.ExtraData
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class cad_service_code : AppCompatActivity() {
    var manager: WifiManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cad_service_code)
        manager = getApplicationContext().getSystemService(Context.WIFI_SERVICE) as WifiManager
        btnCard.setOnClickListener {
                var info = manager?.connectionInfo
                val address = info?.macAddress

            startActivity<MainActivity>("code" to address)
        }
    }


}
