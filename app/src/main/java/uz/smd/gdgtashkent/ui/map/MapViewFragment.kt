package uz.smd.gdgtashkent.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import uz.smd.gdgtashkent.R


class MapViewFragment : Fragment(R.layout.fragment_mapview), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap?) {
        // TODO: Read Latitude and Longitude from remote
        mMap = googleMap!!

        val tvTower = LatLng(41.341040, 69.286838)

        mMap.addMarker(
            MarkerOptions().position(tvTower)
                .title("Tv, Tower")
                .visible(true)
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tvTower,17.0f))
        mMap.uiSettings.isZoomControlsEnabled = true
    }

}
