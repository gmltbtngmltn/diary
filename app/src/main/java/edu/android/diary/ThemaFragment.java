package edu.android.diary;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThemaFragment extends Fragment {

private static int[] IMAGE_IDS1 = {R.drawable.moon00,
            R.drawable.moon01, R.drawable.moon02,
            R.drawable.moon03, R.drawable.moon04,
            R.drawable.moon05, R.drawable.moon06, R.drawable.moon07};

private static int[] IMAGE_IDS2 = {R.drawable.umbrella00,
            R.drawable.umbrella01, R.drawable.umbrella02,
            R.drawable.umbrella03, R.drawable.umbrella04,
            R.drawable.umbrella05, R.drawable.umbrella06, R.drawable.umbrella07};


private static int[] IMAGE_IDS3 = {R.drawable.coconut00,
            R.drawable.coconut01, R.drawable.coconut02,
            R.drawable.coconut03, R.drawable.coconut04,
            R.drawable.coconut05, R.drawable.coconut06, R.drawable.coconut07};

private static int[] IMAGE_IDS4 = {R.drawable.chess00,
            R.drawable.chess01, R.drawable.chess02,
            R.drawable.chess03, R.drawable.chess04,
            R.drawable.chess05, R.drawable.chess06, R.drawable.chess07};

private ImageView imageth;
private int comm;

    public ThemaFragment() {
        // Required empty public constructor
    }

    public static  ThemaFragment newInstance(int comm){
        ThemaFragment fragment=new  ThemaFragment();
        fragment.comm=comm;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thema, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        View v=getView();
        imageth = v.findViewById(R.id.imageth);
        List<Diary> list = DiaryDao.getInstance().getContactList();
        int size = list.size();

        if(comm==1) {
            imageth.setImageResource(IMAGE_IDS1[size % 8]);
        }else if(comm==2){
            imageth.setImageResource(IMAGE_IDS2[size % 8]);
        }else if (comm==3){
            imageth.setImageResource(IMAGE_IDS3[size % 8]);
        }else if (comm==4){
            imageth.setImageResource(IMAGE_IDS4[size % 8]);
        }

        Log.i(MainActivity.TAG, "list size = " + list.size());
    }
}
