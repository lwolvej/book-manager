package org.nuist.view.styles

import javafx.geometry.Pos
import javafx.scene.Cursor
import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class LoginFragmentStyle : Stylesheet() {

    companion object {
        val loginPaneStyle by cssclass()

        val errorMessage by cssclass()

        val crossIcon by cssclass()

        val icon by cssclass()

        val small by cssclass()

    }

    init {
        loginPaneStyle {
            spacing = 20.px
            alignment = Pos.CENTER
            form {
                backgroundColor += c("#fafafa")
                backgroundRadius += box(16.px)
                borderRadius += box(16.px)
                fontFamily = "Source Code Pro for Powerline"
                alignment = Pos.TOP_CENTER
                maxWidth = 350.px
                prefHeight = 220.px
                maxHeight = 300.px
                spacing = 40.px
                effect = DropShadow(BlurType.GAUSSIAN, Color.valueOf("#424242"), 20.0, 0.0, 0.0, 0.0)
                fieldset {
                    spacing = 24.px
                    fontWeight = FontWeight.NORMAL
                    fontSize = 18.px
                }
                button {
                    unsafe("-jfx-button-type", raw("RAISED"))
                    unsafe("-fx-background-color", raw("linear-gradient(to right,#1e88e5,#0d47a1)"))
                    fontSize = 18.px
                    backgroundRadius += box(16.px)
                    borderRadius += box(16.px)
                    textFill = c("#f5f5f5")
                }
            }
        }

        errorMessage {
            borderRadius += box(4.px)
            maxWidth = 316.px
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
            minHeight = 16.px
            maxHeight = 16.px
            backgroundColor += Color.GRAY
            and(small) {
                minWidth = 12.px
                maxWidth = 12.px
                minHeight = 12.px
                maxHeight = 12.px
            }
        }
    }
}