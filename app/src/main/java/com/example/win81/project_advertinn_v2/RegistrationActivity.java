package com.example.win81.project_advertinn_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.win81.project_advertinn_v2.dao.UserController;
import com.example.win81.project_advertinn_v2.dto.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {

    EditText etName_1,etMobile_1,etPassword_1,etEmail_1;
    Button btnRegister;
    String userName,userMobile,userPassword,userEmail;
    UserController userController;
   // public static int userId=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //get edittext
        etName_1=(EditText)findViewById(R.id.etRegisName);
        etEmail_1=(EditText)findViewById(R.id.etRegisEmail);
        etMobile_1=(EditText)findViewById(R.id.etRegisMobile);
        etPassword_1=(EditText)findViewById(R.id.etRegisPass);
        btnRegister=(Button)findViewById(R.id.btnRegister);

        userController = new UserController(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName=etName_1.getText().toString();
                userMobile=etMobile_1.getText().toString();
                userEmail=etEmail_1.getText().toString();
                userPassword=etPassword_1.getText().toString();

                //validaation

                String npatt="^[a-zA-Z ]+$";
                boolean b2= check(userName,npatt);
                if(!b2)
                {
                    etName_1.setError("Enter Only Alphabets");
                    return;
                }
                String mpatt="[0-9]{10,10}";
                boolean b4= check(userMobile,mpatt);
                if(!b4)
                {
                    etMobile_1.setError("Enter Valid Mobile No.");
                    return;
                }
                String epatt="^[a-zA-Z0-9_.]+@[a-zA-Z]+\\.[a-zA-Z]+$";
                boolean b5= check(userEmail,epatt);
                if(!b5)
                {
                    etEmail_1.setError("Enter Valid Email ID");
                    return;
                }
                String ppatt="[a-zA-Z0-9@#$&._]{6,15}";
                boolean b3= check(userPassword,ppatt);
                if(!b3)
                {
                    etPassword_1.setError("password is invalid");
                    return;
                }


 //end validation
                User.autoIncrement= User.autoIncrement+1;
                int uid=User.autoIncrement;
                User user = new User(uid,userName,userEmail,userPassword,userMobile);
                boolean b= userController.saveUser(user);
                if(b)
                {
                    Toast.makeText(RegistrationActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        });




    }
    boolean check(String s,String patt)
    {
        Pattern p= Pattern.compile(patt);
        Matcher mt= p.matcher(s);
        return mt.matches();
    }
}
