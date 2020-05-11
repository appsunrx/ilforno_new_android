package com.aregama.ilfornos.fragments.register


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.aregama.ilfornos.R
import kotlinx.android.synthetic.main.fragment_register_number.*

/**
 * A simple [Fragment] subclass.
 */
class RegisterNumberFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_number, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        continueNumberEnter.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toNumberConfirmation))
    }


}
