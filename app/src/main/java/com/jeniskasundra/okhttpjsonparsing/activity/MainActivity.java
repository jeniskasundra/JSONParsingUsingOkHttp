package com.jeniskasundra.okhttpjsonparsing.activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.jeniskasundra.okhttpjsonparsing.R;
import com.jeniskasundra.okhttpjsonparsing.adapter.EmployListAdapter;
import com.jeniskasundra.okhttpjsonparsing.model.EmployDetail;
import com.jeniskasundra.okhttpjsonparsing.service.ApiCall;
import com.jeniskasundra.okhttpjsonparsing.utils.InternetConnection;
import com.jeniskasundra.okhttpjsonparsing.utils.Keys;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Jenis Kasundra on 2/2/2018.
 */
public class MainActivity extends AppCompatActivity {

    private static final String url = "http://www.jeniskasundra.xyz/api/json_api.json";
    private RecyclerView rvListEmploy;
    private String TAG = MainActivity.class.getSimpleName();
    private ArrayList<EmployDetail> employList;
    private EmployListAdapter employListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvListEmploy = (RecyclerView) findViewById(R.id.rvEmployListList);
        employList = new ArrayList<EmployDetail>();

        if (InternetConnection.checkConnection(getApplicationContext())) {
            new GetDataTask().execute();
        } else {
            Toast.makeText(MainActivity.this,"Internet Connection Not Available",Toast.LENGTH_SHORT).show();
        }
    }

    private class GetDataTask extends AsyncTask<Void, Void, Void> {
        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("Please Wait...");
            dialog.show();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            // Making a request to url and getting response
            String jsonStr = ApiCall.GET(url);
            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray employ = jsonObj.getJSONArray(Keys.KEY_EMPLOY);

                    // looping through All Contacts
                    for (int i = 0; i < employ.length(); i++) {
                        JSONObject c = employ.getJSONObject(i);

                        String id = c.getString(Keys.KEY_ID);
                        String name = c.getString(Keys.KEY_NAME);
                        String gender = c.getString(Keys.KEY_GENDER);
                        String address = c.getString(Keys.KEY_ADDRESS);
                        String picture = c.getString(Keys.KEY_PICTURE);

                        // Contect node is JSON Object
                        JSONObject phone = c.getJSONObject(Keys.KEY_CONTACT);
                        String mobile = phone.getString(Keys.KEY_MOBILE);
                        String email = phone.getString(Keys.KEY_EMAIL);

                        EmployDetail employDetail = new EmployDetail(id, name, gender, address, picture, mobile, email);
                        employList.add(employDetail);

                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (dialog.isShowing())
                dialog.dismiss();
            employListAdapter = new EmployListAdapter(MainActivity.this,employList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            rvListEmploy.setLayoutManager(mLayoutManager);
            rvListEmploy.setItemAnimator(new DefaultItemAnimator());
            rvListEmploy.setAdapter(employListAdapter);
        }
    }

}
