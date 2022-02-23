package com.example.composephotoview

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.res.ResourcesCompat
import com.example.composephotoview.ui.theme.ComposePhotoViewTheme
import com.github.chrisbanes.photoview.PhotoView

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePhotoViewTheme {
                Column(modifier = Modifier.verticalScroll(rememberScrollState()).fillMaxSize()) {
                    AndroidView(
                        factory = { context ->
                            PhotoView(context).apply {
                                scaleType = ImageView.ScaleType.FIT_CENTER
                                val drawable = ResourcesCompat.getDrawable(
                                    resources,
                                    R.drawable.ic_launcher_foreground,
                                    context.theme
                                )
                                val background = ResourcesCompat.getDrawable(
                                    resources,
                                    R.drawable.ic_launcher_background,
                                    context.theme
                                )
                                setImageDrawable(drawable)
                                setBackground(background)
                            }
                        },
                        modifier = Modifier.height(400.dp).fillMaxWidth()
                    )
                    Text(
                        text = "A\nB\nC\nD\nE\nF",
                        fontSize = 60.sp,
                    )
                }
            }
        }
    }
}