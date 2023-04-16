package app.maokg.mvptest.model;

public class IpInfo {
    private int code;
    private String msg;
    private IpData ipData;
    private String tips;
    private long time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public IpData getIpData() {
        return ipData;
    }

    public void setIpData(IpData ipData) {
        this.ipData = ipData;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "IpInfo{" +
                "\ncode=" + code +
                "\n, msg='" + msg + '\'' +
                "\n, ipData=" + ipData.toString() +
                "\n, tips='" + tips + '\'' +
                "\n, time=" + time +
                "\n}";
    }
}
