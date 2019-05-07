package org.nuist.model

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.JsonModel
import tornadofx.getDouble
import tornadofx.getValue
import tornadofx.setValue
import javax.json.JsonObject

class BookModel : JsonModel {

    val idProperty = SimpleIntegerProperty()
    var id by idProperty

    val bookNameProperty = SimpleStringProperty()
    var bookName by bookNameProperty

    val scoreProperty = SimpleDoubleProperty()
    var score by scoreProperty

    val likeProperty = SimpleBooleanProperty()
    var like by likeProperty

    override fun updateModel(json: JsonObject) =
        with(json) {
            id = getInt("id")
            bookName = getString("bookName")
            score = getDouble("score")
            like = getBoolean("like")
        }
}