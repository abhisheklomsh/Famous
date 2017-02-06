package abhisheklomsh.famous;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewClick = (TextView) findViewById(R.id.textViewClick);
        textViewClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shiftToRegistration();
            }
        });
    }

    private void shiftToRegistration() {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }
}
