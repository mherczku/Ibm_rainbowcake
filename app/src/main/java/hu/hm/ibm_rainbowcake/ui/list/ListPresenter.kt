package hu.hm.ibm_rainbowcake.ui.list

import co.zsmb.rainbowcake.withIOContext
import hu.hm.ibm_rainbowcake.interactor.Interactor
import hu.hm.ibm_rainbowcake.data.model.Item
import javax.inject.Inject

class ListPresenter @Inject constructor(
        private val interactor: Interactor
) {

    suspend fun getData(): List<Item> = withIOContext {
        // For testing, get only 10 items with a GET request -->
        // return@withIOContext interactor.getData().subList(0, 10)
        return@withIOContext interactor.getData()
    }
}
