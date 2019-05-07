package org.nuist.view.styles

import tornadofx.*

class MainViewStyle : Stylesheet() {

    companion object {

        val jfxTabPane by cssclass()
        val headersRegion by cssclass()
        val tabSelectedLine by cssclass()
        val tabHeaderBackground by cssclass()
        val tabHeaderArea by cssclass()
        val tabDownButton by cssclass()
        val tabContainer by cssclass()
        val tabLabel by cssclass()
    }

    init {

        jfxTabPane {
            backgroundColor += c("WHITE")
            prefWidth = 600.px
            prefHeight = 400.px
            tab {
                prefWidth = 295.px
                prefHeight = 60.px
            }
            tabHeaderArea {
                tabDownButton {
                    minHeight = 2.em
                    maxHeight = 2.em
                }
            }
            tabHeaderBackground {
                backgroundColor += c("#0d47a1")
            }
            headersRegion {
                tabSelectedLine {
                    backgroundColor += c("#f48fb1")
                }
                tab {
                    tabContainer {
                        tabLabel {
                            fontSize = 20.px
                            fontFamily = "Source Code Pro For Powerline"
                        }
                    }
                }
            }
        }
    }
}