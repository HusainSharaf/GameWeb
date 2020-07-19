package com.example.gameweb;

import android.graphics.Color;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Game {

    private String GameTitle;
    private String GameDescription;
    private int GameImage;
    private int GameColor;
    private int GameTitleSize;


    public Game(String gameTitle, String gameDescription, int gameImage, int gameColor, int gameTitleSize) {
        GameTitle = gameTitle;
        GameDescription = gameDescription;
        GameImage = gameImage;
        GameColor = gameColor;
        GameTitleSize = gameTitleSize;

    }



    public String getGameTitle() {
        return GameTitle;
    }

    public void setGameTitle(String gameTitle) {
        GameTitle = gameTitle;
    }

    public String getGameDescription() {
        return GameDescription;
    }

    public void setGameDescription(String gameDescription) {
        GameDescription = gameDescription;
    }

    public int getGameImage() {
        return GameImage;
    }

    public void setGameImage(int gameImage) {
        GameImage = gameImage;
    }

    public int getGameColor() {
        return GameColor;
    }

    public void setGameColor(int gameColor) {
        GameColor = gameColor;
    }

    public int getGameTitleSize() {
        return GameTitleSize;
    }

    public void setGameTitleSize(int gameTitleSize) {
        GameTitleSize = gameTitleSize;
    }
}
