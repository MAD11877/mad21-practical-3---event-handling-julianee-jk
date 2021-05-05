package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User userInfo = new User(
                "Julian",
                1,
                "Hello, I am Julian. I enjoy playing sports and computer games. I have two doggos, Stitch and Hermione.",
                false);

        Button followButton = findViewById(R.id.followBtn);

        TextView loremText = findViewById(R.id.loremText);
        loremText.setText(userInfo.getDescription());

        TextView helloText = findViewById(R.id.helloText);
        helloText.setText(userInfo.getName());

        Intent receivingEnd = getIntent();
        if (receivingEnd.getIntExtra("randomNo", 0) > 0) {
            helloText.setText("MAD " + receivingEnd.getIntExtra("randomNo", 0));
        }

        if (userInfo.isFollowed()) { followButton.setText("Unfollow"); }
        else { followButton.setText("Follow"); }

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Clicked");
                int duration = Toast.LENGTH_SHORT;

                if (userInfo.isFollowed()) {
                    followButton.setText("Follow");
                    Toast.makeText(MainActivity.this, "Unfollowed", duration).show();
                    userInfo.setFollowed(false);
                }
                else {
                    followButton.setText("Unfollow");
                    Toast.makeText(MainActivity.this, "Followed", duration).show();
                    userInfo.setFollowed(true);
                }
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