package com.example.greenpartycanvas2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zopim.android.sdk.api.ZopimChat;
import com.zopim.android.sdk.prechat.ZopimChatActivity;

import zendesk.core.AnonymousIdentity;
import zendesk.core.Identity;
import zendesk.core.Zendesk;
import zendesk.support.Support;
import zendesk.support.guide.HelpCenterActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Zendesk.INSTANCE.init(this, "https://eamonoc.zendesk.com",
                "0d5b89a0f37f5813397bfe5ed5f2d2e736a716ce43da1970",
                "mobile_sdk_client_718a1ab6420c68412fc6");

        Identity identity = new AnonymousIdentity();
        Zendesk.INSTANCE.setIdentity(identity);

        Support.INSTANCE.init(Zendesk.INSTANCE);

        Button helpCenterButton = (Button) findViewById(R.id.help_button);
        helpCenterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                HelpCenterActivity.builder()
                        .show(MainActivity.this);
            }
        });

        ZopimChat.init("PmuhhvCMyMy34K0aLuJzmoqwPkuidqsF");

        Button mChatButton;
        mChatButton = (Button) findViewById(R.id.chat_button);
        mChatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), ZopimChatActivity.class));
            }
        });

    }
}
