package com.example.voyager.ui.dashboard;

public class DashboardItem {
    String startTime;
    String endTime;
    String score;

    public DashboardItem(String startTime, String endTime, String score) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.score = score;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getScore() {
        return score;
    }
}
