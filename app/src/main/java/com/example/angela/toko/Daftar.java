package com.example.angela.toko;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import com.example.angela.toko.koneksi.AppConfig;
import com.example.angela.toko.koneksi.AppController;
import com.example.angela.toko.koneksi.SQLiteHandler;
import com.example.angela.toko.koneksi.SessionManager;

public class Daftar extends Activity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_daftar);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        private static final String TAG = Daftar.class.getSimpleName();
        private Button btnRegister;
        private Button btnLogin;
        private EditText inputFullName;
        private EditText inputEmail;
        private EditText inputPassword;
        private ProgressDialog pDialog;
        private SessionManager session;
        private SQLiteHandler db;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_daftar);

            inputFullName = (EditText) findViewById(R.id.name);
            inputEmail = (EditText) findViewById(R.id.email);
            inputPassword = (EditText) findViewById(R.id.password);
            btnRegister = (Button) findViewById(R.id.btn_regis);
            btnLogin = (Button) findViewById(R.id.btn_login);

            // Progress dialog
            pDialog = new ProgressDialog(this);
            pDialog.setCancelable(false);

            // Session manager
            session = new SessionManager(getApplicationContext());

            // SQLite database handler
            db = new SQLiteHandler(getApplicationContext());

            // Check if user is already logged in or not
            if (session.isLoggedIn()) {
                // User is already logged in. Take him to main activity
                Intent intent = new Intent(Daftar.this,
                        OwnerHome.class);
                startActivity(intent);
                finish();
            }

            // Register Button Click event
            btnRegister.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String name = inputFullName.getText().toString().trim();
                    String email = inputEmail.getText().toString().trim();
                    String password = inputPassword.getText().toString().trim();

                    if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                        registerUser(name, email, password);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Silakan isi dengan Lengkap!", Toast.LENGTH_LONG)
                                .show();
                    }
                }
            });

            // Link to Login Screen
            btnLogin.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(),
                            Login.class);
                    startActivity(i);
                    finish();
                }
            });

        }

        /**
         * Function to store user in MySQL database will post params(tag, name,
         * email, password) to register url
         * */
        private void registerUser(final String name, final String email,
        final String password) {
            // Tag used to cancel the request
            String tag_string_req = "req_register";

            pDialog.setMessage("Registering ...");
            showDialog();

            StringRequest strReq = new StringRequest(Method.POST,
                    AppConfig.URL_REGISTER, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    Log.d(TAG, "Register Response: " + response.toString());
                    hideDialog();

                    try {
                        JSONObject jObj = new JSONObject(response);
                        boolean error = jObj.getBoolean("error");
                        if (!error) {
                            // User successfully stored in MySQL
                            // Now store the user in sqlite
                            String uid = jObj.getString("uid");

                            JSONObject user = jObj.getJSONObject("user");
                            String name = user.getString("name");
                            String email = user.getString("email");
                            String level = "1";

                            // Inserting row in users table
                            db.addUser(name, email, uid, level);

                            Toast.makeText(getApplicationContext(), "Register telah berhasil. Silakan Login.!", Toast.LENGTH_LONG).show();

                            // Launch login activity
                            Intent intent = new Intent(
                                    Daftar.this,
                                    Login.class);
                            startActivity(intent);
                            finish();
                        } else {

                            // Error occurred in registration. Get the error
                            // message
                            String errorMsg = jObj.getString("error_msg");
                            Toast.makeText(getApplicationContext(),
                                    errorMsg, Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG, "Registration Error: " + error.getMessage());
                    Toast.makeText(getApplicationContext(),
                            error.getMessage(), Toast.LENGTH_LONG).show();
                    hideDialog();
                }
            }) {

                @Override
                protected Map<String, String> getParams() {
                    // Posting params to register url
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("name", name);
                    params.put("email", email);
                    params.put("password", password);

                    return params;
                }

            };

            // Adding request to request queue
            AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
        }

        private void showDialog() {
            if (!pDialog.isShowing())
                pDialog.show();
        }

        private void hideDialog() {
            if (pDialog.isShowing())
                pDialog.dismiss();
        }
    }

//        Button Selesai=findViewById(R.id.btn_regis);
//        Selesai.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(Daftar.this, Login.class);
//                startActivity(i);
//            }
//        });
