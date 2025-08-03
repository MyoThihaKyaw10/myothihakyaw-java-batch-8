package Day4.Homework_4_5;

public abstract class Superhero {
    String heroName;
    int powerLevel;

    public Superhero(String heroName, int powerLevel) {
        this.heroName = heroName;
        this.powerLevel = powerLevel;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public abstract void usePower();

    public void powerBoost(int boostAmount){
        System.out.println(heroName+" used Power Boost and gained +"+boostAmount+".");
        powerLevel += boostAmount;
        System.out.println(heroName+"'s current power level: "+powerLevel);
    }
}
