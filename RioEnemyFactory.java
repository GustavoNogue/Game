import java.util.Random;

// Fábrica concreta que cria inimigos do Rio de Janeiro
public class RioEnemyFactory extends EnemyFactory {
    private String[] gangs = {"Gangue do Porto", "Bairro Sul", "Trupe 13"};
    private Random r = new Random();

    public RioEnemyFactory() { super("Rio de Janeiro"); }

    @Override
    public Enemy createEnemy() {
        String g = gangs[r.nextInt(gangs.length)];
        return new Criminal(g);
    }
}
