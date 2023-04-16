package app.maokg.mvptest.model;

public class IpData {
    private String info1;
    private String info2;
    private String info3;
    private String isp;

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1;
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2;
    }

    public String getInfo3() {
        return info3;
    }

    public void setInfo3(String info3) {
        this.info3 = info3;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    @Override
    public String toString() {
        return "IpData{" +
                "\n     info1='" + info1 + '\'' +
                "\n     ,info2='" + info2 + '\'' +
                "\n     ,info3='" + info3 + '\'' +
                "\n     ,isp='" + isp + '\'' +
                "\n }";
    }
}
