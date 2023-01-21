package com.dev.leonardom.navigationcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.dev.leonardom.navigationcomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    //para quitar la flecha de navegacion hacia atras,1.-- creamos variable de tipo:
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //2.-- Asignamos los fragmentos en los que navegaremos
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.primerFragment,
                R.id.segundoFragment
            )
        )

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        //Toolbar
        setSupportActionBar(binding.toolbar)

        //Config. de la barra de acciones con NavCon.  //3.-- Agregamos a la configuracion
        setupActionBarWithNavController(navController, appBarConfiguration)

        //Bottom Navigation
        //accedemos a la vista de navegacion inferiror y la configuramos con nuestro control de navegacio
        binding.bottomNavigationView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
}









