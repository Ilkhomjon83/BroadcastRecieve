package uz.rakhmonov.broadcastrecieve

import android.content.Intent
import android.content.IntentFilter
import android.location.LocationManager
import android.net.Network
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.rakhmonov.broadcastrecieve.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val gpsBroadcast=MyGpsBroadcast()
        val filter=IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION)
        filter.addAction(Intent.ACTION_PROVIDER_CHANGED)
        this.registerReceiver(gpsBroadcast,filter)


    }
}