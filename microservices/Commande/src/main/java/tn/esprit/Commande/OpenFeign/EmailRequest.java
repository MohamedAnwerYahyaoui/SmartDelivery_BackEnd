package tn.esprit.Commande.OpenFeign;

public class EmailRequest {

    private String to;
    private String Subject;
    private String text;


    public EmailRequest() {
    }

    public EmailRequest(String to, String subject, String text) {
        this.to = to;
        Subject = subject;
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
