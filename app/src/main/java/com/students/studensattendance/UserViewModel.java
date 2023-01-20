package com.students.studensattendance;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;


public class UserViewModel extends AndroidViewModel {
  UserRepositroy userRepositroy;
  MutableLiveData<List<StudentInfo>> listMutableLiveData;

    public UserViewModel(Application application) {
        super( application);
        userRepositroy = new UserRepositroy();
        //setListMutableLiveData();
    }
    public MutableLiveData<List<StudentInfo>> getListMutableLiveData(){
        listMutableLiveData=userRepositroy.getUserList();
        return listMutableLiveData;
    }
    public void setListMutableLiveData(){
        listMutableLiveData=userRepositroy.getUserList();
    }
}
