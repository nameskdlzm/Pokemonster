package com.mrhi2024.pokemonster.Fragment

import Place
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.camera.CameraUpdate
import com.kakao.vectormap.camera.CameraUpdateFactory
import com.kakao.vectormap.label.LabelLayer
import com.kakao.vectormap.label.LabelOptions
import com.kakao.vectormap.mapwidget.InfoWindowOptions
import com.kakao.vectormap.mapwidget.component.GuiLayout
import com.kakao.vectormap.mapwidget.component.GuiText
import com.kakao.vectormap.mapwidget.component.Orientation
import com.mrhi2024.pokemon.Activities.MainActivity
import com.mrhi2024.pokemon.R
import com.mrhi2024.pokemon.databinding.FragmentMapBinding
import com.mrhi2024.pokemon.databinding.FragmentPokemonBinding
import com.mrhi2024.pokemonster.Activities.PlaceDetailActivity

class PokemonMapFragment : Fragment() {

    private val binding: FragmentMapBinding by lazy { FragmentMapBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mapView.start(mapReadyCallback)
    }

    private val mapReadyCallback: KakaoMapReadyCallback = object : KakaoMapReadyCallback() {
        override fun onMapReady(kakaoMap: KakaoMap) {
            val latitude: Double = (activity as MainActivity).myLocation?.latitude ?: 37.566
            val longitude: Double = (activity as MainActivity).myLocation?.longitude ?: 16.9782
            val myPos: LatLng = LatLng.from(latitude, longitude)

            // 카메라이동
            val cameraUpdate: CameraUpdate = CameraUpdateFactory.newCenterPosition(myPos, 16)
            kakaoMap.moveCamera(cameraUpdate)

            // 위치 마커
            val labeloptions: LabelOptions =
                LabelOptions.from(myPos).setStyles(R.drawable.mymylocation)

            val labellayer: LabelLayer = kakaoMap.labelManager!!.layer!!

            labellayer.addLabel(labeloptions)

            val place: List<Place>? = (activity as MainActivity).searchPlaceResponse?.documents
            place?.forEach {
                val pos = LatLng.from(it.y.toDouble(), it.x.toDouble())
                val options = LabelOptions.from(pos).setStyles(R.drawable.location)
                    .setTexts(it.place_name, "${it.distance}m").setTag(it)
                kakaoMap.labelManager!!.layer!!.addLabel(options)
            }

            kakaoMap.setOnLabelClickListener { kakaoMap, layer, label ->
                label.apply {
                    val layout = GuiLayout(Orientation.Vertical)
                    layout.setPadding(16, 16, 16, 16)
                    layout.setBackground(R.drawable.base_msg, true)

                    this.texts.forEach {
                        val guiText = GuiText(it)
                        guiText.setTextSize(30)
                        guiText.setTextColor(Color.WHITE)
                        layout.addView(guiText)
                    }

                    val options = InfoWindowOptions.from(position)
                    options.body = layout
                    options.setBodyOffset(0f, -10f)
                    options.setTag(tag)

                    kakaoMap.mapWidgetManager!!.infoWindowLayer.removeAll()
                    kakaoMap.mapWidgetManager!!.infoWindowLayer.addInfoWindow(options)

                }
            }

            kakaoMap.setOnInfoWindowClickListener { kakaoMap, infoWindow, guiId ->
                val intent = Intent(requireContext(), PlaceDetailActivity::class.java)

                val place = infoWindow.tag as Place
                val json: String = Gson().toJson(place)
                intent.putExtra("place", json)

                startActivity(intent)
            }

        }

    }
}