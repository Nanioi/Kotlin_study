package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatViewInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_phone_book_with_recycler_view.*

class PhoneBookWithRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_with_recycler_view)

//        val  phoneBook = createFakePhoneBook(30)
//        val  phoneBookRecyclerAdapter = PhoneBookRecyclerAdapter(
//            phoneBookList = phoneBook,
//            inflater = LayoutInflater.from(this@PhoneBookWithRecyclerViewActivity),
//            activity = this
//        )
//        phonebook_recycler_view.adapter = phoneBookRecyclerAdapter
//        phonebook_recycler_view.layoutManager = LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)

        //위 코드 쓸데없는 변수 없애기
        with(phonebook_recycler_view) {
            this.adapter = PhoneBookRecyclerAdapter(
                phoneBookList = createFakePhoneBook(fakeNumber = 30),
                inflater = LayoutInflater.from(this@PhoneBookWithRecyclerViewActivity),
                activity = this@PhoneBookWithRecyclerViewActivity
            )
            this.layoutManager  = LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)
        }
    }

    fun createFakePhoneBook(fakeNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()): PhoneBook {
        for (i in 0 until fakeNumber) {
            phoneBook.addPerson(
                Person(name = "" + i + "번쨰사람", number = "010" + i + i + i + i + i + i + i + i)
            )
        }
        return phoneBook
    }
}

class PhoneBookRecyclerAdapter(
    val phoneBookList: PhoneBook,
    val inflater: LayoutInflater,
    val activity: Activity
) : RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName: TextView

        init {
            personName = itemView.findViewById(R.id.person_name)
            itemView.setOnClickListener {
                val intent = Intent(activity, PhoneBookDetailActivity::class.java)
                intent.putExtra("name", phoneBookList.personList.get(adapterPosition).name)
                intent.putExtra("number", phoneBookList.personList.get(adapterPosition).number)
                activity.startActivity(intent)
            }
        }
    }// 재활용할것들 넣기

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.phonebook_item, parent, false)
        return ViewHolder(view) // 이걸해줘야 재활용가능
    }//그려주기

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(phoneBookList.personList.get(position).name)
    }

    override fun getItemCount(): Int {
        return phoneBookList.personList.size
    }
}