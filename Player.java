// Classe que representa o jogador controlado pelo usuário
public class Player {
    private String name;        // nome do jogador
    private int health;         // pontos de vida (HP)
    private int stunnedTurns;   // turnos em que o jogador fica atordoado

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
        this.stunnedTurns = 0;
    }

    public boolean isAlive() { return health > 0; }

    // aplica dano ao jogador
    public void takeDamage(int d) {
        health -= d;
        if (health < 0) health = 0;
        System.out.printf("=> %s agora tem %d HP.%n", name, health);
    }

    // aplica estado de atordoamento
    public void stun(int turns) {
        stunnedTurns += turns;
        System.out.printf("=> %s está atordoado por %d rodada(s).%n", name, turns);
    }

    public boolean isStunned() { return stunnedTurns > 0; }

    // passa o turno e reduz o tempo de atordoamento
    public void passTurn() {
        if (stunnedTurns > 0) stunnedTurns--;
    }

    public String getName() { return name; }
}
