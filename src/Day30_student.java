/**
 * Created by hust on 2018/2/6.
 */
public class Day30_student {
    private int sid;
    private String sname;
    private String nsex;
    private String nscore;
    public Day30_student() {
    }


    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getNsex() {
        return nsex;
    }

    public void setNsex(String nsex) {
        this.nsex = nsex;
    }

    public String getNscore() {
        return nscore;
    }

    public void setNscore(String nscore) {
        this.nscore = nscore;
    }

    @Override
    public String toString() {
        return "Day30_student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", nsex='" + nsex + '\'' +
                ", nscore='" + nscore + '\'' +
                '}';
    }
}
