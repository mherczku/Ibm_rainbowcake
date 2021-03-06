package hu.hm.ibm_rainbowcake.interactor

import hu.hm.ibm_rainbowcake.data.model.Item
import hu.hm.ibm_rainbowcake.data.network.Api
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Interactor @Inject constructor(private val api: Api){

    suspend fun getData(): List<Item> {
        Timber.d("Downloading data")
        val a = api.getData()
        Timber.d("Received ${a.playlist.size} items")
        return a.playlist
    }
}