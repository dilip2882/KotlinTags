package com.dilip.kotlintags

/**
 * Object containing HTML element definitions for a type-safe HTML DSL
 */
object KotlinTags {

    /**
     * Base interface for all HTML elements in the DSL
     */
    sealed interface HtmlElement

    /**
     * Represents an HTML div element
     * @property children List of child elements contained within this div
     * @property id Optional ID attribute for the div
     * @property classNames Optional CSS classes for the div
     */
    data class Div(
        val children: List<HtmlElement>,
        val id: String? = null,
        val classNames: String? = null
    ) {
        /**
         * Converts the Div element to its HTML string representation
         * @return String containing the HTML markup for this div and its children
         */
        override fun toString(): String {
            val idAttr = id?.let { " id=\"$it\"" } ?: ""
            val classAttr = classNames?.let { " class=\"$it\"" } ?: ""
            val innerHtml = children.joinToString("\n")
            return "<div$idAttr$classAttr>$innerHtml</div>"
        }
    }
}