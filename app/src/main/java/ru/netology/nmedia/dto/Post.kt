package ru.netology.nmedia.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likedByMe: Boolean,
    val likes: Likes = Likes(0),
    val share: Share = Share (0)
)