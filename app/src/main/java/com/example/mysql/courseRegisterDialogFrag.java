package com.example.mysql;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class courseRegisterDialogFrag extends DialogFragment {

    private EditText localCourseTitle, localCourseCode;
    private dialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_course_dialog, null);

        builder.setView(view)
                .setPositiveButton(R.string.saveBtn, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!localCourseCode.getText().toString().isEmpty() &&
                        !localCourseTitle.getText().toString().isEmpty())
                        {
                            String course = localCourseCode.getText().toString();
                            String title = localCourseTitle.getText().toString();
                            listener.applyTexts(course,title);
                            Toast.makeText(getContext(), getString(R.string.success),Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(getContext(), getString(R.string.fail),Toast.LENGTH_LONG).show();
                        }

                    }
                })
                .setNegativeButton(R.string.cancelBtn, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       courseRegisterDialogFrag.this.getDialog().cancel();
                    }
                });

        localCourseCode = view.findViewById(R.id.editTextCourseCode);
        localCourseTitle = view.findViewById(R.id.editTextCourseTitle);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (dialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement dialogListener");
        }
    }

    public interface dialogListener{
        void applyTexts(String course, String title);
    }

}
