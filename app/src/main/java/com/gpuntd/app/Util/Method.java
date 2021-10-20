package com.gpuntd.app.Util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.ads.consent.ConsentInformation;
import com.google.ads.consent.ConsentStatus;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.gpuntd.app.Interface.VideoAds;
import com.gpuntd.app.LoginActivity;
import com.gpuntd.app.Models.UserBalance;
import com.gpuntd.app.OtpLoginActivity;
import com.gpuntd.app.R;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAdListener;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


import es.dmoral.toasty.Toasty;

import static androidx.core.content.ContextCompat.startActivity;
import static com.google.firebase.auth.PhoneAuthProvider.getCredential;


public class Method {
    // User Loging logs added
    private AdView adView;
    private Ad fbadView;
    private Activity activity;
    public static boolean share = false, loginBack = false, allowPermitionExternalStorage = false, personalization_ad = false;
    private Context _context;
    private DBHelper dbHelper;
    String TAG="KINGSN";
    public com.facebook.ads.InterstitialAd interstitialAd;
    com.facebook.ads.AdView adViewfb;
    public InterstitialAd mInterstitialAd;
    public Dialog loadingDialog;
    private String countryCode;
    private FirebaseAuth auth,mAuth;
    String verificationcodebysystem;
    String codeBySystem,mobileNumber;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks;
   public Method(Context context) {
        this._context = context;
    }
 /*
    public static void UserLoginLogs(final String userid,final String logStatus,final  String deviceID ) {


        String register = RestAPI.API_Login_Logs +"&user_id=" + userid+ "&deviceid=" + deviceID + "&user_ip=" + Constant.PublicIP + "&logs_status=" + logStatus ;

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(register, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                Log.d("Response", new String(responseBody));
                String res = new String(responseBody);

                try {
                    JSONObject jsonObject = new JSONObject(res);

                    JSONArray jsonArray = jsonObject.getJSONArray(AppSid);

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject object = jsonArray.getJSONObject(i);
                        String msg = object.getString("msg");
                        String success = object.getString("success");

                        if (success.equals("1")) {
                            Log.d("Response",msg);
                        } else {
                            Log.d("Response",msg);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("Response-F", new String(responseBody));
            }
        });
    }
    // Get User balance
    public static void UserBalance( String UserID,final TextView txt) {
        String login = RestAPI.API_User_Balance + "&user_id=" + UserID;
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(login, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                Log.d("Response", new String(responseBody));
                String res = new String(responseBody);
                try {
                    JSONObject jsonObject = new JSONObject(res);
                    JSONArray jsonArray = jsonObject.getJSONArray(Constant.AppSid);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String success = object.getString("success");
                        if (success.equals("1")) {
                            String bal = object.getString("points");
                            Constant.userBalance=new UserBalance(bal);
                            txt.setText(bal);
                            Log.d("Response",bal);
                        } else {
                            Log.d("Response", new String(responseBody));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                // progressDialog.dismiss();
            }
        });
    }

    public static void UserBalance(final String UserID) {
        String login = RestAPI.API_User_Balance + "&user_id=" + UserID;
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(login, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                Log.d("Response-u", new String(responseBody));
                String res = new String(responseBody);
                try {
                    JSONObject jsonObject = new JSONObject(res);
                    JSONArray jsonArray = jsonObject.getJSONArray(Constant.AppSid);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String success = object.getString("success");
                        if (success.equals("1")) {
                            String bal = object.getString("points");

                            Log.d("Response-u", bal);

                        } else {
                            Log.d("Response-u", new String(responseBody));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("Response-UF", new String(responseBody));
            }
        });
    }
    // Update User balance
    public static void BalanceUpdate(final String UserID,final String CoinType,final String Coin,final String Ip,final TextView txt,final int pointtype) {

        String login = RestAPI.API_Balance_Update + "&user_id=" + UserID+"&active_type=" + CoinType+"&points=" + Coin+"&user_ip="
                + Ip+"&device_id=" + DeviceID+"&point_type=" + pointtype;

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(login, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                Log.d("Response-b", new String(responseBody));
                String res = new String(responseBody);

                try {
                    JSONObject jsonObject = new JSONObject(res);
                    JSONArray jsonArray = jsonObject.getJSONArray(Constant.AppSid);
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject object = jsonArray.getJSONObject(i);
                        String success = object.getString("success");

                        if (success.equals("1")) {
                            txt.setText("");
                            String bal = object.getString("points");
                            Constant.userBalance =new UserBalance(bal);
                            txt.setText(bal);
                            Log.d("Response",bal);
                        } else {
                            Log.d("Response", new String(responseBody));
                            // Ex.okAlertBox(getResources().getString(R.string.login_failed_message));
                            //Toast.makeText(Login.this, getResources().getString(R.string.login_failed), Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                // progressDialog.dismiss();
            }
        });
    }

    public static void BalanceUpdate(final String UserID,final String CoinType,final String Coin,final String Ip,final int pointtype) {

        String login = RestAPI.API_Balance_Update + "&user_id=" + UserID+"&active_type=" + CoinType+"&points=" + Coin+"&user_ip="
                + Ip+"&device_id=" + DeviceID+"&point_type=" + pointtype;

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(login, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                Log.d("Response-b", new String(responseBody));
                String res = new String(responseBody);

                try {
                    JSONObject jsonObject = new JSONObject(res);
                    JSONArray jsonArray = jsonObject.getJSONArray(Constant.AppSid);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String success = object.getString("success");
                        if (success.equals("1")) {
                            String bal = object.getString("points");
                            Constant.userBalance =new UserBalance(bal);
                            Log.d("Response",bal);
                        } else {
                            Log.d("Response", new String(responseBody));
                            // Ex.okAlertBox(getResources().getString(R.string.login_failed_message));
                            //Toast.makeText(Login.this, getResources().getString(R.string.login_failed), Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                // progressDialog.dismiss();
            }
        });
    }

*/
    //---------------Banner Ad---------------//


