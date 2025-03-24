package com.example.aroundegypt.features.experience.ui.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.aroundegypt.R
import com.example.aroundegypt.common.data.models.Resource
import com.example.aroundegypt.common.ui.BaseFragment
import com.example.aroundegypt.databinding.FragmentExperiencesBinding
import com.example.aroundegypt.features.experience.ui.viewmodel.ExperienceViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ExperiencesFragment :
    BaseFragment<FragmentExperiencesBinding>(FragmentExperiencesBinding::inflate) {
    private val experienceViewModel: ExperienceViewModel by viewModels()
    private val args: ExperiencesFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        experienceViewModel.getExperiences(args.id)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                experienceViewModel.experienceState.collect { state ->
                    when (state) {
                        is Resource.Loading -> {
                            handleProgressBar(state.isLoading, binding.progressBarDetail)
                        }

                        is Resource.Success -> {
                            Glide.with(requireContext()).load(state.model.coverPhoto)
                                .into(binding.ivExperienceDetail)
                            binding.tvNumberOfViewsDetail.text = state.model.viewsNumber.toString()
                            binding.tvTitleDetail.text = state.model.title
                            binding.tvEraDetail.text = state.model.address
                            binding.tvNumberOfLikesDetail.text = state.model.likesNumber.toString()
                            binding.tvDescriptionDetail.text = state.model.detailedDescription
                            binding.ivLike.setOnClickListener {
                                experienceViewModel.likeExperience(state.model.dataId)
                            }
                        }

                        is Resource.Failure -> {
                            Log.d("exception", "onViewCreated: ${state.exception}")
                        }

                    }
                }

            }
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    experienceViewModel.likeExperienceState.collect { state ->
                        when (state) {
                            is Resource.Loading -> {
                                handleProgressBar(state.isLoading, binding.progressBarDetail)
                            }

                            is Resource.Success -> {
                                binding.ivLike.setImageResource(R.drawable.ic_heart)
                            }

                            is Resource.Failure -> {
                                Log.d("exception", "onViewCreated: ${state.exception}")
                            }

                        }
                    }
                }

            }
        }
    }
}