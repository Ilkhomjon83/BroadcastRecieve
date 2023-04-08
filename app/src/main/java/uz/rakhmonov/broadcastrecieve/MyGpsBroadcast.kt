package uz.rakhmonov.broadcastrecieve

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.util.Log
import android.widget.Toast

private const val TAG = "MyGpsBroadcast"

class MyGpsBroadcast : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "onReceive: GPS imiz ozgardiii")

        if (LocationManager.PROVIDERS_CHANGED_ACTION.equals(intent.action)){
            val locationManager=context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val isGpsEnablad=locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            val isNetworkEnabled=locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
            
            if (isGpsEnablad || isNetworkEnabled){
                Log.d(TAG, "onReceive: GPS yondi")
                Toast.makeText(context, "GPS yondi", Toast.LENGTH_SHORT).show()
            }else{
                Log.d(TAG, "onReceive: GPS o'chdi")
                Toast.makeText(context, "GPS o'chdi", Toast.LENGTH_SHORT).show()
            }
        }

    }
}