package com.example.microsoftdocsapp

class DocsModel (val productName: String = ""){
    override fun toString(): String {
        return "DocsModel()"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        return javaClass == other?.javaClass
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    fun GetProductName() : String{
        return productName;
    }
}