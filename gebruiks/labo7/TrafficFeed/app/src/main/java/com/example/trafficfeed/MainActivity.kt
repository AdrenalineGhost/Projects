package com.example.trafficfeed


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trafficfeed.data.DataSource
import com.example.trafficfeed.model.TrafficNotification
import com.example.trafficfeed.ui.theme.TrafficFeedTheme
import com.example.trafficfeed.ui.theme.Typography
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.text.TextStyle


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val notifications: List<TrafficNotification> =
            DataSource().loadTrafficNotifications(applicationContext)

        setContent {
            TrafficFeedTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        DefaultAppBar()
                        TrafficNotificationList(list = notifications)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TotalDisplay() {
    val notifications: List<TrafficNotification> =
        DataSource().loadTrafficNotifications()


    TrafficFeedTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column {
                DefaultAppBar()
                TrafficNotificationList(list = notifications)
            }
        }
    }

}

@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    search: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = 4.dp,
        color = MaterialTheme.colors.surface
    )
    {
        TextField(modifier = modifier
            .fillMaxWidth(),
            value = text,

            onValueChange = {
                onTextChange(it)
                search()
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.search_here),
                    style = MaterialTheme.typography.body1
                )
            },
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = modifier,
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(R.string.search_icon_description),
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        onTextChange("")
                        onCloseClicked()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(R.string.close_icon_description),
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {}
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = MaterialTheme.colors.onSurface
            ),
            textStyle = MaterialTheme.typography.body1
        )
    }
}

//@Composable
//fun DefaultAppBar(modifier: Modifier = Modifier) {
//    var entered = ""
//    var clicked = false
//    TopAppBar(
//        modifier = modifier,
//        backgroundColor = MaterialTheme.colors.surface,
//        elevation = 10.dp) {
//        Text(text = "TrafficNotifications", style = Typography.h1)
//        IconButton(onClick = {
//            clicked = true
//        }) {
//            Icon(imageVector = Icons.Filled.Search, contentDescription = "SearchIcon")
//        }
//    }
//}


@Composable
fun DefaultAppBar(modifier: Modifier = Modifier) {
    var entered by remember { mutableStateOf("") }
    var clicked by remember { mutableStateOf(false) }

    TopAppBar(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {


            if (clicked) {
                SearchAppBar(
                    modifier = Modifier.height(60.dp),
                    text = entered,
                    onTextChange = { entered = it },
                    onCloseClicked = { clicked = false },
                    search = { /* Implement your search logic here */ }
                )
            } else {
                Text(text = stringResource(R.string.title), style = Typography.h1)
                IconButton(onClick = {
                    clicked = true
                }) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = stringResource(R.string.search_icon_description))
                }

            }
        }

    }
}

@Composable
fun TrafficNotificationCard(item : TrafficNotification, modifier : Modifier = Modifier) {
    val icon = when (item.name){
            "Waze Alerts" -> R.drawable.waze
            "Coyote Alerts" -> R.drawable.coyote
            else -> R.drawable.nmbs
        }
    var expanded by remember{ mutableStateOf(false) }
    Card(modifier = Modifier.padding(8.dp) , elevation = 4.dp){
        Column{
            Row(horizontalArrangement = Arrangement.Absolute.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row (verticalAlignment = Alignment.CenterVertically){ // icon and name
                    TrafficNotificationIcon(notificationIcon = icon)
                    Text(text = item.name, style = Typography.h2)
                }
                Spacer(modifier = Modifier.weight(1f))
                Box( // l, l and IconButton
                    contentAlignment = CenterEnd,
                    modifier = modifier
                        .fillMaxHeight()
                        .padding(2.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column(horizontalAlignment = Alignment.End) {
                            Text(text = item.latitude.toString())
                            Text(text = item.longitude.toString())
                        }
                        IconButton(onClick = { expanded = !expanded }) {
                            Icon(
                                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                                tint = MaterialTheme.colors.secondary,
                                contentDescription = ""
                            )
                        }
                    }
                }
            }
            if(expanded){
                Text(text = item.message, modifier = Modifier.padding(6.dp))
            }
        }
    }
}



@Composable
fun TrafficNotificationIcon(@DrawableRes notificationIcon: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .size(64.dp)
            .padding(8.dp),
        contentScale = ContentScale.FillWidth,
        painter = painterResource(notificationIcon),
        contentDescription = null
    )
}

@Composable
fun TrafficNotificationList(list : List<TrafficNotification>) {
    LazyColumn{
        items(list){
            TrafficNotificationCard(item = it, modifier = Modifier.fillMaxWidth(1f))
        }
    }
}