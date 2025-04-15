package tn.esprit.annonce.Entity;

import java.util.List;

public class GroupNotification {
    private String template;
    private List<IndividualNotification> notifications;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public List<IndividualNotification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<IndividualNotification> notifications) {
        this.notifications = notifications;
    }
}