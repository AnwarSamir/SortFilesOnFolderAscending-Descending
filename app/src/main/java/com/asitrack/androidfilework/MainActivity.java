package com.asitrack.androidfilework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.reactivestreams.Subscription;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static org.apache.commons.io.comparator.LastModifiedFileComparator.LASTMODIFIED_COMPARATOR;
import static org.apache.commons.io.comparator.LastModifiedFileComparator.LASTMODIFIED_REVERSE;

public class MainActivity extends AppCompatActivity {

    private MainActivity FileSortLastModified;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sortListOfFiles();


    }

    public void sortListOfFiles()
    {

        File dir = new File("sdcard/Android/data/com.android.horoof");
        File[] files = dir.listFiles();

        if (files != null) {
            // Sort files in ascending order based on file's last
            // modification date.
//            System.out.println("Ascending order.");
//            Arrays.sort(files, LASTMODIFIED_COMPARATOR);
//            FileSortLastModified.displayFileOrder(files);
//
//            System.out.println("------------------------------------");

            // Sort files in descending order based on file's last
            // modification date.
            // من الاحدث الي الاقدم
            System.out.println("Descending order.");
            Arrays.sort(files, LASTMODIFIED_REVERSE);
            FileSortLastModified.displayFileOrder(files);

        }
    }

    private static void displayFileOrder(File[] files) {
        for (File file : files) {
            System.out.printf("%2$td/%2$tm/%2$tY - %s%n", file.getName(),
                    file.lastModified());
            files[files.length-1].delete();
        }
    }
}
