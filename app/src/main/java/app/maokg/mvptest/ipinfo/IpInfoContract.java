package app.maokg.mvptest.ipinfo;

import app.maokg.mvptest.BaseView;
import app.maokg.mvptest.model.IpInfo;

public interface IpInfoContract {
    interface Presenter{
        void getInfo(String ip);
    }

    interface View extends BaseView<Presenter> {
        void setIpInfo(IpInfo ipInfo);
        void showLoading();
        void hideLoading();
        void showError();
        boolean isActive();
    }
}
