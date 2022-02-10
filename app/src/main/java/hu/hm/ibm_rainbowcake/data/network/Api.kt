package hu.hm.ibm_rainbowcake.data.network

import hu.hm.ibm_rainbowcake.data.model.Playlist
import retrofit2.http.GET


interface Api {

    companion object {
        const val ENDPOINT = "https://android-intern-homework.vercel.app/"
    }

    @GET("/api/")
    suspend fun getData(): Playlist

}