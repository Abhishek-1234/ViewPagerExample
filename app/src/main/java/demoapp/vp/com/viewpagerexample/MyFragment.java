package demoapp.vp.com.viewpagerexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class MyFragment extends Fragment implements YourFragmentInterface {
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    RecyclerView recyclerView;

    public static final MyFragment newInstance(String message) {
        MyFragment f = new MyFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //String message = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.myfragment_layout, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(DemoEvent event) {
        /*if (event.action.equals(DataEvent.DATA_OBTAINED1)) {
            Toast.makeText(getActivity(), "Updating Tab1", Toast.LENGTH_SHORT).show();
            List<JsonDummyRepresentation> albumList = event.responseObject;
            recyclerView.setAdapter(new RestaurantListAdapter(this.getActivity(), albumList));
        } else  if (event.action.equals(DataEvent.DATA_ERROR1)) {
            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
        }*/
        if (event.ACTION.equals(DemoEvent.Action.RESTAURANTSBEAN)){
            //LocationSuggestionsBean suggestion=event.getLocationDetails().getLocation_suggestions().get(0);
            Toast.makeText(this.getActivity(), "update tab two restaurant details", Toast.LENGTH_SHORT).show();
            List<RestaurantsBean> mList=event.getmList();
            recyclerView.setAdapter(new RestaurantListAdapter(this.getActivity(),mList));

            //Toast.makeText(this.getActivity(), ""+suggestion.getCity_name()+" "+suggestion.getCountry_name()+" "+suggestion.getLatitude()+" "+suggestion.getEntity_type(), Toast.LENGTH_SHORT).show();
        }
        else if (event.ACTION.equals(DemoEvent.Action.ERROR)){
            Toast.makeText(this.getActivity(), "this is error", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this.getActivity(), "this is nothing hapening part", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void fragmentBecameVisible(String query) {
        //not using Query currently but you can use query string
        //new ApiRequester().doRequest(DataEvent.DATA_OBTAINED1,DataEvent.DATA_ERROR1,1);

        new ApiRequester().getRestaurants("9d2944162894f3271XXXXXXXXXXXXXXX","96","metro");
    }
}
