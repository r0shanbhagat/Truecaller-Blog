package com.truecaller.truecallerblog.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.truecaller.truecallerblog.R
import com.truecaller.truecallerblog.core.BaseFragment
import com.truecaller.truecallerblog.data.model.BlogModel
import com.truecaller.truecallerblog.databinding.FragmentBlogParseBinding
import com.truecaller.truecallerblog.ui.viewmodel.BlogParseEvent
import com.truecaller.truecallerblog.ui.viewmodel.BlogParseViewModel
import com.truecaller.truecallerblog.utils.DataState
import com.truecaller.truecallerblog.utils.logException
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Details BlogParseFragment:Main fragment where user interact with UI :
 *  1. Fetch the Blog
 *  2.Populate the data on UI
 * @Author Roshan Bhagat
 * @constructor
 */
@AndroidEntryPoint
class BlogParseFragment : BaseFragment<FragmentBlogParseBinding, BlogParseViewModel>() {
    private val blogParseViewModel: BlogParseViewModel by viewModels()

    override val layoutId: Int = R.layout.fragment_blog_parse

    override val viewModel: BlogParseViewModel
        get() = blogParseViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        binding.blogFragment = this
        binding.model = BlogModel()
        subscribeObservers()
    }

    /**
     * Fetch blog content
     *
     */
    fun fetchBlogContent() {
        binding.model?.blogContent = getString(R.string.empty_value)
        /*
         * MVI approach provides more flexibility to perform multiple operation/intent from same state .
         * This way we can remove number of boilerplate code from our repo and easily achieve the asynchronous Programming
         */
        viewModel.setStateIntent(BlogParseEvent.GetBlogContent)
    }

    /*
    * subscribeObservers is an Observers function for mutable live data
    */
    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner) { dataState ->
            when (dataState) {
                is DataState.Loading -> {
                    showLoading(true)
                }
                is DataState.Success -> {
                    hideLoading()
                    dataState.data?.let {
                        updateResponse(it.toString())
                    }
                }
                is DataState.Error -> {
                    hideLoading()
                    logException(dataState.exception)
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.no_data_found),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    /**
     * updateResponse accepts the response string and update the text into UI View.
     */
    private fun updateResponse(response: String) {
        val blogModel = binding.model
        blogModel?.blogContent =
            blogModel?.blogContent.plus("\n").plus(response)
    }


}


