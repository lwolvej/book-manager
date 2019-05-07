package org.nuist.viewmodel

import org.nuist.model.BookDetailModel
import tornadofx.ItemViewModel

class BookDetailViewModel : ItemViewModel<BookDetailModel>() {

    val id = bind(BookDetailModel::idProperty)

    val bookName = bind(BookDetailModel::bookNameProperty)

    val score = bind(BookDetailModel::scoreProperty)

    val like = bind(BookDetailModel::likeProperty)

    val tags = bind(BookDetailModel::tagsProperty)

    val summary = bind(BookDetailModel::summaryProperty)

    val authors = bind(BookDetailModel::authorsProperty)

    val publisher = bind(BookDetailModel::publisherProperty)

    val data = bind(BookDetailModel::dataProperty)
}