package org.nuist.view.styles

import javafx.geometry.Pos
import javafx.scene.text.TextAlignment
import tornadofx.*

class FondFragmentStyle : Stylesheet() {

    companion object {
        val fondHBoxStyle by cssclass()
        val fondBookNameStyle by cssclass()
        val fondScoreStyle by cssclass()
        val fondDeleteButtonStyle by cssclass()


        val fondBookDetailDialogStyle by cssclass()
        val fondFirstHBoxStyle by cssclass()
        val fondDialogImageStyle by cssclass()
        val fondFirstVBoxStyle by cssclass()
        val fondBookNameLabelStyle by cssclass()
        val fondScoreLabelStyle by cssclass()
        val fondSecondBookVBoxStyle by cssclass()
        val fondSecondBookLabelStyle by cssclass()
        val fondBookSummaryVBoxStyle by cssclass()
        val fondBookSummaryIconLabelStyle by cssclass()
        val fondBookSummaryLabelStyle by cssclass()
    }

    init {

        fondHBoxStyle {
            spacing = 7.5.px
        }

        fondBookNameStyle {
            minWidth = 590.px
            maxWidth = 590.px
            maxHeight = 98.px
            minHeight = 98.px
            wrapText = true
        }

        fondScoreStyle {
            maxWidth = 100.px
            minWidth = 100.px
            maxHeight = 98.px
            minHeight = 98.px
        }

        fondDeleteButtonStyle {
            maxWidth = 110.px
            minWidth = 110.px
            maxHeight = 98.px
            minHeight = 98.px
            fontSize = 20.px
            textFill = c("#ef5350")
            fontFamily = "Source Code Pro For Powerline"
        }

        fondBookDetailDialogStyle {
            maxWidth = 500.px
            minWidth = 500.px
            spacing = 30.px
        }

        fondFirstHBoxStyle {
            spacing = 10.px
            padding = box(20.px, 20.px, 0.px, 20.px)
        }

        fondDialogImageStyle {
            smooth = true
            maxHeight = 210.px
            minHeight = 210.px
            maxWidth = 150.px
            minWidth = 150.px
        }

        fondFirstVBoxStyle {
            alignment = Pos.BOTTOM_LEFT
            maxWidth = 240.px
            minWidth = 240.px
            maxHeight = 210.px
            minHeight = 210.px
            spacing = 6.px
        }

        fondBookNameLabelStyle {
            fontSize = 26.px
            textFill = c("#212121")
            fontFamily = "Weibei SC"
            wrapText = true
            maxWidth = 220.px
            minWidth = 220.px
        }

        fondScoreStyle {
            fontSize = 20.px
            textFill = c("#616161")
        }

        fondSecondBookVBoxStyle {
            padding = box(0.px, 20.px, 0.px, 20.px)
            maxWidth = 460.px
            minWidth = 460.px
            spacing = 6.px
        }

        fondSecondBookLabelStyle {
            maxWidth = 460.px
            minWidth = 460.px
            textFill = c("#9e9e9e")
            fontSize = 14.px
            wrapText = true
        }

        fondBookSummaryVBoxStyle {
            maxWidth = 460.px
            minWidth = 460.px
            spacing = 12.px
            padding = box(0.px, 20.px, 20.px, 20.px)
            fontFamily = "Microsoft Sans Serif"
        }

        fondBookSummaryIconLabelStyle {
            alignment = Pos.CENTER
            textFill = c("#757575")
            fontSize = 16.px
        }

        fondBookSummaryLabelStyle {
            wrapText = true
            maxWidth = 460.px
            minWidth = 460.px
            textFill = c("#9e9e9e")
            fontSize = 14.px
            textAlignment = TextAlignment.CENTER
        }
    }
}