package pallav.com.helloworld;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import android.media.MediaPlayer.OnPreparedListener;

public class MainActivity extends Activity {

    private VideoView myVideoView;
    private int position = 0;
    private ProgressDialog progressDialog;
    private MediaController mediaControls;
    Button button;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the layout from video_main.xml
        setContentView(R.layout.activity_main);

//        String path="http://www.ted.com/talks/download/video/8584/talk/761";
//        String path1="http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";
//
//        Uri uri=Uri.parse(path1);
//
//        VideoView video=(VideoView)findViewById(R.id.videoView2);
//        if (mediaControls == null) {
//            mediaControls = new MediaController(MainActivity.this);
//        }
//        video.setMediaController(mediaControls);
//        video.setVideoURI(uri);
//        video.start();

        button=(Button)findViewById(R.id.button);




        if (mediaControls == null) {
            mediaControls = new MediaController(MainActivity.this);
        }

        // Find your VideoView in your video_main.xml layout
        myVideoView = (VideoView) findViewById(R.id.videoView1);

        // Create a progressbar
        progressDialog = new ProgressDialog(MainActivity.this);
        // Set progressbar title
        progressDialog.setTitle("JavaCodeGeeks Android Video View Example");
        // Set progressbar message
        progressDialog.setMessage("Loading...");

        progressDialog.setCancelable(false);
        // Show progressbar
        progressDialog.show();

        try {
            myVideoView.setMediaController(mediaControls);
            myVideoView.setVideoURI(Uri.parse("https://www.youtube.com/watch?v=_jHpnb-QmTA"));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        myVideoView.requestFocus();
        myVideoView.setOnPreparedListener(new OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                progressDialog.dismiss();
                myVideoView.seekTo(position);
                if (position == 0) {
                    myVideoView.start();
                } else {
                    myVideoView.pause();
                }
            }
        });

    }
    public void Click()
    {
        Intent newIntent = new Intent(this,SecondActivity.class);
        startActivity(newIntent);
    }

//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        super.onSaveInstanceState(savedInstanceState);
//        savedInstanceState.putInt("Position", myVideoView.getCurrentPosition());
//        myVideoView.pause();
//    }
//
//    @Override
//    public void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        position = savedInstanceState.getInt("Position");
//        myVideoView.seekTo(position);
//    }
}