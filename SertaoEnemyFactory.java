import java.util.Random;

// Fábrica concreta que cria inimigos do Sertão
public class SertaoEnemyFactory extends EnemyFactory {
    private String[] names = {"Lampiao Jr.", "Zé do Borracheiro", "Maria Bonita II"};
    private Random r = new Random();

    public SertaoEnemyFactory() { super("Sertão"); }

    @Override
    public Enemy createEnemy() {
        String n = names[r.nextInt(names.length)];
        return new Cangaceiro(n);
    }
}
