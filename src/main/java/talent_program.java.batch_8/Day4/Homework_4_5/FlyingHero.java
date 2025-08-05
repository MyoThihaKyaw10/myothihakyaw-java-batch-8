package Day4.Homework_4_5;

public class FlyingHero extends Superhero{
    public FlyingHero(String heroName, int powerLevel) {
        super(heroName, powerLevel);
    }

    @Override
    public void usePower() {
        System.out.println(getHeroName()+" used savage wing attack.");
    }
}
