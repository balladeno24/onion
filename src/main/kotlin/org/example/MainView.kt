package org.example

import com.vaadin.flow.component.Html
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.H1
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route

@Route("")
class MainView : VerticalLayout() {

    init {
        // 1️⃣ Inject raw CSS directly into the HTML head
        val css = """
            <style>
                body {
                    background-color: #f5f5f5;
                    margin: 0;
                    font-family: Arial, sans-serif;
                }

                .container {
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    justify-content: center;
                    height: 100vh;
                }

                h1 {
                    font-size: 40px;
                    color: #333;
                    margin-bottom: 30px;
                }

                .row {
                    display: flex;
                    justify-content: center;
                    margin: 5px 0;
                }

                .digit {
                    width: 80px;
                    height: 80px;
                    margin: 8px;
                    font-size: 24px;
                    border-radius: 10px;
                    background-color: #007BFF;
                    color: white;
                    border: none;
                    cursor: pointer;
                    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                    transition: background-color 0.2s;
                }

                .digit:hover {
                    background-color: #0056b3;
                }
            </style>
        """.trimIndent()

        add(Html(css)) // adds the <style> element directly into the DOM

        // 2️⃣ Create outer container
        val container = Div()
        container.addClassName("container")

        // 3️⃣ Add title
        val title = H1("Phoned")

        // 4️⃣ Create buttons (0–9)
        val buttons = (1..99).map { Button(it.toString()) } + Button("0")
        buttons.forEach { it.addClassName("digit") }

        // 5️⃣ Build rows
        val row1 = Div(buttons[0], buttons[1], buttons[2])
        val row2 = Div(buttons[3], buttons[4], buttons[5])
        val row3 = Div(buttons[6], buttons[7], buttons[8])
        val row4 = Div(buttons[9])

        listOf(row1, row2, row3, row4).forEach { it.addClassName("row") }

        // 6️⃣ Add everything to container and then to layout
        container.add(title, row1, row2, row3, row4)
        add(container)
    }
}
