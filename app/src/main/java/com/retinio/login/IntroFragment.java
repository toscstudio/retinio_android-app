package com.retinio.login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.retinio.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends Fragment {

    public static IntroFragment newInstance(int position) {
        IntroFragment fragment = new IntroFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    public IntroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_intro, container, false);

        TextView text = (TextView) rootView.findViewById(R.id.intro_text);
        ImageView introFace = (ImageView) rootView.findViewById(R.id.intro_fragment_face);

        ImageView introImage1 = (ImageView) rootView.findViewById(R.id.intro_ic_one);
        ImageView introImage2 = (ImageView) rootView.findViewById(R.id.intro_ic_two);
        ImageView introImage3 = (ImageView) rootView.findViewById(R.id.intro_ic_three);

        switch (getArguments().getInt("position")) {
            case 0:
                text.setText("Discover optical stores and eye clinics near you");
                introFace.setImageResource(R.drawable.intro_male_1);
                introImage1.setImageResource(R.drawable.lineicon_box_eye);
                introImage2.setImageResource(R.drawable.lineicon_shop);
                introImage3.setImageResource(R.drawable.lineicon_map_search);
                break;
            case 1:
                text.setText("Book appointments for your next eye checkup");
                introFace.setImageResource(R.drawable.intro_female_1);
                introImage1.setImageResource(R.drawable.lineicon_calendar_schedule);
                introImage2.setImageResource(R.drawable.lineicon_doctor);
                introImage3.setImageResource(R.drawable.lineicon_eye_chart);
                break;
            case 2:
                text.setText("Look for the store with your favourite eyewear brand");
                introFace.setImageResource(R.drawable.intro_male_2);
                introImage1.setImageResource(R.drawable.lineicon_funky_glass_1);
                introImage2.setImageResource(R.drawable.lineicon_funky_glass_2);
                introImage3.setImageResource(R.drawable.lineicon_funky_glass_3);
                break;
            case 3:
                text.setText("Browse through best offers in optical stores near you");
                introFace.setImageResource(R.drawable.intro_female_2);
                introImage1.setImageResource(R.drawable.lineicon_discount);
                introImage2.setImageResource(R.drawable.lineicon_discount_balloon);
                introImage3.setImageResource(R.drawable.lineicon_discount_gear);
                break;
            default:
                break;
        }
        return rootView;

    }


}
