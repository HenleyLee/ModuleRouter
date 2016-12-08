package org.loader.module2module;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import org.loader.router.Router;
import org.loader.router.rule.intent.ActivityRule;
import org.loader.utilslib.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setTextSize(50);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLACK);
        textView.setText("MAIN模块");
        setContentView(textView);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Router.invoke(MainActivity.this, ActivityRule.SCHEME_ACTIVITY, Constants.ROUTER_PATH_SHOP);
                intent.putExtra("title", "来自于MainActivity");
                startActivity(intent);
            }
        });
    }

}
