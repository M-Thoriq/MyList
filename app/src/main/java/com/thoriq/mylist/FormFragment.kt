package com.thoriq.mylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.thoriq.mylist.databinding.FragmentFormBinding


class FormFragment : Fragment() {

    private lateinit var binding : FragmentFormBinding
    private val noteViewModel : NoteViewModel by viewModels{
        ViewModelFactory(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFormBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdd.setOnClickListener {
            val judul = binding.etTitle.text
            val konten = binding.etContent.text
            noteViewModel.addNote(
                Note(0, judul.toString(), konten.toString())
            )
            Navigation.findNavController(binding.root).navigate(R.id.action_formFragment_to_itemFragment3)
        }
    }
}