package entity;

public class WebInfo {
    private String visittime;
    private Integer visittimes;

    public String getVisittime() {
        return visittime;
    }

    public void setVisittime(String visittime) {
        this.visittime = visittime;
    }

    public Integer getVisittimes() {
        return visittimes;
    }

    public void setVisittimes(Integer visittimes) {
        this.visittimes = visittimes;
    }

    @Override
    public String toString() {
        return "WebInfo{" +
                "visittime='" + visittime + '\'' +
                ", visittimes=" + visittimes +
                '}';
    }
}
