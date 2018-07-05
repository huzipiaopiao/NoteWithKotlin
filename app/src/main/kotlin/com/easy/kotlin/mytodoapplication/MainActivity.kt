package com.easy.kotlin.mytodoapplication

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import com.banbury.notewithkotlin.R

class MainActivity : AppCompatActivity() {

    var fab: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
        setSupportActionBar(toolbar)

        fab = findViewById(R.id.fab) as FloatingActionButton
        fab?.setOnClickListener {
            val todoEditFragment = TodoEditFragment()
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.content_main, todoEditFragment, todoEditFragment.javaClass.simpleName)
                    .addToBackStack(todoEditFragment.javaClass.simpleName)
                    .commit()
            hideFab()
        }

        val todosFragment = TodosFragment.getInstance()

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.content_main, todosFragment, todosFragment::class.java.simpleName)
                .commit()

        supportFragmentManager.addOnBackStackChangedListener {
            val backStackEntryCount = supportFragmentManager.backStackEntryCount
            if (backStackEntryCount == 0) {
                showFab()
            }
        }

    }

    fun hideFab() {
        fab?.visibility = GONE
    }

    fun showFab() {
        fab?.visibility = VISIBLE
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }
}
