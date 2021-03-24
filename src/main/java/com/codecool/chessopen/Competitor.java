package com.codecool.chessopen;

public class Competitor implements Comparable<Competitor>{
    private final String name;
    private final double points;

    public Competitor(String[] strings) {
        this.name = strings[0];
        this.points = countPoints(strings);
    }

    private double countPoints(String[] strings) {
        double points = 0;
        for (int i = 1; i < strings.length; i++) {
            points += Double.parseDouble(strings[i]);
        }
        return points;
    }

    public String getName() {
        return name;
    }

    public double getPoints() {
        return points;
    }

    @Override
    public int compareTo(Competitor competitor) {
        return Double.compare(this.points, competitor.getPoints());
    }
}
