package com.easy.kotlin.mytodoapplication

import android.support.v4.app.Fragment
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView
import com.banbury.notewithkotlin.R
import io.realm.Realm
import io.realm.RealmBasedRecyclerViewAdapter
import io.realm.RealmViewHolder

/**
 * Created by banbury on 2018/7/5.
 */
class TodosFragment : Fragment() {
    @BindView(R.id.todos_recycler_view)
    lateinit var realmRecyclerView: RealmRecyclerView

    private var realm: Realm? = null


    inner class TodoAdapter() : RealmBasedRecyclerViewAdapter<Todo, ViewHolder>() {

    }

    inner class ViewHolder(view: View, private val clickListener: TodoItemClickListenter?) : RealmViewHolder(view), View.OnClickListener {

        @BindView(R.id.todo_item_todo_title)
        lateinit var todoTitle: TextView
        @BindView(R.id.todo_item_todo_content)
        lateinit var todoContent: TextView

        init {
            ButterKnife.bind(this, view)
            view.setOnClickListener { this }
        }


        override fun onClick(v: View?) {
            clickListener?.
        }

    }
}