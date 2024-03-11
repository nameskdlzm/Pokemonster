package com.mrhi2024.pokemon.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mrhi2024.pokemon.R
import com.mrhi2024.pokemon.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLoginPokemon.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        binding.tvSignup.setOnClickListener { startActivity(Intent(this,SignupActivity::class.java)) }

        binding.layoutEmailLogin.setOnClickListener { startActivity(Intent(this,SignupActivity::class.java)) }

        binding.btnLoginKakao.setOnClickListener { clickKakao() }
        binding.btnLoginGoogle.setOnClickListener { clickGoogle() }

    }

    private fun clickKakao(){

    }

    private fun clickGoogle(){

    }

}