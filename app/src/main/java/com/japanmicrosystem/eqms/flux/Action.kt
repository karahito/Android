package com.japanmicrosystem.eqms.flux

interface Action<out T> {
    val data:T
}