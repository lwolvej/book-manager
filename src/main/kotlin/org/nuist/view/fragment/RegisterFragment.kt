package org.nuist.view.fragment

import animatefx.animation.Swing
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.layout.StackPane
import org.nuist.api.UserApi
import org.nuist.view.controls.*
import org.nuist.view.styles.RegisterFragmentStyle
import org.nuist.view.styles.RegisterFragmentStyle.Companion.crossIcon
import org.nuist.view.styles.RegisterFragmentStyle.Companion.errorMessage
import org.nuist.view.styles.RegisterFragmentStyle.Companion.jfxDatePicker
import org.nuist.view.styles.RegisterFragmentStyle.Companion.registerButtonStyle
import org.nuist.view.styles.RegisterFragmentStyle.Companion.registerPaneStyle
import org.nuist.view.styles.RegisterFragmentStyle.Companion.small
import org.nuist.viewmodel.UserViewModel
import tornadofx.*

class RegisterFragment : Fragment("注册") {

    private val userApi: UserApi by inject()

    private val userViewModel: UserViewModel by inject()

    private val messageWrapper by cssid()

    override val root = vbox {

        addClass(registerPaneStyle)

        stackpane().setId(messageWrapper)

        form {
            fieldset {
                field("账户") {
                    icon(MaterialDesignIcon.ACCOUNT_PLUS)
                    jfxtextfield(userViewModel.account) {
                        onMouseClickedProperty().value = EventHandler {
                            Swing().apply {
                                node = this@field.label
                                setSpeed(2.0)
                            }.play()
                        }
                    }
                }
                field("密码") {
                    icon(MaterialDesignIcon.SECURITY)
                    jfxpasswordfield(userViewModel.password) {
                        onMouseClickedProperty().value = EventHandler {
                            Swing().apply {
                                node = this@field.label
                                setSpeed(2.0)
                            }.play()
                        }
                    }
                }
                field("真实姓名") {
                    icon(MaterialDesignIcon.RENAME_BOX)
                    jfxtextfield(userViewModel.realName) {
                        onMouseClickedProperty().value = EventHandler {
                            Swing().apply {
                                node = this@field.label
                                setSpeed(2.0)
                            }.play()
                        }
                    }
                }
                field("生日") {
                    icon(MaterialDesignIcon.CAKE_VARIANT)
                    jfxdatepicker(userViewModel.birthday) {
                        addClass(jfxDatePicker)
                        onMouseClickedProperty().value = EventHandler {
                            Swing().apply {
                                node = this@field.label
                                setSpeed(2.0)
                            }.play()
                        }
                    }
                }
            }
            buttonbar {
                jfxbutton("注册") {
                    addClass(registerButtonStyle)
                    icon(MaterialDesignIcon.FLASH, "14px")
                    action {
                        register()
                    }
                }
            }
        }
    }

    private fun Button.register() {
        fun signalSigningIn() {
            properties["originalText"] = text
            text = "加载中..."
            opacity = 0.5
        }

        fun signalComplete() {
            text = properties["originalText"] as String
            opacity = 1.0
        }

        if (userViewModel.commit()) {
            signalSigningIn()

            runAsync {
                Thread.sleep(1000L)
                userApi.register()
            } ui { success ->
                signalComplete()
                if (success) {
                    println("success")
                } else {
                    registerFailed()
                }
            }
        }
    }

    private fun registerFailed() {
        root.select<StackPane>(messageWrapper).replaceChildren {
            hbox {
                addClass(errorMessage)
                label("注册失败，检查你填写的信息！")
                spacer()
                button {
                    addClass(crossIcon, RegisterFragmentStyle.icon, small)
                    action {
                        this@hbox.removeFromParent()
                    }
                }
            }
        }
    }
}