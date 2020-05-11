package com.aregama.ilfornos.fragments


import android.Manifest
import android.content.IntentSender
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.PointF
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation

import com.aregama.ilfornos.R
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.tasks.Task
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.layers.ObjectEvent
import com.yandex.mapkit.logo.Alignment
import com.yandex.mapkit.logo.HorizontalAlignment
import com.yandex.mapkit.logo.VerticalAlignment
import com.yandex.mapkit.map.*
import com.yandex.mapkit.map.Map
import com.yandex.mapkit.user_location.UserLocationLayer
import com.yandex.mapkit.user_location.UserLocationObjectListener
import com.yandex.mapkit.user_location.UserLocationView
import com.yandex.runtime.image.ImageProvider
import kotlinx.android.synthetic.main.fragment_map.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class MapFragment : Fragment() ,Map.CameraCallback, UserLocationObjectListener, CameraListener,MapLoadedListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    val PERMISSION_ID = 42
    val REQUIRED_SDK_PERMISSIONS= arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
    val REQUEST_CODE_ASK_PERMISSIONS=1
    val REQUEST_CHECK_SETTINGS=1
    private lateinit var missingPermissions:ArrayList<String>
    private var isMapLoadedSusseccfully=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("990238ea-ebca-4ad7-9afe-c616822547ef")
        MapKitFactory.initialize(activity)
    }


    private  lateinit var userLocationLayer:UserLocationLayer





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)










        checkPermission()




        val aligment= Alignment(HorizontalAlignment.RIGHT, VerticalAlignment.TOP)
        mapView.map.logo.setAlignment(aligment)





        mapView.map.addCameraListener(this)
        mapView.map.setMapLoadedListener(this)




        mapView.map.isRotateGesturesEnabled=true
        mapView.map.isZoomGesturesEnabled=true









        zoom_in.setOnClickListener {

            mapView.map.move(CameraPosition(mapView.map.cameraPosition.target,mapView.map.cameraPosition.zoom+1,0.0f,0.0f),
                Animation(Animation.Type.SMOOTH,1.toFloat()),null)

        }


        zoom_out.setOnClickListener {
            mapView.map.move(CameraPosition(mapView.map.cameraPosition.target,mapView.map.cameraPosition.zoom-1,0.0f,0.0f),
                Animation(Animation.Type.SMOOTH,1.toFloat()),null)

        }


        show_me.setOnClickListener {
            moveToHome()
        }




        deliverBtn.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.toCloseRestaurants))


        contactBtn.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.toRestaurants))


    }


    override fun onStart() {
        super.onStart()
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
    }


    override fun onStop() {
        super.onStop()
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
    }

    override fun onObjectUpdated(userLocationView: UserLocationView, p1: ObjectEvent) {







    }

    override fun onObjectRemoved(p0: UserLocationView) {

    }

    override fun onObjectAdded(userLocationView: UserLocationView) {

        userLocationLayer.setAnchor(
            PointF(mapView.width()*0.5.toFloat(),mapView.height().toFloat()*0.5.toFloat()),
            PointF(mapView.width()*0.5.toFloat(),mapView.height().toFloat()*0.5.toFloat()))


        userLocationView.pin.setIcon(ImageProvider.fromResource(context,R.drawable.transparent_background))
        userLocationView.arrow.setIcon(ImageProvider.fromResource(context,R.drawable.me))


        userLocationView.accuracyCircle.fillColor= Color.TRANSPARENT

    }




    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {


        if (requestCode == REQUEST_CODE_ASK_PERMISSIONS) {

            for(index in permissions.indices){

                if ((grantResults[index] != PackageManager.PERMISSION_GRANTED)) {


                    activity!!.finish()

                    return

                }
            }


           askTurnOnLocation()
        }
    }



    private fun askTurnOnLocation(){
        val locationRequest = LocationRequest.create()?.apply {
            interval = 10000
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }


        locationRequest?.let {

            val builder = LocationSettingsRequest.Builder()
                .addLocationRequest(it)

            val client: SettingsClient = LocationServices.getSettingsClient(context!!)
            val task: Task<LocationSettingsResponse> = client.checkLocationSettings(builder.build())


            task.addOnSuccessListener { locationSettingsResponse ->

                moveToHome()
            }


            task.addOnFailureListener{exception ->
                if (exception is ResolvableApiException){
                    // Location settings are not satisfied, but this can be fixed
                    // by showing the user a dialog.
                    try {
                        // Show the dialog by calling startResolutionForResult(),
                        // and check the result in onActivityResult().
                        exception.startResolutionForResult(activity,
                            REQUEST_CHECK_SETTINGS)

                        moveToHome()


                    } catch (sendEx: IntentSender.SendIntentException) {
                        // Ignore the error.


                        Toast.makeText(context,"Ooops!",Toast.LENGTH_SHORT).show()
                    }
                }
            }






        }



    }




    private fun moveToHome(){

        mapView.map.move(CameraPosition(mapView.map.cameraPosition.target,mapView.map.maxZoom,0.0f,0.0f),
            Animation(Animation.Type.SMOOTH,1.toFloat()),this)
    }

    override fun onMoveFinished(p0: Boolean) {







    }

    override fun onCameraPositionChanged(
        p0: Map,
        p1: CameraPosition,
        p2: CameraUpdateSource,
        p3: Boolean
    ) {




    }





    override fun onMapLoaded(p0: MapLoadStatistics) {



        isMapLoadedSusseccfully=true

        val mapkit=MapKitFactory.getInstance()


       mapView?.let {


           userLocationLayer=mapkit.createUserLocationLayer(mapView.mapWindow)





           userLocationLayer.isVisible=true
           userLocationLayer.isHeadingEnabled=true

           userLocationLayer.setObjectListener(this)


           Handler().postDelayed({


               if(isMapLoadedSusseccfully && userLocationLayer.isValid){

                   mapView.map.move(CameraPosition(mapView.map.cameraPosition.target,mapView.map.maxZoom,0.0f,0.0f),
                       Animation(Animation.Type.SMOOTH,1.toFloat()),null)
               }

           }, 5000)
       }






    }





    private fun checkPermission(){


        missingPermissions= ArrayList()
        for(permission in REQUIRED_SDK_PERMISSIONS){
            val result= ContextCompat.checkSelfPermission(context!!, permission)

            if(result!=PackageManager.PERMISSION_GRANTED){
                missingPermissions.add(permission)
            }


        }


        if(!missingPermissions.isEmpty()){

            val permissions=missingPermissions.toTypedArray()

            requestPermissions(permissions,REQUEST_CODE_ASK_PERMISSIONS)

        } else{

            val grantResults=IntArray(REQUIRED_SDK_PERMISSIONS.size)

            Arrays.fill(grantResults, PackageManager.PERMISSION_GRANTED)


            onRequestPermissionsResult(REQUEST_CODE_ASK_PERMISSIONS, REQUIRED_SDK_PERMISSIONS,
                grantResults);

        }






    }







}
