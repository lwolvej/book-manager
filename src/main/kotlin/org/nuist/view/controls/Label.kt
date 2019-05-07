package org.nuist.view.controls

import de.jensd.fx.glyphs.GlyphIcon
import de.jensd.fx.glyphs.GlyphIcons
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView
import javafx.scene.control.ContentDisplay
import javafx.scene.control.Label
import javafx.scene.paint.Color

fun Label.icon(icon: GlyphIcons, size: String = "18px", color: String = "black") {
    graphic = when (icon) {
        is FontAwesomeIcon -> FontAwesomeIconView(icon)
        is MaterialDesignIcon -> MaterialDesignIconView(icon)
        else -> throw IllegalArgumentException("Unknown font family ${icon.fontFamily}")
    }
    with(graphic as GlyphIcon<*>) {
        contentDisplay = ContentDisplay.LEFT
        this.setFill(Color.valueOf(color))
        setSize(size)
    }
}