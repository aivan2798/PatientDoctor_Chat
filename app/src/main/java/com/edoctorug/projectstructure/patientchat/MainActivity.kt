package com.edoctorug.projectstructure.patientchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.edoctorug.projectstructure.patientchat.ui.theme.PatientChatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            /*
            PatientChatTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    //Greeting("Android")
                    Box()
                    {
                       Text("Hello User:")
                    }
                    patient_doctor_chat.MainUI()
                }
            }
            */
            HomeUI()
        }
    }
}

@Composable
fun PatientChatUI()
{

}

fun login()
{

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeUI()
{
    var login = remember{ mutableStateOf(false) }
    var name by remember{ mutableStateOf("") }
    var pass by remember{ mutableStateOf("") }

    if (login.value==false) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Brush.linearGradient(
                                                    colors = listOf(Color.Black,Color(0, 255, 136),Color.Black),
                                                    start = Offset.Zero,
                                                    end = Offset.Infinite,
                                                    tileMode = TileMode.Mirror
                                                )
                            )
        )
        {
            Column(modifier = Modifier
                .align(alignment = Alignment.Center)
                .background(Color.Black))
            {
                Text("Please Write Your Name And User Type",
                    modifier=Modifier.padding(5.dp),style = TextStyle(
                    fontSize = TextUnit(10f, TextUnitType.Sp),
                    fontStyle = FontStyle.Normal,
                    color = Color.White,
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = TextUnit(2f, TextUnitType.Sp)))
                TextField(
                    value = name,
                    label = {Text("your username",
                        style=TextStyle(
                            fontSize = TextUnit(12f, TextUnitType.Sp),
                            fontStyle = FontStyle.Normal,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = TextUnit(2f, TextUnitType.Sp)
                        ))},
                    onValueChange = { name = it },
                    modifier = Modifier
                        .width(230.dp).padding(start=5.dp).align(alignment = Alignment.CenterHorizontally),
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.AccountCircle,
                            contentDescription = "send mesage"
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = Color.Blue,
                        focusedIndicatorColor = Color.White,
                        cursorColor = Color.Black,
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp),
                    textStyle = TextStyle(
                        fontSize = TextUnit(10f, TextUnitType.Sp),
                        fontStyle = FontStyle.Normal,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = TextUnit(2f, TextUnitType.Sp)
                    )

                )

                TextField(
                    value = pass,
                    label = {Text("your password",
                             style=TextStyle(
                                 fontSize = TextUnit(12f, TextUnitType.Sp),
                                 fontStyle = FontStyle.Normal,
                                 fontFamily = FontFamily.Monospace,
                                 letterSpacing = TextUnit(2f, TextUnitType.Sp)
                             ))},
                    onValueChange = { pass = it },
                    modifier = Modifier
                        .width(230.dp).padding(start=5.dp).align(alignment = Alignment.CenterHorizontally),
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.AccountCircle,
                            contentDescription = "send mesage"
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = Color.Blue,
                        focusedIndicatorColor = Color.White,
                        cursorColor = Color.Black,
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp),
                    textStyle = TextStyle(
                        fontSize = TextUnit(10f, TextUnitType.Sp),
                        fontStyle = FontStyle.Normal,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = TextUnit(2f, TextUnitType.Sp)
                    )

                )

                Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
                {
                    Button(
                                colors=ButtonDefaults.buttonColors(
                                                                    containerColor = Color.Red,
                                                                    disabledContainerColor = Color.Blue
                                                                   ),

                                onClick = { /*TODO*/login.value=true }) {
                        Icon(Icons.Outlined.Person, contentDescription = "")
                        Text("Patient", style = TextStyle(
                            fontSize = TextUnit(10f, TextUnitType.Sp),
                            fontStyle = FontStyle.Normal,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = TextUnit(2f, TextUnitType.Sp)
                        ))
                    }
                    Button(
                        colors=ButtonDefaults.buttonColors(
                            containerColor = Color.Red,
                            disabledContainerColor = Color.Blue
                        ),

                        onClick = { /*TODO*/login.value=true }) {
                        Icon(Icons.Outlined.Person, contentDescription = "")
                        Text("Doctor", style = TextStyle(
                            fontSize = TextUnit(10f, TextUnitType.Sp),
                            fontStyle = FontStyle.Normal,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = TextUnit(2f, TextUnitType.Sp)
                        ))
                    }
                }
            }
        }
    }
    else
    {
        var patient_doctor_chat = PatientDoctorChat(name, "Anywar")
        patient_doctor_chat.MainUI(login)
    }
}





@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PatientChatTheme {
        Greeting("Android")
    }
}