package eif.viko.lt.mg.universalusappsas.presentation.ui.youtubevideo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import eif.viko.lt.mg.universalusappsas.domain.model.Video


@Composable
fun ListItem(
    modifier: Modifier = Modifier,
    items: List<Video>
) {
    val uriHandler = LocalUriHandler.current

    LazyColumn(modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    modifier = Modifier.weight(1f)
                )
                Divider()
                Text(
                    text = "Watch video",
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            uriHandler.openUri(item.url)
                        }
                )

            }
            Divider()
        }
    }
}