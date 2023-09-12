package com.example.gracewellchurchbotnav.ui.Volunteer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.gracewellchurchbotnav.R;

import java.util.ArrayList;
import java.util.List;

public class VolunteerChoiceForm extends AppCompatActivity {

    CheckBox chkFoodBank, chkAnimalHandling, chkCleanUp, chkMonday, chkTuesday, chkWednesday, chkThursday, chkFriday, chkSaturday, chkSunday;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_choice_form);

        chkFoodBank = findViewById(R.id.chkFoodbank);
        chkAnimalHandling = findViewById(R.id.chkAnimalHandling);
        chkCleanUp = findViewById(R.id.chkCleanUp);
        chkMonday = findViewById(R.id.chkMonday);
        chkTuesday = findViewById(R.id.chkTuesday);
        chkWednesday = findViewById(R.id.chkWednesday);
        chkThursday = findViewById(R.id.chkThursday);
        chkFriday = findViewById(R.id.chkFriday);
        chkSaturday = findViewById(R.id.chkSaturday);
        chkSunday = findViewById(R.id.chkSunday);

        submit = findViewById(R.id.btnVolunteerSubmit);

        ArrayList volunteerOptions = new ArrayList<>();
        ArrayList volunteerDays = new ArrayList<>();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chkFoodBank.isChecked())
                {
                    volunteerOptions.add(chkFoodBank.getText().toString());
                }
                if (chkAnimalHandling.isChecked())
                {
                    volunteerOptions.add(chkAnimalHandling.getText().toString());
                }
                if (chkCleanUp.isChecked())
                {
                    volunteerOptions.add(chkCleanUp.getText().toString());
                }
                if (chkMonday.isChecked())
                {
                    volunteerDays.add(chkMonday.getText().toString());
                }
                if (chkTuesday.isChecked())
                {
                    volunteerDays.add(chkTuesday.getText().toString());
                }
                if (chkWednesday.isChecked())
                {
                    volunteerDays.add(chkWednesday.getText().toString());
                }
                if (chkThursday.isChecked())
                {
                    volunteerDays.add(chkThursday.getText().toString());
                }
                if (chkFriday.isChecked())
                {
                    volunteerDays.add(chkFriday.getText().toString());
                }
                if (chkSaturday.isChecked())
                {
                    volunteerDays.add(chkSaturday.getText().toString());
                }
                if (chkSunday.isChecked())
                {
                    volunteerDays.add(chkSunday.getText().toString());
                }
            }
        });
    }
}