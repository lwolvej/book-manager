package org.nuist.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleListProperty
import tornadofx.getValue
import tornadofx.setValue
import tornadofx.JsonModel
import tornadofx.toModel
import javax.json.JsonObject

class PageModel : JsonModel {

    val nowPageProperty = SimpleIntegerProperty()
    val allPageProperty = SimpleIntegerProperty()
    val bookModelListProperty = SimpleListProperty<BookModel>()

    var nowPage: Int? by nowPageProperty
    var allPage by allPageProperty
    var bookModelList by bookModelListProperty

    override fun updateModel(json: JsonObject) =
        with(json) {
            nowPage = getInt("nowPage")
            allPage = getInt("allPage")
            bookModelList = getJsonArray("data").toModel<BookModel>()
        }
}