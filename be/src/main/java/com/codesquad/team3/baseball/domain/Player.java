package com.codesquad.team3.baseball.domain;

import com.codesquad.team3.baseball.dto.Result;

public class Player {

    private Integer id;
    private String name;
    private boolean isPitcher;
    private float average;
    private int battingOrder;
    private Integer team;
    private Integer atBats;
    private Integer hits;
    private Integer outs;
    private Integer pitches;

    public Player(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.isPitcher = builder.isPitcher;
        this.average = builder.average;
        this.battingOrder = builder.battingOrder;
        this.team = builder.team;
        this.atBats = builder.atBats;
        this.hits = builder.hits;
        this.outs = builder.outs;
        this.pitches = builder.pitches;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getAverage() {
        return average;
    }

    public int getBattingOrder() {
        return battingOrder;
    }

    public Integer getAtBats() {
        return atBats;
    }

    public Integer getHits() {
        return hits;
    }

    public Integer getOuts() {
        return outs;
    }

    public Integer getPitches() {
        return pitches;
    }

    public Result hit() {
        int hit = (int)(average * 1000);
        int strike = ((1000 - hit) / 2 - 50);
        int ball = ((1000 - hit) / 2 - 50);
        int result = (int)(Math.random() * 1000);

        if(result < hit){
            return Result.HIT;
        }else if(result < hit + strike){
            return Result.STRIKE;
        }else if(result >= (hit + strike) && result < (hit + strike + ball)){
            return Result.BALL;
        }else{
            return Result.OUT;
        }
    }

    public static class Builder {
        private Integer id;
        private String name;
        private boolean isPitcher;
        private float average;
        private int battingOrder;
        private Integer team;
        private int atBats;
        private int hits;
        private int outs;
        private int pitches;

        public Builder(Integer id) {
            this.id = id;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder isPitcher(boolean isPitcher) {
            this.isPitcher = isPitcher;
            return this;
        }

        public Builder average(float average) {
            this.average = average;
            return this;
        }

        public Builder battingOrder(int battingOrder) {
            this.battingOrder = battingOrder;
            return this;
        }

        public Builder team(Integer team) {
            this.team = team;
            return this;
        }

        public Builder atBats(Integer atBats) {
            this.atBats = atBats;
            return this;
        }

        public Builder hits(Integer hits) {
            this.hits = hits;
            return this;
        }

        public Builder outs(Integer outs) {
            this.outs = outs;
            return this;
        }

        public Builder pitches(Integer pitches) {
            this.pitches = pitches;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
}
