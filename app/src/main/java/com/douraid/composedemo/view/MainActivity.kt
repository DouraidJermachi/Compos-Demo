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
import com.douraid.composedemo.model.StudiesListState
import com.douraid.composedemo.model.StudyDetailsState
import com.douraid.composedemo.ui.theme.ComposeDemoTheme
import com.douraid.composedemo.view.details_screen.StudyDetailsScreen
import com.douraid.composedemo.view.home_screen.StudiesListScreen
import com.douraid.composedemo.viewmodel.CaseStudiesViewModel
import com.douraid.composedemo.viewmodel.StudiesListViewModelFactory
import com.douraid.composedemo.viewmodel.StudyDetailsViewModel
import com.douraid.composedemo.viewmodel.StudyDetailsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    internal lateinit var studiesListViewModelFactory: StudiesListViewModelFactory
    private val caseStudiesViewModel: CaseStudiesViewModel by viewModels {
        studiesListViewModelFactory
    }

    @Inject
    internal lateinit var studyDetailsViewModelFactory: StudyDetailsViewModelFactory
    private val studyDetailsViewModel: StudyDetailsViewModel by viewModels {
        studyDetailsViewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {

                DefaultSurface {
                    StudiesListWithViewModel(caseStudiesViewModel)
                }

                //details screen
//                DefaultSurface {
//                    StudyDetailsWithViewModel(studyDetailsViewModel)
//                }

                //navigation
//                val navController = rememberNavController()
//
//                NavHost(
//                    navController = navController,
//                    startDestination = "home"
//                ) {
//                    composable(route = "home") {
//                        Surface(color = MaterialTheme.colors.background) {
//                            StudiesListWithViewModel(caseStudiesViewModel, navController)
//                        }
//                    }
//                    composable(route = "full") {
//                        Surface(color = MaterialTheme.colors.background) {
//                            Text(text = "Case Study full screen")
//                        }
//                    }
//                    composable(route = "search") {
//                        Surface(color = MaterialTheme.colors.background) {
//                            Text(text = "Search results screen")
//                        }
//                    }
//
//                }

            }
        }
    }
}

// A surface container using the 'background' color from the theme
@Composable
fun DefaultSurface(content: @Composable () -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        content.invoke()
    }
}

@Composable
fun StudiesListWithViewModel(
    caseStudiesViewModel: CaseStudiesViewModel
) {
    val currentState: State<StudiesListState> = caseStudiesViewModel.viewState.collectAsState()
    when (val result = currentState.value) {
        is StudiesListState.Loaded -> StudiesListScreen(
            caseStudies = result.caseStudies
        )
        is StudiesListState.Loading -> Text(text = "Loading...")
        else -> Text(text = " Hello there is an error")
        //todo handle other states
    }
}

@Composable
fun StudyDetailsWithViewModel(
    studyViewModel: StudyDetailsViewModel
) {
    val currentState: State<StudyDetailsState> = studyViewModel.viewState.collectAsState()
    when (val result = currentState.value) {
        is StudyDetailsState.Loaded -> StudyDetailsScreen(
            caseStudy = result.caseStudy,
            caseStudyDetails = result.caseStudyDetails
        )
        is StudyDetailsState.Loading -> Text(text = "Loading...")
        else -> Text(
            text = " Hello there is an error with details screen",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onError
        )
        //todo handle other states
    }
}