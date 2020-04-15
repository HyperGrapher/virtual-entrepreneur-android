package com.hypergraph.entrepreneur.ui.home


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.hypergraph.entrepreneur.R
import com.hypergraph.entrepreneur.core.BaseFragment
import com.hypergraph.entrepreneur.models.Menu
import com.hypergraph.entrepreneur.utils.fadeIn
import kotlinx.android.synthetic.main.fragment_dashboard.*


/**
 * A simple [Fragment] subclass.
 */
class DashboardFragment : BaseFragment() {

    private var menuList: ArrayList<Menu> = ArrayList()


    // Use this in every fragment to setup layout in BaseFragment
    override fun layoutId() = R.layout.fragment_dashboard

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // in the layout: android:alpha="0" android:translationY="-50dp"
        main_card.fadeIn(350L, 50f).subscribe()

        val a = Menu("Profile", 2, false)
        val b = Menu("Market", 2, false)
        val c = Menu("V.I.P.", 2, false)
        val d = Menu("Help", 2, false)
        val e = Menu("Leaderboard", 2, false)
        val f = Menu("Account", 2, false)
        val g = Menu("Users.", 2, false)
        val h = Menu("Others", 2, false)

        menuList.add(a)
        menuList.add(b)
        menuList.add(c)
        menuList.add(d)
        menuList.add(e)
        menuList.add(f)
        menuList.add(g)
        menuList.add(h)

        dashRecycler.layoutManager = GridLayoutManager(activity, 2)
        dashRecycler.adapter = DashboardAdapter(menuList, context!!)


        // Use Action ID to navigate with animation defined in nav graph

        // Animation is set in the res/navigation/navigation_graph.xml
        my_btn.setOnClickListener {
            // navController initialized in BaseFragment
            navController.navigate(R.id.action_navigation_dashboard_to_childFragment)
        }

    }

}
