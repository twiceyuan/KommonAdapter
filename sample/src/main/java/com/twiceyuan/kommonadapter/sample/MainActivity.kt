package com.twiceyuan.kommonadapter.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.twiceyuan.commonadapter.library.LayoutId
import com.twiceyuan.commonadapter.library.holder.CommonHolder
import com.twiceyuan.kommonadapter.KommonAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.view.*

class MainActivity : AppCompatActivity() {

    private val adapter by lazy { KommonAdapter.create<Person, PersonHolder>(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.addAll(listOf(
                Person("twiceYuan", 24),
                Person("Tonia", 18)
        ))

        adapter.notifyDataSetChanged()
    }
}

data class Person(val name: String, val age: Int)

@LayoutId(R.layout.item)
class PersonHolder : CommonHolder<Person>() {

    override fun bindData(t: Person?) {
        itemView.tv_name.text = t?.name
        itemView.tv_age.text = t?.age.toString()
    }
}
