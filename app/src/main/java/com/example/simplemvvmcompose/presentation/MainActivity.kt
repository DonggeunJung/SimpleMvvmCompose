package com.example.simplemvvmcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.simplemvvmcompose.data.User
import com.example.simplemvvmcompose.ui.theme.Purple80
import com.example.simplemvvmcompose.ui.theme.PurpleGrey40
import com.example.simplemvvmcompose.ui.theme.PurpleGrey80
import com.example.simplemvvmcompose.ui.theme.SimpleMvvmComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModel : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleMvvmComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        user = viewModel.user.value,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        viewModel.reqUser()
    }
}

@Composable
fun Greeting(user: User, modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize().background(color = PurpleGrey80)) {
        val (header, mainArea, footer) = createRefs()

        Text(text = user.name, color = PurpleGrey40, modifier = modifier.fillMaxWidth().padding(20.dp)
            .constrainAs(header) { top.linkTo(parent.top) }
        )
        Text(text = user.location, color = PurpleGrey40, modifier = modifier.fillMaxSize().padding(20.dp)
            .constrainAs(mainArea) { top.linkTo(header.bottom)
            bottom.linkTo(footer.top)
            height = Dimension.fillToConstraints}
        )
        Text(text = user.bio, color = PurpleGrey40, modifier = modifier.fillMaxWidth().padding(20.dp)
            .constrainAs(footer) { bottom.linkTo(parent.bottom) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleMvvmComposeTheme {
        Greeting(User("Name", "Location", "Description"))
    }
}