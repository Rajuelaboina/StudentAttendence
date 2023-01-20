package com.students.studensattendance.model

data class StudentDetail(
    val id: Int,
    val Student_id: String,
    val Student_name: String,
    val date: String,
    val time: String,
    val status: String,
    val created_at: Any,
    val updated_at: Any
)