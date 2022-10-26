package com.furkan.datastore.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.furkan.datastore.databinding.ActivityMainBinding
import com.furkan.datastore.utils.PreferenceHelper.APP_NAME
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvEmail.isSelected = true

        binding.btnSave.setOnClickListener {
            if (binding.etAppName.text.isEmpty()) {
                return@setOnClickListener
            } else {
                viewModel.saveData(binding.etAppName.text.toString())
            }
        }

        binding.btnRead.setOnClickListener {
            lifecycleScope.launchWhenCreated {
                viewModel.readString(APP_NAME).collectLatest {
                    Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}