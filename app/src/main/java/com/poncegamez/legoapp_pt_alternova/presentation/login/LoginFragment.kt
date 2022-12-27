package com.poncegamez.legoapp_pt_alternova.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.poncegamez.legoapp_pt_alternova.databinding.FragmentLoginBinding
import com.poncegamez.legoapp_pt_alternova.utils.isEmailValid
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var loginBinding: FragmentLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginBinding = FragmentLoginBinding.inflate(inflater, container, false)

        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        loginViewModel.onUserLogged.observe(viewLifecycleOwner) { result ->
            onUserLoggedSubscribe(result)}

        return loginBinding.root
    }

    private fun onUserLoggedSubscribe(result: Boolean?) {
        result?.let { isLoggedIn ->
            if (isLoggedIn){
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToListFragment())
            } else
                Toast.makeText(context, "Error en el inicio de sesión", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(loginBinding) {
            loginButtom.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(
                        context,
                        "Debe digitar correo electrónico y contraseña",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else
                    if (!isEmailValid(email)) {
                        Toast.makeText(
                            context,
                            "No corresponde a un formato de correo electrónico",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        loginViewModel.login(email, password)
                    }
            }
            registerTextView.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
            }
        }

    }

}