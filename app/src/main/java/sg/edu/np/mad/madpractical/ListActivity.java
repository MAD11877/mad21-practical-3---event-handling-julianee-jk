package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private final static String TAG = "List Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView alertButton = findViewById(R.id.alertPopup);
        alertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating dialog box
                new AlertDialog.Builder(ListActivity.this)
                        .setTitle("Profile")
                        .setMessage("MADness")
                        .setNegativeButton("Close", null)
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Continue with delete operation
                                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                                intent.putExtra("randomNo", new Random().nextInt());
                                startActivity(intent);
                            }
                        }).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "Destroy");
    }
}