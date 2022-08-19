package com.proyecto.apportizjonathan.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.proyecto.apportizjonathan.R
import com.proyecto.apportizjonathan.databinding.ActivitySanchezBinding
import com.proyecto.apportizjonathan.db.entity.PersonaEntity
import com.proyecto.apportizjonathan.retrofit.response.ResponseLogin
import com.proyecto.apportizjonathan.utilitarios.Constantes
import com.proyecto.apportizjonathan.utilitarios.SharedPrederences
import com.proyecto.apportizjonathan.viewmodel.PersonaViewModel

class SanchezActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:ActivitySanchezBinding
    private lateinit var auth: FirebaseAuth

    private lateinit var personoaViewModel: PersonaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySanchezBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnlogin.setOnClickListener(this)

        personoaViewModel = ViewModelProvider(this)
            .get(PersonaViewModel::class.java)

    }

    override fun onClick(vista: View) {
        when (vista.id) {
            R.id.btnlogin -> autenticacionFirebase()
        }
    }


    private fun autenticacionFirebase() {
        if (binding.etusuario.text?.isNotEmpty()!! && binding.etpassword.text?.isNotEmpty()!!) {
            auth.signInWithEmailAndPassword(binding.etusuario.text.toString(),
                binding.etpassword.text.toString()).addOnCompleteListener {
                    login ->
                if (login.isSuccessful) {
                    ingresarApp(login.result?.user?.email?: "")
                }else{
                    alerta()
                }
            }
        }
    }

    private fun alerta() {
        binding.tvmensaje.setText("No autenticado")
    }

    private fun ingresarApp(email: String) {
        val intent = Intent(this, OrtizActivity::class.java)
            .apply {
                putExtra("email", email)
            }
        startActivity(intent)
    }

    private fun obtenerDatos(reponse: ResponseLogin) {
        if (reponse.rpta) {
            val personaEntity = PersonaEntity(
                reponse.idPersona,
                reponse.apellido,
                reponse.nombre,
                reponse.email
            )
            personoaViewModel.insertar(personaEntity)
            startActivity(Intent(applicationContext,
                OrtizActivity::class.java))
            finish()
        }else{
            binding.tvmensaje.setText("No autenticado")
        }

    }

}