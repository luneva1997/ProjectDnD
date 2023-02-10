package com.example.begin.presentation.adventures.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.begin.AdventureActivity
import com.example.begin.DnDBook
import com.example.begin.Settings
import com.example.begin.data.db.entities.Adventure
import com.example.begin.databinding.ActivityAdventuresListBinding
import com.example.begin.presentation.adventures.create.CreateAdventureActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class AdventuresListActivity : AppCompatActivity() {

    private val viewModel: AdventuresListViewModel by viewModel()
    private lateinit var viewBinding: ActivityAdventuresListBinding
    private lateinit var adventuresAdapter: AdventuresListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adventuresAdapter = AdventuresListAdapter(adventureClickListener = ::onAdventureClicked)
        viewBinding = ActivityAdventuresListBinding.inflate(layoutInflater)
        with(viewBinding) {
            setContentView(root)
            adventures.adapter = adventuresAdapter
            createAdventureButton.setOnClickListener {
                goToCreateAdventureScreen()
            }
        }

        viewModel.onStateChange(this@AdventuresListActivity, ::renderState)
    }

    override fun onResume() {
        super.onResume()
        viewModel.emit(AdventuresListEvent.Load)
    }

    private fun onAdventureClicked(adventure: Adventure) {
        startActivity(
            AdventureActivity.createIntent(
                context = this,
                adventureId = adventure.id,
            )
        )
    }

    private fun goToCreateAdventureScreen() {
        startActivity(CreateAdventureActivity.createIntent(this))
    }

    private fun renderState(state: AdventuresListState) {
        when (state) {
            AdventuresListState.Empty -> renderEmpty()
            is AdventuresListState.Loaded -> renderLoaded(state)
            AdventuresListState.Loading -> renderLoading()
        }
    }

    private fun renderEmpty() {
        with(viewBinding) {
            loadingLayout.visibility = View.GONE
            adventures.visibility = View.GONE
            emptyLayout.visibility = View.VISIBLE
        }
    }

    private fun renderLoaded(state: AdventuresListState.Loaded) {
        adventuresAdapter.update(state.adventures)
        with(viewBinding) {
            adventures.visibility = View.VISIBLE
            loadingLayout.visibility = View.GONE
            emptyLayout.visibility = View.GONE
        }
    }

    private fun renderLoading() {
        with(viewBinding) {
            loadingLayout.visibility = View.VISIBLE
            emptyLayout.visibility = View.GONE
            adventures.visibility = View.GONE
        }
    }

    fun toDnDBook(view: View) {
        val intent = Intent(this, DnDBook::class.java)
        startActivity(intent)
    }

    fun toSettings(view: View) {
        val intent = Intent(this@AdventuresListActivity, Settings::class.java)
        startActivity(intent)
    }
}