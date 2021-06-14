package com.geekbrains.tests

import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.view.details.ViewDetailsContract
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class DetailsPresenterTest {
    private lateinit var presenter: DetailsPresenter

    private var count: Int = 0

    @Mock
    private lateinit var viewContract: ViewDetailsContract

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailsPresenter()
        presenter.onAttach(viewContract)
    }

    @Test
    fun onAttachView_Test(){
        assertNotNull(presenter.getViewContract())
    }

    @Test
    fun onDetachView_Test(){
        presenter.onDetach()
        assertNull(presenter.getViewContract())
    }

    @Test
    fun setCounter_Test(){
        assertNotNull(presenter.setCounter(count))
    }

    @Test
    fun onIncrement_Test(){
        presenter.onIncrement()
        verify(viewContract, times(1)).setCount(anyInt())
    }

    @Test
    fun onDecrement_Test(){
        presenter.onDecrement()
        verify(viewContract, times(1)).setCount(anyInt())
    }
}