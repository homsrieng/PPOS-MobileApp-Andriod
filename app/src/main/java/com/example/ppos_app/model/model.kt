package com.example.ppos_app.model

data class BaseModel<T>(var status:String,var status_message:String,var data:T){
}