package com.edoctorug.projectstructure.patientchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.edoctorug.projectstructure.patientchat.ui.theme.PatientChatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var patient_doctor_chat = PatientDoctorChat("Ivan", "Anywar")

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
            patient_doctor_chat.MainUI()
        }
    }
}

@Composable
fun PatientChatUI()
{

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