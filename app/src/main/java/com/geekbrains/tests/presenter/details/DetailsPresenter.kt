package com.geekbrains.tests.presenter.details

import com.geekbrains.tests.view.ViewContract
import com.geekbrains.tests.view.details.ViewDetailsContract
import com.geekbrains.tests.view.search.ViewSearchContract

internal class DetailsPresenter internal constructor(
    private var viewContract: ViewDetailsContract? = null,
    private var count: Int = 0
) : PresenterDetailsContract {

    override fun onAttach(viewContract: ViewContract) {
        this.viewContract = viewContract as ViewDetailsContract
    }

    override fun onDetach() {
        viewContract = null
    }

    override fun getViewContract(): ViewDetailsContract? = viewContract

    override fun setCounter(count: Int) {
        this.count = count
    }

    override fun onIncrement() {
        count++
        viewContract?.setCount(count)
    }

    override fun onDecrement() {
        count--
        viewContract?.setCount(count)
    }
}
