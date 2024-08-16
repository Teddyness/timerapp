package com.example.timerapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.timerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TimerResetListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.btnStartTimer.setOnClickListener {
            val minutes = binding.etMinutes.text.toString().toIntOrNull() ?: 0
            val intent = Intent(this, TimerActivity::class.java)
            intent.putExtra("MINUTES", minutes)
            startActivity(intent)
        }

        loadFragment(HomeFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.reset_timer -> {
                resetTimer()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun resetTimer() {
        binding.etMinutes.text.clear()
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onResetTimer() {
        resetTimer()
    }
}