package com.example.todolist.ui.task

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todolist.R
import com.example.todolist.databinding.FragmentTaskBinding


class TaskFragment : Fragment() {

    var thiscontext: Context? = null

    // https://dev.to/vtsen/recommended-ways-to-create-viewmodel-or-androidviewmodel-5e7k
    private  var viewModel =  TaskViewModel(getActivity().getApplicationContext() as Application)


    private lateinit var mAdapter: TaskAdapter


    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        thiscontext = container?.context

        viewModel = TaskViewModel(thiscontext)

        val binding = FragmentTaskBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        mAdapter = TaskAdapter(TaskClickListener { taskEntry ->
            findNavController().navigate(TaskFragmentDirections.actionTaskFragmentToUpdateFragment(taskEntry))
        })


        viewModel.getAllTasks.observe(viewLifecycleOwner){
            mAdapter.submitList(it)
        }


        binding?.apply {

            recyclerView.adapter = mAdapter

            // findNavController().navigate(R.id.action_taskFragment_to_addFragment)
            floatingActionButton.setOnClickListener {
                findNavController().navigate(R.id.action_taskFragment_to_addFragment)
            }
        }


        return binding.root
    }

}