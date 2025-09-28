import java.util.Random;

// Fábrica concreta que cria inimigos da Amazônia
public class AmazonEnemyFactory extends EnemyFactory {
    private String[] species = {"Jacare-mutante", "Onca-radiante", "Piranha-titan"};
    private Random r = new Random();

    public AmazonEnemyFactory() { super("Amazônia"); }

    @Override
    public Enemy createEnemy() {
        String s = species[r.nextInt(species.length)];
        return new MutantAnimal(s);
    }
}
