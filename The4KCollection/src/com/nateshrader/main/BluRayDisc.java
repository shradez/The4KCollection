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
    private String genre1;
    private String genre2;

    public BluRayDisc(int uniqueID, String title, int releaseYear, String mPAARating, int runtimeInMin, String directorNameFirst, String directorNameLast, BigDecimal iMDBScore, boolean nateWatched, String genre1, String genre2) {
        this.uniqueID = uniqueID;
        this.title = title;
        this.releaseYear = releaseYear;
        this.mPAARating = mPAARating;
        this.runtimeInMin = runtimeInMin;
        this.directorNameFirst = directorNameFirst;
        this.directorNameLast = directorNameLast;
        this.iMDBScore = iMDBScore;
        this.nateWatched = nateWatched;
        this.genre1 = genre1;
        this.genre2 = genre2;
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

    public String getGenre1() {
        return genre1;
    }

    public String getGenre2() {
        return genre2;
    }


    // Derived attribute for director full name
    public String getDirectorFullName() {
        return directorNameFirst + directorNameLast;
    }

    public String toString() {
        String col1 = this.getTitle();
        int col2 = this.getReleaseYear();
        String col3 = this.getmPAARating();
        int col4 = this.getRuntimeInMin();
        String col5pretext = "IMDb Score: ";
        BigDecimal col5 = this.getiMDBScore();
        String pipe = "|";
        return String.format("%-62s%-3s%-6d%-3s%-7s%-3s%-9s%-3s%-12s%-4.1f\n", col1, pipe, col2, pipe, col3, pipe, col4 + " min", pipe, col5pretext, col5);
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
            return releaseYear1 - releaseYear2;
        }
    };
}




