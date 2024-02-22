package com.example.microsoftdocsapp

data class DocsModel (val productName: String){
    override fun toString(): String {
        return "DocsModel for $productName"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        return javaClass == other?.javaClass
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}