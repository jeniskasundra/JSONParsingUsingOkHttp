package com.jeniskasundra.okhttpjsonparsing.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jeniskasundra.okhttpjsonparsing.R;
import com.jeniskasundra.okhttpjsonparsing.utils.Keys;

/**
 * Created by Jenis Kasundra on 2/3/2018.
 */

public class DetailActivity extends AppCompatActivity {

    private String id, name, gender, address, mobile, email;
    private TextView tvId, tvName, tvGender, tvAddress, tvMobile, tvEmail;
    private ImageView imgPicture;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employ_detail_layout);

        Bundle bundle = getIntent().getExtras();
        String id = bundle.getString(Keys.KEY_ID);
        String name = bundle.getString(Keys.KEY_NAME);
        String gender = bundle.getString(Keys.KEY_GENDER);
        String address = bundle.getString(Keys.KEY_ADDRESS);
        String picture = bundle.getString(Keys.KEY_PICTURE);
        String mobile = bundle.getString(Keys.KEY_MOBILE);
        String email = bundle.getString(Keys.KEY_EMAIL);

        tvId = (TextView) findViewById(R.id.tvId);
        tvName = (TextView) findViewById(R.id.tvName);
        tvGender = (TextView) findViewById(R.id.tvGender);
        tvAddress = (TextView) findViewById(R.id.tvAddress);
        tvMobile = (TextView) findViewById(R.id.tvMobile);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        imgPicture = (ImageView) findViewById(R.id.imgEmployPic);
        tvId.setText(id);
        tvName.setText(name);
        tvGender.setText(gender);
        tvAddress.setText(address);
        tvMobile.setText(mobile);
        tvEmail.setText(email);
        Glide.with(DetailActivity.this).load(picture).placeholder(R.mipmap.ic_launcher).into(imgPicture);


    }
}
