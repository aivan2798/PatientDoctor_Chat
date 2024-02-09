package com.edoctorug.projectstructure.patientchat

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.ColorStateListDrawable
import android.util.MutableBoolean
import androidx.activity.ComponentActivity
import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.twotone.AddCircle
import androidx.compose.material.icons.twotone.Close
import androidx.compose.material.icons.twotone.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

import com.edoctorug.projectstructure.patientchat.ChatModel
import kotlin.jvm.internal.Ref.BooleanRef

class PatientDoctorChat(apatient_name: String, adoctor_name: String)
{
    lateinit var this_patient_name: String
    lateinit var this_doctor_name: String

    init {
        this_patient_name = apatient_name
        this_doctor_name = adoctor_name
    }

    //@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

    fun updateChats(chat_value: String)
    {

    }
    @Composable
    fun MainUI(reset: MutableState<Boolean>)
    {
        var chats = remember{ mutableStateListOf<ChatModel>() }
        var scroll_state = rememberScrollState()
        Scaffold (
                    topBar={InAppBar(chats,reset)},
                    bottomBar = {MessageBox(chats,scroll_state)}

        )
        {innerPadding->Surface(
                                color= Color.Gray,
                                modifier = Modifier
                                    .padding(innerPadding)
                                    .fillMaxHeight()
                                    .fillMaxWidth(),

                               ) {

                                    ChatUI(chats,scroll_state)
                                }
        }

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ChatUI(chats: MutableList<ChatModel>, scroll_state: ScrollState)
    {


        Box(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .fillMaxHeight())
        {
            ChatBoxes(chats,scroll_state)
            /*
            Box(modifier = Modifier.align(Alignment.BottomStart))
            {
                MessageBox(chats)
            }
            */
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ChatBoxes(chats: MutableList<ChatModel>,scroll_state: ScrollState)
    {
        //val chatboxes =  List<String>()
        //var chats = remember{ mutableStateListOf<String>() }
        var init_bool = true


        Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(scroll_state)
            )
            {
                for(chat in chats)
                {
                    init_bool = chat.is_patient
                    ChatBox(chat.message,init_bool)
                   // init_bool = !init_bool
                }

            }

    }

    @Composable
    fun ChatBox(chat_msg: String,chatter_type: Boolean)
    {
        if(chatter_type == true)//is patient
        {
            PatientBox(chat_msg)
        }
        else
        {
            DoctorBox(chat_msg)
        }
    }

    @Composable
    fun PatientBox(chat_msg: String)
    {
        Box(modifier=Modifier.padding(10.dp))
        {
            Column(
                modifier = Modifier
                    .background(Color.Black, shape = RoundedCornerShape(20.dp))
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(20.dp))
                    //.width(150.dp)
                    //.shadow(elevation = 5.dp)

            )
            {
                Icon(Icons.Outlined.Face, contentDescription = "", tint = Color.White, modifier = Modifier
                    .size(18.dp)
                    .padding(top = 5.dp, start = 8.dp)
                    )
                Row()
                {


                    Text(
                        chat_msg,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = TextUnit(13f, TextUnitType.Sp),
                            fontStyle = FontStyle.Normal,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = TextUnit(2f, TextUnitType.Sp)
                        ),
                        modifier = Modifier.padding(top = 5.dp, start = 8.dp, bottom = 5.dp)
                    )

                    Spacer(modifier = Modifier.width(100.dp))
                }
            }
        }
    }


