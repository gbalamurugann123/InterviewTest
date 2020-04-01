package com.android.form.utils;

import android.app.Activity;
import android.text.Html;
import android.text.InputFilter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.form.R;
import com.android.form.model.Control;

import java.util.ArrayList;
import java.util.List;

public class PageUtils {

    public static final String CONTROL_TEXT = "text";
    public static final String CONTROL_SELECT = "select";
    public static final String CONTROL_CHECKBOX = "checkbox";

    public static void createView(Control control, final Activity context, LinearLayout parentLayout) {


        switch (control.getType())
        {
            case CONTROL_TEXT:
                parentLayout.addView(createTextView(control,context));
                break;
            case CONTROL_SELECT:
                parentLayout.addView(createSpinner(control,context));
                break;
            case CONTROL_CHECKBOX:
                parentLayout.addView(createCheckBox(control,context));
                break;
        }


    }

    static View createTextView(final Control control, final Activity context) {

        View field = context.getLayoutInflater().inflate(R.layout.section_item_text, null);
        TextView labelView = field.findViewById(R.id.txtViewLabel);
        String mandatoryLabel = "";
        if (control.getRequired()) {
            mandatoryLabel = "<span style=\"color:red;\"> * </span>";
        }
        labelView.setText(Html.fromHtml(control.getLabel() + mandatoryLabel));
        EditText valueView = field.findViewById(R.id.edtxtValue);
        valueView.setFilters(new InputFilter[] { new InputFilter.LengthFilter(control.getMaxLength()) });
        valueView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                control.setApiValue(((EditText)view).getText().toString());
            }
        });
        return field;
    }

    static View createSpinner(final Control control, final Activity context) {

        View field = context.getLayoutInflater().inflate(R.layout.section_item_drop_down, null);
        TextView labelView = field.findViewById(R.id.txtViewLabel);
        String mandatoryLabel = "";
        if (control.getRequired()) {
            mandatoryLabel = "<span style=\"color:red;\"> * </span>";
        }
        labelView.setText(Html.fromHtml(control.getLabel() + mandatoryLabel));

        Spinner valueView = field.findViewById(R.id.spinnerValue);
        final List<String> dropDownValues = new ArrayList<>();
        dropDownValues.addAll(control.getOptions());

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, dropDownValues);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        valueView.setAdapter(dataAdapter);

        valueView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                control.setApiValue(dropDownValues.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return field;

    }


    static View createCheckBox(final Control control, final Activity context) {

        View field = context.getLayoutInflater().inflate(R.layout.section_item_checkbox, null);
        TextView labelView = field.findViewById(R.id.txtViewLabel);
        String mandatoryLabel = "";
        if (control.getRequired()) {
            mandatoryLabel = "<span style=\"color:red;\"> * </span>";
        }
        labelView.setText(Html.fromHtml(control.getLabel() + mandatoryLabel));

        final LinearLayout valueLayout = field.findViewById(R.id.layoutCheckBoxGroup);

        for (int i = 0; i < control.getOptions().size(); i++) {
            CheckBox checkBox = new CheckBox(context);
            checkBox.setText(control.getOptions().get(i));
            valueLayout.addView(checkBox);
            final int finalI = i;
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b)
                    {
                        control.setApiValue(control.getOptions().get(finalI) + ", ");
                    }
                    else
                    {
                        control.setApiValue(control.getApiValue().replace(control.getOptions().get(finalI) + ", " , ""));
                    }
                }
            });
        }

        return field;

    }



}
