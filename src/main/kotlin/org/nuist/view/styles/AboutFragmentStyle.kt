package org.nuist.view.styles

import javafx.geometry.Pos
import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment
import tornadofx.*

class AboutFragmentStyle : Stylesheet() {

    companion object {
        val aboutStyle by cssclass()

        val centerVBoxStyle by cssclass()
        val chipStyle by cssclass()
        val iconImageStyle by cssclass()
        val lChipIconStyle by cssclass()
        val cChipIconStyle by cssclass()
        val mChipIconStyle by cssclass()
        val hChipIconStyle by cssclass()
        val chipTextStyle by cssclass()
        val chipViewStyle by cssclass()

        val mainLabelStyle by cssclass()
        val secondLabelStyle by cssclass()
        val versionLabelStyle by cssclass()

        val bottomVBoxStyle by cssclass()
        val developLabelStyle by cssclass()
    }

    init {

        aboutStyle {
            backgroundColor += c("white")
        }

        centerVBoxStyle {
            alignment = Pos.CENTER
            spacing = 20.px
        }

        iconImageStyle {
            smooth = true
            maxWidth = 100.px
            minWidth = 100.px
            maxHeight = 100.px
            minWidth = 100.px
        }

        chipStyle {
            backgroundColor += c("#e0e0e0")
            backgroundRadius += box(16.px)
            borderRadius += box(16.px)
            maxWidth = 120.px
            minWidth = 120.px
            maxHeight = 30.px
            minHeight = 30.px
            spacing = 8.px
            padding = box(0.px, 4.px, 0.px, 4.px)
            alignment = Pos.CENTER_LEFT
        }

        chipViewStyle {
            spacing = 6.px
            alignment = Pos.CENTER
        }

        val chipIconCommon = mixin {
            backgroundRadius += box(24.px)
            borderRadius += box(24.px)
            maxWidth = 24.px
            minWidth = 24.px
            maxHeight = 24.px
            minHeight = 24.px
            alignment = Pos.CENTER
            fontSize = 18.px
        }

        lChipIconStyle {
            +chipIconCommon
            backgroundColor += c("#03a9f4")
        }

        cChipIconStyle {
            +chipIconCommon
            backgroundColor += c("#26a69a")
        }

        mChipIconStyle {
            +chipIconCommon
            backgroundColor += c("#ffeb3b")
        }

        hChipIconStyle {
            +chipIconCommon
            backgroundColor += c("#ff7043")
        }

        chipTextStyle {
            alignment = Pos.CENTER
            fontSize = 16.px
        }

        mainLabelStyle {
            textFill = c("#323232")
            fontFamily = "Quicksand"
            fontSize = 32.px
            fontWeight = FontWeight.BOLD
        }

        secondLabelStyle {
            textFill = c("#323232")
            wrapText = true
            textAlignment = TextAlignment.CENTER
            fontFamily = "Source Code Pro for Powerline"
            fontSize = 24.px
            fontWeight = FontWeight.NORMAL
            maxWidth = 400.px
            minWidth = 400.px
        }

        versionLabelStyle {
            fontFamily = "Wawati sc"
            textFill = c("#323232")
            fontSize = 16.px
            wrapText = true
            fontWeight = FontWeight.LIGHT
            textAlignment = TextAlignment.CENTER
            alignment = Pos.CENTER
        }

        bottomVBoxStyle {
            spacing = 30.px
            padding = box(0.px, 0.px, 60.px, 0.px)
            alignment = Pos.CENTER
        }

        developLabelStyle {
            alignment = Pos.CENTER
            textFill = c("#616161")
            fontSize = 24.px
        }
    }
}