package org.nuist.viewmodel

import org.nuist.model.PageModel
import tornadofx.ItemViewModel

class PageViewModel : ItemViewModel<PageModel>() {

    val nowPage = bind(PageModel::nowPageProperty)

    val allPage = bind(PageModel::allPageProperty)

    val bookModelList = bind(PageModel::bookModelListProperty)
}