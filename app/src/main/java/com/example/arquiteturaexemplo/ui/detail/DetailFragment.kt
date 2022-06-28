package com.example.arquiteturaexemplo.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import com.example.arquiteturaexemplo.R
import com.example.arquiteturaexemplo.data.model.Planeta
import com.example.arquiteturaexemplo.databinding.FragmentDetailBinding
import com.example.arquiteturaexemplo.databinding.FragmentLoginBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        ViewCompat.setTransitionName(_binding!!.imvPlaneta, "hero_image")
      val planeta =  arguments?.getParcelable<Planeta>(getString(R.string.txt_planeta))
        println(planeta)

        init(planeta)
    }

   fun init(planeta: Planeta?){
       Picasso.get().load(planeta?.imagem).into( _binding?.imvPlaneta);
       _binding?.tvName?.text  = planeta?.nome
       _binding?.tvDescricao?.text  = planeta?.longaDescricao
   }
}