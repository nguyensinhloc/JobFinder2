package com.example.jobfindernew;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private Spinner spPosition, spIndustry, spLocation;
    private Button btnSearch;
    private RecyclerView rvJobList;
    private ProgressBar pbLoading;

    private List<JobPost> allJobPosts;
    private List<JobPost> filteredJobPosts;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_search);

        this.spPosition = this.findViewById(R.id.sp_position);
        this.spIndustry = this.findViewById(R.id.sp_industry);
        this.spLocation = this.findViewById(R.id.sp_location);
        this.btnSearch = this.findViewById(R.id.btn_search);
        this.rvJobList = this.findViewById(R.id.rv_job_list);
        this.pbLoading = this.findViewById(R.id.pb_loading);

        // Initialize spinners
        final ArrayAdapter<CharSequence> positionAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.position_array,
                android.R.layout.simple_spinner_item
        );
        positionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spPosition.setAdapter(positionAdapter);

        final ArrayAdapter<CharSequence> industryAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.industry_array,
                android.R.layout.simple_spinner_item
        );
        industryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spIndustry.setAdapter(industryAdapter);

        final ArrayAdapter<CharSequence> locationAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.location_array,
                android.R.layout.simple_spinner_item
        );
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spLocation.setAdapter(locationAdapter);

        // Set up RecyclerView
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.rvJobList.setLayoutManager(layoutManager);

        // Load all job posts initially
        this.loadAllJobPosts();

        // Set up button click listener
        this.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                SearchActivity.this.filterJobPosts();
            }
        });
    }

    private void loadAllJobPosts() {
        // Use AsyncTask or another background task to load job posts from the database
        new LoadAllJobPostsTask().execute();
    }

    private void filterJobPosts() {
        final String selectedPosition = this.spPosition.getSelectedItem().toString();
        final String selectedIndustry = this.spIndustry.getSelectedItem().toString();
        final String selectedLocation = this.spLocation.getSelectedItem().toString();

        // Use AsyncTask or another background task to filter job posts based on selected criteria
        new FilterJobPostsTask().execute(selectedPosition, selectedIndustry, selectedLocation);
    }

    private class LoadAllJobPostsTask extends AsyncTask<Void, Void, List<JobPost>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            SearchActivity.this.pbLoading.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<JobPost> doInBackground(final Void... voids) {
            // Fetch all job posts from the database
            return DatabaseInitializer.getJobPostDao().getAllJobPosts();
        }

        @Override
        protected void onPostExecute(final List<JobPost> jobPosts) {
            super.onPostExecute(jobPosts);
            SearchActivity.this.pbLoading.setVisibility(View.GONE);
            SearchActivity.this.allJobPosts = jobPosts;
        }
    }

    private class FilterJobPostsTask extends AsyncTask<String, Void, List<JobPost>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            SearchActivity.this.pbLoading.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<JobPost> doInBackground(final String... params) {
            final String selectedPosition = params[0];
            final String selectedIndustry = params[1];
            final String selectedLocation = params[2];

            // Perform filtering based on selected criteria
            SearchActivity.this.filteredJobPosts = new ArrayList<>();

            for (final JobPost jobPost : SearchActivity.this.allJobPosts) {
                if (("All".equals(selectedPosition) || jobPost.getPosition().equals(selectedPosition))
                        && ("All".equals(selectedIndustry) || jobPost.getIndustry().equals(selectedIndustry))
                        && ("All".equals(selectedLocation) || jobPost.getLocation().equals(selectedLocation))) {
                    SearchActivity.this.filteredJobPosts.add(jobPost);
                }
            }

            return SearchActivity.this.filteredJobPosts;
        }

        @Override
        protected void onPostExecute(final List<JobPost> filteredPosts) {
            super.onPostExecute(filteredPosts);
            SearchActivity.this.pbLoading.setVisibility(View.GONE);

            // Update RecyclerView with filtered data
            final JobPostAdapter adapter = new JobPostAdapter(filteredPosts);
            SearchActivity.this.rvJobList.setAdapter(adapter);
        }
    }
}