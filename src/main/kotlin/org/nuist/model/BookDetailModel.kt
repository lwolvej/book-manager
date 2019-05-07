package org.nuist.model

import javafx.beans.property.*
import javafx.scene.image.Image
import sun.misc.BASE64Decoder
import tornadofx.*
import java.io.ByteArrayInputStream
import javax.json.JsonObject

class BookDetailModel : JsonModel {

    val idProperty = SimpleIntegerProperty()
    var id by idProperty

    val bookNameProperty = SimpleStringProperty()
    var bookName by bookNameProperty

    val scoreProperty = SimpleDoubleProperty()
    var score by scoreProperty

    val likeProperty = SimpleBooleanProperty()
    var like by likeProperty

    val dataProperty = SimpleObjectProperty<Image>()
    var data by dataProperty

    val summaryProperty = SimpleStringProperty()
    var summary by summaryProperty

    val tagsProperty = SimpleStringProperty()
    var tags by tagsProperty

    val publisherProperty = SimpleStringProperty()
    var publisher by publisherProperty

    val authorsProperty = SimpleStringProperty()
    var authors by authorsProperty

    override fun updateModel(json: JsonObject) =
        with(json) {
            id = getInt("id")
            bookName = getString("bookName")

            println(bookName)

            score = getDouble("score")
            like = getBoolean("like")
            data = Image(ByteArrayInputStream(BASE64Decoder().decodeBuffer(getString("data"))))
            summary = getString("summary")
            tags = getString("tags")
            publisher = getString("publisher")
            authors = getString("authors")
        }
}