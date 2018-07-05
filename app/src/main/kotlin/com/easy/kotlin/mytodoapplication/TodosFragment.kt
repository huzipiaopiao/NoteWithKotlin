package com.easy.kotlin.mytodoapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView
import com.banbury.notewithkotlin.R
import io.realm.Realm

/**
 * Created by banbury on 2018/7/5.
 */
class TodosFragment : Fragment(), TodoAdapter.TodoItemClickListenter {

    val TAG = TodosFragment::class.java.simpleName


    @BindView(R.id.todos_recycler_view)
    lateinit var realmRecyclerView: RealmRecyclerView

    private var realm: Realm? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_todos, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        realm = Realm.getDefaultInstance()
    }

    override fun onResume() {
        super.onResume()
        val todos = realm!!.where(Todo::class.java).findAll()
        Log.i(TAG, "onResume:${todos}")
        val adapter = TodoAdapter(activity, todos, true, true, this)
        realmRecyclerView.setAdapter(adapter)
    }

    override fun onDestroy() {
        super.onDestroy()
        realm!!.close()
    }

    override fun onClick(caller: View, todo: Todo) {
        (activity as MainActivity).hideFab()

        val todoEditFragment = TodoEditFragment.newInstance(todo.id)

        activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.content_main, todoEditFragment, todoEditFragment.javaClass.simpleName)
                .addToBackStack(todoEditFragment.javaClass.simpleName)
                .commit()
    }

    companion object {
        fun getInstance(): TodosFragment = TodosFragment()
    }

}