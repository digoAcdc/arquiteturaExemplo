package com.example.arquiteturaexemplo.ui.home.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.arquiteturaexemplo.R
import com.example.arquiteturaexemplo.data.model.Planeta
import com.squareup.picasso.Picasso


class PlanetasAdapter(val planetaClickListner: PlanetasAdapterItemOnClickListener) :
    RecyclerView.Adapter<PlanetasAdapter.ViewHolder>() {
    private var mList: MutableList<Planeta> = mutableListOf()

    interface PlanetasAdapterItemOnClickListener {
        fun OnClickItemListener(view: View, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_planeta, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val planeta = mList[position]
        Picasso.get().load(planeta.imagem).placeholder(R.drawable.place_holder)
            .into(holder.imageView);
        holder.textView.text = planeta.nome

        holder.itemView.setOnClickListener {
            planetaClickListner.OnClickItemListener(it, position)
        }
        ViewCompat.setTransitionName(holder.imageView, "item_image")
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun getPlaneta(position: Int): Planeta {
        return mList[position]
    }

    fun addPlanetas(planetas: List<Planeta>) {
        mList.addAll(planetas)
        notifyDataSetChanged()
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imvPlaneta)
        val textView: TextView = itemView.findViewById(R.id.tvName)

    }
}