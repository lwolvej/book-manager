package org.nuist.view.fragment

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import org.nuist.ImageBase64.imageIcon
import org.nuist.view.controls.icon
import org.nuist.view.styles.AboutFragmentStyle.Companion.aboutStyle
import org.nuist.view.styles.AboutFragmentStyle.Companion.bottomVBoxStyle
import org.nuist.view.styles.AboutFragmentStyle.Companion.cChipIconStyle
import org.nuist.view.styles.AboutFragmentStyle.Companion.centerVBoxStyle
import org.nuist.view.styles.AboutFragmentStyle.Companion.chipStyle
import org.nuist.view.styles.AboutFragmentStyle.Companion.chipTextStyle
import org.nuist.view.styles.AboutFragmentStyle.Companion.chipViewStyle
import org.nuist.view.styles.AboutFragmentStyle.Companion.developLabelStyle
import org.nuist.view.styles.AboutFragmentStyle.Companion.hChipIconStyle
import org.nuist.view.styles.AboutFragmentStyle.Companion.iconImageStyle
import org.nuist.view.styles.AboutFragmentStyle.Companion.lChipIconStyle
import org.nuist.view.styles.AboutFragmentStyle.Companion.mChipIconStyle
import org.nuist.view.styles.AboutFragmentStyle.Companion.mainLabelStyle
import org.nuist.view.styles.AboutFragmentStyle.Companion.secondLabelStyle
import org.nuist.view.styles.AboutFragmentStyle.Companion.versionLabelStyle
import tornadofx.*


class AboutFragment : Fragment() {

    override val root = borderpane {

        addClass(aboutStyle)
        center {
            vbox {
                addClass(centerVBoxStyle)
                imageview {
                    addClass(iconImageStyle)
                    image = imageIcon
                    fitWidth = 100.0
                    fitHeight = 100.0
                    isPreserveRatio = true
                }

                label("书籍管理") {
                    addClass(mainLabelStyle)
                }

                label("找到你喜欢的书并加入喜欢列表吧！") {
                    addClass(secondLabelStyle)
                }
            }
        }

        bottom {
            vbox {
                addClass(bottomVBoxStyle)
                label("开发成员") {
                    addClass(developLabelStyle)
                    icon(MaterialDesignIcon.DIAMOND, size = "16px", color = "#ffab00")
                }

                hbox {
                    addClass(chipViewStyle)
                    hbox {
                        addClass(chipStyle)
                        label("L") {
                            addClass(lChipIconStyle)
                        }
                        label("Li") {
                            addClass(chipTextStyle)
                        }
                    }
                    hbox {
                        addClass(chipStyle)
                        label("C") {
                            addClass(cChipIconStyle)
                        }
                        label("Chen") {
                            addClass(chipTextStyle)
                        }
                    }
                    hbox {
                        addClass(chipStyle)
                        label("M") {
                            addClass(mChipIconStyle)
                        }
                        label("Ma") {
                            addClass(chipTextStyle)
                        }
                    }
                    hbox {
                        addClass(chipStyle)
                        label("H") {
                            addClass(hChipIconStyle)
                        }
                        label("Hu") {
                            addClass(chipTextStyle)
                        }
                    }
                }

                label("版本 1.0贝塔") {
                    addClass(versionLabelStyle)
                }
            }
        }
    }


}