package com.thelearningtogether.myapplication;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import com.thelearningtogether.myapplication.models.User;
import com.thelearningtogether.myapplication.ui.TinderCardView;
import com.thelearningtogether.myapplication.ui.TinderStackLayout;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    // region Constants
    private static final int STACK_SIZE = 5;
    // endregion

    // region Views
    private TinderStackLayout tinderStackLayout;
    // endregion

    // region Member Variables
    private String[] displayNames, userNames, avatarUrls;
    private int index = 0;
    // endregion

    // region Listeners
    // endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayNames = getResources().getStringArray(R.array.display_names);
        userNames = getResources().getStringArray(R.array.usernames);
        avatarUrls = getResources().getStringArray(R.array.avatar_urls);

        tinderStackLayout = (TinderStackLayout) findViewById(R.id.tsl);

        TinderCardView tc;
        for(int i=index; index<i+STACK_SIZE; index++){
            tc = new TinderCardView(this);
            tc.bind(getUser(index));
            tinderStackLayout.addCard(tc);
        }

        tinderStackLayout.getPublishSubject()
                .observeOn(AndroidSchedulers.mainThread()) // UI Thread
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        if(integer == 1){
                            TinderCardView tc;
                            for(int i=index; index<i+(STACK_SIZE-1); index++){
                                tc = new TinderCardView(MainActivity.this);
                                tc.bind(getUser(index));
                                tinderStackLayout.addCard(tc);
                            }
                        }
                    }
                });

    }

    // region Helper Methods

    String s = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
    private User getUser(int index){
        User user = new User();
        user.setAvatarUrl(avatarUrls[index]);
        user.setDisplayName(displayNames[index]);
        user.setUsername(userNames[index]+s);
        return user;
    }
    // endregion
}
