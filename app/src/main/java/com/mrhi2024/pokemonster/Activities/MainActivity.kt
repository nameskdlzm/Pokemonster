package com.mrhi2024.pokemon.Activities

import KakaoSearchPlaceResponse
import Place
import PlaceMeta
import PokemonData
import RealPokemon
import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationRequest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.mrhi2024.pokemon.R
import com.mrhi2024.pokemon.databinding.ActivityMainBinding
import com.mrhi2024.pokemonster.Fragment.PokemonListFragment
import com.mrhi2024.pokemonster.Fragment.PokemonMapFragment
import com.mrhi2024.pokemonster.Fragment.PokemonTypeFragment
import com.mrhi2024.pokemonster.Network.RetrofitService
import com.mrhi2024.tpsearchplacebykakao.network.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    // 포켓몬 프래그먼트
    var pokemonmain: PokemonData? = null

    var realPokemon: RealPokemon? = null

    var myLocation: Location? = null

    var searchPlaceResponse: KakaoSearchPlaceResponse? = null

    val locationProviderClient: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(this)
    }

    val locationCallback = object : LocationCallback() {
        override fun onLocationResult(p0: LocationResult) {
            super.onLocationResult(p0)

            myLocation = p0.lastLocation

            locationProviderClient.removeLocationUpdates(this)

            searchPlaces()

        }
    }



    var searchQuery: String = "화장실"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.container_fragment, PokemonListFragment())
            .commit()

        binding.bnv.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.menu_bnv_main -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment, PokemonListFragment()).commit()

                R.id.menu_bnv_map -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment, PokemonMapFragment()).commit()

                R.id.menu_bnv_type -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment, PokemonTypeFragment()).commit()


            }
            true
        }
        pokemon()

        val permissionState:Int = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
        if (permissionState == PackageManager.PERMISSION_DENIED){
            permissionResultLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }else{
            requestMyLocation()
        }

    }

    private fun pokemon() {
//        Toast.makeText(this, "aaa", Toast.LENGTH_SHORT).show()
        val s = binding.etSearch.text.toString()

        val retrofit = RetrofitHelper.getRetrofitInstance("https://raw.githubusercontent.com")
        val retrofitSevice = retrofit.create(RetrofitService::class.java)
        val call = retrofitSevice.pokemonSearch()

        call.enqueue(object : Callback<RealPokemon> {
            override fun onResponse(call: Call<RealPokemon>, response: Response<RealPokemon>) {
                realPokemon = response.body()
            }

            override fun onFailure(call: Call<RealPokemon>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun searchPlaces() {
        Toast.makeText(
            this,
            "$searchQuery\n${myLocation?.latitude},${myLocation?.longitude}",
            Toast.LENGTH_SHORT
        ).show()

        val retrofit = RetrofitHelper.getRetrofitInstance("https://dapi.kakao.com")
        val retrofitService = retrofit.create(RetrofitService::class.java)
        val call = retrofitService.searchPlace(
            searchQuery,
            myLocation?.longitude.toString(),
            myLocation?.latitude.toString()
        )
        call.enqueue(object : Callback<KakaoSearchPlaceResponse> {
            override fun onResponse(
                call: Call<KakaoSearchPlaceResponse>,
                response: Response<KakaoSearchPlaceResponse>
            ) {
                searchPlaceResponse = response.body()

                val meta: PlaceMeta? = searchPlaceResponse?.meta
                val documents: List<Place>? = searchPlaceResponse?.documents


                binding.bnv.selectedItemId = R.id.menu_bnv_main

            }

            override fun onFailure(call: Call<KakaoSearchPlaceResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })

        fun requestMyLocation() {
            val request: com.google.android.gms.location.LocationRequest =
                com.google.android.gms.location.LocationRequest.Builder(
                    Priority.PRIORITY_HIGH_ACCURACY,
                    3000
                ).build()

            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                )
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {

                return
            }
            locationProviderClient.requestLocationUpdates(
                request,
                locationCallback,
                Looper.getMainLooper()
            )
        }



    }

    val permissionResultLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) requestMyLocation()
            else Toast.makeText(this, "내 위치정보를 제공하지 않아 검색기능 사용이 제한됩니다.", Toast.LENGTH_SHORT)
                .show()
        }

    private fun requestMyLocation(){

        // 요청 객체 생성
        val request: com.google.android.gms.location.LocationRequest = com.google.android.gms.location.LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY,3000).build()

        // 실시간 위치정보 갱신 요청 - 퍼미션 체크코드가 있어야만 함.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            return
        }
        locationProviderClient.requestLocationUpdates(request,locationCallback,Looper.getMainLooper())
    }


}
