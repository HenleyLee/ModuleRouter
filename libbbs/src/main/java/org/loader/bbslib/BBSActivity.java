package org.loader.bbslib;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import org.loader.router.Router;
import org.loader.router.rule.intent.ActivityRule;
import org.loader.utilslib.Application;
import org.loader.utilslib.Constants;
import org.loader.utilslib.ToastHelper;
import org.loader.utilslib.UseContext;

public class BBSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setTextSize(50);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLACK);
        textView.setText("BBS模块");
        setContentView(textView);

        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            ToastHelper.showToast(title);
        }

        UseContext.use(Application.get());

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Router.invoke(BBSActivity.this, ActivityRule.SCHEME_ACTIVITY, Constants.ROUTER_PATH_SHOP);
                intent.putExtra("title", "来自于BBSActivity");
                startActivity(intent);
            }
        });
    }
}
