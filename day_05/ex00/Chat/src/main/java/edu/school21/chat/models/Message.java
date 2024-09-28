package edu.school21.chat.models;

import java.sql.Timestamp;
import java.util.Objects;

public class Message {
    private Long id;
    private User author;
    private Chatroom room;
    private String text;
    private Timestamp dateAndTime;

    public Long getId() {
        return this.id;
    }

    public User getAuthor() {
        return this.author;
    }

    public Chatroom getRoom() {
        return this.room;
    }

    public String getText() {
        return this.text;
    }

    public Timestamp getDateAndTime() {
        return this.dateAndTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateAndTime(Timestamp dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, room, text, dateAndTime);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if ((obj == null) || (obj.getClass() != this.getClass())) {
            result = false;
        } else if (obj == this) {
            result = true;
        } else {
            try {
                Message other = (Message) obj;

                result = id.equals(other.id) && author.equals(other.author)
                        && room.equals(other.room) && text.equals(other.text)
                        && dateAndTime.equals(other.dateAndTime);
            } catch (Exception e) {
                result = false;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "Message {id=" + id + ",\n author=" + author + ",\n room=" + room
                + ",\n text=\"" + text + "\",\n dateAndTime=" + dateAndTime
                + "} ";
    }

}
