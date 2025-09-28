import java.util.*;

// Classe que controla a simulação do jogo
public class GameEngine {
    private EnemyFactory factory; // fábrica que define os inimigos da região
    private Player player;        // jogador atual

    public GameEngine(EnemyFactory factory, Player player) {
        this.factory = factory;
        this.player = player;
    }

    // Simula a entrada do jogador em uma região e a luta contra inimigos
    public void enterRegionAndFight(int enemyCount) {
        System.out.printf("%n== Jogador %s entra na região: %s - %d inimigos detectados ==%n",
                          player.getName(), factory.locationName, enemyCount);

        // cria os inimigos usando a fábrica
        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < enemyCount; i++) {
            enemies.add(factory.createEnemy());
        }

        int round = 1;
        while (!enemies.isEmpty() && player.isAlive()) {
            System.out.printf("%n-- Rodada %d: %d inimigo(s) ainda ativo(s) --%n", round, enemies.size());
            Iterator<Enemy> it = enemies.iterator();
            while (it.hasNext() && player.isAlive()) {
                Enemy e = it.next();
                e.attack(player); // inimigos sempre atacam o jogador

                // chance do inimigo ser derrotado por eventos ambientais
                if (new Random().nextDouble() < 0.20) {
                    System.out.printf("   >> %s foi neutralizado (evento ambiental).%n", e.getType());
                    it.remove();
                }
                if (player.isStunned()) {
                    System.out.println("   (Jogador está atordoado e pula a próxima ação)");
                }
            }
            player.passTurn(); // processa o efeito de atordoamento
            round++;
        }

        if (!player.isAlive()) 
            System.out.printf("%n*** %s foi derrotado na região %s... GAME OVER ***%n", player.getName(), factory.locationName);
        else 
            System.out.printf("%n*** %s sobreviveu e saiu da região %s! ***%n", player.getName(), factory.locationName);
    }
}
