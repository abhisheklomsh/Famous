package abhisheklomsh.falhaarfruitshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static abhisheklomsh.falhaarfruitshop.R.layout.activity_user_registration;

public class UserRegistration extends AppCompatActivity {
Button mSignUpButton;
    EditText mEmail,mPassword;
    TextView mForgotPassword,mAlreadyUser;
    private FirebaseAuth mAuth;
    Snackbar snackbar;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_user_registration);
        mSignUpButton = (Button) findViewById(R.id.sign_up_button_firebase);
        mAlreadyUser = (TextView) findViewById(R.id.mAlreadyUser);
        mForgotPassword = (TextView) findViewById(R.id.mForgotPasswordButton);
        mEmail = (EditText) findViewById(R.id.signup_email_firebase);
        mPassword = (EditText) findViewById(R.id.signup_password_firebase);

        mAuth = FirebaseAuth.getInstance();
        mAlreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserRegistration.this, Login_Firebase.class));
                finish();
            }
        });
        mForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserRegistration.this, ForgotPassword.class));
            }
        });
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpUser(mEmail.getText().toString(),mPassword.getText().toString());
                startActivity(new Intent(UserRegistration.this, Login_Firebase.class));
            }
        });

    }

    private void signUpUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    Toast.makeText(UserRegistration.this, "Error "+task.getException(), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(UserRegistration.this, "Success!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
