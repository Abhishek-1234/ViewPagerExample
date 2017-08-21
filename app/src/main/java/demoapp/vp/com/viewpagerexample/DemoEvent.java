package demoapp.vp.com.viewpagerexample;

import java.util.List;

/**
 * Created by ABHISHEK on 20-08-2017.
 */

public class DemoEvent {

    public String ACTION=null;
  //  public LocationDetails locationDetails=null;
    public List<RestaurantsBean> mList=null;


    public DemoEvent(String ACTION){
        this.ACTION=ACTION;
    }

   /* public DemoEvent(String ACTION, LocationDetails locationDetails)
    {
        this.ACTION=ACTION;
        this.locationDetails=locationDetails;
    }
*/
    public DemoEvent(String ACTION, List<RestaurantsBean> mList){
        this.ACTION=ACTION;
        this.mList=mList;
    }

    public void setACTION(String ACTION) {
        this.ACTION = ACTION;
    }

   /* public void setLocationDetails(LocationDetails locationDetails) {
        this.locationDetails = locationDetails;
    }*/

    public String getACTION() {
        return ACTION;
    }

    /*public LocationDetails getLocationDetails() {
        return locationDetails;
    }
*/
    public List<RestaurantsBean> getmList() {
        return mList;
    }

    public void setmList(List<RestaurantsBean> mList) {
        this.mList = mList;
    }

    public static  class Action{
        public static String ERROR="error";
        public static String LOCATIONDETAILS="locationdetails";
        public static String RESTAURANTSBEAN="restaurantsbean";
    }
}
