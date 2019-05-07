package org.nuist.view

import animatefx.animation.GlowText
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import javafx.event.EventHandler
import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.layout.BorderPane
import javafx.scene.paint.Color
import org.nuist.ImageBase64.imageIcon
import org.nuist.view.controls.icon
import org.nuist.view.controls.jfxtoolbar
import org.nuist.view.controls.leftSide
import org.nuist.view.fragment.AboutFragment
import org.nuist.view.fragment.FondFragment
import org.nuist.view.fragment.HomeFragment
import org.nuist.view.fragment.LibraryFragment
import org.nuist.view.styles.DashboardStyle.Companion.drawerContentFragmentStyle
import org.nuist.view.styles.DashboardStyle.Companion.firstLabelStyle
import org.nuist.view.styles.DashboardStyle.Companion.jfxToolBar
import org.nuist.view.styles.DashboardStyle.Companion.leftItemStyle
import org.nuist.view.styles.DashboardStyle.Companion.mainDashboardStyle
import org.nuist.view.styles.DashboardStyle.Companion.mainIconImageViewStyle
import org.nuist.view.styles.DashboardStyle.Companion.secondVBoxStyle
import tornadofx.*
import java.lang.IllegalArgumentException


class DashboardView : View("dashboard") {

    private var borderPane: BorderPane by singleAssign()

    override val root = stackpane {
        borderPane = borderpane {

            addClass(mainDashboardStyle)
            top {
                jfxtoolbar {
                    addClass(jfxToolBar)
                    leftSide {
                        hbox {
                            addClass(leftItemStyle)
                            imageview {
                                addClass(mainIconImageViewStyle)
                                image = imageIcon
                                //下面三个在css无法定义
                                fitWidth = 40.0
                                fitHeight = 40.0
                                isPreserveRatio = true
                            }
                            label("BookManager") {
                                addClass(firstLabelStyle)
                                GlowText(this, Color.valueOf("#18ffff"), Color.valueOf("#00b8d4"))
                                    .apply {
                                        setSpeed(0.2)
                                        setCycleCount(Int.MAX_VALUE)
                                    }.play()
                            }
                        }
                    }
                }
            }

            left {
                vbox {
                    addClass(drawerContentFragmentStyle)
                    effect = DropShadow(BlurType.GAUSSIAN, Color.valueOf("#424242"), 10.0, 0.0, 0.0, 10.0)
                    vbox {
                        addClass(secondVBoxStyle)
                        label("Home") {
                            icon(MaterialDesignIcon.HOME, "30px", "#2196f3")
                            onMouseClicked = EventHandler {
                                changeCenterPane(1)
                            }
                        }
                        label("Library") {
                            icon(MaterialDesignIcon.BOOK, "30px", "#3f51b5")
                            onMouseClicked = EventHandler {
                                changeCenterPane(2)
                            }
                        }
                        label("Fond") {
                            icon(MaterialDesignIcon.HEART, "30px", "#673ab7")
                            onMouseClicked = EventHandler {
                                changeCenterPane(3)
                            }
                        }
                        label("About") {
                            icon(MaterialDesignIcon.SETTINGS, "30px", "#03a9f4")
                            onMouseClicked = EventHandler {
                                changeCenterPane(4)
                            }
                        }
                    }
                }
            }

            center(HomeFragment::class)
        }
    }

    private fun changeCenterPane(index: Int) {
        when (index) {
            1 -> borderPane.center = find(HomeFragment::class).root
            2 -> borderPane.center = find(LibraryFragment::class).root
            3 -> borderPane.center = find(FondFragment::class).root
            4 -> borderPane.center = find(AboutFragment::class).root
            else -> throw IllegalArgumentException("Wrong index number!")
        }
    }
}