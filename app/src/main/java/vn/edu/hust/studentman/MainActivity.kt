package vn.edu.hust.studentman

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitleTextColor(Color.WHITE) // Set title text color to white
        setSupportActionBar(toolbar)

        toolbar.overflowIcon?.setTint(Color.WHITE)

        try {
            val navController = findNavController(R.id.nav_host_fragment)
            setupActionBarWithNavController(navController)
            Log.d("MainActivity", "NavController set up successfully")
        } catch (e: Exception) {
            Log.e("MainActivity", "Error setting up NavController", e)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_add -> {
                val action = MainFragmentDirections.actionMainFragmentToAddStudentFragment()
                findNavController(R.id.nav_host_fragment).navigate(action)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}