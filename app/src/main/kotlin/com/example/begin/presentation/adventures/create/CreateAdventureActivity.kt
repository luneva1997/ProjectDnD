package com.example.begin.presentation.adventures.create

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.example.begin.R
import com.example.begin.databinding.ActivityCreateAdventureBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateAdventureActivity : AppCompatActivity() {

    private val viewModel: CreateAdventureViewModel by viewModel()
    private lateinit var viewBinding: ActivityCreateAdventureBinding
    private var adventureCreated: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityCreateAdventureBinding.inflate(layoutInflater)
        with(viewBinding) {
            setContentView(root)
            createAdventureButton.setOnClickListener {
                createAdventure()
            }
        }

        viewModel.onStateChange(this, ::renderState)
    }

    private fun renderState(state: CreateAdventureState) {
        when (state) {
            CreateAdventureState.Created -> renderCreated()
            CreateAdventureState.Idle -> renderIdle()
            CreateAdventureState.Loading -> renderLoading()
        }
    }

    private fun renderLoading() {
        with(viewBinding) {
            loadingLayout.visibility = View.VISIBLE
            editTextContainer.visibility = View.GONE
            createAdventureButton.visibility = View.GONE
        }
    }

    private fun renderCreated() {
        with(viewBinding) {
            loadingLayout.visibility = View.GONE
            editTextContainer.visibility = View.VISIBLE
            createAdventureButton.visibility = View.VISIBLE
        }
        adventureCreated = true
        showToast(R.string.create_adventure_success)
    }

    private fun renderIdle() {
        with(viewBinding) {
            loadingLayout.visibility = View.GONE
            editTextContainer.visibility = View.VISIBLE
            createAdventureButton.visibility = View.VISIBLE
        }
    }

    private fun createAdventure() {
        with(viewBinding) {
            val name = adventureName.text.toString()
            val description = adventureDescription.text.toString()

            if (name.isEmpty()) {
                showToast(R.string.create_adventure_name_cannot_be_empty)
                return
            }

            viewModel.emit(CreateAdventureEvent.Create(name, description))
        }
    }

    private fun Activity.showToast(@StringRes text: Int) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CreateAdventureActivity::class.java)
        }
    }
}