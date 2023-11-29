package com.example.jobfindernew;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class PostActivity extends AppCompatActivity {

    private EditText etPosition, etDescription, etRequirement, etContact;
    private Spinner spIndustry;
    private Button btnPost;

    private String selectedIndustry;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_post);

        this.etPosition = this.findViewById(R.id.et_position);
        this.etDescription = this.findViewById(R.id.et_description);
        this.etRequirement = this.findViewById(R.id.et_requirement);
        this.etContact = this.findViewById(R.id.et_contact);
        this.spIndustry = this.findViewById(R.id.sp_industry);
        this.btnPost = this.findViewById(R.id.btn_post);

        // Set up the spinner with data from industries.xml
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.industry_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spIndustry.setAdapter(adapter);

        // Set up item click listener for the spinner
        this.spIndustry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parentView, final View selectedItemView, final int position, final long id) {
                PostActivity.this.selectedIndustry = (String) parentView.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(final AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        // Set up click listener for the "Đăng tin" button
        this.btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                // Get data from the UI
                final String position = PostActivity.this.etPosition.getText().toString();
                final String description = PostActivity.this.etDescription.getText().toString();
                final String requirement = PostActivity.this.etRequirement.getText().toString();
                final String contact = PostActivity.this.etContact.getText().toString();

                // Create a new JobPost object
                final JobPost jobPost = new JobPost();
                jobPost.userId = 1; // Set the user ID (you may need to get this from your app)
                jobPost.position = position;
                jobPost.industry = PostActivity.this.selectedIndustry;
                jobPost.description = description;
                jobPost.requirements = requirement;
                jobPost.contactInfo = contact;
                jobPost.createdAt = new Date().toString(); // You may want to format this date properly

                // Insert the JobPost into the database
                DatabaseInitializer.getJobPostDao().insert(jobPost);

                // Finish the activity or navigate to another screen as needed
                PostActivity.this.finish();
            }
        });
    }
}