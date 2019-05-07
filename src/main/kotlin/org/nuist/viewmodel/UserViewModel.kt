package org.nuist.viewmodel

import org.nuist.model.UserModel
import tornadofx.ItemViewModel

class UserViewModel : ItemViewModel<UserModel>() {

    val id = bind(UserModel::id)

    val account = bind(UserModel::account)

    val password = bind(UserModel::password)

    val realName = bind(UserModel::realName)

    val age = bind(UserModel::age)

    val birthday = bind(UserModel::birthday)
}