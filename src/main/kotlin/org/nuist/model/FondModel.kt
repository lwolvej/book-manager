package org.nuist.model

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.JsonModel
import tornadofx.getDouble
import tornadofx.getValue
import tornadofx.setValue
import javax.json.JsonObject

class FondModel : JsonModel {
    val idProperty = SimpleIntegerProperty()
    var id by idProperty

    val bookIdProperty = SimpleIntegerProperty()
    var bookId by bookIdProperty

    val bookNameProperty = SimpleStringProperty()
    var bookName:String by bookNameProperty

    val scoreProperty = SimpleDoubleProperty()
    var score by scoreProperty

    override fun updateModel(json: JsonObject) =
        with(json) {
            id = getInt("id")
            bookId = getInt("bookId")
            bookName = getString("bookName")
            score = getDouble("score")
        }
}