package org.nuist.view.fragment

import com.jfoenix.controls.JFXDialog
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import javafx.scene.control.Button
import javafx.scene.control.ListView
import javafx.scene.input.MouseEvent
import org.nuist.api.BookApi
import org.nuist.api.BookDetailApi
import org.nuist.api.FondApi
import org.nuist.model.BookModel
import org.nuist.view.DashboardView
import org.nuist.view.controls.icon
import org.nuist.view.controls.jfxbutton
import org.nuist.view.controls.jfxlistview
import org.nuist.view.styles.LibraryFragmentStyle.Companion.bookDetailDialogStyle
import org.nuist.view.styles.LibraryFragmentStyle.Companion.bookNameLabelStyle
import org.nuist.view.styles.LibraryFragmentStyle.Companion.bookNameStyle
import org.nuist.view.styles.LibraryFragmentStyle.Companion.bookSummaryIconLabelStyle
import org.nuist.view.styles.LibraryFragmentStyle.Companion.bookSummaryLabelStyle
import org.nuist.view.styles.LibraryFragmentStyle.Companion.bookSummaryVBoxStyle
import org.nuist.view.styles.LibraryFragmentStyle.Companion.dialogImageStyle
import org.nuist.view.styles.LibraryFragmentStyle.Companion.firstHBoxStyle
import org.nuist.view.styles.LibraryFragmentStyle.Companion.firstVBoxStyle
import org.nuist.viewmodel.BookDetailViewModel
import org.nuist.viewmodel.PageViewModel
import tornadofx.*
import org.nuist.view.styles.LibraryFragmentStyle.Companion.listView
import org.nuist.view.styles.LibraryFragmentStyle.Companion.loveButtonHBoxStyle
import org.nuist.view.styles.LibraryFragmentStyle.Companion.loveButtonStyle
import org.nuist.view.styles.LibraryFragmentStyle.Companion.scoreLabelStyle
import org.nuist.view.styles.LibraryFragmentStyle.Companion.scoreStyle
import org.nuist.view.styles.LibraryFragmentStyle.Companion.secondBookLabelStyle
import org.nuist.view.styles.LibraryFragmentStyle.Companion.secondBookVBoxStyle

class LibraryFragment : Fragment() {

    private val bookApi: BookApi by inject()

    private val bookDetailApi: BookDetailApi by inject()

    private val pageViewModel: PageViewModel by inject()

    private val bookDetailViewModel: BookDetailViewModel by inject()

    private val fondApi: FondApi by inject()

    private var myJfxListView: ListView<BookModel> by singleAssign()

    override val root = vbox {

        myJfxListView = jfxlistview<BookModel> {
            addClass(listView)
            cellFormat {
                graphic = hbox {

                    label(it.bookName) {
                        addClass(bookNameStyle)
                        icon(MaterialDesignIcon.BOOK_MULTIPLE, size = "35px", color = "#26a69a")
                    }

                    label(it.score.toString()) {
                        addClass(scoreStyle)
                        icon(MaterialDesignIcon.FLASH, size = "35px", color = "#ffd600")
                    }
                }
            }

            onUserSelect(2) {
                runAsync {
                    bookDetailApi.showOneBook(bookId = it.id)
                } ui {
                    JFXDialog().apply {
                        transitionType = JFXDialog.DialogTransition.CENTER
                        dialogContainer = find(DashboardView::class).root
                        content = vbox {
                            addClass(bookDetailDialogStyle)
                            hbox {
                                addClass(firstHBoxStyle)
                                imageview(bookDetailViewModel.data) {
                                    addClass(dialogImageStyle)
                                    fitWidth = 150.0
                                    fitHeight = 210.0
                                    isPreserveRatio = true
                                }

                                vbox {
                                    addClass(firstVBoxStyle)
                                    label(bookDetailViewModel.bookName) {
                                        addClass(bookNameLabelStyle)
                                        icon(MaterialDesignIcon.BOOK, size = "26px", color = "#009688")
                                    }

                                    label(bookDetailViewModel.score) {
                                        addClass(scoreLabelStyle)
                                        icon(MaterialDesignIcon.FLASH, size = "22px", color = "#f9a825")
                                    }
                                }
                            }

                            vbox {
                                addClass(secondBookVBoxStyle)
                                label(bookDetailViewModel.tags) {
                                    addClass(secondBookLabelStyle)
                                    icon(MaterialDesignIcon.TAG, "16px", color = "#f44336")
                                }

                                label(bookDetailViewModel.authors) {
                                    addClass(secondBookLabelStyle)
                                    icon(MaterialDesignIcon.AV_TIMER, size = "16px", color = "#03a9f4")
                                }

                                label(bookDetailViewModel.publisher) {
                                    addClass(secondBookLabelStyle)
                                    icon(MaterialDesignIcon.BANK, size = "16px", color = "#8bc34a")
                                }
                            }

                            vbox {
                                addClass(bookSummaryVBoxStyle)
                                label("简介") {
                                    addClass(bookSummaryIconLabelStyle)
                                    icon(MaterialDesignIcon.GOOGLE_CIRCLES, size = "16px", color = "#4527a0")
                                }

                                label(bookDetailViewModel.summary) {
                                    addClass(bookSummaryLabelStyle)
                                }
                            }

                            hbox {
                                addClass(loveButtonHBoxStyle)
                                jfxbutton {
                                    addClass(loveButtonStyle)
                                    if (bookDetailViewModel.like.value) {
                                        icon(MaterialDesignIcon.HEART, size = "30px", color = "red")
                                    } else {
                                        icon(MaterialDesignIcon.HEART, size = "30px")
                                    }
                                    action {
                                        loveClick()
                                    }
                                }
                            }
                        }
                    }.show()
                }
            }

            whenDocked {
                runAsyncWithProgress {
                    bookApi.showAllBooks(page = 0)
                } ui {
                    if (it) {
                        asyncItems {
                            pageViewModel.bookModelList.value
                        }
                    }
                }
            }

            whenRefreshed {
                asyncItems {
                    pageViewModel.bookModelList.value
                }
            }
        }

        pagination {
            pageCountProperty().bind(pageViewModel.allPage)
            currentPageIndexProperty().bindBidirectional(pageViewModel.nowPage)
            currentPageIndexProperty().addListener { _, oldValue, newValue ->
                run {
                    if (oldValue != newValue) {
                        runAsync {
                            bookApi.showAllBooks(page = newValue)
                        } ui {
                            myJfxListView.apply { onRefresh() }
                        }
                    }
                }
            }
        }
    }

    private fun Button.loveClick() {
        val love = bookDetailViewModel.like.value
        runAsync {
            if (love) {
                //寂寞,如果已经标记不需要再添加
                false
            } else {
                fondApi.addFond()
            }
        } ui {
            if (it) {
                if (love) {
                    //同样寂寞
                } else {
                    icon(MaterialDesignIcon.HEART, size = "30px", color = "red")
                }
            }
        }
    }

    //不用非常蛋疼的每次回车都会出现的。。。。
    private fun <T> ListView<T>.onUserSelect(clickCount: Int = 2, action: (T) -> Unit) {
        addEventFilter(MouseEvent.MOUSE_CLICKED) { event ->
            val selectedItem = this.selectedItem
            if (event.clickCount == clickCount && selectedItem != null && event.target.isInsideRow())
                action(selectedItem)
        }
    }
}
