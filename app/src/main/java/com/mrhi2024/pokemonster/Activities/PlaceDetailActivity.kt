package com.mrhi2024.pokemonster.Activities

import Place
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.google.gson.Gson
import com.mrhi2024.pokemon.R
import com.mrhi2024.pokemon.databinding.ActivityPlaceDetailBinding

class PlaceDetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityPlaceDetailBinding.inflate(layoutInflater) }

    private lateinit var db: SQLiteDatabase

    private lateinit var place: Place
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val s: String? = intent.getStringExtra("place")
        s?.also {
            place = Gson().fromJson(it, Place::class.java)

            binding.wv.webViewClient = WebViewClient()
            binding.wv.webChromeClient = WebChromeClient()
            binding.wv.settings.javaScriptEnabled = true

            binding.wv.loadUrl(place.place_url)
        }

        db = openOrCreateDatabase("place", MODE_PRIVATE, null)
        db.execSQL("CREATE TABLE IF NOT EXISTS favor(id TEXT PRIMARY KEY,place_name TEXT, category_name TEXT,phone TEXT,address_name TEXT,road_address_name TEXT,x TEXT,y TEXT,place_url TEXT,distance TEXT)")

    }

}