package org.example.entity;

public class Player {

    private long id;
    private String name;
    private Boolean isPlaying;

    private int playerPosition;

    public static long totalPlayerCount = 0;


    public Player(String name) {
        this.name = name;
        this.id = ++totalPlayerCount;
        isPlaying = Boolean.TRUE;
        playerPosition = 0;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(Boolean playing) {
        isPlaying = playing;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }
}
