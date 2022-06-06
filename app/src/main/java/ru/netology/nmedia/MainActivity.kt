package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.*
import ru.netology.nmedia.utils.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likedByMe = false
        )

        with(binding) {
            authorTextView.text = post.author
            publishedTextView.text = post.published
            contentTextView.text = post.content
            if (post.likedByMe) {
                icLikesImageButton.setImageResource(R.drawable.ic_baseline_favorite_24)
            }
            likesTextView.text = compressNumber(post.likes.count)

            root.setOnClickListener {
                Log.d("stuff", "stuff")
            }

            avatarImageView.setOnClickListener {
                Log.d("stuff", "avatar")
            }

            icLikesImageButton.setOnClickListener {
                Log.d("stuff", "like")
                post.likedByMe = !post.likedByMe
                icLikesImageButton.setImageResource(
                    if (post.likedByMe) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24
                )
                if (post.likedByMe) post.likes.count++ else post.likes.count--
                likesTextView.text = compressNumber(post.likes.count)
            }

            icShareImageButton.setOnClickListener {
                Log.d("stuff", "share")
                post.share.count++
                shareTextView.text = compressNumber(post.share.count)
            }
        }
    }
}