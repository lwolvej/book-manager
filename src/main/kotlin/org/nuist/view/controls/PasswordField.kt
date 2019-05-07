package org.nuist.view.controls

import com.jfoenix.controls.JFXPasswordField
import javafx.beans.property.Property
import javafx.event.EventTarget
import tornadofx.opcr

fun EventTarget.jfxpasswordfield(
    promptText: String? = null,
    op: JFXPasswordField.() -> Unit = {}
): JFXPasswordField {
    val passwordField = JFXPasswordField()
    if (promptText != null) passwordField.promptText = promptText
    return opcr(this, passwordField, op)
}

fun EventTarget.jfxpasswordfield(
    property: Property<String>,
    promptText: String? = null,
    op: JFXPasswordField.() -> Unit = {}
): JFXPasswordField = jfxpasswordfield(promptText, op).apply { textProperty().bindBidirectional(property) }