   /* public void showBannerAd(Activity activity, FrameLayout frameLayout) {
        // Log.d("Response-ads", Boolean.toString(Constant.settings.isBanner_ad()));
        if (Constant.settings.getBanner_ad().toLowerCase().equals("addmob")) {
            if (ConsentInformation.getInstance(_context).getConsentStatus() == ConsentStatus.NON_PERSONALIZED) {
                showNonPersonalizedAds(frameLayout);
            } else {
                showPersonalizedAds(frameLayout);
            }

        } else if (Constant.settings.getBanner_ad().toLowerCase().equals("facebook")) {
            //showFbBanner(activity,linearLayout);
           showFbBanner2(activity,frameLayout);
              }
         else if(Constant.settings.getBanner_ad().toLowerCase().equals("both")) {
               // showBoth_BannerAd();
            Log.d(TAG, "showIndustrialAd: "+Constant.banner_switch);
            if (Constant.banner_switch == 1) {
                Log.d(TAG, "showIndustrialAd: indusrtialcall:on both case");
                if (ConsentInformation.getInstance(_context).getConsentStatus() == ConsentStatus.NON_PERSONALIZED) {
                    showNonPersonalizedAds(frameLayout);
                } else {
                    showPersonalizedAds(frameLayout);
                }
                Constant.banner_switch = 0;
            } else {
                Log.d(TAG, "showIndustrialAd: fbindusrtialcall:on both case");
                showFbBanner2(activity,frameLayout);
                Constant.banner_switch = 1;
            }
             }
    }

    private void showPersonalizedAds(FrameLayout frameLayout) {

        if (Constant.settings.getBanner_ad().toLowerCase().equals("addmob")) {
            AdView adView = new AdView(_context);
            AdRequest adRequest = new AdRequest.Builder()
                    .build();
            adView.setAdUnitId(Constant.settings.getBanner_ad_id());
            adView.setAdSize(AdSize.SMART_BANNER);
            frameLayout.addView(adView);
            adView.loadAd(adRequest);
        }
    }


     private void showNonPersonalizedAds(FrameLayout frameLayout) {
        Bundle extras = new Bundle();
        extras.putString("npa", "1");
        if (Constant.settings.getBanner_ad().toLowerCase().equals("addmob")) {
            AdView adView = new AdView(_context);
            AdRequest adRequest = new AdRequest.Builder()
                    .addNetworkExtrasBundle(AdMobAdapter.class, extras)
                    .build();
            adView.setAdUnitId(Constant.settings.getBanner_ad_id());
            adView.setAdSize(AdSize.SMART_BANNER);
            frameLayout.addView(adView);
            adView.loadAd(adRequest);
        }
    }

    public void showFbBanner(Activity activity, LinearLayout linearLayout)
    {

        fbadView = new com.facebook.ads.AdView(activity, Constant.settings.getFb_banner_ad_id(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (linearLayout);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        fbadView.loadAd();
    }

    public void showFbBanner2(Activity activity, FrameLayout frameLayout)
    {
        Log.d("KINGSN", "showFbBanner2: "+Constant.settings.getFb_banner_ad_id());

        adViewfb = new com.facebook.ads.AdView(activity, Constant.settings.getFb_banner_ad_id(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
        // Find the Ad Container
        FrameLayout adContainer = (frameLayout);

        // Add the ad view to your activity layout
        adContainer.addView(adViewfb);

        adViewfb.loadAd();
       // advieww.setVisibility(View.VISIBLE);

    }
*/
    //---------------Banner Ad---------------//

