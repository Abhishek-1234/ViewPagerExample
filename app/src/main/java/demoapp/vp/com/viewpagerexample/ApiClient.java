package demoapp.vp.com.viewpagerexample;

/**
 * Created by jitesh.upadhyay on 8/7/2017.
 */


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    //public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    public static final String BASE_URL = "https://developers.zomato.com/api/v2.1/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}