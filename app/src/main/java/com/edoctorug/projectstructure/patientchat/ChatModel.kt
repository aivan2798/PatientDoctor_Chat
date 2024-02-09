package com.edoctorug.projectstructure.patientchat

class ChatModel(msg: String,stat: Boolean)
{
    lateinit var message: String
    var is_patient: Boolean = true

    init{
        message = msg
        is_patient = stat
    }
}