package impression11.lesson6;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// 2 When creating fragments remember to change "extends Fragment" to "extends android.support.v4.app.Fragment"

public class fragment1 extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // 2 setup the visual interface for this fragment


        View rootView = inflater.inflate(R.layout.fragment_fragment1, container, false);

        return rootView;
    }

}
