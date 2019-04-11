package com.mengsoftstudio.android.footballmobile.presenters

import com.mengsoftstudio.android.footballmobile.contracts.MatchContract
import com.mengsoftstudio.android.footballmobile.models.Match
import com.mengsoftstudio.android.footballmobile.models.response.Response
import io.reactivex.Flowable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MatchPresenterTest {

    @Mock
    lateinit var view: MatchContract.View

    @Mock
    lateinit var apiRepositoryImpl: ApiRepositoryImpl

    @InjectMocks
    lateinit var presenter: MatchPresenter

    private val match = mutableListOf<Match>()

    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        presenter = MatchPresenter(view, apiRepositoryImpl)
        Mockito.`when`(apiRepositoryImpl.getEventsNextMatch("4328")).thenReturn(Flowable.just( Response.MatchResponse(match) ))

    }

    @Test
    fun getNextMatch() {
        presenter.getNextMatch("4328")
        Mockito.verify(view).onShowLoading()
        Mockito.verify(view).onSuccessFetchData(match)
        Mockito.verify(view).onHideLoading()
    }

}