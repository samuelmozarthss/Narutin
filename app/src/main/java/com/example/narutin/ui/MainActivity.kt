package com.example.narutin.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.narutin.*
import com.example.narutin.service.CharacterServices
import com.example.narutin.service.RetrofitClient
import com.example.narutin.ui.adapter.CharacterAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var mRecyclerview: RecyclerView
    private var mCharacterList: ArrayList<CharactersModel> = ArrayList()
    private val mAdapter: CharacterAdapter = CharacterAdapter(mCharacterList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val remote = RetrofitClient.createService(CharacterServices::class.java)
        val call: Call<List<CharactersModel>> = remote.list()

        val response = call.enqueue(object : Callback<List<CharactersModel>> {

            override fun onResponse(
                call: Call<List<CharactersModel>>,
                response: Response<List<CharactersModel>>
            ) {
//                response.body()?.forEach {
//                    mCharacterList.add(it)
//                }

                response.body()?.let { charactersList ->
                    mCharacterList.addAll(charactersList)
                }
//                val res = response.body()
//                if(res != null) {
//                    mCharacterList.addAll(res)
//                }

                Log.d("teste", mCharacterList.toString())
                mAdapter.notifyDataSetChanged()

//                Lista de ocupações
            }

            override fun onFailure(call: Call<List<CharactersModel>>, t: Throwable) {
                val s = t.message
            }
        })

        mRecyclerview = findViewById(R.id.characters_list)
        mRecyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mRecyclerview.adapter = mAdapter
    }
}