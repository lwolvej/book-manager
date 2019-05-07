package org.nuist.api

import org.nuist.viewmodel.UserViewModel
import tornadofx.*
import java.time.LocalDate
import java.time.Period

class UserApi : Controller() {

    private val rest: Rest by inject()

    private val userViewModel: UserViewModel by inject()

    fun login(
        account: String? = userViewModel.account.value,
        password: String? = userViewModel.password.value
    ): Boolean {
        //非空判断
        account ?: return false
        password ?: return false

        //构造json
        val requestBody = JsonBuilder().apply {
            add("account", account)
            add("password", password)
        }.build()

        //做请求
        rest.post("/user/login", requestBody).use {
            val obj = it.one()

            val code = obj.getInt("code")
            if (code == 200) {
                val jsonObject = obj.getJsonObject("data")
                userViewModel.item = JsonBuilder().apply {
                    add("id", jsonObject.getInt("id"))
                    add("account", account)
                    add("password", password)
                    add("realName", jsonObject.getString("realName"))
                    add("age", jsonObject.getInt("age"))
                    add("birthday", jsonObject.getString("birthday"))
                }.build().toModel()
                return true
            }
            return false
        }
    }

    fun changePassword(
        id: Int = userViewModel.id.value,
        oldPassword: String,
        newPassword: String
    ): Boolean {

        //检验旧密码是否正确
        if (oldPassword != userViewModel.password.value) return false

        //输入检验
        if (newPassword.length > 12 || newPassword.length < 5) return false
        if (oldPassword.length > 12 || oldPassword.length < 5) return false

        //构造json
        val requestBody = JsonBuilder().apply {
            add("id", id)
            add("oldPassword", oldPassword)
            add("newPassword", newPassword)
        }.build()

        //做请求
        rest.put("/user", requestBody).use {
            if (it.one().getInt("code") == 200) {
                userViewModel.password.value = newPassword
                return true
            }
            return false
        }
    }

    fun register(
        account: String? = userViewModel.account.value,
        password: String? = userViewModel.password.value,
        realName: String? = userViewModel.realName.value,
        birthday: LocalDate? = userViewModel.birthday.value
    ): Boolean {

        account ?: return false
        password ?: return false
        realName ?: return false
        birthday ?: return false

        //输入检验
        if (account.length > 12 || account.length < 5) return false
        if (password.length > 12 || password.length < 5) return false
        if (realName.length > 5) return false

        //通过生日获取年龄
        val now = LocalDate.now()
        val age = Period.between(birthday, now).years

        //将localDate转换成string
        val birthdayStr = birthday.toString()

        //构造json
        val requestBody = JsonBuilder().apply {
            add("account", account)
            add("password", password)
            add("realName", realName)
            add("birthday", birthdayStr)
            add("age", age)
        }.build()

        //做请求
        rest.post("/user/register", requestBody).use {
            return it.one().getInt("code") == 200
        }
    }
}