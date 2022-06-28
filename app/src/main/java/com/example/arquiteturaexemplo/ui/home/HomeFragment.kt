package com.example.arquiteturaexemplo.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arquiteturaexemplo.R
import com.example.arquiteturaexemplo.data.Resource
import com.example.arquiteturaexemplo.data.model.Planeta
import com.example.arquiteturaexemplo.databinding.FragmentHomeBinding
import com.example.arquiteturaexemplo.ui.home.adapter.PlanetasAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModel()
    private lateinit var adapter: PlanetasAdapter

    private val planetasObserver = Observer<Resource> { resource ->
        when (resource) {
            is Resource.Failure<*> -> {
                println(resource.error?.message)
                Toast.makeText(context, resource.error?.message, Toast.LENGTH_LONG).show()
            }
            is Resource.Success<*> -> {
                println(resource.data)
                val planetas: List<Planeta> = resource.data as List<Planeta>
                adapter.addPlanetas(planetas)
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        viewModel.buscaPlanetas()
    }

    private fun init() {
        viewModel.planetasLiveData.observe(viewLifecycleOwner, planetasObserver)
        _binding?.rvPlanetas?.layoutManager = LinearLayoutManager(context)
        adapter = PlanetasAdapter(planetaOnClickListener)

        _binding?.rvPlanetas?.adapter = adapter
    }

    private var planetaOnClickListener = object : PlanetasAdapter.PlanetasAdapterItemOnClickListener {
        override fun OnClickItemListener(view: View, position: Int) {
            val bundle = bundleOf(getString(R.string.txt_planeta) to adapter.getPlaneta(position))
            requireParentFragment().findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
        }

    }

}