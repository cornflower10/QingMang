package com.qingmang.api;


import com.qingmang.moudle.entity.BaseEntity;
import com.qingmang.moudle.entity.LoginEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by xiejingbao on 2017/5/18.
 */

public interface ApiService {

    /**
     * 注册
     * @param userName
     * @param type
     * @param sign
     * @return
     */
    @FormUrlEncoded
    @POST("regist.php")
    Observable<BaseEntity> getSms(@Field("mobile") String userName,
                                 @Field("mobileCodeType") String type,
                                 @Field("sign") String sign);

    /**
     * 登录
     * @param userName
     * @param passWd
     * @return
     */
    @FormUrlEncoded
    @POST("regist.php")
    Observable<BaseEntity<LoginEntity>> login(@Field("phone") String userName,
                                              @Field("password") String passWd
                                              );
//
//
//
//    @FormUrlEncoded
//    @POST("agency/shuanglu/changePassword")
//    Observable<ChangePasswdEntity> changePasswd(@Field("oldPassword") String userName,
//                                                @Field("newPassword") String passWd,
//                                                @Field("sign") String sign
//    );
//
//    //上传同时
//    @Multipart
//    @POST("agency/shuanglu/submitIntentAgencyInfo")
//    Observable<UploadEntity> uploads(@PartMap Map<String, RequestBody> params
//    );
//
//    @FormUrlEncoded
//    @POST("agency/shuanglu/isAgencyNameUsed")
//    Observable<AgencyNameUsed> isAgencyNameUsed(@Field("customName") String customName,
//                                                @Field("sign") String sign);
}
