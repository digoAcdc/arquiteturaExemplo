package com.example.arquiteturaexemplo.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.arquiteturaexemplo.R
import com.example.arquiteturaexemplo.data.Resource
import com.example.arquiteturaexemplo.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private lateinit var _binding: FragmentLoginBinding
    private val binding get() = _binding
    private val viewModel: LoginViewModel by viewModel()

    private val loginObserver = Observer<Resource> { resource ->
        when (resource) {
            is Resource.Failure<*> -> {
                println(resource.error?.message)
                Toast.makeText(context, resource.error?.message, Toast.LENGTH_LONG).show()
            }
            is Resource.Success<*> -> {
                println(resource.data)
                requireParentFragment().findNavController()
                    .navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        viewModel.loginLiveData.observe(viewLifecycleOwner, loginObserver)
    }

    private fun init() {
        _binding.btContinuar.setOnClickListener {
            val user = _binding.tilUsuario.editText?.text.toString()
            val senha = binding.tilSenha.editText?.text.toString()
            viewModel.login(
                user,
                senha
            )
        }
    }


}