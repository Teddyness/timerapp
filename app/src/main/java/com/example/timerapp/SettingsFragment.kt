package com.example.timerapp

import android.os.Bundle
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment() {

    private lateinit var etMinutes: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        etMinutes = view.findViewById(R.id.etMinutes)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Settings"
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
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
        etMinutes.text.clear()
    }
}