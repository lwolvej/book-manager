package org.nuist.view.styles

import javafx.geometry.Pos
import javafx.scene.text.TextAlignment
import tornadofx.*

class LibraryFragmentStyle : Stylesheet() {

    companion object {

        val vBoxStyle by cssclass()

        val jfxListViewStyle by cssclass()

        val hBoxStyle by cssclass()

        val listView by cssclass()

        val bookNameStyle by cssclass()
        val scoreStyle by cssclass()

        val bookDetailDialogStyle by cssclass()
        val dialogImageStyle by cssclass()
        val firstHBoxStyle by cssclass()
        val firstVBoxStyle by cssclass()
        val bookNameLabelStyle by cssclass()
        val scoreLabelStyle by cssclass()

        val secondBookVBoxStyle by cssclass()
        val secondBookLabelStyle by cssclass()

        val bookSummaryVBoxStyle by cssclass()
        val bookSummaryIconLabelStyle by cssclass()
        val bookSummaryLabelStyle by cssclass()

        val loveButtonHBoxStyle by cssclass()
        val loveButtonStyle by cssclass()
    }

    init {

        vBoxStyle {
            spacing = 10.px
        }

        jfxListViewStyle {
            maxWidth = 600.px
            minWidth = 600.px
            maxHeight = 960.px
            minHeight = 960.px
            s(odd, hover) {
                backgroundColor += c("white")
            }
        }

        hBoxStyle {
            maxHeight = 55.px
            minHeight = 55.px
            maxWidth = 398.px
            minWidth = 398.px
        }

        listCell {
            maxHeight = 55.px
            minHeight = 55.px
            maxWidth = 398.px
            minWidth = 398.px
        }

        listView {
            borderColor += box(c("#bdbdbd"))
            borderRadius += box(12.px)
            backgroundRadius += box(12.px)
            backgroundInsets += box(0.px)

            maxWidth = 960.px
            minWidth = 960.px
            maxHeight = 700.px
            minHeight = 700.px

            odd {
                backgroundColor += c("white")
            }
            even {
                backgroundColor += c("white")
            }

            selected {
                backgroundColor += c("#3f51b5")
            }

            listCell {
                fontFamily = "Weibei SC"
                fontSize = 32.px
                textFill = c("#424242")
                borderColor += box(c("#bdbdbd"))
                borderRadius += box(12.px)
                backgroundRadius += box(12.px)
            }
        }

        bookNameStyle {
            maxWidth = 780.px
            minWidth = 780.px
            maxHeight = 98.px
            minHeight = 98.px
            wrapText = true
        }

        scoreStyle {
            maxWidth = 135.px
            minWidth = 135.px
            maxHeight = 98.px
            minHeight = 98.px
            wrapText = true
        }

        bookDetailDialogStyle {
            maxWidth = 500.px
            minWidth = 500.px
            spacing = 30.px
        }

        firstHBoxStyle {
            spacing = 10.px
            padding = box(20.px, 20.px, 0.px, 20.px)
        }

        dialogImageStyle {
            smooth = true
            maxHeight = 210.px
            minHeight = 210.px
            maxWidth = 150.px
            minWidth = 150.px
        }

        firstVBoxStyle {
            alignment = Pos.BOTTOM_LEFT
            maxWidth = 240.px
            minWidth = 240.px
            maxHeight = 210.px
            minHeight = 210.px
            spacing = 6.px
        }

        bookNameLabelStyle {
            fontSize = 26.px
            textFill = c("#212121")
            fontFamily = "Weibei SC"
            wrapText = true
            maxWidth = 220.px
            minWidth = 220.px
        }

        scoreStyle {
            fontSize = 20.px
            textFill = c("#616161")
        }

        secondBookVBoxStyle {
            padding = box(0.px, 20.px, 0.px, 20.px)
            maxWidth = 460.px
            minWidth = 460.px
            spacing = 6.px
        }

        secondBookLabelStyle {
            maxWidth = 460.px
            minWidth = 460.px
            textFill = c("#9e9e9e")
            fontSize = 14.px
            wrapText = true
        }

        bookSummaryVBoxStyle {
            maxWidth = 460.px
            minWidth = 460.px
            spacing = 12.px
            padding = box(0.px, 20.px, 0.px, 20.px)
            fontFamily = "Microsoft Sans Serif"
        }

        bookSummaryIconLabelStyle {
            alignment = Pos.CENTER
            textFill = c("#757575")
            fontSize = 16.px
        }

        bookSummaryLabelStyle {
            wrapText = true
            maxWidth = 460.px
            minWidth = 460.px
            textFill = c("#9e9e9e")
            fontSize = 14.px
            textAlignment = TextAlignment.CENTER
        }

        loveButtonHBoxStyle {
            alignment = Pos.CENTER
            maxHeight = 32.px
            minHeight = 32.px
            padding = box(0.px, 0.px, 20.px, 20.px)
        }

        loveButtonStyle {
            fontSize = 30.px
            unsafe("-jfx-button-type", raw("RAISED"))
            alignment = Pos.CENTER
        }
    }
}