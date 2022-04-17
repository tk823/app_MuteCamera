package com.tapps.mutecamera

import android.content.Context
import android.media.AudioManager
import android.service.quicksettings.TileService

class MuteTask {
    fun runMute(context: Context, enable: Boolean) {
        val audioManager = context.getSystemService(TileService.AUDIO_SERVICE) as AudioManager
        audioManager.setMasterMute(enable, 0)
    }

    fun check(context: Context): Boolean {
        val audioManager = context.getSystemService(TileService.AUDIO_SERVICE) as AudioManager
        return audioManager.isMasterMute()
    }
}