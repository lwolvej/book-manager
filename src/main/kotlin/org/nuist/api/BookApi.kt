package org.nuist.api

import org.nuist.viewmodel.PageViewModel
import org.nuist.viewmodel.UserViewModel
import tornadofx.Controller
import tornadofx.JsonBuilder
import tornadofx.Rest
import tornadofx.toModel

class BookApi : Controller() {

    private val rest: Rest by inject()

    private val userViewModel: UserViewModel by inject()

    private val pageViewModel: PageViewModel by inject()

    fun showAllBooks(
        userId: Int = userViewModel.id.value,
        page: Number? = pageViewModel.nowPage.value,
        size: Int = 6
    ): Boolean {

        val realPage = page ?: 2

        //构造json
        val requestBody = JsonBuilder().apply {
            add("userId", userId)
            add("page", realPage)
            add("size", size)
        }.build()

        rest.post("/book/all", requestBody).use {
            val response = it.one()

            if (response.getInt("code") == 200) {
                pageViewModel.item = response.getJsonObject("data").toModel()
                return true
            }
            return false
        }
    }
}