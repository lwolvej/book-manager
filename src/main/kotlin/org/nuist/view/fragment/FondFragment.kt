package org.nuist.view.fragment

import com.jfoenix.controls.JFXDialog
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import org.nuist.api.BookDetailApi
import org.nuist.api.FondApi
import org.nuist.model.FondModel
import org.nuist.view.DashboardView
import org.nuist.view.controls.icon
import org.nuist.view.controls.jfxbutton
import org.nuist.view.controls.jfxlistview
import org.nuist.view.styles.FondFragmentStyle.Companion.fondBookDetailDialogStyle
import org.nuist.view.styles.FondFragmentStyle.Companion.fondBookNameLabelStyle
import org.nuist.view.styles.FondFragmentStyle.Companion.fondBookNameStyle
import org.nuist.view.styles.FondFragmentStyle.Companion.fondBookSummaryIconLabelStyle
import org.nuist.view.styles.FondFragmentStyle.Companion.fondBookSummaryLabelStyle
import org.nuist.view.styles.FondFragmentStyle.Companion.fondBookSummaryVBoxStyle
import org.nuist.view.styles.FondFragmentStyle.Companion.fondDeleteButtonStyle
import org.nuist.view.styles.FondFragmentStyle.Companion.fondDialogImageStyle
import org.nuist.view.styles.FondFragmentStyle.Companion.fondFirstHBoxStyle
import org.nuist.view.styles.FondFragmentStyle.Companion.fondFirstVBoxStyle
import org.nuist.view.styles.FondFragmentStyle.Companion.fondHBoxStyle
import org.nuist.view.styles.FondFragmentStyle.Companion.fondScoreLabelStyle
import org.nuist.view.styles.FondFragmentStyle.Companion.fondScoreStyle
import org.nuist.view.styles.FondFragmentStyle.Companion.fondSecondBookLabelStyle
import org.nuist.view.styles.FondFragmentStyle.Companion.fondSecondBookVBoxStyle
import org.nuist.viewmodel.BookDetailViewModel
import tornadofx.*

class FondFragment : Fragment() {

    private val fondApi: FondApi by inject()

    private val bookDetailApi: BookDetailApi by inject()

    private val bookDetailViewModel: BookDetailViewModel by inject()

    override val root = pane {
        jfxlistview<FondModel> {

            isExpanded = true
            cellFormat {
                graphic = hbox {
                    addClass(fondHBoxStyle)
                    label(it.bookName) {
                        addClass(fondBookNameStyle)
                        icon(MaterialDesignIcon.BOOK_MULTIPLE, size = "35px", color = "#26a69a")
                    }

                    label(it.score.toString()) {
                        addClass(fondScoreStyle)
                        icon(MaterialDesignIcon.FLASH, size = "35px", color = "#ffd600")
                    }

                    jfxbutton("删除") {
                        addClass(fondDeleteButtonStyle)
                        action {
                            val select = it
                            runAsync {
                                fondApi.removeFond(fondId = select.id)
                            } ui {
                                if (it) {
                                    items.remove(select)
                                }
                            }
                        }
                    }
                }
            }

            onUserSelect {
                runAsync {
                    bookDetailApi.showOneBook(bookId = it.bookId)
                } ui {
                    JFXDialog().apply {
                        JFXDialog().apply {
                            transitionType = JFXDialog.DialogTransition.CENTER
                            dialogContainer = find(DashboardView::class).root
                            content = vbox {
                                addClass(fondBookDetailDialogStyle)
                                hbox {
                                    addClass(fondFirstHBoxStyle)
                                    imageview(bookDetailViewModel.data) {
                                        addClass(fondDialogImageStyle)
                                        fitWidth = 150.0
                                        fitHeight = 210.0
                                        isPreserveRatio = true
                                    }

                                    vbox {
                                        addClass(fondFirstVBoxStyle)
                                        label(bookDetailViewModel.bookName) {
                                            addClass(fondBookNameLabelStyle)
                                            icon(MaterialDesignIcon.BOOK, size = "26px", color = "#009688")
                                        }

                                        label(bookDetailViewModel.score) {
                                            addClass(fondScoreLabelStyle)
                                            icon(MaterialDesignIcon.FLASH, size = "22px", color = "#f9a825")
                                        }
                                    }
                                }

                                vbox {
                                    addClass(fondSecondBookVBoxStyle)
                                    label(bookDetailViewModel.tags) {
                                        addClass(fondSecondBookLabelStyle)
                                        icon(MaterialDesignIcon.TAG, "16px", color = "#f44336")
                                    }

                                    label(bookDetailViewModel.authors) {
                                        addClass(fondSecondBookLabelStyle)
                                        icon(MaterialDesignIcon.AV_TIMER, size = "16px", color = "#03a9f4")
                                    }

                                    label(bookDetailViewModel.publisher) {
                                        addClass(fondSecondBookLabelStyle)
                                        icon(MaterialDesignIcon.BANK, size = "16px", color = "#8bc34a")
                                    }
                                }

                                vbox {
                                    addClass(fondBookSummaryVBoxStyle)
                                    label("简介") {
                                        addClass(fondBookSummaryIconLabelStyle)
                                        icon(MaterialDesignIcon.GOOGLE_CIRCLES, size = "16px", color = "#4527a0")
                                    }

                                    label(bookDetailViewModel.summary) {
                                        addClass(fondBookSummaryLabelStyle)
                                    }
                                }
                            }
                        }.show()
                    }
                }
            }

            whenDocked {
                runAsyncWithProgress {
                    fondApi.showAllFond()
                } ui {
                    asyncItems { it }
                }
            }
        }
    }
}
