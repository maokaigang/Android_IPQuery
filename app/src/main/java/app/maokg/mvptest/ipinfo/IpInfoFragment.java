package app.maokg.mvptest.ipinfo;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import app.maokg.mvptest.R;
import app.maokg.mvptest.model.IpData;
import app.maokg.mvptest.model.IpInfo;

public class IpInfoFragment extends Fragment implements IpInfoContract.View {

    private TextView tv_location;
    private Button bt_ipinfo;
    private Dialog mDialog;
    private EditText ed_ip;
    private IpInfoContract.Presenter mPresenter;
    public static IpInfoFragment newInstance(){
        return new IpInfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ipinfo, container, false);
        tv_location = (TextView) root.findViewById(R.id.tv_location);
        bt_ipinfo = (Button) root.findViewById(R.id.bt_ipinfo);
        ed_ip = (EditText) root.findViewById(R.id.ed_ip);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDialog = new ProgressDialog(getActivity());
        mDialog.setTitle("获取数据中");
        bt_ipinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getInfo(ed_ip.getText().toString().isEmpty() ? ed_ip.getHint().toString() : ed_ip.getText().toString());
            }
        });
    }

    @Override
    public void setPresenter(IpInfoContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setIpInfo(IpInfo ipInfo) {
        if(ipInfo != null && ipInfo.getIpData() != null){
            IpData ipData = ipInfo.getIpData();
            tv_location.setText(ipInfo.toString());
        }
    }

    @Override
    public void showLoading() {
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        if(mDialog.isShowing()){
            mDialog.dismiss();
        }
    }

    @Override
    public void showError() {
        Toast.makeText(getActivity().getApplicationContext(), "网络出错", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
