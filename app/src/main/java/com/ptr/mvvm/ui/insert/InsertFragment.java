package com.ptr.mvvm.ui.insert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.ptr.mvvm.R;
import com.ptr.mvvm.network.model.Post;

public class InsertFragment extends Fragment {

    private InsertViewModel viewModel;
    private View rootView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel =
                ViewModelProviders.of(this).get(InsertViewModel.class);
        rootView = inflater.inflate(R.layout.fragment_insert, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText etUserid = rootView.findViewById(R.id.et_userid);
        EditText etid = rootView.findViewById(R.id.et_id);
        EditText etBody = rootView.findViewById(R.id.et_body);
        EditText etTitle = rootView.findViewById(R.id.et_title);

        Button bSubmit = rootView.findViewById(R.id.b_submit);
        bSubmit.setOnClickListener(v -> viewModel.insert(new Post(
                etUserid.getText().toString().matches("") ? 1 : Integer.parseInt(etUserid.getText().toString()),
                etid.getText().toString().matches("") ? 1 : Integer.parseInt(etid.getText().toString()),
                etBody.getText().toString(),
                etTitle.getText().toString()
        )));

    }
}