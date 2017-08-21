package demoapp.vp.com.viewpagerexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jitesh.upadhyay on 8/7/2017.
 */

public interface ApiInterface {
    /*@GET("albums/{albumId}/photos")
    Call<List<JsonDummyRepresentation>> getDetails(@Path("albumId") int albumId);*/

    @GET("search")
    Call<RestaurantSearch> getRestaurantSearch(@Header("user-key") String apikey,
                                               @Query("entity_id") String entityId,
                                               @Query("entity_type") String entityType);
}
