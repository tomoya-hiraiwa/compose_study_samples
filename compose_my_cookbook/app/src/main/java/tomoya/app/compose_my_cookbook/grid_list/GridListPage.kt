package tomoya.app.compose_my_cookbook.grid_list

import android.widget.Space
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tomoya.app.compose_my_cookbook.DemoData
import tomoya.app.compose_my_cookbook.ui.theme.Compose_my_cookbookTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GridListPage(navController: NavController,modifier: Modifier = Modifier) {
    var isVertical by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Grid List") },
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(Icons.AutoMirrored.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Row(modifier.fillMaxWidth().padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "GridList Orientation vertical/horizontal")
                Switch(checked = isVertical, onCheckedChange = {isVertical = it},modifier = Modifier.padding(start = 20.dp))
            }
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                if (!isVertical){
                    VerticalGridView()
                }
                else {
                    HorizontalGridView()
                }
            }
        }
    }
}

@Composable
fun VerticalGridView(modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),modifier = modifier) {
        items(DemoData.itemList) {item ->
            GridListItem(item)
        }
    }
}

@Composable
fun HorizontalGridView(modifier: Modifier = Modifier) {
    LazyHorizontalGrid (rows = GridCells.Fixed(3),modifier = modifier) {
        items(DemoData.itemList) {item ->
            GridListItem(item)
        }
    }
}


@Preview
@Composable
private fun GridListPagePreview() {
    Compose_my_cookbookTheme {
        GridListPage(navController = rememberNavController());
    }
}