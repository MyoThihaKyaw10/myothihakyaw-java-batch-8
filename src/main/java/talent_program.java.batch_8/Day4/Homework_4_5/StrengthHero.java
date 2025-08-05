package Day4.Homework_4_5;

public class StrengthHero extends Superhero{
    public StrengthHero(String heroName, int powerLevel) {
        super(heroName, powerLevel);
    }

    @Override
    public void usePower() {
        System.out.println(getHeroName()+" used empowered punch attack.");
    }
}
