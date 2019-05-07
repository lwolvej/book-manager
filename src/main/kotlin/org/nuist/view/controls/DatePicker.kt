package org.nuist.view.controls

import com.jfoenix.controls.JFXDatePicker
import javafx.beans.property.Property
import javafx.event.EventTarget
import tornadofx.bind
import tornadofx.opcr
import java.time.LocalDate

fun EventTarget.jfxdatepicker(op: JFXDatePicker.() -> Unit = {}): JFXDatePicker = opcr(this, JFXDatePicker(), op)

fun EventTarget.jfxdatepicker(property: Property<LocalDate>, op: JFXDatePicker.() -> Unit = {}): JFXDatePicker =
    jfxdatepicker(op).apply { bind(property) }