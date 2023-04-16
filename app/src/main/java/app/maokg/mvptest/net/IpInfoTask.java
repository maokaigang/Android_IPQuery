package app.maokg.mvptest.net;

import android.util.Log;

import app.maokg.mvptest.LoadTasksCallBack;
import app.maokg.mvptest.model.IpInfo;
import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.RequestParams;

public class IpInfoTask implements NetTask<String> {

    private static IpInfoTask INSTANCE = null;
    private static final String HOST = "https://api.vore.top/api/IPdata";
    private IpInfoTask(){}

    public static IpInfoTask getInstance(){
        if (INSTANCE == null){
            INSTANCE = new IpInfoTask();
        }
        return INSTANCE;
    }

    @Override
    public void execute(String data, final LoadTasksCallBack callBack) {
        RequestParams requestParams = new RequestParams();
        requestParams.addFormDataPart("ip", data);

        HttpRequest.get(HOST, requestParams, new BaseHttpRequestCallback<IpInfo>(){
            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                callBack.onFinish();
            }

            @Override
            protected void onSuccess(IpInfo ipInfo) {
                super.onSuccess(ipInfo);
                callBack.onSuccess(ipInfo);
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                Log.d("MKG", "onFailure: " + errorCode + "  " + msg);
                callBack.onFailed();
            }
        });

    }
}
