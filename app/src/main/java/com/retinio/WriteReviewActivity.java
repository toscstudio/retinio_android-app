package com.retinio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.retinio.R;

/**
 * Created by naman on 09/04/16.
 */
public class WriteReviewActivity extends AppCompatActivity {

    Button submitReview;
    EditText editReview;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        assert toolbar != null;
        toolbar.setTitle("Write review");
        setSupportActionBar(toolbar);

        submitReview = (Button) findViewById(R.id.btn_submit_review);
        editReview = (EditText) findViewById(R.id.edit_review);
        ratingBar = (RatingBar) findViewById(R.id.ratingbar);
    }
}
