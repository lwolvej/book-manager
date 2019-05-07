package org.nuist.viewmodel

import org.nuist.model.BookModel
import tornadofx.ItemViewModel

class BookViewModel : ItemViewModel<BookModel>() {

    val id = bind(BookModel::idProperty)

    val bookName = bind(BookModel::bookNameProperty)

    val score = bind(BookModel::scoreProperty)

    val like = bind(BookModel::likeProperty)
}