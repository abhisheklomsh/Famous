package abhisheklomsh.falhaarfruitshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Firebase extends AppCompatActivity {

    private EditText mEmailField;
    private EditText mPasswordField;
    private Button mSignInButton;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
private TextView mSignUpButton,mForgotPasswordButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__firebase);


        mEmailField = (EditText) findViewById(R.id.email_firebase);
        mPasswordField = (EditText) findViewById(R.id.password_firebase);
        mSignInButton = (Button) findViewById(R.id.sign_in_button_firebase);
        mSignUpButton = (TextView) findViewById(R.id.mSignUpButton);
                mForgotPasswordButton = (TextView) findViewById(R.id.mForgotPasswordButton);

        mAuth = FirebaseAuth.getInstance();

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Firebase.this, UserRegistration.class));
            }
        });
        mForgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Firebase.this, ForgotPassword.class));
            }
        });




        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSignIn();
            }
        });
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
if(firebaseAuth.getCurrentUser() != null){
    //Already logged in, redirect from here
startActivity(new Intent(Login_Firebase.this, MainActivity.class));
}
else{

}
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    private void startSignIn() {

        String email = mEmailField.getText().toString();
        String password = mPasswordField.getText().toString();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(Login_Firebase.this, "Fields are Empty", Toast.LENGTH_LONG).show();
        } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(Login_Firebase.this, "Sign In problem", Toast.LENGTH_LONG).show();

                    }
                }
            });


        }
    }
}
