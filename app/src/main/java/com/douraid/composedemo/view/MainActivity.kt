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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.douraid.composedemo.api.dto.CaseStudy
import com.douraid.composedemo.model.StudiesListState
import com.douraid.composedemo.model.StudyDetailsState
import com.douraid.composedemo.ui.theme.ComposeDemoTheme
import com.douraid.composedemo.view.utils.reusable_views.CaseStudyStandardProgressBar
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

                val navController = rememberNavController()
                val caseStudiesNavigation = CaseStudiesNavigation(navController)

                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route
                ) {
                    composable(route = Screen.Home.route) {
                        DefaultSurface {
                            StudiesListWithViewModel(
                                caseStudiesNavigation.navigateToDetailsScreen,
                                caseStudiesViewModel
                            )
                        }
                    }
                    composable(
                        route = Screen.Details.route + "/{id}/{title}/{client}/{vertical}/{heroImageUrl}",
                        arguments = detailsScreenArguments
                    ) { navBackStackEntry ->

                        navBackStackEntry.getCaseStudy?.let { caseStudy ->
                            DefaultSurface {
                                StudyDetailsWithViewModel(
                                    studyDetailsViewModel,
                                    caseStudy
                                )
                            }
                        }
                    }
                    composable(route = "search") {
                        Surface(color = MaterialTheme.colors.background) {
                            Text(text = "Search results screen")
                        }
                    }

                }

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
    onCaseStudyClicked: (CaseStudy) -> Unit,
    caseStudiesViewModel: CaseStudiesViewModel
) {
    val currentState: State<StudiesListState> = caseStudiesViewModel.viewState.collectAsState()
    when (val result = currentState.value) {
        is StudiesListState.Loaded -> StudiesListScreen(
            onCaseStudyClicked = onCaseStudyClicked,
            caseStudies = result.caseStudies
        )
        is StudiesListState.Loading -> CaseStudyStandardProgressBar()
        else -> Text(text = " Hello there is an error")
        //todo handle other states
    }
}

@Composable
fun StudyDetailsWithViewModel(
    studyViewModel: StudyDetailsViewModel,
    selectedCaseStudy: CaseStudy
) {
    studyViewModel.loadStudyDetails(selectedCaseStudy)

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