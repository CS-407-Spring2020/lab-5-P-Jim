package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String usernameKey = "username";
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        if (!sharedPreferences.getString(usernameKey, "").equals("")){
            String login = sharedPreferences.getString(usernameKey, "");
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("message", login);
            startActivity(intent);
        }
        else{
            setContentView(R.layout.activity_main);
        }
    }

    public void clickFunction (View view){
        EditText myText = (EditText) findViewById(R.id.login);
        String str = myText.getText().toString();
        goToActivity2(str);
    }
    public void goToActivity2 (String s){
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("message", s);
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", s).apply();
        startActivity(intent);
    }
}
