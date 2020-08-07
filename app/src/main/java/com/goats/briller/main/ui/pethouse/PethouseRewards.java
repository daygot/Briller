package com.goats.briller.main.ui.pethouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.goats.briller.R;

public class PethouseRewards extends AppCompatActivity {

    private ImageButton previous, next;
    private ImageSwitcher imageSwitcher;
    private int[] skins = {R.drawable.onboarding_dog, R.drawable.onboarding_dog_skinned};
    private int imagePosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pethouse_store);

        imageSwitcher = findViewById(R.id.pethouse_skin_switcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(PethouseRewards.this);
                imageView.setImageResource(skins[imagePosition]);
                return imageView;
            }
        });

        imageSwitcher.setInAnimation(this, android.R.anim.slide_in_left);
        imageSwitcher.setOutAnimation(this, android.R.anim.slide_out_right);

        previous = findViewById(R.id.pethouse_skin_previous);
        next = findViewById(R.id.pethouse_skin_next);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imagePosition > 0) imagePosition--;
                imageSwitcher.setImageResource(skins[imagePosition]);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imagePosition < skins.length - 1) imagePosition++;
                imageSwitcher.setImageResource(skins[imagePosition]);
            }
        });
    }

}
