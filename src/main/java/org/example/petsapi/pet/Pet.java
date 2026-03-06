package org.example.petsapi.pet;

public class Pet {
    private String name;
    private String owner;
    private String type;
    private String race;
    private int realAge;

    public Pet(String name, String owner, String type, String race, int realAge) {
        this.name = name;
        this.owner = owner;
        this.type = type;
        this.race = race;
        this.realAge = realAge;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getType() {
        return type;
    }

    public String getRace() {
        return race;
    }

    public int getRealAge() {
        return realAge;
    }

    public int getHumanAge() {
        if (realAge<=0) return 0;

        switch (type) {
            case "dog":
                if (realAge == 1) return 15;
                if (realAge== 2) return 15 + 9;
                return 24 + (realAge - 2) * 5;
            case "cat":
                if (realAge == 1) return 15;
                if (realAge == 2) return 15 + 9;
                return 24 + (realAge-2) * 4;
            default:
                return realAge * 7;
        }
    }
}
