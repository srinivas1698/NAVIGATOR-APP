package edu.sjsu.android.project3srinivasraochavan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.sjsu.android.project3srinivasraochavan.databinding.FragmentDetailBinding;


public class DetailFragment extends Fragment {


    // TODO: Rename and change types of parameters
    private Item item;



    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            item = getArguments().getParcelable(getString(R.string.selected));
            //todo get item instead of get string, int, etc.
            //item=getArguments().get
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentDetailBinding binding=FragmentDetailBinding.inflate(inflater);

        //todo: receive object instead each string, int, etc.
        String name=item.getName();
        String des=item.getDescription();
        int imageID=item.getImageID();
        //set them to corresponding widget
        binding.groupName.setText(name);
        binding.description.setText(des);
        binding.image.setImageResource(imageID);
        return binding.getRoot();
    }
}