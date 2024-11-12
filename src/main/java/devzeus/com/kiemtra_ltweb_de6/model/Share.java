package devzeus.com.kiemtra_ltweb_de6.model;

import java.util.Date;

public class Share {
    private int shareId;
    private String emails;
    private Date sharedDate;
    private String username;
    private int videoId;

    public Share() {}

    public Share(int shareId, String emails, Date sharedDate, String username, int videoId) {
        this.shareId = shareId;
        this.emails = emails;
        this.sharedDate = sharedDate;
        this.username = username;
        this.videoId = videoId;
    }

    public int getShareId() { return shareId; }
    public void setShareId(int shareId) { this.shareId = shareId; }

    public String getEmails() { return emails; }
    public void setEmails(String emails) { this.emails = emails; }

    public Date getSharedDate() { return sharedDate; }
    public void setSharedDate(Date sharedDate) { this.sharedDate = sharedDate; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public int getVideoId() { return videoId; }
    public void setVideoId(int videoId) { this.videoId = videoId; }
}
