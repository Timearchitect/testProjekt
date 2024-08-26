package se.gritacademy.myapplication;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            String test = "hejsan";
            Log.i("test", test);

            TextView tv= findViewById(R.id.label1);
            tv.setTextSize(18);
            ConstraintLayout layout = findViewById(R.id.main);
            ArrayList<Button> buttons = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                Button button = new Button(getBaseContext());
                button.setText(i + "");
                button.setX(i % 3 * 200 + 200);
                button.setY(Math.round(100 * Math.floor(i / 3)) + 100);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Hejsan", Toast.LENGTH_SHORT).show();
                    }
                });

                buttons.add(button);
                //optional: add your buttons to any layout if you want to see them in your screen
                layout.addView(button);
            }

            Log.println(Log.DEBUG,"Alrik","Hello world");

            return insets;
        });
    }
}