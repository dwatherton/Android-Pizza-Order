package com.ualr.androidpizzaorder;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MaterialButton roundButton = findViewById(R.id.round_button);
        roundButton.performClick();

        final RadioButton noCheeseRadioButton = findViewById(R.id.no_cheese_radiobutton);
        noCheeseRadioButton.performClick();

        final ChipGroup chipGroup = findViewById(R.id.chip_group);

        final CheckBox pepperoni = findViewById(R.id.pepperoni_checkbox);
        final Chip pepperoniChip = new Chip(chipGroup.getContext());
        pepperoniChip.setText(R.string.pepperoni);
        pepperoni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean pepperonisSelected) {
                chipGroup.removeView(pepperoniChip);
                if (pepperonisSelected) {
                    chipGroup.addView(pepperoniChip);
                }
            }
        });

        final CheckBox mushrooms = findViewById(R.id.mushrooms_checkbox);
        final Chip mushroomsChip = new Chip(chipGroup.getContext());
        mushroomsChip.setText(R.string.mushrooms);
        mushrooms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean mushroomsSelected) {
                chipGroup.removeView(mushroomsChip);
                if (mushroomsSelected) {
                    chipGroup.addView(mushroomsChip);
                }
            }
        });

        final CheckBox veggies = findViewById(R.id.veggies_checkbox);
        final Chip veggiesChip = new Chip(chipGroup.getContext());
        veggiesChip.setText(R.string.veggies);
        veggies.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean veggiesSelected) {
                chipGroup.removeView(veggiesChip);
                if (veggiesSelected) {
                    chipGroup.addView(veggiesChip);
                }
            }
        });

        final CheckBox anchovies = findViewById(R.id.anchovies_checkbox);
        final Chip anchoviesChip = new Chip(chipGroup.getContext());
        anchoviesChip.setText(R.string.anchovies);
        anchovies.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean anchoviesSelected) {
                chipGroup.removeView(anchoviesChip);
                if (anchoviesSelected) {
                    chipGroup.addView(anchoviesChip);
                }
            }
        });

        final Chip cheeseChip = new Chip(chipGroup.getContext());
        RadioGroup radioGroup = findViewById(R.id.cheese_selection);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int index) {
                String text;

                switch (radioGroup.getCheckedRadioButtonId())
                {
                    case R.id.cheese_radiobutton:
                        text = getResources().getString(R.string.cheese);
                        cheeseChip.setText(text);
                        chipGroup.removeView(cheeseChip);
                        chipGroup.addView(cheeseChip);
                        break;
                    case R.id.double_cheese_radiobutton:
                        text = getResources().getString(R.string.double_cheese);
                        cheeseChip.setText(text);
                        chipGroup.removeView(cheeseChip);
                        chipGroup.addView(cheeseChip);
                        break;
                    case R.id.no_cheese_radiobutton:
                    default:
                        chipGroup.removeView(cheeseChip);
                        break;
                }
            }
        });
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
