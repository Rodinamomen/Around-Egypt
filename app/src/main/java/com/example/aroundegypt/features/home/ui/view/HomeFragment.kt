package com.example.aroundegypt.features.home.ui.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aroundegypt.common.data.models.Resource
import com.example.aroundegypt.common.ui.BaseFragment
import com.example.aroundegypt.databinding.FragmentHomeBinding
import com.example.aroundegypt.features.home.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var recommendedAdapter: RecommendedAdapter
    private var lastLikedItemId: String? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getExperiences()
        viewModel.getRecommendedExperiences()

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.experienceState.collect { state ->
                    when (state) {
                        is Resource.Loading -> if (state.isLoading) {
                            Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                        }

                        is Resource.Success -> {
                            recommendedAdapter =
                                RecommendedAdapter(state.model.data, requireContext(), false)
                            binding.rvMostRecent.layoutManager = LinearLayoutManager(
                                requireContext(),
                                LinearLayoutManager.VERTICAL,
                                false
                            )
                            binding.rvMostRecent.adapter = recommendedAdapter

                            recommendedAdapter.setOnClickListener(object :
                                RecommendedAdapter.OnItemClickListener {
                                override fun onItemClicked(id: String) {
                                    lastLikedItemId = id
                                    viewModel.likeExperience(id)
                                }
                            })
                        }

                        is Resource.Failure ->
                            Toast.makeText(
                                requireContext(),
                                "${state.exception}",
                                Toast.LENGTH_SHORT
                            ).show()

                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.recommendExperienceState.collect { state ->
                    when (state) {
                        is Resource.Loading -> if (state.isLoading) {
                            Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                        }

                        is Resource.Success -> {
                            recommendedAdapter =
                                RecommendedAdapter(state.model.data, requireContext(), true)
                            binding.rvRecommended.layoutManager = LinearLayoutManager(
                                requireContext(),
                                LinearLayoutManager.HORIZONTAL,
                                false
                            )
                            binding.rvRecommended.adapter = recommendedAdapter
                            recommendedAdapter.setOnClickListener(object :
                                RecommendedAdapter.OnItemClickListener {
                                override fun onItemClicked(id: String) {
                                    viewModel.likeExperience(id)

                                }
                            })
                        }

                        is Resource.Failure ->
                            Toast.makeText(
                                requireContext(),
                                "${state.exception}",
                                Toast.LENGTH_SHORT
                            ).show()

                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.likeExperienceState.collect { state ->
                when (state) {
                    is Resource.Loading -> if (state.isLoading) {
                        Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                    }

                    is Resource.Success -> {
                        lastLikedItemId?.let { id ->
                            val newLikesCount = state.model
                            recommendedAdapter.updateLikedItem(id, state.model.numberOfLikes)
                        }
                    }

                    is Resource.Failure ->
                        Log.d("likess", "onViewCreated:${state.exception} ")

                }
            }
        }
    }
}