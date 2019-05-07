package org.nuist.api

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import org.nuist.model.FondModel
import org.nuist.viewmodel.BookDetailViewModel
import org.nuist.viewmodel.UserViewModel
import tornadofx.Controller
import tornadofx.JsonBuilder
import tornadofx.Rest
import tornadofx.toModel

class FondApi : Controller() {

    private val rest: Rest by inject()

    private val userViewModel: UserViewModel by inject()

    private val selectBookDetailViewModel: BookDetailViewModel by inject()

    fun showAllFond(
        userId: Int = userViewModel.id.value
    ): ObservableList<FondModel> {

        //构造json
        val requestBody = JsonBuilder()
            .add("userId", userId)
            .build()

        rest.post("/fond/show", requestBody).use {

            val response = it.one()
            if (response.getInt("code") == 200) {
                return response.getJsonArray("data").toModel()
            }
            return FXCollections.observableArrayList()
        }
    }

    fun addFond(
        bookId: Number = selectBookDetailViewModel.id.value,
        userId: Number = userViewModel.id.value
    ): Boolean {

        val requestBody = JsonBuilder().apply {
            add("bookId", bookId)
            add("userId", userId)
        }.build()

        rest.post("/fond/add", requestBody).use {
            return it.one().getInt("code") == 200
        }
    }

    fun removeFond(
        fondId: Number
    ): Boolean {
        val requestBody = JsonBuilder()
            .add("id", fondId)
            .build()

        rest.delete("/fond", requestBody).use {
            return it.one().getInt("code") == 200
        }
    }
}