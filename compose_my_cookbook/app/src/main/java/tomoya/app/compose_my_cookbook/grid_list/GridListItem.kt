package tomoya.app.compose_my_cookbook.grid_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tomoya.app.compose_my_cookbook.DemoData
import tomoya.app.compose_my_cookbook.Item
import tomoya.app.compose_my_cookbook.ui.theme.Compose_my_cookbookTheme

@Composable
fun GridListItem(item: Item,modifier: Modifier = Modifier) {
    Card(shape = MaterialTheme.shapes.medium, modifier = modifier.width(190.dp).height(220.dp).padding(8.dp)) {
        Column(modifier = Modifier.clickable(onClick = {})) {
            Image(
                painter = painterResource(item.imageId),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.height(80.dp).fillMaxWidth()
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 14.sp),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = item.subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = item.source,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GridListItemPreview() {
    val item = DemoData.item
    Compose_my_cookbookTheme {
        GridListItem(item)
    }
}