    //---------------Rewarded video ad---------------//

  /*  public void showVideoAd(final Activity activity,final String uid, final String Device) {
        if (Constant.settings.getRewarded_video_ads().toLowerCase().equals("addmob")) {
            Video_ads_limit_count(activity,uid,Device);
            if (Constant.VIDEO_AD_COUNT <= Integer.parseInt(Constant.settings.getVideo_ads_limit())) {
                final ProgressDialog progressDialog = new ProgressDialog(activity);
                progressDialog.setMessage(activity.getString(R.string.adsloading));
                progressDialog.setCancelable(false);
                progressDialog.show();
                mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(activity);
                if (Constant.settings != null) {
                    if (Constant.settings.getRewarded_video_ads().toLowerCase().equals("addmob")) {
                        if (mRewardedVideoAd != null) {
                            AdRequest adRequest;
                            if (ConsentInformation.getInstance(activity).getConsentStatus() == ConsentStatus.PERSONALIZED) {
                                adRequest = new AdRequest.Builder().build();
                            } else {
                                Bundle extras = new Bundle();
                                extras.putString("npa", "1");
                                adRequest = new AdRequest.Builder()
                                        .addNetworkExtrasBundle(AdMobAdapter.class, extras)
                                        .build();
                            }

                            mRewardedVideoAd.loadAd(Constant.settings.getRewarded_video_ads_id(), adRequest);
                            mRewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
                                @Override
                                public void onRewarded(RewardItem reward) {
                                    Log.d("reward_video_ad", "reward");

                                    Toast.makeText(activity, "Reward Point Added", Toast.LENGTH_SHORT).show();
                                    BalanceUpdate(uid,"Video Ads",Constant.settings.getVideo_add_point(),Constant.PublicIP,1);
                                    Ads_Count_Update(uid,Device);
                                    Video_ads_limit_count(activity,uid,Device);
                                }

                                @Override
                                public void onRewardedVideoAdLeftApplication() {
                                    Log.d("reward_video_ad", "AdLeftApplication");
                                }

                                @Override
                                public void onRewardedVideoAdFailedToLoad(int i) {
                                    progressDialog.dismiss();
                                    Toast.makeText(activity, "Video Ads load Failed", Toast.LENGTH_SHORT).show();
                                    Log.d("reward_video_ad", "Failed");
                                }

                                @Override
                                public void onRewardedVideoAdClosed() {
                                    Events.VideoAdsReload adsReload = new Events.VideoAdsReload("100");
                                    EventBus.getDefault().post(adsReload);
                                    Log.d("reward_video_ad", "close");


                                }

                                @Override
                                public void onRewardedVideoAdLoaded() {
                                    //  mRewardedVideoAd.show();
                                    progressDialog.dismiss();
                                    Toast.makeText(activity, "Video Ads load", Toast.LENGTH_SHORT).show();
                                    Log.d("reward_video_ad", "Video Ads load");
                                }

                                @Override
                                public void onRewardedVideoAdOpened() {
                                    Log.d("reward_video_ad", "open");
                                }

                                @Override
                                public void onRewardedVideoStarted() {
                                    Log.d("reward_video_ad", "start");
                                }

                                @Override
                                public void onRewardedVideoCompleted() {
                                    Log.d("reward_video_ad", "completed");

                                }
                            });
                        }
                    } else {
                        progressDialog.dismiss();

                    }
                } else {
                    progressDialog.dismiss();
                }
            }else{ Toast.makeText(activity, "Daily Ads Limit Over", Toast.LENGTH_SHORT).show();}
        }else{ Toast.makeText(activity, "Daily Ads Limit Over", Toast.LENGTH_SHORT).show();}
    }*/

