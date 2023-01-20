package com.students.studensattendance.viewmodelhelper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.students.studensattendance.repositroy.StudentRepositroy
import com.students.studensattendance.viewmodel.StudentsViewModel

class StudentViewModelHelper constructor(var repositroy: StudentRepositroy) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(StudentsViewModel::class.java)){
             StudentsViewModel(this.repositroy) as T
        }else{
            throw  IllegalArgumentException("StudentsViewModel not found")
        }
    }
}