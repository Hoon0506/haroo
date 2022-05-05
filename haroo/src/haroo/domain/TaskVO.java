package haroo.domain;

import java.io.Serializable;

public class TaskVO implements Serializable {
    private int no;
    private String title;
    private String place;
    private String friends;
    private String start;
    private String end;
    private String time;
    private String contents;
    private int emNo;

    public TaskVO() {}

    public TaskVO(int no, String title, String place, String friends, String start, String end, String time, String contents, int emNo) {
        this.no = no;
        this.title = title;
        this.place = place;
        this.friends = friends;
        this.start = start;
        this.end = end;
        this.time = time;
        this.contents = contents;
        this.emNo = emNo;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getEmNo() {
        return emNo;
    }

    public void setEmNo(int emNo) {
        this.emNo = emNo;
    }
}
