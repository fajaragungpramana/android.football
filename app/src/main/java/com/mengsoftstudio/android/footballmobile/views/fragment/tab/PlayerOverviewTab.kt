package com.mengsoftstudio.android.footballmobile.views.fragment.tab

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mengsoftstudio.android.footballmobile.R
import com.mengsoftstudio.android.footballmobile.contracts.PlayerContract
import com.mengsoftstudio.android.footballmobile.extensions.gone
import com.mengsoftstudio.android.footballmobile.extensions.visible
import com.mengsoftstudio.android.footballmobile.models.Player
import com.mengsoftstudio.android.footballmobile.presenters.PlayerPresenter
import com.mengsoftstudio.android.footballmobile.views.activity.TeamDetailActivity
import com.mengsoftstudio.android.footballmobile.views.adapter.PlayerAdapter
import com.mengsoftstudio.android.footballmobile.views.base.BaseFragment
import io.reactivex.plugins.RxJavaPlugins
import kotlinx.android.synthetic.main.tab_overview_player.view.*
import javax.inject.Inject

class PlayerOverviewTab : BaseFragment(), PlayerContract.View {

    private lateinit var ui: View

    @Inject
    lateinit var presenter: PlayerPresenter

    override fun onFragmentCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ui = inflater.inflate(R.layout.tab_overview_player, container, false)

        RxJavaPlugins.setErrorHandler {}

        val teamDetailActivity = activity as TeamDetailActivity

        presenter.getTeamPlayer( teamDetailActivity.getTeam().idTeam!! )

        return ui
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDestroyPresenter()

    }

    override fun onShowLoading() {
        ui.pb_player.visible()
        ui.rv_player.gone()
        ui.include_no_connection.gone()
    }

    override fun onSuccessFetchData(playerList: List<Player>) {
        ui.rv_player.layoutManager = GridLayoutManager(activity, 2)
        ui.rv_player.adapter = PlayerAdapter(activity!!, playerList)
    }

    override fun onFailureFetchData() {
        ui.pb_player.gone()
        ui.rv_player.gone()
        ui.include_no_connection.visible()
    }

    override fun onHideLoading() {
        ui.pb_player.gone()
        ui.rv_player.visible()
        ui.include_no_connection.gone()
    }

}