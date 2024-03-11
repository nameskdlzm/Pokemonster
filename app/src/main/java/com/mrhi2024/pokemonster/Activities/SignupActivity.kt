package com.mrhi2024.pokemon.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore
import com.mrhi2024.pokemon.R
import com.mrhi2024.pokemon.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySignupBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { finish() }
        binding.btnSignup.setOnClickListener { clickUp() }

    }

    private fun clickUp(){
        var email = binding.inputLayoutEmail.editText!!.text.toString()
        var password = binding.inputLayoutPassword.editText!!.text.toString()
        var passwordConfirm = binding.inputLayoutPasswordConfirm.editText!!.text.toString()

        if (password != passwordConfirm){
            AlertDialog.Builder(this).setMessage("패스워드가 틀렷습니다").create().show()
            binding.inputLayoutPasswordConfirm.editText!!.selectAll()
            return
        }

        val userRef: CollectionReference = Firebase.firestore.collection("emailUesrs")

        userRef.whereEqualTo("email",email).get().addOnSuccessListener {
            if (it.documents.size>0){
                AlertDialog.Builder(this).setMessage("중복된 이메일이 있습니다. 다시 입력햇주세요").create().show()
                binding.inputLayoutEmail.editText!!.requestFocus()
                binding.inputLayoutEmail.editText!!.selectAll()
        }else{
            val user:MutableMap<String,String> = mutableMapOf()
                user["email"] = email
                user["password"] = password

                userRef.document().set(user).addOnSuccessListener {
                AlertDialog.Builder(this)
                    .setMessage("축하합니다 회원가입이 완료되었습니다")
                    .setPositiveButton("확인",{p0,p1->finish()})
                    .create().show()

                }
            }

        }

    }

}