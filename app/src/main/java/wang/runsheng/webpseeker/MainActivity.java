package wang.runsheng.webpseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private String path = "/Android/data/com.douban.frodo/cache/images/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String sdcard = Environment.getExternalStorageDirectory().getPath();
        Log.d(TAG, "path: " + sdcard + path);
        File dir = new File(sdcard + path);
        dir = new File("content://com.android.fileexplorer.myprovider/external_files" + path);
        if (dir.isDirectory()) {
            File[] images = dir.listFiles();
            if (images != null) {
                Log.d(TAG, "douban has: " + images.length);
            }
        }
    }
}