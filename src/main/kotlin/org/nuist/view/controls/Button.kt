package org.nuist.view.controls

import com.jfoenix.controls.JFXButton
import de.jensd.fx.glyphs.GlyphIcon
import de.jensd.fx.glyphs.GlyphIcons
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView
import javafx.event.EventTarget
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar
import javafx.scene.control.ContentDisplay
import tornadofx.*


fun ButtonBar.jfxbutton(
    value: String? = null,
    btnType: JFXButton.ButtonType = JFXButton.ButtonType.FLAT,
    graphic: Node? = null,
    type: ButtonBar.ButtonData? = null,
    op: JFXButton.() -> Unit = {}
): JFXButton {
    val button = JFXButton(value)
    button.buttonType = btnType
    if (graphic != null) button.graphic = graphic
    if (type != null) ButtonBar.setButtonData(button, type)
    buttons.add(button)
    return button.also(op)
}

fun EventTarget.jfxbutton(
    value: String? = null,
    btnType: JFXButton.ButtonType = JFXButton.ButtonType.FLAT,
    graphic: Node? = null,
    op: JFXButton.() -> Unit = {}
): JFXButton {
    val button = JFXButton(value)
    button.buttonType = btnType
    if (graphic != null) button.graphic = graphic
    return opcr(this, button, op)
}


fun Button.icon(icon: GlyphIcons, size: String = "18px", color: String = "black") {
    graphic = when (icon) {
        is FontAwesomeIcon -> FontAwesomeIconView(icon)
        is MaterialDesignIcon -> MaterialDesignIconView(icon)
        else -> throw IllegalArgumentException("Unknown font family ${icon.fontFamily}")
    }
    with(graphic as GlyphIcon<*>) {
        contentDisplay = ContentDisplay.LEFT
        this.setFill(c(color))
        setSize(size)
    }
}