package com.example.geochatroom;

import java.time.Instant;

public class Message {
    private final String author;
    private final long timestamp;
    private final float latitude;
    private final float longitude;
    private final String content;

    public Message(String author, float latitude, float longitude, String content) {
        this.author = author;
        this.timestamp = System.currentTimeMillis() / 1000L;
        this.latitude = latitude;
        this.longitude = longitude;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getContent() {
        return content;
    }
}
