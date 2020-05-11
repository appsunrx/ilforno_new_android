package com.aregama.ilfornos.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.aregama.ilfornos.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_navigation_layout.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class MainActivity : AppCompatActivity() {

    private  var locationMenu:MenuItem?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbarMain)


        supportActionBar?.setDisplayShowTitleEnabled(false)



        val navController=Navigation.findNavController(this,R.id.nav_host_fragment)


        NavigationUI.setupActionBarWithNavController(this,navController)

        bottomNav.setupWithNavController(navController)






        navController.addOnDestinationChangedListener { controller, destination, arguments ->

            when(destination.id){
                R.id.mapFragment->{
                    showBackButton(false)
                    toolBarText.text=getString(R.string.your_address)
                }
                R.id.restaurantMenuFragment->{
                    showBackButton(true)
                    toolBarText.text=getString(R.string.restaurants)
                }
                R.id.aboutRestaurantFragment->{
                    showBackButton(true)



                }
                R.id.menuItemFragment->{
                    showBackButton(true)
                    toolBarText.text="Маленковская улица, 28"

                }
                R.id.addToCartFragment->{
                    showBackButton(true)
                }

                R.id.cartFragment->{
                    showBackButton(true)
                    toolBarText.text=getString(R.string.cart)
                }

                R.id.registerNumberFragment->{
                    showBackButton(true)
                    toolBarText.text=getString(R.string.number_confirmation)
                }

                R.id.numberConfirmationFragment->{
                    showBackButton(true)
                    toolBarText.text=getString(R.string.number_confirmation)
                }



                else->{
                    showBackButton(false)
                    toolBarText.text=getString(R.string.restaurants)
                }
            }

            locationMenu?.let {

                if(destination.id==R.id.menuItemFragment)it.isVisible=true else it.isVisible=false
            }



            if(destination.id==R.id.aboutRestaurantFragment) {
                toolBarText.visibility= View.GONE
                toolBarImage.visibility=View.VISIBLE
                toolBarImage.setImageResource(R.drawable.ic_craft)
            } else{
                toolBarText.visibility= View.VISIBLE
                toolBarImage.visibility=View.GONE
            }

            if(destination.id==R.id.mapFragment) bottomBarId.isVisible=false else bottomBarId.isVisible=true





        }






    }


    override fun onSupportNavigateUp(): Boolean {

        val navController=Navigation.findNavController(this,R.id.nav_host_fragment)

        return navController.navigateUp()


    }


    private fun showBackButton(isBack:Boolean){

        supportActionBar?.setDisplayHomeAsUpEnabled(isBack)
        supportActionBar?.setHomeButtonEnabled(isBack)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)

        locationMenu=menu?.findItem(R.id.location)

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==R.id.location){

            val navController=Navigation.findNavController(this,R.id.nav_host_fragment)
            navController.navigate(R.id.toMap)
            return true
        }

        return super.onOptionsItemSelected(item)
    }












}
