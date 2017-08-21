package demoapp.vp.com.viewpagerexample;

/**
 * Created by jitesh.upadhyay on 8/7/2017.
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Abhishek on 18/05/16.
 */
public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.MyViewHolder> {

    private Context mContext;
    //private List<JsonDummyRepresentation> albumList;
    private List<RestaurantsBean> restaurantsBeen;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, albumid,id,city,address;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            /*
            albumid = (TextView) view.findViewById(R.id.albumid);
            id = (TextView) view.findViewById(R.id.id);
            ;*/
            title = (TextView) view.findViewById(R.id.title_data);
            address=(TextView)view.findViewById(R.id.address);
            city=(TextView)view.findViewById(R.id.city);
            thumbnail = (ImageView) view.findViewById(R.id.list_image);

        }
    }


    public RestaurantListAdapter(Context mContext, List<RestaurantsBean> restaurantsBeen) {
        this.mContext = mContext;
        this.restaurantsBeen = restaurantsBeen;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_response, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        /*JsonDummyRepresentation album = albumList.get(position);
        holder.title.setText(album.getTitle());
        holder.albumid.setText(album.getAlbumId() + " is the AlbumId");
        holder.id.setText(album.getId().toString() );
        Glide.with(mContext).load(album.getThumbnailUrl()).into(holder.thumbnail);
*/
        RestaurantsBean.RestaurantBean restaurant=restaurantsBeen.get(position).getRestaurant();
        holder.title.setText(restaurant.getName());
        holder.city.setText(restaurant.getLocation().getCity());
        holder.address.setText(restaurant.getLocation().getAddress());
        if (!restaurant.getThumb().equals(""))
        Glide.with(mContext).load(restaurant.getThumb()).into(holder.thumbnail);
        else
            holder.thumbnail.setImageResource(R.mipmap.ic_launcher);

    }



    @Override
    public int getItemCount() {
        return restaurantsBeen.size();
    }
}