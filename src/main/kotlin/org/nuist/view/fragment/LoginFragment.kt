package org.nuist.view.fragment

import animatefx.animation.RubberBand
import com.jfoenix.controls.JFXPasswordField
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.layout.StackPane
import org.nuist.api.UserApi
import org.nuist.view.DashboardView
import org.nuist.view.controls.*
import org.nuist.view.styles.LoginFragmentStyle
import org.nuist.view.styles.LoginFragmentStyle.Companion.crossIcon
import org.nuist.view.styles.LoginFragmentStyle.Companion.errorMessage
import org.nuist.view.styles.LoginFragmentStyle.Companion.loginPaneStyle
import org.nuist.view.styles.LoginFragmentStyle.Companion.small
import org.nuist.viewmodel.UserViewModel
import tornadofx.*

class LoginFragment : Fragment("Login") {

    private val userApi: UserApi by inject()

    private val userViewModel: UserViewModel by inject()

    private val messageWrapper by cssid()

    private val passwordField by cssid()

    override val root = vbox {
        addClass(loginPaneStyle)

        stackpane().setId(messageWrapper)

        form {
            fieldset {
                field("account") {
                    icon(MaterialDesignIcon.ACCOUNT)
                    jfxtextfield(userViewModel.account) {
                        isFocused
                        onMouseClickedProperty().value = EventHandler {
                            RubberBand().apply {
                                node = this@field.label
                                setSpeed(2.0)
                            }.play()
                        }
                    }
                }
                field("password") {
                    icon(MaterialDesignIcon.KEY)
                    jfxpasswordfield(userViewModel.password) {
                        setId(passwordField)
                        onMouseClickedProperty().value = EventHandler {
                            RubberBand().apply {
                                node = this@field.label
                                setSpeed(2.0)
                            }.play()
                        }
                    }
                }
            }
            buttonbar {
                jfxbutton("Login now!") {
                    icon(MaterialDesignIcon.LOGIN)
                    action {
                        login()
                    }
                }
            }
        }
    }

    private fun Button.login() {

        fun signalSigningIn() {
            properties["originalText"] = text
            text = "Signing..."
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
                userApi.login()
            } ui { success ->
                signalComplete()
                if (success) {
                    close()
                    find<DashboardView>().openWindow()
                } else {
                    loginFailed()
                }
            }
        }
    }

    private fun loginFailed() {
        root.select<StackPane>(messageWrapper).replaceChildren {
            hbox {
                addClass(errorMessage)
                label("Incorrect account or password.")
                spacer()
                button {
                    addClass(crossIcon, LoginFragmentStyle.icon, small)
                    action {
                        this@hbox.removeFromParent()
                    }
                }
            }
        }

        root.select<JFXPasswordField>(passwordField).requestFocus()
    }
}