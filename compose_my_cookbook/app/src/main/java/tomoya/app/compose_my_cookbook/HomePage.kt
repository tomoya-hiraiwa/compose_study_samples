package tomoya.app.compose_my_cookbook

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier = Modifier,onClick: (RouteItem) -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text("Compose CookBook")
                },
                actions = {
                    IconButton(onClick = {/*write action*/}) {
                        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                    }
                }
            )
        }
    ) { paddingValue ->
        LazyColumn(contentPadding = paddingValue) {
            items(DemoData.uiList){item ->
                HomeListItem(item,{onClick(it)})
            }
        }
    }
}

@Composable
fun HomeListItem(item: RouteItem,onClick: (RouteItem) -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = {onClick(item)}, modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Text(item.name, style = MaterialTheme.typography.titleLarge,modifier = Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePagePreview() {
    HomePage(onClick = {})
}