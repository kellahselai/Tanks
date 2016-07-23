package com.kellahselai.game.level;

/**
 * Created by pc2 on 23.07.16.
 */
public enum TileType {

    EMPTY(0), BRICK(1), METAL(2), WATER(3), GRASS(4), ICE(5);

    private int n;

    TileType(int n) {
        this.n = n;


    }

    public int numeric(){
        return n;
    }

    public static TileType fromNumeric(int n){
        switch(n){
            case 1:
                return BRICK;
            case 2:
                return METAL;
            case 3:
                return WATER;
            case 4:
                return GRASS;
            case 5:
                return ICE;
            default:
                return EMPTY;
        }
    }
}

