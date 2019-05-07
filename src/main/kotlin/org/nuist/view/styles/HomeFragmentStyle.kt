package org.nuist.view.styles

import javafx.geometry.Pos
import tornadofx.*

class HomeFragmentStyle : Stylesheet() {


    companion object {
        val mainHomeVBoxStyle by cssclass()
        val userHomeVBoxStyle by cssclass()
        val userHomeImageStyle by cssclass()
        val userHomeRealNameStyle by cssclass()
        val userHomeAccountStyle by cssclass()

        val mainHomeHBoxStyle by cssclass()

        val secondHomeVBoxStyle by cssclass()
        val secondHomeIncLabelStyle by cssclass()
        val secondHomeViewModelLabelStyle by cssclass()

        val thirdHomeVBoxStyle by cssclass()
        val passwordHomeHBoxStyle by cssclass()
        val passwordHomeVBoxStyle by cssclass()
        val passwordHomeLabelStyle by cssclass()
        val myPasswordHomeTextFiledStyle by cssclass()
        val changePasswordLabelStyle by cssclass()

        val updateButtonHomeStyle by cssclass()
    }

    init {

        mainHomeVBoxStyle {
            padding = box(40.px, 0.px, 40.px, 0.px)
            maxWidth = 960.px
            minWidth = 960.px
            spacing = 80.px
        }

        userHomeVBoxStyle {
            alignment = Pos.CENTER
            spacing = 10.px
        }

        userHomeImageStyle {
            smooth = true
        }

        userHomeRealNameStyle {
            fontSize = 36.px
            textFill = c("#424242")
        }

        userHomeAccountStyle {
            fontSize = 24.px
            textFill = c("#616161")
        }

        mainHomeHBoxStyle {
            alignment = Pos.CENTER
            spacing = 100.px
        }

        secondHomeVBoxStyle {
            spacing = 8.px
        }

        secondHomeIncLabelStyle {
            fontSize = 20.px
            textFill = c("#424242")
        }

        secondHomeViewModelLabelStyle {
            fontSize = 24.px
            textFill = c("#616161")
        }

        thirdHomeVBoxStyle {
            alignment = Pos.CENTER
            spacing = 20.px
        }


        passwordHomeHBoxStyle {
            alignment = Pos.CENTER
            spacing = 30.px
        }

        passwordHomeVBoxStyle {
            spacing = 8.px
        }

        passwordHomeLabelStyle {
            textFill = c("#616161")
            fontSize = 18.px
        }

        myPasswordHomeTextFiledStyle {
            fontSize = 18.px
        }

        changePasswordLabelStyle {
            alignment = Pos.CENTER
            fontSize = 24.px
            textFill = c("#424242")
        }

        updateButtonHomeStyle {
            fontSize = 20.px
            unsafe("-jfx-button-type", raw("RAISED"))
            backgroundColor += c("#fffde7")
            backgroundRadius += box(16.px)
            borderRadius += box(16.px)
        }
    }
}