package com.douraid.composedemo.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.douraid.composedemo.model.UsersListState
import com.douraid.composedemo.ui.theme.ComposeDemoTheme
import com.douraid.composedemo.viewmodel.UsersListViewModel
import com.douraid.composedemo.viewmodel.UsersListViewModelFactory

class MainActivity : ComponentActivity() {
    private val usersListViewModel: UsersListViewModel by viewModels{
        UsersListViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    GreetingWithViewModel(usersListViewModel)
                }
            }
        }
    }
}

@Composable
fun GreetingWithViewModel(usersListViewModel: UsersListViewModel){
    val currentState:State<UsersListState> = usersListViewModel.viewState.collectAsState()
    Greeting(name = currentState.value.users.first().firstName)
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeDemoTheme {
        Greeting("Android")
    }
}