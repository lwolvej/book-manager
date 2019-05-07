package org.nuist.view

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView
import org.nuist.view.controls.jfxtabpane
import org.nuist.view.fragment.LoginFragment
import org.nuist.view.fragment.RegisterFragment
import org.nuist.view.styles.MainViewStyle.Companion.jfxTabPane
import tornadofx.*

class MainView : View("Main") {


    override val root = jfxtabpane {

        addClass(jfxTabPane)

        fun setGraphic(icon: MaterialDesignIcon) =
            MaterialDesignIconView(icon)
                .apply {
                    size = "24px"
                    fill = c("#bbdefb")
                }


        tab<LoginFragment> {
            graphic = setGraphic(MaterialDesignIcon.ANDROID)
        }

        tab<RegisterFragment> {
            graphic = setGraphic(MaterialDesignIcon.AIRBALLOON)
        }
    }
}

