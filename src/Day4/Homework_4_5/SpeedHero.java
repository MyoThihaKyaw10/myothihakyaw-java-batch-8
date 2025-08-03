package Day4.Homework_4_5;

public class SpeedHero extends Superhero{
    public SpeedHero(String heroName, int powerLevel) {
        super(heroName, powerLevel);
    }

    @Override
    public void usePower() {
        System.out.println(getHeroName()+" used rapid kick attack.");
    }
}
