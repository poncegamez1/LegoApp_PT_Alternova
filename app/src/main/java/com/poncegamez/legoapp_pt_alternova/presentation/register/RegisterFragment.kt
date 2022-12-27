package com.poncegamez.legoapp_pt_alternova.presentation.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.poncegamez.legoapp_pt_alternova.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var viewModel: RegisterViewModel
    private lateinit var registerBinding: FragmentRegisterBinding
    private lateinit var email: String
    private lateinit var nombre: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registerBinding = FragmentRegisterBinding.inflate(inflater,container, false)

        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        viewModel.onUserCreated.observe(viewLifecycleOwner, { result ->
            onUserCreatedSubscribe(result)
        })

        return registerBinding.root
    }

    private fun onUserCreatedSubscribe(result: Boolean?) {
        result?.let { isRegister ->
            if (isRegister) {
                Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
                viewModel.createUserAccount(email, nombre)
                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToListFragment())
            } else
                Toast.makeText(context, "Error en el registro", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(registerBinding){
            createAccountButtom.setOnClickListener{
                nombre = usernameEditText.text.toString()
                email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                viewModel.register(email, password)
            }
        }
    }


}