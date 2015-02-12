package com.example.fei.yhb_20.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fei.yhb_20.R;
import com.example.fei.yhb_20.utils.GV;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RegistActivity extends ActionBarActivity implements View.OnClickListener{

    @InjectView(R.id.et_regist_email)EditText mEmail;
    @InjectView(R.id.et_regist_password)EditText mPassword;
    @InjectView(R.id.et_regist_username)EditText mUsername;
    @InjectView(R.id.tv_regist_protocol)TextView mProtocol;
    @InjectView(R.id.bt_regist_regist)Button mRegist;

    char role ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.inject(this);
        role = getIntent().getCharExtra("role", (char) 0);
        initEvents();
    }

    private void initEvents() {
        mProtocol.setOnClickListener(this);
        mRegist.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_regist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        String username = mUsername.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(username)){
            Toast.makeText(this,"请填写必要的注册信息",Toast.LENGTH_LONG).show();
        }else {
            switch (v.getId()){
                case R.id.bt_regist_regist:
                    Intent intent = null;
                    switch (role){
                        case GV.MERCHANT:
                            intent = new Intent(this,MerchantRegist.class);
                            intent.putExtra("email",email);
                            intent.putExtra("password",password);
                            intent.putExtra("username",username);
                            break;
                        case GV.PERSON:
                            //应该是在这里注册成功了
                            break;
                        default:
                            break;
                    }
                    startActivity(intent);
                    break;
                case R.id.tv_regist_protocol:

                    //在这里添加用户协议界面，暂时先不添加
                    break;
                default:
                    break;
            }
        }


    }
}