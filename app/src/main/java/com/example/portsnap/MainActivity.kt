package com.example.portsnap

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.portsnap.ui.theme.PortSnapTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortSnapTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreatePortSnap()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreatePortSnap() {
    val mContext = LocalContext.current
    val buttonClickState = remember {
        mutableStateOf(false)
    }

    Surface(modifier = Modifier.fillMaxSize()) {

        Card(modifier = Modifier
            .fillMaxSize()
            .padding(7.dp),
            shape = RoundedCornerShape(corner = CornerSize(10.dp))
        ) {

            Column(modifier = Modifier
                .height(310.dp)
                .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                CreateImageProfile()

                AboutInfo()

                Divider(modifier = Modifier
                    .padding(0.dp, 12.dp)
                    .background(Color(0xFFFFE51A)))

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0XFF0F9D58)),
                    shape = RoundedCornerShape(5.dp),
                    onClick = {
                        buttonClickState.value = !buttonClickState.value
                    })
                {
                    Text(text = "Portfolio",
                        color = Color.White,
                        style = MaterialTheme.typography.titleSmall)
                }
            }
            if (buttonClickState.value) {
                Content()
                Toast.makeText(mContext, "Portfolio shown!", Toast.LENGTH_LONG).show()
            } else {
                Box {}
            }
        }
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(140.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
private fun AboutInfo() {
    Column(modifier = Modifier.padding(0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Sayan Bera",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary)

        Text(text = "Aspiring Android Developer",
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.titleSmall)

        Text(text = "Email: prolweo@gmail.com",
            style = MaterialTheme.typography.bodySmall)
    }
}


@Preview(showBackground = true)
@Composable
private fun Content() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp)) {

        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(3.dp),
            shape = RoundedCornerShape(corner = CornerSize(7.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Portfolio(data = listOf<String>(
                "Project 1", "Project 2",
                "Project 3", "Project 4",
                "Project 5", "Project 6",
                "Project 7", "Project 8",
                "Project 9")
            )
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data) { item ->
            Surface(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
                shape = RectangleShape,
                border = BorderStroke(0.5.dp, Color.LightGray),
                shadowElevation = 4.dp) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                ) {

                    CreateImageProfile(modifier = Modifier.size(100.dp))

                    Column(modifier = Modifier.padding(7.dp),
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "A great Project..",
                            style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}