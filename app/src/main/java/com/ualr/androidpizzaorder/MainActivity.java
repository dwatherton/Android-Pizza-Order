package com.ualr.androidpizzaorder;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pizzaShapeButtonPressed(View view)
    {
        MaterialButtonToggleGroup pizzaShapeButtonGroup = findViewById(R.id.button_group);
        ImageView pizzaImage = findViewById(R.id.pizza_image);
        Drawable pizzaShapeImage;

        switch (pizzaShapeButtonGroup.getCheckedButtonId()) {
            case R.id.round_button:
                pizzaShapeImage = getResources().getDrawable(R.drawable.ic_round_pizza, null);
                break;
            case R.id.square_button:
                pizzaShapeImage = getResources().getDrawable(R.drawable.ic_squared_pizza, null);
                break;
            default:
                pizzaShapeImage = getResources().getDrawable(R.drawable.ic_not_selected_pizza, null);
                break;
        }

        pizzaImage.setImageDrawable(pizzaShapeImage);
    }
}