    //---------------Rewarded video ad---------------//

    //---------------Interstitial Ad---------------//

    public void loadInter(Activity activity) {
      //mInterstitial = new InterstitialAd(activity);

           // Constant.AD_COUNT = Constant.AD_COUNT + 1;

                //Constant.AD_COUNT = 0;
                AdRequest adRequest;

                if (ConsentInformation.getInstance(activity).getConsentStatus() == ConsentStatus.PERSONALIZED) {
                    adRequest = new AdRequest.Builder().build();
                } else {
                    Bundle extras = new Bundle();
                    extras.putString("npa", "1");
                    adRequest = new AdRequest.Builder()
                            .addNetworkExtrasBundle(AdMobAdapter.class, extras)
                            .build();
                }
          InterstitialAd.load(activity, "ca-app-pub-3940256099942544/1033173712", adRequest,
                  new InterstitialAdLoadCallback() {

                      @Override
                      public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                          // The mInterstitialAd reference will be null until
                          // an ad is loaded.
                          mInterstitialAd = interstitialAd;
                          Log.i(TAG, "onAdLoaded");
                      }

                      @Override
                      public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                          // Handle the error
                          Log.i(TAG, loadAdError.getMessage());
                          mInterstitialAd = null;
                      }


                });


    }

    //---------------Interstitial Ad---------------//

   /* public void Video_ads_limit_count(final Activity activity,final String uid, final String Device){
    String login = RestAPI.API_Video_Ads_Count + "&user_id=" + uid + "&device_id=" + Device;
    AsyncHttpClient client = new AsyncHttpClient();
    client.get(login, null, new AsyncHttpResponseHandler() {
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            Log.d("Response", new String(responseBody));
            String res = new String(responseBody);
            try {
                JSONObject jsonObject = new JSONObject(res);
                JSONArray jsonArray = jsonObject.getJSONArray(Constant.AppSid);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    String success = object.getString("success");
                    if (success.equals("1")) {
                        int  Counter =Integer.parseInt(object.getString("ads_count"));
                        Constant.VIDEO_AD_COUNT = Counter;

                        int CountLimit=Integer.parseInt(Constant.settings.getDaily_spin_limit());

                    }
                    else {

                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

        }
    });
}

    public void Ads_Count_Update(final String uid, final String Device) {
        String login = RestAPI.API_Video_Ads_Count_update + "&user_id=" + uid + "&device_id=" + Device;
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(login, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                Log.d("Response-count", new String(responseBody));
                String res = new String(responseBody);
                try {
                    JSONObject jsonObject = new JSONObject(res);
                    JSONArray jsonArray = jsonObject.getJSONArray(Constant.AppSid);
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject object = jsonArray.getJSONObject(i);
                        String success = object.getString("success");

                        if (success.equals("1")) {
                        } else {
                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
*/
   /* public void showFacdebookAd(Activity activity1)
    {
        if (interstitialAd != null) {
            interstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
            Constant.AD_COUNT = Constant.AD_COUNT + 1;
            AudienceNetworkAds.initialize(activity1);
            interstitialAd = new com.facebook.ads.InterstitialAd(activity1, Constant.settings.getFb_industrial_ad_id());


        // Create listeners for the Interstitial Ad
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
                //Log.e(TAG, "Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                //Log.e(TAG, "Interstitial ad dismissed.");
              //  interstitialAd.loadAd();

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e(TAG, "FBInterstitial ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d(TAG, "FBInterstitial ad is loaded and ready to be displayed!");
                // Show the ad
                //interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
                //Log.d(TAG, "Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
                //Log.d(TAG, "Interstitial ad impression logged!");
            }
        };

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());
      }
    }
    public void showIndustrialAd(Activity activity1)
    {
       if( Constant.AD_COUNT == Integer.parseInt(Constant.settings.getInterstital_ad_click())) {
           Constant.AD_COUNT = 0;
           if (Constant.settings.getInterstital_ad().toLowerCase().equals("addmob")) {
             //  loadInter(activity1);
               showadmobindus(activity1);

           } else if (Constant.settings.getInterstital_ad().toLowerCase().equals("facebook")) {
               showFacdebookAd(activity1);
           } else if (Constant.settings.getInterstital_ad().toLowerCase().equals("both")) {
               Log.d(TAG, "showIndustrialAd: "+Constant.industrial_switch);
               if (Constant.industrial_switch == 1) {
                   Log.d(TAG, "showIndustrialAd: indusrtialcall:on both case");
                   showadmobindus(activity1);
                   Constant.industrial_switch = 0;
               } else {
                   Log.d(TAG, "showIndustrialAd: fbindusrtialcall:on both case");
                   showFacdebookAd(activity1);
                   Constant.industrial_switch = 1;
               }
           }

       }else{
           Constant.AD_COUNT =Constant.AD_COUNT+1  ;
       }
    }

    public void createInterstitialAd(Activity activity) {

        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(activity, "ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i(TAG, loadAdError.getMessage());
                        mInterstitialAd = null;
                    }


                });
    }

        public void showadmobindus(Activity activity){
            if (mInterstitialAd != null) {
                mInterstitialAd.show(activity);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
                loadInter(activity);
            }
        }
*/
    public static boolean isConnectionAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnected()
                    && netInfo.isConnectedOrConnecting()
                    && netInfo.isAvailable();
        }
        return false;
    }

    public void loadingDialogg(Activity activity) {
       loadingDialog = new Dialog(activity);
        loadingDialog.setContentView(R.layout.lotiee_loading);
        loadingDialog.setCancelable(false);
        Objects.requireNonNull(loadingDialog.getWindow()).setBackgroundDrawableResource(
                R.color.transparent);
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        } else {
            loadingDialog = new Dialog(activity);
            loadingDialog.setContentView(R.layout.lotiee_loading);
            loadingDialog.setCancelable(false);
            Objects.requireNonNull(loadingDialog.getWindow()).setBackgroundDrawableResource(
                    R.color.transparent);
            loadingDialog.show();
        }
    }
    public void loadingDialoggDismiss(Activity activity) {
        loadingDialog.dismiss();

    }

    public void showToasty(Activity activity,String Type,String Message){
        if(Type.equals("1")) {
            Toasty.success(activity, ""+Message, Toast.LENGTH_SHORT).show();
        }else{
            Toasty.error(activity, ""+Message, Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("HardwareIds")
    public String getDeviceId(Context context) {

        String deviceId;

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            deviceId = android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
            // Toast.makeText(context,  deviceId, Toast.LENGTH_SHORT).show();

        }else {

            final TelephonyManager mTelephony = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);



            if (mTelephony.getDeviceId() != null) {
                deviceId = mTelephony.getDeviceId();
            } else {
                deviceId = android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
                //  Toast.makeText(LoginActivity.this,  deviceId, Toast.LENGTH_SHORT).show();
            }
        }

        return deviceId;

    }
}