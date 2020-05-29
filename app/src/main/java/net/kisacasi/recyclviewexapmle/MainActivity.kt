package net.kisacasi.recyclviewexapmle

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private var list= ArrayList<RvItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()

    }
    private fun initData(){
        list.add(RvItem(R.drawable.ic_smile,"Item Deneme Title","Deneme Subtitle"))
        list.add(RvItem(R.drawable.ic_smile,"Item Deneme Title2","Deneme Subtitle2"))
        list.add(RvItem(R.drawable.ic_smile,"Item Deneme Title3","Deneme Subtitle3"))
        list.add(RvItem(R.drawable.ic_smile,"Item Deneme Title4","Deneme Subtitle4"))
        list.add(RvItem(R.drawable.ic_smile,"Item Deneme Title5","Deneme Subtitle5"))
        list.add(RvItem(R.drawable.ic_smile,"Item Deneme Title6","Deneme Subtitle6"))

        setAdapter()
    }

    private fun setAdapter(){
        val rvAdapter =RvAdapter(list)
        rv.apply {
            adapter=rvAdapter
            layoutManager=LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
        rvAdapter.setOnItemClickListener {
            Toast.makeText(this.applicationContext,it.title +"\n" + it.subTitle,Toast.LENGTH_SHORT).show()
        }

    }
}
