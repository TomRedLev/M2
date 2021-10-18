package com.example.gunbattle;

public class GameModel {
    private int[] positions;
    private int selected_gun = -1;

    public void create(int cellNumber, int guns, int strongholds) {
        if (guns + strongholds > cellNumber) {
            System.out.println("Guns + Strongholds > cell numbers");
            return ;
        }
        positions = new int[cellNumber];

        int i = 0;
        while (i < guns) {
            int pos_rand = (int) (Math.random() * (cellNumber));
            if (positions[pos_rand] == 0) {
                positions[pos_rand] = 1;
                i++;
            }
        }

        int j = 0;
        while (j < strongholds) {
            int pos_rand = (int) (Math.random() * (cellNumber));
            if (positions[pos_rand] == 0) {
                positions[pos_rand] = 2;
                j++;
            }
        }
    }

    public int destructCheck(int x, int elem_size) {
        for (int i = 0; i < positions.length; i++) {
            if (x >= i * elem_size && x <= (i+1) * elem_size) {
                positions[i] = 0;
            }
        }
        int cmpt = 0;
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] == 1) {
                cmpt += 1;
                break;
            }
        }
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] == 2) {
                cmpt += 1;
                break;
            }
        }
        return cmpt;

    }

    public int[] getPositions() {
        return positions;
    }

    public void setSelectedGun(int position) {
        selected_gun = position;
    }

    public int getSelectedGun() {
        return selected_gun;
    }
}
