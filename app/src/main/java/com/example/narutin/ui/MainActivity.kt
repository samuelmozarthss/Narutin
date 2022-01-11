package com.example.narutin.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.narutin.*
import com.example.narutin.repository.CharacterDAO
import com.example.narutin.repository.local.AppDatabase
import com.example.narutin.repository.local.CharacterRepository
import com.example.narutin.repository.local.CharacterRepositoryImpl
import com.example.narutin.service.CharacterServices
import com.example.narutin.service.RetrofitClient
import com.example.narutin.ui.adapter.CharacterAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var mRepository: CharacterRepository
    private lateinit var mDatabase: AppDatabase
    private lateinit var mRecyclerview: RecyclerView
    private var mCharacterList: ArrayList<CharactersModel> = ArrayList()
    private val mAdapter: CharacterAdapter = CharacterAdapter(mCharacterList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        mDatabase = AppDatabase.getDatabase(this)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mRepository = CharacterRepositoryImpl(mDatabase.characterDAO())

        val remote = RetrofitClient.createService(CharacterServices::class.java)
        val call: Call<List<CharactersModel>> = remote.list()

        verifyCache(call)

        mRecyclerview = findViewById(R.id.characters_list)
        mRecyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mRecyclerview.adapter = mAdapter
    }

    private fun verifyCache(call: Call<List<CharactersModel>>) {
        val characters = mRepository.getAll()
        if (characters.isEmpty()) {
            call.enqueue(
                object : Callback<List<CharactersModel>> {

                    override fun onResponse(
                        call: Call<List<CharactersModel>>,
                        response: Response<List<CharactersModel>>
                    ) {
                        response.body()?.let { charactersList ->
                            mCharacterList.addAll(charactersList)
                        }

                        mCharacterList.forEach { charactersModel ->
                            mRepository.save(charactersModel)
                        }

                        Log.d("teste", mCharacterList.toString())
                        mAdapter.notifyDataSetChanged()

//                Lista de ocupações
                    }

                    override fun onFailure(call: Call<List<CharactersModel>>, t: Throwable) {
                        val s = t.message
                    }
                }
            )
        } else {
            mCharacterList.addAll(characters)
            mAdapter.notifyDataSetChanged()
        }
    }
}