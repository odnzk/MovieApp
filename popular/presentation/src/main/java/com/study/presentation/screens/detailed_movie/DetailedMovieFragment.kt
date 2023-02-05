package com.study.presentation.screens.detailed_movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.study.common.State
import com.study.domain.model.DetailedMovie
import com.study.presentation.databinding.FragmentDetailedMovieBinding
import com.study.presentation.util.CanChangeToolbarStyle
import com.study.ui.databinding.StateLoadingBinding
import com.study.ui.errorOccurred
import com.study.ui.loadImage
import com.study.ui.loadingFinished
import com.study.ui.loadingStarted
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
internal class DetailedMovieFragment : Fragment(), CanChangeToolbarStyle {
    private var _binding: FragmentDetailedMovieBinding? = null
    private val binding: FragmentDetailedMovieBinding get() = _binding!!

    private var _loadingBinding: StateLoadingBinding? = null
    private val loadingBinding: StateLoadingBinding get() = _loadingBinding!!

    private val viewModel by viewModels<DetailedMovieViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeMovie()
    }

    private fun observeMovie() = lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.movie.collectLatest { state ->
                when (state) {
                    is State.Error -> state.error?.let {
                        loadingBinding.errorOccurred(it) {
                            viewModel.onEvent(DetailedMovieEvent.TryAgain)
                        }
                    }
                    is State.Loading -> loadingBinding.loadingStarted()
                    is State.Success -> {
                        loadingBinding.loadingFinished()
                        state.data?.let { displayMovie(it) }
                    }
                }
            }
        }
    }

    private fun displayMovie(movie: DetailedMovie) {
        with(binding) {
            tvTitle.text = movie.title
            tvDescription.text = movie.description
            tvCountries.text = movie.countries.joinToString(separator = ", ")
            tvGenres.text = movie.genres.joinToString(separator = ", ")
            ivMovieImage.loadImage(movie.imageUrl)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailedMovieBinding.inflate(inflater, container, false)
        _loadingBinding = StateLoadingBinding.bind(binding.root)

        changeToolbarStyle()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _loadingBinding = null
        _binding = null
        returnToolbarStyle()
    }

    override fun changeToolbarStyle() {
        (activity as? AppCompatActivity)?.supportActionBar?.hide()
    }

    override fun returnToolbarStyle() {
        (activity as? AppCompatActivity)?.supportActionBar?.hide()
    }
}
