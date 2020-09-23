package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    //Global Variables
    EditText emailForm, passwordForm, passwordConfirmForm;
    Button button;
    String error = "";
    TextView welcomeTxt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailForm = (EditText)findViewById(R.id.emailForm);
        passwordForm = (EditText)findViewById(R.id.passwordForm);
        passwordConfirmForm = (EditText)findViewById(R.id.passwordConfirmForm);
        button = (Button)findViewById(R.id.button);
        welcomeTxt = (TextView)findViewById(R.id.textView4);

    }

    public void saveForm(View view) {
        String email = emailForm.getText().toString();
        String password = passwordForm.getText().toString();
        String passwordConfirm = passwordConfirmForm.getText().toString();

        if(email.length() == 0){
            error = "Email is empty";
            displayToast();
            return;
        }
        if(password.length() == 0){
            error = "Password is empty";
            displayToast();
           return;
        }
         if(passwordConfirm.length() == 0){
            error = "Password confirmation is empty ";
             displayToast();
           return;
        }

        if(password.equals(passwordConfirm) == false ){
            error = "Passwords do not match";
            displayToast();
           return;
        }


        welcomeTxt.setText("Welcome, " + email + ", to the Form Activity");


    }

  public void showToast(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_root));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.setText(error);
        toast.show();
    }

    public void displayToast(){
        Context context = getApplicationContext();
        Toast.makeText(context, error, Toast.LENGTH_LONG).show();
    }



}