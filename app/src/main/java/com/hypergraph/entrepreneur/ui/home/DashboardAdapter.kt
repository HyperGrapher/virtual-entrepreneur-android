package com.hypergraph.entrepreneur.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hypergraph.entrepreneur.R
import com.hypergraph.entrepreneur.models.Menu
import kotlinx.android.synthetic.main.row_dashboard_menu.view.*


class DashboardAdapter(
    private val items: ArrayList<Menu>,
    private val context: Context
) :
    RecyclerView.Adapter<ViewHolder>() {

    companion object {
        const val TAG: String = "DashboardAdapter"

    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.row_dashboard_menu,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvTitle.text = items[position].title


        holder.itemView.setOnClickListener {
            /* (context as MainActivity).acceptRequestDialog(
                 usages[position].phone!!,
                 usages[position].username!!,
                 usages[position].firebaseKey!!
             )*/
        }
    }


}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val tvTitle: TextView = view.row_menu_title


}

