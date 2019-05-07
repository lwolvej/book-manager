package org.nuist.viewmodel

import org.nuist.model.FondModel
import tornadofx.ItemViewModel

class FondViewModel : ItemViewModel<FondModel>() {

    val id = bind(FondModel::idProperty)

    val bookId = bind(FondModel::bookIdProperty)

    val bookName = bind(FondModel::bookNameProperty)

    val score = bind(FondModel::scoreProperty)
}