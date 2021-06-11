package com.nateshrader;

import java.math.BigDecimal;

public class BluRayDisc {

    private int uniqueID;
    private String title;
    private int releaseYear;
    private String mPAARating;
    private int runtimeInMin;
    private String directorNameFirst;
    private String directorNameLast;
    private BigDecimal iMDBScore;
    private boolean nateWatched;
    private int nateScoreOutOfTen;

    public int getUniqueID() {
        return uniqueID;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getmPAARating() {
        return mPAARating;
    }

    public int getRuntimeInMin() {
        return runtimeInMin;
    }

    public String getDirectorNameFirst() {
        return directorNameFirst;
    }

    public String getDirectorNameLast() {return directorNameLast;}

    public BigDecimal getiMDBScore() {
        return iMDBScore;
    }

    public boolean hasNateWatched() {
        return nateWatched;
    }

    public int getNateScoreOutOfTen() {
        return nateScoreOutOfTen;
    }

    // Derived attribute for director full name
    public String getDirectorFullName(){
        return directorNameFirst + directorNameLast;
    }




}
