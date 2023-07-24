package com.example.appfirebase.classNotification.classNotification;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                   "Authorization:key=AAAAIpt27z4:APA91bGM0ztv9tdGAZiFxda0L-T-oUSYUqQYki9w7Z2oLVRG1ctoYc_4YHFC0DudNtkNmPFHG0bjXjufUcGeLMclYZyn0uj1YFbAgSZvJo4TdQJi74obkxtdhHDuyF1WIk_u0eanG2uM"
            }
    )
    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body NotificationSender body);


}
