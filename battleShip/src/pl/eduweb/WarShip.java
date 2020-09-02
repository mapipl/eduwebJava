package pl.eduweb;

public abstract class WarShip implements Ship {

    enum Orientation {
        HORIZONTAL, VERTICAL
    }

    private Orientation orientation;
    private int hits;
    private Field[] occupied;

    public WarShip() {
        occupied = new Field[getDecksCount()];
    }

    @Override
    public boolean isSunk() {
        return hits == getDecksCount();
    }

    public void setOnField(Field field, int deckNo) {
        field.setShip(this);
        field.setState(State.SHIP);
        occupied[deckNo] = field;
    }

    @Override
    public void hit() {
        hits++;
        if (isSunk()) {
            for (int i = 0; i < occupied.length; i++) {
                occupied[i].setState(State.SUNK);
            }
        }
    }
}

class Submarine extends WarShip {
    @Override
    public int getDecksCount() {
        return 1;
    }
}

class Destroyer extends WarShip {
    @Override
    public int getDecksCount() {
        return 2;
    }
}

class Cruiser extends WarShip {
    @Override
    public int getDecksCount() {
        return 3;
    }
}

class BattleShip extends WarShip {
    @Override
    public int getDecksCount() {
        return 4;
    }
}
