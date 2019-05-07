package org.nuist

import kotlinx.coroutines.runBlocking
import tornadofx.launch


fun main(args: Array<String>) = runBlocking {
    launch<Application>(args)
}
//
//class Test {
//
//    fun print() {
//        println(javaClass.classLoader.getResource("img/icon.png").file)
//    }
//}
//
//fun main() {
//    Test().print()
//}