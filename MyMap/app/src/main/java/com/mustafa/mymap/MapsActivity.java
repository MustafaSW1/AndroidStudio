package com.mustafa.mymap;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    private LatLng Sparkasse_Duisburg = new LatLng(51.43256370550697, 6.769685093722243);
    private LatLng Königstraße = new LatLng(51.432964, 6.768892);
    private LatLng Bauernmarkt = new LatLng(51.43317011674925, 6.768253977083163);
    private LatLng Duisburger_Innenstadt = new LatLng(51.43307181072014, 6.768131897349764);
    private LatLng König_Heinrich_Platz = new LatLng(51.4330918947648, 6.767935213334845);


    private Marker mSparkasse_Duisburg;
    private Marker mKönigstraße;
    private Marker mBauernmarkt;
    private Marker mDuisburger_Innenstadt;
    private Marker mKönig_Heinrich_Platz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this) ;


        List<Marker> markerList = new ArrayList<>();

        mSparkasse_Duisburg = mMap.addMarker(new MarkerOptions().position(Sparkasse_Duisburg)
                .title("SparKasse Duisburg")
        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mSparkasse_Duisburg.setTag(0);
        markerList.add(mSparkasse_Duisburg);
        //_____________________________

        mBauernmarkt = mMap.addMarker(new MarkerOptions().position(Bauernmarkt)
                .title("Bauern Markt")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mBauernmarkt.setTag(0);
        markerList.add(mBauernmarkt);
        //_____________________________

        mDuisburger_Innenstadt = mMap.addMarker(new MarkerOptions().position(Duisburger_Innenstadt)
        .title("Duisburger Innenstadt")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        mDuisburger_Innenstadt.setTag(0);
        markerList.add(mDuisburger_Innenstadt);
        //_____________________________

        mKönig_Heinrich_Platz = mMap.addMarker(new MarkerOptions().position(König_Heinrich_Platz)
        .title("König Heinrig Platz")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        mKönig_Heinrich_Platz.setTag(0);
        markerList.add(mKönig_Heinrich_Platz);
        //_____________________________

        mKönigstraße = mMap.addMarker(new MarkerOptions().position(Königstraße)
        .title("König Straße")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mKönigstraße.setTag(0);
        markerList.add(mKönigstraße);


        for (Marker m:markerList) {
            LatLng latLng = new LatLng(m.getPosition().latitude,m.getPosition().longitude);
            mMap.addMarker(new MarkerOptions().position(latLng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
        }

        //LatLng sydney = new LatLng(-34, 151);
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        Toast.makeText(this,marker.getTitle(),Toast.LENGTH_LONG).show();
        return false;
    }
}