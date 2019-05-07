package org.nuist.view.controls

import com.jfoenix.controls.JFXToolbar
import javafx.event.EventTarget
import javafx.scene.Node
import tornadofx.*

fun EventTarget.jfxtoolbar(vararg nodes: Node, op: JFXToolbar.() -> Unit = {}): JFXToolbar {
    val toolbar = JFXToolbar()
    if (nodes.isNotEmpty()) toolbar.leftItems.addAll(nodes)
    return opcr(this, toolbar, op)
}

fun JFXToolbar.leftSide(op: JFXToolbar.() -> Unit = {}) {
    val interceptor = object : ChildInterceptor {
        override fun invoke(parent: EventTarget, node: Node, index: Int?): Boolean {
            if (parent is JFXToolbar) {
                parent.leftItems += node
                return true
            }
            return false
        }
    }
    FX.addChildInterceptor(interceptor)
    op()
    FX.removeChildInterceptor(interceptor)
}
