package com.hypergraph.entrepreneur.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

abstract class BaseFragment : Fragment() {

    /**
     * in child fragments use:
     * override fun layoutId() = R.layout.fragment_home
     */
    abstract fun layoutId(): Int

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(layoutId(), container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve the NavController created by a NavHostFragment
        // navController reachable in every child fragment.
        navController = NavHostFragment.findNavController(this)
    }
}