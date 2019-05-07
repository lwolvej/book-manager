package org.nuist.view.controls

import com.jfoenix.controls.JFXListView
import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.event.EventTarget
import tornadofx.SortedFilteredList
import tornadofx.onChange
import tornadofx.opcr

fun <T> EventTarget.jfxlistview(
    items: ObservableList<T>? = null,
    op: JFXListView<T>.() -> Unit = {}
): JFXListView<T> {
    val listView = JFXListView<T>()
    if (items != null) {
        if (items is SortedFilteredList<T>) items.bindTo(listView)
        else listView.items = items
    }
    return opcr(this, listView, op)
}
