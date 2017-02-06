package abhisheklomsh.FunFacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import abhisheklomsh.amazingFacts.R;

public class FunFactsActivity extends AppCompatActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    private TextView mFactTextView;
    private Button mShowFactButton;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener(){
          @Override
            public void onClick(View v){
            String fact = mFactBook.getFact();
              int color = mColorWheel.getColor();
              mFactTextView.setText(fact);
              mRelativeLayout.setBackgroundColor(color);
              mShowFactButton.setTextColor(color);
          }
        };



        mShowFactButton.setOnClickListener(listener);
        Toast.makeText(FunFactsActivity.this, "Welcome!\nThis app is developed by Abhishek Lomsh", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"We are logging from onCreate() method!");

    }
}
