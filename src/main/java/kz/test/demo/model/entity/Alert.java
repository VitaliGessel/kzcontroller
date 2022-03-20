package kz.test.demo.model.entity;

public class Alert {

    private long id;
    private long userId;
    private boolean alertSms = false;
    private boolean alertEmail = false;
    private boolean alertTelegram = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isAlertSms() {
        return alertSms;
    }

    public void setAlertSms(boolean alertSms) {
        this.alertSms = alertSms;
    }

    public boolean isAlertEmail() {
        return alertEmail;
    }

    public void setAlertEmail(boolean alertEmail) {
        this.alertEmail = alertEmail;
    }

    public boolean isAlertTelegram() {
        return alertTelegram;
    }

    public void setAlertTelegram(boolean alertTelegram) {
        this.alertTelegram = alertTelegram;
    }
}
