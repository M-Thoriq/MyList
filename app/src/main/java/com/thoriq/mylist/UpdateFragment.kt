package com.thoriq.mylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.thoriq.mylist.databinding.FragmentUpdateBinding


class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    private val args by navArgs<UpdateFragmentArgs>()
    private val noteViewModel: NoteViewModel by viewModels {
        ViewModelFactory(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUpdateBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etUptitle.setText(args.currentnote.title)
        binding.etUpcontent.setText(args.currentnote.content)
        val currentNoteId = args.currentnote.id
        binding.btnUpdate.setOnClickListener {
            noteViewModel.updateNote(Note(
                currentNoteId,
                binding.etUptitle.text.toString(),
                binding.etUpcontent.text.toString()
            ))
            Navigation.findNavController(binding.root).navigate(R.id.action_updateFragment_to_itemFragment3)
        }
        binding.btnDelete.setOnClickListener {
            noteViewModel.deleteNote(Note(
                currentNoteId,
                args.currentnote.title,
                args.currentnote.content
            ))
            Navigation.findNavController(binding.root).navigate(R.id.action_updateFragment_to_itemFragment3)
        }
    }
}