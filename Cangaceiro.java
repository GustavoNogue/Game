import java.util.Random;

// Implementação concreta de inimigo: Cangaceiro do Sertão
public class Cangaceiro implements Enemy {
    private String name; // nome do cangaceiro

    public Cangaceiro(String name) {
        this.name = name;
    }

    @Override
    public void attack(Player player) {
        Random r = new Random();
        boolean critical = r.nextDouble() < 0.25; // 25% de chance de acerto crítico
        int base = 8 + r.nextInt(8);              // dano base entre 8 e 15
        int damage = critical ? base * 2 : base;  // crítico dobra o dano

        if (critical)
            System.out.printf("[Cangaceiro - %s] acerta um tiro crítico e causa %d de dano!%n", name, damage);
        else
            System.out.printf("[Cangaceiro - %s] ataca e causa %d de dano.%n", name, damage);

        player.takeDamage(damage);
    }

    @Override
    public String getType() { 
        return "Cangaceiro(" + name + ")"; 
    }
}
