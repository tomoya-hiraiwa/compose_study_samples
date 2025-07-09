package tomoya.app.compose_my_cookbook.vertical_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tomoya.app.compose_my_cookbook.DemoData
import tomoya.app.compose_my_cookbook.Item
import tomoya.app.compose_my_cookbook.ui.theme.Compose_my_cookbookTheme

@Composable
fun VerticalListItem(item: Item, modifier: Modifier = Modifier) {
    val typography = MaterialTheme.typography
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        val imageModifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.medium)
        Image(
            painter = painterResource(item.imageId),
            modifier = imageModifier,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(16.dp))
        Text(text = item.title, style = typography.titleLarge)
        Text(text = item.subtitle, style = typography.bodyMedium)
        Text(text = item.source, style = typography.titleSmall)
    }
}

@Composable
fun SmallVerticalListItem(item: Item, modifier: Modifier = Modifier){
    val typography = MaterialTheme.typography
    Row(modifier = Modifier
        .clickable(onClick = {})
        .padding(16.dp)) {
        ItemImage(item, Modifier.padding(end = 16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(item.title, style = typography.titleMedium)
            Text(item.subtitle, style = typography.bodyMedium)
        }
        FavIcon(modifier)
    }
}

@Composable
fun ItemImage(item: Item, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(item.imageId),
        modifier = modifier
            .size(100.dp, 80.dp)
            .clip(MaterialTheme.shapes.medium),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun FavIcon(modifier: Modifier = Modifier) {
     var isFavorite by remember { mutableStateOf(true) }
    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = {isFavorite = !isFavorite}
    ) {
        if (isFavorite){
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = null, modifier = modifier)
        } else {
            Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null, modifier = modifier)
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun VerticalListItemPreview() {
    val item = DemoData.item
    Compose_my_cookbookTheme { VerticalListItem(item) }
}

@Preview(showBackground = true)
@Composable
fun SmallVerticalListItemPreview(modifier: Modifier = Modifier) {
    val item = DemoData.item
    Compose_my_cookbookTheme { SmallVerticalListItem(item) }
}