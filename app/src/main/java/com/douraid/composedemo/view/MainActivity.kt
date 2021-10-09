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
import com.douraid.composedemo.model.StudiesListState
import com.douraid.composedemo.ui.theme.ComposeDemoTheme
import com.douraid.composedemo.viewmodel.CaseStudiesViewModel
import com.douraid.composedemo.viewmodel.StudiesListViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    internal lateinit var studiesListViewModelFactory: StudiesListViewModelFactory

    private val caseStudiesViewModel: CaseStudiesViewModel by viewModels {
        studiesListViewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    GreetingWithViewModel(caseStudiesViewModel)
                }
            }
        }
    }
}

@Composable
fun GreetingWithViewModel(caseStudiesViewModel: CaseStudiesViewModel) {
    val currentState: State<StudiesListState> = caseStudiesViewModel.viewState.collectAsState()
    when (val result = currentState.value) {
        is StudiesListState.Loaded -> Greeting(name = result.caseStudies.first().title)
        else -> Greeting(name = "error")
    }

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