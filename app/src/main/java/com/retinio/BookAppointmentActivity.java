package com.retinio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import net.i2p.android.ext.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naman on 09/04/16.
 */
public class BookAppointmentActivity extends AppCompatActivity {

    EditText name, phone, address;
    Spinner timeSpinner;
    Button bookAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        assert toolbar != null;
        toolbar.setTitle("Book appointment");
        setSupportActionBar(toolbar);

        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone_number);
        address = (EditText) findViewById(R.id.address);

        bookAppointment = (Button) findViewById(R.id.btn_book_appointment);

        timeSpinner = (Spinner) findViewById(R.id.time_spinner);
        ArrayList<String> timeArray = new ArrayList<>();
        timeArray.add("9AM");
        timeArray.add("11AM");
        timeArray.add("1PM");
        ArrayAdapter<String> timeAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, timeArray);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeAdapter);

    }
}
