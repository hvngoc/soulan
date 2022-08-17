package com.once.soul.presentation.first

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.helper.widget.Carousel
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.once.soul.presentation.R
import com.once.soul.presentation.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    var images = intArrayOf(
        R.drawable.bryce_canyon,
        R.drawable.cathedral_rock,
        R.drawable.death_valley,
        R.drawable.fitzgerald_marine_reserve,
        R.drawable.goldengate,
        R.drawable.golden_gate_bridge,
        R.drawable.shipwreck_1,
        R.drawable.shipwreck_2,
        R.drawable.grand_canyon,
        R.drawable.horseshoe_bend,
        R.drawable.muir_beach,
        R.drawable.rainbow_falls
    )

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentMainBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return images.size
            }

            override fun populate(view: View?, index: Int) {
                val imageView = view as ImageView?
                imageView?.setImageResource(images[index])
            }

            override fun onNewItem(index: Int) {
                Log.i("conheoheoheo", "heo $index")
            }

        })

        binding.nextNext.setOnClickListener {
            val action = MainFragmentDirections.mainToNext()
            findNavController().navigate(action)
        }

        return binding.root
    }
}