package com.example.marvelcharacters.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelcharacters.characters.SuperHeroes.SuperHeroe
import com.example.marvelcharacters.databinding.FragmentFirstBinding
import com.example.marvelcharacters.utils.Status

class FirstFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpObserver() {
        mainViewModel.getUsers().observe(viewLifecycleOwner) {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { data ->
                            val adapter = CharactersListAdapter(data, this)
                            binding.recyclerview.adapter = adapter
                            binding.recyclerview.layoutManager =
                                LinearLayoutManager(requireContext())
                        }
                        binding.lottieMainLoading.visibility = View.GONE
                    }
                    Status.ERROR -> {
                        print(it.message)
                        binding.lottieMainLoading.visibility = View.GONE
                    }
                    Status.LOADING -> {
                        binding.lottieMainLoading.visibility = View.VISIBLE
                    }
                }

            }
        }
    }

    override fun onClick(v: View?) {
        val data = v!!.tag as SuperHeroe
        print(data.id)

        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(data.id)
        findNavController().navigate(action)

    }

}