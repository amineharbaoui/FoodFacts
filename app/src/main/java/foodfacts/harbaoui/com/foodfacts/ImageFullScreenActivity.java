package foodfacts.harbaoui.com.foodfacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageFullScreenActivity extends AppCompatActivity {

    @Bind(R.id.iv_fullscreen)
    ImageView ivFullscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_full_screen);
        ButterKnife.bind(this);
        if (getSupportActionBar() != null) getSupportActionBar().hide();

        Intent intent = getIntent();
        String imageUrl = intent.getExtras().getString("imageUrl");

        if (imageUrl != null) {
            if (!imageUrl.isEmpty()) {
                Picasso.with(this)
                        .load(imageUrl)
                        .networkPolicy(NetworkPolicy.OFFLINE)
                        .into(ivFullscreen, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError() {
                                //Try again online if cache failed
                                Picasso.with(getApplicationContext())
                                        .load(imageUrl)
                                        .into(ivFullscreen, new Callback() {
                                            @Override
                                            public void onSuccess() {

                                            }

                                            @Override
                                            public void onError() {
                                                Log.v("Picasso","Could not fetch image");
                                            }
                                        });
                            }
                        });
            }
        }
    }
}
