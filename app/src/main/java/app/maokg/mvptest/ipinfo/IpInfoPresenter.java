package app.maokg.mvptest.ipinfo;

import android.util.Log;

import app.maokg.mvptest.LoadTasksCallBack;
import app.maokg.mvptest.net.NetTask;
import app.maokg.mvptest.model.IpInfo;

public class IpInfoPresenter implements IpInfoContract.Presenter, LoadTasksCallBack {
    private NetTask netTask;
    private IpInfoContract.View addTaskView;

    public IpInfoPresenter(IpInfoContract.View addTaskView, NetTask netTask){
        this.netTask = netTask;
        this.addTaskView = addTaskView;
    }

    @Override
    public void getInfo(String ip) {
        netTask.execute(ip, this);
    }

    @Override
    public void onSuccess(Object o) {
        Log.d("MKG", "onSuccess: " + o.toString());
        if(addTaskView.isActive()){
            addTaskView.setIpInfo((IpInfo) o);
        }
    }

    @Override
    public void onStart() {
        if(addTaskView.isActive()){
            addTaskView.showLoading();
        }
    }

    @Override
    public void onFailed() {
        if(addTaskView.isActive()){
            addTaskView.showError();
        }
    }

    @Override
    public void onFinish() {
        if(addTaskView.isActive()){
            addTaskView.hideLoading();
        }
    }
}
