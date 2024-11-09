package com.thoriq.mylist

import android.content.ClipData.Item
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.thoriq.mylist.databinding.FragmentItemListBinding
import java.util.Objects

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() {

    private lateinit var binding: FragmentItemListBinding
    private val noteViewModel: NoteViewModel by viewModels {
        ViewModelFactory(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentItemListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvNotes.layoutManager = LinearLayoutManager(requireContext())
        var adapter: ItemAdapter
        noteViewModel.getAllNotes().observe(requireActivity()) {
            adapter = ItemAdapter(it)
            binding.rvNotes.adapter = ItemAdapter(it)
        }

        binding.fabAdd.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_itemFragment3_to_formFragment)
        }
    }

    private fun onSelectedItem(item: Note) {
        Log.d("DEBUG", "onSelectedItem: Harusnya ini muncul")
        noteViewModel.deleteNote(item)
    }

}