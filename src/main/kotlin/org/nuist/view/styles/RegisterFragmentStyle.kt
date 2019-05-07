package org.nuist.view.styles

import javafx.geometry.Pos
import javafx.scene.Cursor
import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*


class RegisterFragmentStyle : Stylesheet() {

    companion object {
        val registerPaneStyle by cssclass()
        val registerButtonStyle by cssclass()

        val jfxDatePicker by cssclass()
        val jfxDefaultColor by cssproperty<Color>("-jfx-default-color")


        val errorMessage by cssclass()
        val crossIcon by cssclass()
        val icon by cssclass()
        val small by cssclass()
    }

    init {
        registerPaneStyle {
            spacing = 10.px
            alignment = Pos.CENTER
            form {
                backgroundColor += c("#fafafa")
                backgroundRadius += box(16.px)
                borderRadius += box(16.px)
                fontFamily = "Source Code Pro for Powerline"
                alignment = Pos.CENTER
                maxWidth = 350.px
                minWidth = 350.px
                maxHeight = 270.px
                minHeight = 270.px
                spacing = 16.px
                effect = DropShadow(BlurType.GAUSSIAN, Color.valueOf("#424242"), 20.0, 0.0, 0.0, 0.0)
                fieldset {
                    spacing = 14.px
                    fontSize = 14.px
                    fontWeight = FontWeight.NORMAL
                }
            }
        }

        registerButtonStyle {
            unsafe("-jfx-button-type", raw("RAISED"))
            unsafe("-fx-background-color", raw("linear-gradient(to right,#1e88e5,#0d47a1)"))
            fontSize = 14.px
            backgroundRadius += box(16.px)
            borderRadius += box(16.px)
            textFill = c("#f5f5f5")
        }

        jfxDatePicker {
            jfxDefaultColor.value = c("#2196f3")
        }


        errorMessage {
            borderRadius += box(4.px)
            maxWidth = 320.px
            alignment = Pos.CENTER
            label {
                textFill = c(153, 17, 17)
            }
            icon {
                backgroundColor += c(153, 17, 17)
            }
            backgroundColor += c(252, 222, 222)
            borderColor += box(c(210, 178, 178))
            padding = box(12.px)
        }

        crossIcon {
            shape =
                "M7.48 8l3.75 3.75-1.48 1.48L6 9.48l-3.75 3.75-1.48-1.48L4.52 8 .77 4.25l1.48-1.48L6 6.52l3.75-3.75 1.48 1.48z"
            cursor = Cursor.HAND
        }

        icon {
            minWidth = 16.px
            maxWidth = 16.px
            minHeight = 14.px
            maxHeight = 14.px
            backgroundColor += Color.GRAY
            and(small) {
                minWidth = 12.px
                maxWidth = 12.px
                minHeight = 10.px
                maxHeight = 10.px
            }
        }
    }
}