package com.example.interviewexercise.views.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.interviewexercise.data.Movie
import com.example.interviewexercise.databinding.FragmentGalleryBinding
import com.example.interviewexercise.networking.common.Status
import com.example.interviewexercise.repository.MovieRepository
import com.example.interviewexercise.views.util.showSnackbar

class GalleryFragment : Fragment() {

    companion object {
        fun newInstance() = GalleryFragment()
    }

    private val viewModel = GalleryViewModel(MovieRepository())
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    private val adapter = MovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupViewModel()
    }

    private fun setupView() {
        with(binding){
            adapter.onMovieSelected = ::showTitle
            list.adapter = adapter
        }
    }

    private fun showTitle(movie: Movie) {
        movie.title?.let { binding.root.showSnackbar(it) }
    }

    private fun setupViewModel() {
        viewModel.moviesLiveData.observe(viewLifecycleOwner){
            when (it.status){
                Status.SUCCESS->{
                    binding.progressBar.visibility = View.GONE
                    it.data?.results?.let { movies -> adapter.setItems(movies) }
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    it.message?.let { msg-> binding.root.showSnackbar(msg) }
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
        viewModel.getMovies()
    }
}
