package com.ptr.mvvm.ui.api;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ptr.mvvm.R;
import com.ptr.mvvm.ui.adapter.PostListAdapter;

public class ApiFragment extends Fragment {

    private ApiViewModel viewModel;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel =
                ViewModelProviders.of(this).get(ApiViewModel.class);
        View rootView = inflater.inflate(R.layout.fragment_api, container, false);
        recyclerView = rootView.findViewById(R.id.rv_api);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final PostListAdapter adapter = new PostListAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        viewModel.getPosts().observe(this, adapter::setPosts);
    }
}