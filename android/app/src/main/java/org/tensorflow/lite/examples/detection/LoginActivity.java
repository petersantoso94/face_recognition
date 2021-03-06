package org.tensorflow.lite.examples.detection;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import org.tensorflow.lite.examples.detection.model.UserProfile;

public class LoginActivity extends AppCompatActivity {

    private ImageView logo, ivSignIn, btnTwitter;
    private AutoCompleteTextView email, password;
    private TextView forgotPass, signUp;
    private Button btnSignIn;
    private UserProfile user;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeGUI();

        user = null;

        if(user != null) {
            finish();
            startActivity(new Intent(LoginActivity.this,DetectorActivity.class));
        }

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inEmail = email.getText().toString();
                String inPassword = password.getText().toString();

                if(validateInput(inEmail, inPassword)){
                    signUser(inEmail, inPassword);
                }

            }
        });



    }



    public void signUser(String email, String password){

        progressDialog.setMessage("Verificating...");
        progressDialog.show();

        if(email.equals("petersantoso94@gmail.com")  && password.equals("peter33")){
            progressDialog.dismiss();
            Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this,DetectorActivity.class));
        }
        else{
            progressDialog.dismiss();
            Toast.makeText(LoginActivity.this,"Invalid email or password",Toast.LENGTH_SHORT).show();
        }

    }


    private void initializeGUI(){

        logo = findViewById(R.id.ivLogLogo);
        ivSignIn = findViewById(R.id.ivSignIn);
        email = findViewById(R.id.atvEmailLog);
        password = findViewById(R.id.atvPasswordLog);
        btnSignIn = findViewById(R.id.btnSignIn);
        progressDialog = new ProgressDialog(this);

    }


    public boolean validateInput(String inemail, String inpassword){

        if(inemail.isEmpty()){
            email.setError("Email field is empty.");
            return false;
        }
        if(inpassword.isEmpty()){
            password.setError("Password is empty.");
            return false;
        }

        return true;
    }

}
