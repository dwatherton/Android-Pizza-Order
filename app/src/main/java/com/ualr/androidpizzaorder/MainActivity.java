package com.ualr.androidpizzaorder;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setActiveSelections();
        handleChipListeners();
    }

    public void pizzaShapeButtonPressed(View view)
    {
        // Get ButtonToggleGroup
        MaterialButtonToggleGroup pizzaShapeButtonGroup = findViewById(R.id.button_group);

        // Get ImageView
        ImageView pizzaImage = findViewById(R.id.pizza_image);

        // Declare Our Drawable
        Drawable pizzaShapeImage;

        // Handle Checked Button By Id
        switch (pizzaShapeButtonGroup.getCheckedButtonId()) {
            case R.id.round_button:
                // Set Our Drawable Pizza Shape Image To Round
                pizzaShapeImage = getResources().getDrawable(R.drawable.ic_round_pizza, null);
                break;
            case R.id.square_button:
                // Set Our Drawable Pizza Shape Image To Square
                pizzaShapeImage = getResources().getDrawable(R.drawable.ic_squared_pizza, null);
                break;
            default:
                // Set Our Drawable Pizza Shape Image To Not Selected
                pizzaShapeImage = getResources().getDrawable(R.drawable.ic_not_selected_pizza, null);
                break;
        }

        // Update The ImageView To Reflect The Checked Button's Corresponding Image
        pizzaImage.setImageDrawable(pizzaShapeImage);
    }

    public void setActiveSelections()
    {
        // Get And Click Round Button
        final MaterialButton roundButton = findViewById(R.id.round_button);
        roundButton.performClick();

        // Get And Click No Cheese RadioButton
        final RadioButton noCheeseRadioButton = findViewById(R.id.no_cheese_radiobutton);
        noCheeseRadioButton.performClick();
    }

    public void handleChipListeners()
    {
        // Get Checkboxes
        final CheckBox pepperoni = findViewById(R.id.pepperoni_checkbox);
        final CheckBox mushrooms = findViewById(R.id.mushrooms_checkbox);
        final CheckBox veggies = findViewById(R.id.veggies_checkbox);
        final CheckBox anchovies = findViewById(R.id.anchovies_checkbox);

        // Get ChipGroup
        final ChipGroup chipGroup = findViewById(R.id.chip_group);

        // Create Styled Chips For Each Checkbox
        final Chip pepperoniChip = new Chip(chipGroup.getContext(), null, R.attr.chipStyle);
        final Chip mushroomsChip = new Chip(chipGroup.getContext(), null, R.attr.chipStyle);
        final Chip veggiesChip = new Chip(chipGroup.getContext(), null, R.attr.chipStyle);
        final Chip anchoviesChip = new Chip(chipGroup.getContext(), null, R.attr.chipStyle);

        // Set Each Chips Text Appropriately
        pepperoniChip.setText(R.string.pepperoni);
        mushroomsChip.setText(R.string.mushrooms);
        veggiesChip.setText(R.string.veggies);
        anchoviesChip.setText(R.string.anchovies);

        // Set Pepperoni Checkbox Change Listener (Always Remove Chip, And Add It Back If Checkbox Is Selected)
        pepperoni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean pepperonisSelected) {
                chipGroup.removeView(pepperoniChip);
                if (pepperonisSelected) {
                    chipGroup.addView(pepperoniChip);
                }
            }
        });

        // Set Mushroom Checkbox Change Listener (Always Remove Chip, And Add It Back If Checkbox Is Selected)
        mushrooms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean mushroomsSelected) {
                chipGroup.removeView(mushroomsChip);
                if (mushroomsSelected) {
                    chipGroup.addView(mushroomsChip);
                }
            }
        });

        // Set Veggies Checkbox Change Listener (Always Remove Chip, And Add It Back If Checkbox Is Selected)
        veggies.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean veggiesSelected) {
                chipGroup.removeView(veggiesChip);
                if (veggiesSelected) {
                    chipGroup.addView(veggiesChip);
                }
            }
        });

        // Set Anchovies Checkbox Change Listener (Always Remove Chip, And Add It Back If Checkbox Is Selected)
        anchovies.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean anchoviesSelected) {
                chipGroup.removeView(anchoviesChip);
                if (anchoviesSelected) {
                    chipGroup.addView(anchoviesChip);
                }
            }
        });

        // Handle Cheese Chip
        handleCheeseChipListener(chipGroup);
    }

    public void handleCheeseChipListener(final ChipGroup chipGroup)
    {
        // Get RadioGroup
        final RadioGroup radioGroup = findViewById(R.id.cheese_selection);

        // Create Styled Chip For Cheese Radio Button Selection (Only One Selectable At A Time)
        final Chip cheeseChip = new Chip(chipGroup.getContext(), null, R.attr.chipStyle);

        // Set Cheese RadioGroup Change Listener (Set Cheese Chip Text By Checked RadioButton Id)
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int index) {
                // Handle Checked RadioButton By Id
                switch (radioGroup.getCheckedRadioButtonId())
                {
                    case R.id.cheese_radiobutton:
                        // Set Text To Cheese
                        cheeseChip.setText(getResources().getString(R.string.cheese));

                        // Remove Cheese Chip, Then Add It With The Cheese Text
                        chipGroup.removeView(cheeseChip);
                        chipGroup.addView(cheeseChip);
                        break;
                    case R.id.double_cheese_radiobutton:
                        // Set Text To 2x Cheese
                        cheeseChip.setText(getResources().getString(R.string.double_cheese));

                        // Remove Cheese Chip, Then Add It With The 2x Cheese Text
                        chipGroup.removeView(cheeseChip);
                        chipGroup.addView(cheeseChip);
                        break;
                    case R.id.no_cheese_radiobutton:
                    default:
                        // Remove Cheese Chip
                        chipGroup.removeView(cheeseChip);
                        break;
                }
            }
        });
    }

    public void placeOrderButtonClicked(View view)
    {
        // Get Customer Info EditText's
        TextInputEditText name = findViewById(R.id.name_edittext);
        TextInputEditText phone = findViewById(R.id.phone_edittext);

        // Get Customer Info Layouts
        TextInputLayout nameLayout = findViewById(R.id.name_textinputlayout);
        TextInputLayout phoneLayout = findViewById(R.id.phone_textinputlayout);

        // Check Name Field Empty, Error - Required!
        if (name.getText().toString().isEmpty()) {
            nameLayout.setError("Required!");
        }
        // If Name Is Not Empty, Clear The Name Layout Error Text
        else {
            nameLayout.setError("");
        }

        // Check Phone Field Empty, Error - Required!
        if (phone.getText().toString().isEmpty()) {
            phoneLayout.setError("Required!");
        }
        // Else Check Phone Number Is Not 10 Numbers Long (Strip '-' Just In Case), Error - Invalid
        else if (phone.getText().toString().replaceAll("-","").length() != 10) {
            phoneLayout.setError("Phone number not valid!");
        }
        // Otherwise, Clear The Phone Layout Error Text
        else {
            phoneLayout.setError("");
        }
    }
}
