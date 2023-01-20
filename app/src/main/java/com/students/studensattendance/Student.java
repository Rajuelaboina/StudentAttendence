package com.students.studensattendance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.students.studensattendance.model.StudentDetail;

import java.util.List;

public class Student {
   @SerializedName("Student Details")
   @Expose
   private List<StudentInfo> studentDetails = null;

   public List<StudentInfo> getStudentDetails() {
      return studentDetails;
   }

   public void setStudentDetails(List<StudentInfo> studentDetails) {
      this.studentDetails = studentDetails;
   }
}
