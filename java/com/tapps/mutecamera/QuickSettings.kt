package com.tapps.mutecamera

import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import android.util.Log

class QuickSetting : TileService() {

    private val debug = false
    private val tag = "QuickSetting"

    override fun onClick() {
        val tile = qsTile
        when (tile.state) {
            Tile.STATE_ACTIVE -> active()
            Tile.STATE_INACTIVE -> inactive()
        }
        tile.updateTile()
    }

    override fun onStartListening() {
        log("onStartListening is called")
        changeState()
    }

    override fun onStopListening() {
        log("onStopListening is called")
    }

    override fun onTileAdded() {
        log("onTileAdded is called")
    }

    override fun onTileRemoved() {
        log("onTileRemoved is called")
    }

    private fun changeState() {
        qsTile.state = when (MuteTask().check(this)) {
            true -> Tile.STATE_ACTIVE
            false -> Tile.STATE_INACTIVE
        }
    }

    private fun active() {
        qsTile.state = Tile.STATE_INACTIVE
        MuteTask().runMute(this, false)
    }

    private fun inactive() {
        qsTile.state = Tile.STATE_ACTIVE
        MuteTask().runMute(this, true)
    }

    private fun log(text: String) {
        if (debug) Log.d(tag, text)
    }
}