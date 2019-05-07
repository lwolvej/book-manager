package org.nuist.api

import org.nuist.viewmodel.BookDetailViewModel
import org.nuist.viewmodel.UserViewModel
import tornadofx.Controller
import tornadofx.JsonBuilder
import tornadofx.Rest
import tornadofx.toModel

class BookDetailApi : Controller() {

    private val rest: Rest by inject()

    private val userViewModel: UserViewModel by inject()

    private val bookDetailViewModel: BookDetailViewModel by inject()

    fun showOneBook(
        userId: Number = userViewModel.id.value,
        bookId: Number
    ): Boolean {

        //构造json
        val requestBody = JsonBuilder().apply {
            add("bookId", bookId)
            add("userId", userId)
        }.build()

        // 做请求
        rest.get("/book/one", requestBody).use {
            val response = it.one()

            val code = response.getInt("code")

            if (code == 200) {
                bookDetailViewModel.item = response.getJsonObject("data").toModel()
            }
            return false
        }
    }
}