import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class Playground {
    public static void main(String[] args) {
        System.out.println("Two Dimensional sorting in Java");
        Playground play = new Playground();
        play.compareHeroes();
    }

        public void compareHeroes() {
            //Build the array.
            ArrayList<Hero> allHeroes = new ArrayList<Hero>();

            allHeroes.add(new Hero("Captain America", true));
            allHeroes.add(new Hero("Wolverine", true));
            allHeroes.add(new Hero("Captain Marvel", false));
            allHeroes.add(new Hero("Iron Man", false));
            allHeroes.add(new Hero("Star-Lord", true));
            allHeroes.add(new Hero("Drax", false));
            allHeroes.add(new Hero("Deadpool", true));
            allHeroes.add(new Hero("Thor", false));
            allHeroes.add(new Hero("Hulk", false));

            System.out.println("\nUnsorted:\n");
            printValues(allHeroes);

            //sort them:
            HeroComparator heroComparator = new HeroComparator();
            Collections.sort(allHeroes, heroComparator);


            System.out.println("\n\nSorted:\n");
            printValues(allHeroes);

        }

        public void printValues(ArrayList<Hero> heroes) {
            for (Hero h : heroes) {
                System.out.println(h.isTheBest + "   " + h.name);
            }
        }
    //inline class for our model. For demonstration this is in one file.
    //For reals Java wants a new file for every class.
    class Hero {
        public String name = "";
        public boolean isTheBest = false;

        Hero(String name, boolean isTheBest) {
            this.name = name;
            this.isTheBest = isTheBest;
        }
    }
    //inline comparator class
    class HeroComparator implements Comparator<Hero> {
        public int compare(Hero r1, Hero r2) {
            if(r1.isTheBest == r2.isTheBest ) {
                return r1.name.compareTo(r2.name);
            } else {

		//return (r1.isTheBest ? 1 : 0) - (r2.isTheBest ? 1 : 0); //will sort isTheBest false first
                return (r2.isTheBest ? 1 : 0) - (r1.isTheBest ? 1 : 0);

            }
        }
    }
}
