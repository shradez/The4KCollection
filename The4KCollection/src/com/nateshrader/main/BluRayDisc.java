package com.nateshrader.main;

import java.math.BigDecimal;
import java.util.Comparator;

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

    public BluRayDisc(int uniqueID, String title, int releaseYear, String mPAARating, int runtimeInMin, String directorNameFirst, String directorNameLast, BigDecimal iMDBScore, boolean nateWatched) {
        this.uniqueID = uniqueID;
        this.title = title;
        this.releaseYear = releaseYear;
        this.mPAARating = mPAARating;
        this.runtimeInMin = runtimeInMin;
        this.directorNameFirst = directorNameFirst;
        this.directorNameLast = directorNameLast;
        this.iMDBScore = iMDBScore;
        this.nateWatched = nateWatched;
    }

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

    public String getDirectorNameLast() {
        return directorNameLast;
    }

    public BigDecimal getiMDBScore() {
        return iMDBScore;
    }

    public boolean hasNateWatched() {
        return nateWatched;
    }

    // Derived attribute for director full name
    public String getDirectorFullName() {
        return directorNameFirst + directorNameLast;
    }

    // toString
    public String toString() {
        return title + " | " + releaseYear + " | " + mPAARating + " | " + runtimeInMin + " minutes" + " | " + "IMDB Score: " + iMDBScore;
    }

    // Comparator method for sorting by IMDB score, descending
    public static Comparator<BluRayDisc> BRDIMDBScoreDescendingComparator = new Comparator<BluRayDisc>() {
        @Override
        public int compare(BluRayDisc o1, BluRayDisc o2) {
            BigDecimal iMDBScore1 = o1.getiMDBScore();
            BigDecimal iMDBScore2 = o2.getiMDBScore();
            return iMDBScore2.compareTo(iMDBScore1);
        }
    };

    // Comparator method for sorting by IMDB score, ascending
    public static Comparator<BluRayDisc> BRDIMDBScoreAscendingComparator = new Comparator<BluRayDisc>() {
        @Override
        public int compare(BluRayDisc o1, BluRayDisc o2) {
            BigDecimal iMDBScore1 = o1.getiMDBScore();
            BigDecimal iMDBScore2 = o2.getiMDBScore();
            return iMDBScore1.compareTo(iMDBScore2);
        }
    };

    // Comparator method for sorting by runtime, descending
    public static Comparator<BluRayDisc> BRDRuntimeDescendingComparator = new Comparator<BluRayDisc>() {
        @Override
        public int compare(BluRayDisc o1, BluRayDisc o2) {
            int runtime1 = o1.getRuntimeInMin();
            int runtime2 = o2.getRuntimeInMin();
            return runtime2 - runtime1;
        }
    };

    // Comparator method for sorting by runtime, ascending
    public static Comparator<BluRayDisc> BRDRuntimeAscendingComparator = new Comparator<BluRayDisc>() {
        @Override
        public int compare(BluRayDisc o1, BluRayDisc o2) {
            int runtime1 = o1.getRuntimeInMin();
            int runtime2 = o2.getRuntimeInMin();
            return runtime1 - runtime2;
        }
    };

    // Comparator method for sorting by release year, descending
    public static Comparator<BluRayDisc> BRDReleaseYearDescendingComparator = new Comparator<BluRayDisc>() {
        @Override
        public int compare(BluRayDisc o1, BluRayDisc o2) {
            int releaseYear1 = o1.getReleaseYear();
            int releaseYear2 = o2.getReleaseYear();
            return releaseYear2 - releaseYear1;
        }
    };

    // Comparator method for sorting by release year, ascending
    public static Comparator<BluRayDisc> BRDRelaseYearAscendingComparator = new Comparator<BluRayDisc>() {
        @Override
        public int compare(BluRayDisc o1, BluRayDisc o2) {
            int releaseYear1 = o1.getReleaseYear();
            int releaseYear2 = o2.getReleaseYear();
            return  releaseYear1 - releaseYear2;
        }
    };
}




