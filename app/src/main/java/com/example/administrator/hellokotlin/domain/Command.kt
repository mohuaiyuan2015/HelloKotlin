package com.example.administrator.hellokotlin.domain

public interface Command<T> {
    fun execute(): T
}