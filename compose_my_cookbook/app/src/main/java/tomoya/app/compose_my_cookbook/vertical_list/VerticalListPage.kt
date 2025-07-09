package tomoya.app.compose_my_cookbook.vertical_list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tomoya.app.compose_my_cookbook.DemoData
import tomoya.app.compose_my_cookbook.ui.theme.Compose_my_cookbookTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerticalListPage(navController: NavController,modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Vertical List")
                },
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(Icons.AutoMirrored.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { paddingValues ->
        VerticalListView(modifier = Modifier.padding(paddingValues))
    }
}

@Composable
fun VerticalListView(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(DemoData.itemList){ item ->
            if ((item.id % 3) == 0){
                SmallVerticalListItem(item = item)
            }
            else {
                VerticalListItem(item = item)
            }
            ListItemDivider()
        }
    }
}

@Composable
fun ListItemDivider(modifier: Modifier = Modifier) {
    HorizontalDivider(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
    )
}

@Preview
@Composable
private fun VerticalListPreview() {
    Compose_my_cookbookTheme {
        VerticalListPage(navController = rememberNavController())
    }
}