package com.example.win81.project_advertinn_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win81.project_advertinn_v2.dao.UserController;
import com.example.win81.project_advertinn_v2.dto.User;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail,etPassword;
    Button btnLogin;
    TextView etvNotRegister;
    String userEmail,userPassword;
    UserController userController;

    ArrayList<User> elist;

    //facebook
    LoginButton loginButton;
    CallbackManager callbackManager;
    AccessTokenTracker accessTokenTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fb
        FacebookSdk.sdkInitialize(LoginActivity.this);
        setContentView(R.layout.activity_login);

        etEmail = (EditText)findViewById(R.id.etLoginEmail);
        etPassword = (EditText)findViewById(R.id.etLoginPassword);
        btnLogin= (Button)findViewById(R.id.btnLoginLogin);
        etvNotRegister=(TextView)findViewById(R.id.tvLoginNotRegister);

        userController =new UserController(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userEmail=etEmail.getText().toString();
                userPassword=etPassword.getText().toString();


                //validaation
                String epatt="^[a-zA-Z0-9_.]+@[a-zA-Z]+\\.[a-zA-Z]+$";
                boolean b5= check(userEmail,epatt);
                if(!b5)
                {
                    etEmail.setError("Enter Valid Email ID");
                    return;
                }
                String ppatt="[a-zA-Z0-9@#$&._]{6,15}";
                boolean b3= check(userPassword,ppatt);
                if(!b3)
                {
                    etPassword.setError("password is invalid");
                    return;
                }


                User user=userController.showUser(userEmail);
                if(user == null)
                {
                    Toast.makeText(LoginActivity.this, "Invalid username or Password ", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(userPassword.equals(user.getPassword()))
                    {
                        Intent intent= new Intent(getApplicationContext(),CategoryActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Invalid username or Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        etvNotRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),RegistrationActivity.class);
                startActivity(intent);
            }
        });

        //fb
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("public_profile, email, user_birthday, user_friends"));
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult){
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                try {
                                    String email = object.getString("email");
                                    Log.e("Email",email);
                                    //String birthday = object.getString("birthday");
                                    String id = object.getString("id");
                                    Log.e("ID",id);
                                    String name = object.getString("name");
                                    Log.e("Name",name);
                                    String imageurl = "https://graph.facebook.com/" + id + "/picture?type=large";
                                    Intent in=new Intent(LoginActivity.this,CategoryActivity.class);
                                    in.putExtra("id",id);
                                    in.putExtra("name",name);
                                    in.putExtra("email",email);
                                    in.putExtra("image",imageurl);
                                    startActivity(in);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();
/**
 * AccessTokenTracker to manage logout
 */
                accessTokenTracker = new AccessTokenTracker() {
                    @Override
                    protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken,
                                                               AccessToken currentAccessToken) {
                        if (currentAccessToken == null) {

                        }
                    }
                };

            }
            @Override
            public void onCancel() {
            }
            @Override
            public void onError(FacebookException error) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    boolean check(String s,String patt)
    {
        Pattern p= Pattern.compile(patt);
        Matcher mt= p.matcher(s);
        return mt.matches();
    }
}
