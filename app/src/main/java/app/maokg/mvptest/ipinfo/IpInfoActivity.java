package app.maokg.mvptest.ipinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import app.maokg.mvptest.net.IpInfoTask;
import app.maokg.mvptest.R;
import app.maokg.mvptest.utils.ActivityUtils;

public class IpInfoActivity extends AppCompatActivity {
    private IpInfoPresenter ipInfoPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip_info);
        IpInfoFragment ipInfoFragment = (IpInfoFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if(ipInfoFragment == null){
            ipInfoFragment = IpInfoFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), ipInfoFragment, R.id.contentFrame);
        }
        IpInfoTask ipInfoTask = IpInfoTask.getInstance();
        ipInfoPresenter = new IpInfoPresenter(ipInfoFragment, ipInfoTask);
        ipInfoFragment.setPresenter(ipInfoPresenter);
    }
}