    @Composable
    fun DoctorBox(chat_msg: String)
    {
        Box(modifier= Modifier
            .padding(10.dp)
            .fillMaxWidth()
            )
        {
            Column(
                modifier = Modifier
                    .background(Color.Gray, shape = RoundedCornerShape(20.dp))
                    .border(1.dp, Color.Gray, shape = RoundedCornerShape(20.dp))
                    .align(Alignment.TopEnd)
                //.width(150.dp)
                //.shadow(elevation = 5.dp)

            )
            {
                Icon(Icons.Outlined.Person, contentDescription = "", tint = Color.Black, modifier = Modifier
                    .size(19.dp)
                    .padding(top = 5.dp, start = 8.dp)
                    )
                Row()
                {


                    Text(
                        chat_msg,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = TextUnit(13f, TextUnitType.Sp),
                            fontStyle = FontStyle.Normal,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = TextUnit(2f, TextUnitType.Sp)
                        ),
                        modifier = Modifier.padding(top = 5.dp, start=8.dp, bottom = 5.dp)
                    )

                    Spacer(modifier = Modifier.width(100.dp))
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MessageBox(chats: MutableList<ChatModel>,scroll_state: ScrollState)
    {
        var amsg: String;
        var message by remember{ mutableStateOf("") };

            Row(
                modifier = Modifier
                    .padding(5.dp)
                    .height(50.dp)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(20.dp)),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                /*Row(
                //modifier=Modifier.width(260.dp).height(50.dp),
                horizontalArrangement = Arrangement.SpaceBetween)
            {*/
                TextField(
                    value = message,
                    onValueChange = { message = it },
                    modifier = Modifier
                        .width(230.dp)
                        .fillMaxHeight(),
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Email,
                            contentDescription = "send mesage"
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = Color.Black,
                        focusedIndicatorColor = Color.Gray,
                        cursorColor = Color.Black,
                        containerColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(10.dp),
                    textStyle = TextStyle(
                        fontSize = TextUnit(10f, TextUnitType.Sp),
                        fontStyle = FontStyle.Normal,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = TextUnit(2f, TextUnitType.Sp)
                    )

                )
                ConstraintLayout()
                {
                    val (send_refs, add_ref) = createRefs()

                    IconButton(
                        modifier = Modifier.constrainAs(send_refs)
                        {
                            top.linkTo(parent.top, margin = 0.dp)
                        },
                        onClick = {
                            var chat_model = ChatModel(message,true)
                            chats.add(chat_model)
                            //scroll_state.scrollTo(scroll_state.maxValue)
                        }) {
                        Icon(
                            Icons.Filled.Send,
                            contentDescription = "",
                            tint = Color.Black,
                            //modifier = Modifier.size(20.dp)
                        )

                    }

                    IconButton(
                        modifier = Modifier.constrainAs(add_ref)
                        {
                            absoluteRight.linkTo(send_refs.absoluteRight, margin = 35.dp)
                        }, onClick = {

                                    }) {
                        Icon(
                            Icons.TwoTone.AddCircle,
                            contentDescription = "",
                            tint = Color.Black,
                            // modifier = Modifier.size(20.dp)
                        )

                    }
                }
                //Spacer(modifier = Modifier.width(10.dp))
                //}
            }

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun InAppBar(chats: MutableList<ChatModel>, reset: MutableState<Boolean>)
    {
        TopAppBar(
                    title = {Text(
                                    "Hello  $this_patient_name",
                                     style = TextStyle(
                                                        color=Color.White,
                                                        fontSize = TextUnit(15f, TextUnitType.Sp),
                                                        fontWeight = FontWeight.Light,
                                                        fontStyle = FontStyle.Normal,
                                                        letterSpacing = TextUnit(8f,TextUnitType.Sp),

                                         )
                                )
                            },
                    navigationIcon = { Icon(Icons.Filled.AccountCircle, contentDescription = "Patient",tint=Color.White)},
                    modifier = Modifier.height(25.dp),
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Black
                    ),
                    actions = {
                                //Row(modifier=Modifier.padding(0.1.dp)) {
                                    IconButton(onClick = { /*TODO*/
                                                            chats.clear()
                                                        }) {
                                        Icon(Icons.TwoTone.Delete, contentDescription = "",tint=Color.White)

                                    }
                                    IconButton(onClick = { /*TODO*/reset.value= false }) {
                                        Icon(Icons.TwoTone.Close, contentDescription = "",tint=Color.White)

                                    }
                            //    }
                              }
                )
    }

}