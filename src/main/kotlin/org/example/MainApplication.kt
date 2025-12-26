package org.example

import com.vaadin.flow.spring.annotation.EnableVaadin
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableVaadin
open class MainApplication

fun main(args: Array<String>) {
    runApplication<MainApplication>(*args)
}
