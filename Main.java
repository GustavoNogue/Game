// Classe principal: ponto de entrada do jogo
public class Main {
    public static void main(String[] args) {
        // cria o jogador
        Player hero = new Player("Aventureiro", 100);

        // Fase 1: Amazônia
        EnemyFactory amazonFactory = new AmazonEnemyFactory();
        GameEngine amazonEngine = new GameEngine(amazonFactory, hero);
        amazonEngine.enterRegionAndFight(3);

        // Fase 2: Sertão (só se o jogador sobreviveu)
        if (hero.isAlive()) {
            EnemyFactory sertaoFactory = new SertaoEnemyFactory();
            GameEngine sertaoEngine = new GameEngine(sertaoFactory, hero);
            sertaoEngine.enterRegionAndFight(2);
        }

        // Fase 3: Rio de Janeiro (futura)
        if (hero.isAlive()) {
            EnemyFactory rioFactory = new RioEnemyFactory();
            GameEngine rioEngine = new GameEngine(rioFactory, hero);
            rioEngine.enterRegionAndFight(4);
        }

        System.out.println("\nSimulação encerrada.");
    }
}
