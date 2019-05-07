package org.nuist

import org.nuist.view.MainView
import org.nuist.view.styles.*
import tornadofx.App
import tornadofx.Rest

class Application : App(
    MainView::class,
    MainViewStyle::class,
    LoginFragmentStyle::class,
    RegisterFragmentStyle::class,
    DashboardStyle::class,
    AboutFragmentStyle::class,
    LibraryFragmentStyle::class,
    HomeFragmentStyle::class,
    FondFragmentStyle::class
) {

    private val rest: Rest by inject()

    init {
        rest.baseURI = "http://192.168.43.15:10086"

    }
}