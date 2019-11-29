package bes.tehno.testlab.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun loadImageCircle(view: ImageView, url: String?) {
    Picasso.get()
        .load(url)
        .into(view)
}