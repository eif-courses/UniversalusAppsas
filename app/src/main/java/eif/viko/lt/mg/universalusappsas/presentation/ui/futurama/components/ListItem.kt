package eif.viko.lt.mg.universalusappsas.presentation.ui.futurama.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import eif.viko.lt.mg.universalusappsas.domain.model.Futurama




@Composable
fun ListItem(modifier: Modifier = Modifier,
             items: List<Futurama>,
             itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
             onItemClick: (Futurama) -> Unit) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(item) }
                .padding(16.dp)
            ) {

                AsyncImage(
                    modifier = Modifier.width(64.dp),
                    model = item.PicUrl,
                    contentDescription = item.Name,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.Name,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f)
                )
            }
            Divider()
        }
    }
}