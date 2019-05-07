package org.nuist.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.JsonModel
import tornadofx.getValue
import tornadofx.setValue
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.json.JsonObject

class UserModel : JsonModel {

    val idProperty = SimpleIntegerProperty()
    var id by idProperty

    val realNameProperty = SimpleStringProperty()
    var realName: String? by realNameProperty

    val ageProperty = SimpleIntegerProperty()
    var age by ageProperty

    val birthdayProperty = SimpleObjectProperty<LocalDate>()
    var birthday: LocalDate? by birthdayProperty

    val accountProperty = SimpleStringProperty()
    var account: String? by accountProperty

    val passwordProperty = SimpleStringProperty()
    var password: String? by passwordProperty

    override fun updateModel(json: JsonObject) =
        with(json) {
            id = getInt("id")
            realName = getString("realName")
            account = getString("account")
            password = getString("password")
            age = getInt("age")
            val birStr = getString("birthday").trim()
            birthday = LocalDate.parse(birStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        }
}
