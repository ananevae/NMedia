package ru.netology.nmedia.utils

fun compressNumber(num: Long): String {
    if (num >= 1_100_000){
        return ("%.1f".format((num / 1_000_000).toDouble()) + "M")
    }
    else if (num >= 1_000_000){
        return ((num / 1_000_000).toString() + "M")
    }
    else if (num >= 10_000){
        return ((num / 10_000).toString() + "K")
    }
    else if (num >= 1_100){
        return ("%.1f".format((num / 1_000).toDouble()) + "K")
    }
    else if (num >= 1_000){
        return ("1K")
    }
    else return (num.toString())
}