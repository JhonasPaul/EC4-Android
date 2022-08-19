package com.proyecto.apportizjonathan.view

import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.proyecto.apportizjonathan.R
import com.proyecto.apportizjonathan.databinding.ActivityOrtizBinding
import com.proyecto.apportizjonathan.viewmodel.PersonaViewModel


class OrtizActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityOrtizBinding

        private lateinit var personaViewModel: PersonaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityOrtizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarOrtiz.toolbar)

        binding.appBarOrtiz.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_ortiz)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        mostrarInfoPersona();
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.ortiz, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_ortiz)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun mostrarInfoPersona() {
        val tvnompersona: TextView = binding.navView.getHeaderView(0)
            .findViewById(R.id.etusuario)
        val tvemailpersona: TextView = binding.navView.getHeaderView(0)
            .findViewById(R.id.etusuario)
        personaViewModel = ViewModelProvider(this)
            .get(PersonaViewModel::class.java)
        personaViewModel.obtener().observe(this, Observer {
                persona ->
            persona?.let {
                tvnompersona.setText(persona.nombre + " " + persona.apellidos)
                tvemailpersona.setText(persona.email)
            }
        })

}