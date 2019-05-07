package org.nuist.view.controls

import com.jfoenix.controls.JFXTextField
import javafx.beans.value.ObservableValue
import javafx.event.EventTarget
import tornadofx.bind
import tornadofx.opcr

fun EventTarget.jfxtextfield(
    value: String? = null,
    promptText: String? = null,
    labelFloat: Boolean = false,
    op: JFXTextField.() -> Unit = {}
): JFXTextField {
    val textfield = JFXTextField(value)
    textfield.isLabelFloat = labelFloat
    if (promptText != null) textfield.promptText = promptText
    return opcr(this, textfield, op)
}

fun EventTarget.jfxtextfield(
    property: ObservableValue<String>,
    promptText: String? = null,
    labelFloat: Boolean = false,
    op: JFXTextField.() -> Unit = {}
): JFXTextField = jfxtextfield(promptText = promptText, labelFloat = labelFloat, op = op).apply { bind(property) }
