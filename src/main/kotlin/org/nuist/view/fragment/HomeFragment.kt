package org.nuist.view.fragment

import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.JFXPasswordField
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import javafx.geometry.Pos
import org.nuist.ImageBase64.imageUser
import org.nuist.api.UserApi
import org.nuist.view.DashboardView
import org.nuist.view.controls.icon
import org.nuist.view.controls.jfxbutton
import org.nuist.view.controls.jfxpasswordfield
import org.nuist.view.styles.HomeFragmentStyle.Companion.changePasswordLabelStyle
import org.nuist.view.styles.HomeFragmentStyle.Companion.mainHomeHBoxStyle
import org.nuist.view.styles.HomeFragmentStyle.Companion.mainHomeVBoxStyle
import org.nuist.view.styles.HomeFragmentStyle.Companion.myPasswordHomeTextFiledStyle
import org.nuist.view.styles.HomeFragmentStyle.Companion.passwordHomeHBoxStyle
import org.nuist.view.styles.HomeFragmentStyle.Companion.passwordHomeLabelStyle
import org.nuist.view.styles.HomeFragmentStyle.Companion.passwordHomeVBoxStyle
import org.nuist.view.styles.HomeFragmentStyle.Companion.secondHomeIncLabelStyle
import org.nuist.view.styles.HomeFragmentStyle.Companion.secondHomeVBoxStyle
import org.nuist.view.styles.HomeFragmentStyle.Companion.secondHomeViewModelLabelStyle
import org.nuist.view.styles.HomeFragmentStyle.Companion.thirdHomeVBoxStyle
import org.nuist.view.styles.HomeFragmentStyle.Companion.updateButtonHomeStyle
import org.nuist.view.styles.HomeFragmentStyle.Companion.userHomeAccountStyle
import org.nuist.view.styles.HomeFragmentStyle.Companion.userHomeImageStyle
import org.nuist.view.styles.HomeFragmentStyle.Companion.userHomeRealNameStyle
import org.nuist.view.styles.HomeFragmentStyle.Companion.userHomeVBoxStyle
import org.nuist.viewmodel.UserViewModel
import tornadofx.*

class HomeFragment : Fragment() {

    private val userViewModel: UserViewModel by inject()

    private val userApi: UserApi by inject()

    private var oldPasswordField: JFXPasswordField by singleAssign()

    private var newPasswordField: JFXPasswordField by singleAssign()

    override val root = vbox {

        addClass(mainHomeVBoxStyle)

        vbox {
            addClass(userHomeVBoxStyle)
            imageview {
                addClass(userHomeImageStyle)
                image = imageUser
                fitWidth = 160.0
                fitHeight = 160.0
                isPreserveRatio = true
            }
            label(userViewModel.realName) {
                addClass(userHomeRealNameStyle)
            }
            label(userViewModel.account) {
                addClass(userHomeAccountStyle)
            }
        }

        hbox {
            addClass(mainHomeHBoxStyle)

            vbox {
                addClass(secondHomeVBoxStyle)
                label("Age") {
                    addClass(secondHomeIncLabelStyle)
                    icon(MaterialDesignIcon.FISH, size = "20px", color = "#ff5252")
                }
                label(userViewModel.age) {
                    addClass(secondHomeViewModelLabelStyle)
                }
            }
            vbox {
                addClass(secondHomeVBoxStyle)

                label("Birthday") {
                    addClass(secondHomeIncLabelStyle)
                    icon(MaterialDesignIcon.GOOGLE_CONTROLLER, size = "20px", color = "#e040fb")
                }

                label(userViewModel.birthday) {
                    addClass(secondHomeViewModelLabelStyle)

                }
            }
        }

        vbox {
            addClass(thirdHomeVBoxStyle)

            label("Change Your Password!") {
                addClass(changePasswordLabelStyle)
                icon(MaterialDesignIcon.INFORMATION, size = "24px", color = "#ff6e40")
            }

            hbox {
                addClass(passwordHomeHBoxStyle)
                vbox {
                    addClass(passwordHomeVBoxStyle)
                    label("Old Password") {
                        addClass(passwordHomeLabelStyle)
                        icon(MaterialDesignIcon.GOOGLE_CHROME, size = "20px", color = "#536dfe")
                    }
                    oldPasswordField = jfxpasswordfield {
                        addClass(myPasswordHomeTextFiledStyle)

                    }
                }
                vbox {
                    addClass(passwordHomeVBoxStyle)
                    label("New Password") {
                        addClass(passwordHomeLabelStyle)
                        icon(MaterialDesignIcon.COMPASS, size = "20px", color = "#40c4ff")
                    }
                    newPasswordField = jfxpasswordfield {
                        addClass(myPasswordHomeTextFiledStyle)
                    }
                }
            }

            jfxbutton("Update") {
                addClass(updateButtonHomeStyle)
                action {
                    update()
                }
            }
        }
    }

    private fun update() {
        val newPassword = newPasswordField.text
        val oldPassword = oldPasswordField.text

        runAsync {
            userApi.changePassword(oldPassword = oldPassword, newPassword = newPassword)
        } ui {
            newPasswordField.text = ""
            oldPasswordField.text = ""
            JFXDialog().apply {
                transitionType = JFXDialog.DialogTransition.CENTER
                dialogContainer = find(DashboardView::class).root
                content = vbox {
                    style {
                        maxWidth = 300.px
                        minWidth = 300.px
                        maxHeight = 100.px
                        minHeight = 100.px
                        alignment = Pos.CENTER
                    }
                    label {
                        text = if (it) {
                            "Update Success!"
                        } else {
                            "Update Fail!"
                        }
                        style {
                            wrapText = true
                            fontSize = 24.px
                            textFill = c("#f4511e")
                            alignment = Pos.CENTER
                        }
                    }
                }
            }.show()
        }
    }
}