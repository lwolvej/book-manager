package org.nuist.view.styles

import javafx.geometry.Pos
import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class DashboardStyle : Stylesheet() {

    companion object {
        val mainDashboardStyle by cssclass()

        val jfxToolBar by cssclass()

        val mainIconImageViewStyle by cssclass()
        val firstLabelStyle by cssclass()

        val leftItemStyle by cssclass()

        val drawerContentFragmentStyle by cssclass()
        val secondVBoxStyle by cssclass()
    }

    init {
        mainDashboardStyle {
            maxWidth = 1200.px
            minWidth = 1200.px
            maxHeight = 820.px
            minHeight = 820.px
        }

        jfxToolBar {
            fontSize = 36.px
            fontWeight = FontWeight.BOLD
            backgroundColor += c("#2962ff")
            unsafe("-fx-pref-width", raw("100%"))
            prefHeight = 70.px
        }

        leftItemStyle {
            spacing = 20.px
            alignment = Pos.CENTER
            padding = box(10.px, 0.px, 10.px, 10.px)
        }

        mainIconImageViewStyle {
            smooth = true
            maxWidth = 40.px
            minWidth = 40.px
            maxHeight = 40.px
            minWidth = 40.px
        }

        firstLabelStyle {
            wrapText = true
            alignment = Pos.CENTER
            fontFamily = "Source Code Pro for Powerline"
            fontWeight = FontWeight.BOLD
            fontSize = 24.px
        }

        drawerContentFragmentStyle {
            minWidth = 240.px
            maxWidth = 240.px
            minHeight = 750.px
            maxHeight = 750.px
            spacing = 60.px
            startMargin = 20.px
            backgroundColor += c("#f5f5f5")
        }

        val commonLabelStyle = mixin {
            minWidth = 200.px
            maxWidth = 200.px
            wrapText = true
        }

        secondVBoxStyle {
            spacing = 42.px
            padding = box(20.px, 0.px, 0.px, 20.px)
            label {
                +commonLabelStyle
                fontSize = 32.px
                alignment = Pos.BASELINE_LEFT
                textFill = c("#424242")
                borderRadius += box(16.px)
                backgroundRadius += box(16.px)
                padding = box(0.px, 0.px, 0.px, 30.px)
            }
            label and hover {
                backgroundColor += c("#f5f5f5")
                effect = DropShadow(BlurType.GAUSSIAN, Color.valueOf("#424242"), 10.0, 0.0, 0.0, 0.0)
            }
            label and pressed {
                backgroundColor += c("#eeeeee")
                effect = DropShadow(BlurType.GAUSSIAN, Color.valueOf("#424242"), 10.0, 0.0, 0.0, 0.0)
            }
        }
    }
}