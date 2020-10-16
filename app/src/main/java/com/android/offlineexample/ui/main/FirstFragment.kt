package com.android.offlineexample.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.offlineexample.R
import com.android.offlineexample.data.model.User
import com.android.offlineexample.databinding.FragmentFirstBinding
import com.android.offlineexample.ui.main.adapter.MainAdapter
import com.android.offlineexample.ui.main.viewmodel.MainViewModel
import com.android.offlineexample.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : Fragment(R.layout.fragment_first) {
    private val mainViewModel by activityViewModels<MainViewModel>()
    //private val mainViewModel: MainViewModel by viewModels()
    private var mBinding: FragmentFirstBinding? = null
    private lateinit var adapter: MainAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFirstBinding.bind(view)
        mBinding = binding
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUi()
        setupObserver()
    }

    private fun goToUserDetail(view: View, userId: String){

    }

    private fun setupUi() {
        adapter = MainAdapter(::goToUserDetail)
        this.let { it ->
            mBinding!!.apply {
                mBinding!!.recyclerView.adapter = adapter
                viewModel = it.mainViewModel
                mBinding!!.recyclerView.layoutManager = LinearLayoutManager(requireContext())
                mBinding!!.recyclerView.addItemDecoration(
                    DividerItemDecoration(
                        mBinding!!.recyclerView.context,
                        (mBinding!!.recyclerView.layoutManager as LinearLayoutManager).orientation
                    )
                )
            }
        }
    }

    private fun setupObserver() {
        mainViewModel.users.observe(viewLifecycleOwner, Observer { status ->
            when (status) {
                is Status.Loading -> {
                    displayView(true, mBinding!!.progressBar)
                }
                is Status.Error -> {
                    displayError(status.exception.message)
                    displayView(true, mBinding!!.warning)
                }
                is Status.Success -> {
                    renderList(status.data)
                    displayView(true, mBinding!!.recyclerView)
                }
            }
        })
    }
    private fun displayError(message: String?){
        if(message != null) mBinding!!.warning.text = message else mBinding!!.warning.text = "Unknown error."
    }

    private fun displayView(isDisplayed: Boolean, view: View){
        view.visibility = if(isDisplayed) View.VISIBLE else View.GONE
    }

    private fun renderList(users: List<User>) {
        adapter.updateUsers(users)
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        // Consider not storing the binding instance in a field
        // if not needed.
        mBinding = null
        super.onDestroyView()
    }
}