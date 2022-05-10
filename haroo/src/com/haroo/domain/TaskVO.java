package com.haroo.domain;

import java.io.Serializable;

public class TaskVO implements Serializable {
<<<<<<< HEAD
    private int id;
    private String groupId;
    private String title;
    private String writer;
    private String content;
    private String start;
    private String end;
    private boolean allday;
    private String textColor;
    private String backgroundColor;
    private String borderColor;
    private int em_no;

    public TaskVO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEm_no() {
        return em_no;
    }

    public void setEm_no(int em_no) {
        this.em_no = em_no;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
=======
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
>>>>>>> cc8be617ba2be86f7e24b1a8a45710aa8b502c6a
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

<<<<<<< HEAD
    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
=======
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
>>>>>>> cc8be617ba2be86f7e24b1a8a45710aa8b502c6a
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

<<<<<<< HEAD
    public boolean isAllday() {
        return allday;
    }

    public void setAllday(boolean allday) {
        this.allday = allday;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public String toString() {
        return "TaskVO{" +
                "id=" + id +
                ", groupId='" + groupId + '\'' +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", allday=" + allday +
                ", textColor='" + textColor + '\'' +
                ", backgroundColor='" + backgroundColor + '\'' +
                ", borderColor='" + borderColor + '\'' +
                ", em_no=" + em_no +
                '}';
=======
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
>>>>>>> cc8be617ba2be86f7e24b1a8a45710aa8b502c6a
    }
}
