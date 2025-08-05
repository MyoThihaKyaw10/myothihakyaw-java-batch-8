package Day4.Homework_4_5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Superhero> heroes = new ArrayList<>();
        heroes.add(new FlyingHero("Viper",80));
        heroes.add(new StrengthHero("Stone Giant",90));
        heroes.add(new SpeedHero("Bloodseeker",70));

        for(Superhero hero : heroes){
            System.out.println("Hero: "+hero.getHeroName()+"  Power Level: "+hero.getPowerLevel());
            hero.usePower();
            System.out.println();
        }

        System.out.println("Power Boost usage");
        heroes.get(2).powerBoost(30);
        heroes.get(2).usePower();
    }
}
