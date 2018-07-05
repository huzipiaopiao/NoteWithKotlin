package com.easy.kotlin.mytodoapplication

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.banbury.notewithkotlin.R
import io.realm.RealmBasedRecyclerViewAdapter
import io.realm.RealmResults
import io.realm.RealmViewHolder
import org.jetbrains.anko.textColor

/**
 * @created 2018/7/5_10:52.
 * @author banbury
 * @version v1.0
 * @description
 */
class TodoAdapter(context: Context,
                  realmResults: RealmResults<Todo>,
                  automaticUpdate: Boolean,
                  animateResults: Boolean,
                  private val clickListener: TodoItemClickListenter) :

        RealmBasedRecyclerViewAdapter<Todo, TodoAdapter.ViewHolder>(
                context,
                realmResults,
                automaticUpdate,
                animateResults) {


    override fun onBindRealmViewHolder(p0: ViewHolder, p1: Int) {
        val todo = realmResults[p1]
        p0.todoTitle.text = todo.title
        p0.todoTitle.fontFeatureSettings = "font-size:12px"
        p0.todoTitle.textColor = Color.argb(255, 69, 106, 124)

        p0.todoContent.text = todo.content
    }

    override fun onCreateRealmViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = inflater.inflate(R.layout.todo_item, p0, false)
        return ViewHolder(view, clickListener)
    }


    inner class ViewHolder(view: View, private val clickListener: TodoItemClickListenter?) : RealmViewHolder(view), View.OnClickListener {

        @BindView(R.id.todo_item_todo_title)
        lateinit var todoTitle: TextView
        @BindView(R.id.todo_item_todo_content)
        lateinit var todoContent: TextView

        init {
            ButterKnife.bind(this, view)
            view.setOnClickListener(this)
        }


        override fun onClick(v: View) {
            clickListener?.onClick(v, realmResults[adapterPosition])
        }

    }

    interface TodoItemClickListenter {
        fun onClick(caller: View, todo: Todo)
    }
}