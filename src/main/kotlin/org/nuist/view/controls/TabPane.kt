package org.nuist.view.controls

import com.jfoenix.controls.JFXTabPane
import javafx.event.EventTarget
import tornadofx.opcr


fun EventTarget.jfxtabpane(op: JFXTabPane.() -> Unit = {}): JFXTabPane = opcr(this, JFXTabPane(), op)
