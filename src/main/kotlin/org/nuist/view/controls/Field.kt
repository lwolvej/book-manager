package org.nuist.view.controls

import de.jensd.fx.glyphs.GlyphIcons
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView
import javafx.scene.control.ContentDisplay
import tornadofx.Dimension
import tornadofx.Field
import tornadofx.em

fun Field.icon(
    icon: GlyphIcons,
    iconSize: Dimension<Dimension.LinearUnits> = 2.em
) {
    label.graphic = when (icon) {
        is FontAwesomeIcon -> FontAwesomeIconView(icon).apply {
            size = iconSize.toString()
        }
        is MaterialDesignIcon -> MaterialDesignIconView(icon).apply {
            size = iconSize.toString()
        }
        else -> throw IllegalArgumentException("Unknown font family ${icon.fontFamily}")
    }
    label.contentDisplay = ContentDisplay.LEFT
}