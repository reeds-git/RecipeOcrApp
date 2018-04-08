package reed.com.recipeocrapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button scanRecipeActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scanRecipeActivityBtn = (Button)findViewById(R.id.scanRecipeActivityBtn);

        scanRecipeActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scanRecipeActivityIntent = new Intent(getApplicationContext(), ScanRecipeActivity.class);
                startActivity(scanRecipeActivityIntent);
            }
        });
    }
}
