package edu.sjsu.android.project3srinivasraochavan;

import android.app.AlertDialog;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.sjsu.android.project3srinivasraochavan.databinding.FragmentListBinding;


/**
 * A fragment representing a list of Items.
 */
public class ListFragment extends Fragment {


    private ArrayList<Item> data;
    //todo: have Item object instead of String
     private Item selected;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListFragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data= new ArrayList<>();
        data.add(new Item(R.drawable.img1,getString(R.string.SpiderVerse),getString(R.string.SpiderVerseInfo)));
        data.add(new Item(R.drawable.img2,getString(R.string.BabyDriver),getString(R.string.BabyDriverInfo)));
        data.add(new Item(R.drawable.img3,getString(R.string.Dunkirk),getString(R.string.DunkirkInfo)));
        data.add(new Item(R.drawable.img4,getString(R.string.JurassicWorld),getString(R.string.JurassicWorldInfo)));
        data.add(new Item(R.drawable.img5,getString(R.string.Dragons),getString(R.string.DragonsInfo)));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentListBinding binding = FragmentListBinding.inflate(inflater);
        //*
        binding.list.setAdapter(new MyAdapter(data,
                this));
        return binding.getRoot();
    }

    //TODO: attach to the onClickListener for each row in MyAdapter
    public void onClick(int position)
    {
        // todo get Item object instead of name
        selected = data.get(position);
        if(position == data.size()-1)
            showDialog();
        else
            goDetail();
    }
    public void goDetail()
    {
            Bundle bundle=new Bundle();
            // todo : send item object instead of sending string, int, etc.
            // not use putString ! use the correct method.
            bundle.putParcelable(getString(R.string.selected),selected);
            NavController controller= NavHostFragment.findNavController(this);
            controller.navigate(R.id.action_listFragment_to_infoFragment,bundle);

    }

    private void showDialog()
    {
        //*
        AlertDialog.Builder builder= new AlertDialog.Builder(requireActivity());
        builder.setMessage(getString(R.string.warning));
        builder.setPositiveButton(R.string.yes, (dialog, id)->{
            goDetail();
        }).setNegativeButton(R.string.no,(dialog, id)->{
            //do nothing
        });
        builder.create().show();
    }
}