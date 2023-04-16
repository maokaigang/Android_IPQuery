package app.maokg.mvptest.net;

import app.maokg.mvptest.LoadTasksCallBack;

public interface NetTask <T>{
    void execute(T data, LoadTasksCallBack callBack);
}
