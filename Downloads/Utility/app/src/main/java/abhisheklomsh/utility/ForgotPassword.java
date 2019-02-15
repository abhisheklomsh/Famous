package abhisheklomsh.falhaarfruitshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    private EditText input_Email;
    private Button mButton_reset_password;
    private Button mButton_Back;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        input_Email = (EditText) findViewById(R.id.inputEmail_Forgot);
                mButton_reset_password = (Button) findViewById(R.id.resetPassword_forgot);
        mButton_Back = (Button) findViewById(R.id.back_login_forgot);

        mAuth = FirebaseAuth.getInstance();
        mButton_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForgotPassword.this, Login_Firebase.class));
            }
        });

        mButton_reset_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword(input_Email.getText().toString());
                startActivity(new Intent(ForgotPassword.this, Login_Firebase.class));
            }
        });



    }
    private void resetPassword(final String email){
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(ForgotPassword.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
           if(task.isSuccessful()){
               Toast.makeText(ForgotPassword.this, "We have sent password to mail: "+email, Toast.LENGTH_LONG).show();
           }
           else{
               Toast.makeText(ForgotPassword.this, "Failed to send password", Toast.LENGTH_LONG).show();
           }
            }
        });
    }
}
