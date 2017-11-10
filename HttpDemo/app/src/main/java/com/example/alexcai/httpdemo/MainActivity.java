package com.example.alexcai.httpdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private TextView textView;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String in = (String) msg.obj;
            updateText(in);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.tv_textView);
//        getHttp();


        postHttp();


        // 发送网络请求
//        starHttp();

    }

    // post request
    private  void postHttp(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://httpbin.org/").build();
        XCHttpClient httpClient = retrofit.create(XCHttpClient.class);

        HashMap<String,Object> params = new HashMap<>();
        params.put("name","alex");


//        Call<ResponseBody> request = httpClient.requestForPost(params);
//        Call<ResponseBody> request = httpClient.requestForPostQuery("alexiuce","hz");


        RequestBody body = RequestBody.create(MediaType.parse("application/json"),"{\"name\":\"alexiuce\",\"job\":\"dev\"}");

        JSONObject

        Call<ResponseBody> request = httpClient.requestForPostBody(body);
        request.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String result =  response.body().string();
                    System.out.println(result);
                    textView.setText(result);
                }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


    // Get request
    private void getHttp(){
        final Retrofit refit = new Retrofit.Builder().baseUrl("http://httpbin.org/").build();
        XCHttpClient httpClient = refit.create(XCHttpClient.class);
        Call<ResponseBody> request = httpClient.responForGet();

        request.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    String result =  response.body().string(); //StringUtil.stringFromInputStream(response.body().byteStream());
                    System.out.println(result);
                    textView.setText(result);
                }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void starHttp(){
               /*开启子线程 发送网络请求*/
        new Thread  (new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://httpbin.org/get");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = urlConnection.getInputStream();


                    // 方式1
//               final String result = StringUtil.stringFromInputStream(inputStream);
//               runOnUiThread(new Runnable() {
//                   @Override
//                   public void run() {
//                       updateText(result);
//                   }
//               });
                    // 方式2
                    String result = StringUtil.stringFromInputStream(inputStream);
                    Message msg = new Message();
                    msg.obj = result;
                    mHandler.sendMessage(msg);

                }catch (Exception e){

                    System.out.println(e.getMessage());

                }
            }
        }).start();
    }
    private void updateText(String text){
        System.out.println(text + "====");
        textView.setText(text);
    }
}
