package calculator.sameer.com.mycalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.FileNameMap;

public class MainActivity extends AppCompatActivity {
    // Declare Private Variables for Length,Area and Mass
    private Button LengthButton,AreaButton,MassButton;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectConversion();
    }

    public void selectConversion(){
      // Find respective buttons in UI
      LengthButton = (Button) findViewById(R.id.Length_button);
      AreaButton   = (Button) findViewById(R.id.Area_button);
      MassButton   = (Button) findViewById(R.id.Mass_button);
    }

    // onClick Methods for each button
    public void ConvertLengthActivity(View view) {
        Log.d(LOG_TAG, "Convert Length Button clicked!");
        Intent intent = new Intent(this,Convert_Length_Activity.class);
        startActivity(intent);
    }

    public void ConvertAreaActivity(View view) {
        Log.d(LOG_TAG, "Convert Area Button clicked!");

    }

    public void ConvertMassActivity(View view) {
        Log.d(LOG_TAG, "Convert Mass Button clicked!");

    }
}
