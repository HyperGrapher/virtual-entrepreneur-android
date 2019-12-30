package com.hypergraph.entrepreneur.ui.home


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hypergraph.entrepreneur.R
import com.hypergraph.entrepreneur.core.BaseFragment
import com.hypergraph.entrepreneur.utils.fadeIn
import kotlinx.android.synthetic.main.fragment_dashboard.*


/**
 * A simple [Fragment] subclass.
 */
class DashboardFragment : BaseFragment() {

    // Use this in every fragment to setup layout in BaseFragment
    override fun layoutId() = R.layout.fragment_dashboard

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // in the layout: android:alpha="0" android:translationY="-50dp"
        main_card.fadeIn(350L, 50f).subscribe()

        // Use Action ID to navigate with animation defined in nav graph

        // Animation is set in the res/navigation/navigation_graph.xml
        my_btn.setOnClickListener {
            // navController initialized in BaseFragment
            navController.navigate(R.id.action_navigation_dashboard_to_childFragment)
        }

    }

}
