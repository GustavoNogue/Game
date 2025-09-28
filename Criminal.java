import java.util.Random;

// Implementação concreta de inimigo: Criminoso do Rio de Janeiro
public class Criminal implements Enemy {
    private String gang; // nome da gangue

    public Criminal(String gang) {
        this.gang = gang;
    }

    @Override
    public void attack(Player player) {
        Random r = new Random();
        int damage = 6 + r.nextInt(10);   // dano entre 6 e 15
        boolean stun = r.nextDouble() < 0.15; // 15% de chance de atordoar

        System.out.printf("[Criminal - %s] ataca e causa %d de dano%s.%n", 
                          gang, damage, stun ? " (atordoado)" : "");

        player.takeDamage(damage);
        if (stun) player.stun(1); // jogador perde 1 rodada
    }

    @Override
    public String getType() { 
        return "Criminal(" + gang + ")"; 
    }
}
