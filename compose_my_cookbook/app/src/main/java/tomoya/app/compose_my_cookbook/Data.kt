package tomoya.app.compose_my_cookbook

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import tomoya.app.compose_my_cookbook.grid_list.GridListItem
import tomoya.app.compose_my_cookbook.grid_list.GridListPage
import tomoya.app.compose_my_cookbook.horizontal_list.HorizontalListPage
import tomoya.app.compose_my_cookbook.vertical_list.VerticalListPage

typealias NavComposable = @Composable (NavController) -> Unit


data class Item(
    val id: Int,
    val title: String,
    val subtitle: String,
    val imageId: Int,
    val source: String = "demo source"
)


data class RouteItem(
    val name: String,
    val route: String,
    val page: NavComposable
)


object DemoData {
    val item =
        Item(
            1,
            "Awesome List Item",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food6
        )

    val itemList =
        listOf(
            Item(
                1,
                "Fresh Vegges and Greens",
                "Very awesome list item has very awesome subtitle. This is bit long",
                R.drawable.food1
            ),
            Item(
                2,
                "Best blue berries",
                "Very awesome list item has very awesome subtitle. This is bit long",
                R.drawable.food2
            ),
            Item(
                3,
                "Cherries La Bloom",
                "Very awesome list item has very awesome subtitle. This is bit long",
                R.drawable.food3
            ),
            Item(
                4,
                "Fruits everyday",
                "Very awesome list item has very awesome subtitle. This is bit long",
                R.drawable.food4
            ),
            Item(
                5,
                "Sweet and sour",
                "Very awesome list item has very awesome subtitle. This is bit long",
                R.drawable.food5
            ),
            Item(
                6,
                "Pancakes for everyone",
                "Very awesome list item has very awesome subtitle. This is bit long",
                R.drawable.food6
            ),
            Item(
                7,
                "Cupcakes and sparkle",
                "Very awesome list item has very awesome subtitle. This is bit long",
                R.drawable.food7
            ),
            Item(
                8,
                "Best Burgers shop",
                "Very awesome list item has very awesome subtitle. This is bit long",
                R.drawable.food8
            ),
            Item(
                9,
                "Coffee of India",
                "Very awesome list item has very awesome subtitle. This is bit long",
                R.drawable.food9
            ),
            Item(
                10,
                "Pizza boy town",
                "Very awesome list item has very awesome subtitle. This is bit long",
                R.drawable.food10
            ),
            Item(
                11,
                "Burgers and Chips",
                "Very awesome list item has very awesome subtitle. This is bit long",
                R.drawable.food11
            ),
            Item(
                12,
                "Breads and butter",
                "Very awesome list item has very awesome subtitle. This is bit long",
                R.drawable.food12
            ),
            Item(
                13,
                "Cupcake factory",
                "Very awesome list item has very awesome subtitle. This is bit long",
                R.drawable.food13
            ),
            Item(
                14,
                "Breakfast paradise",
                "Very awesome list item has very awesome subtitle. This is bit long",
                R.drawable.food14
            ),
            Item(
                15,
                "Cake and Bake",
                "Very awesome list item has very awesome subtitle. This is bit long",
                R.drawable.food15
            ),
            Item(
                16,
                "Brunch and Stakes",
                "Very awesome list item has very awesome subtitle. This is bit long",
                R.drawable.food16
            )
        )

    val uiList = listOf<RouteItem>(
        RouteItem(
            "Vertical List",
            "verticalList",
            { navController -> VerticalListPage(navController) }),
        RouteItem("Horizontal List", "horizontalList", { navController ->
            HorizontalListPage(
                navController
            )
        }),
        RouteItem("Grid List", "gridList", { navController -> GridListPage(navController) })
    )
}