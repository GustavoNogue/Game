import java.util.Random;

// Implementação concreta de inimigo: Animal mutante da Amazônia
public class MutantAnimal implements Enemy {
    private String species; // nome da espécie mutante (ex: "Onça-radiante")

    public MutantAnimal(String species) {
        this.species = species;
    }

    @Override
    public void attack(Player player) {
        // gera dano aleatório entre 5 e 15
        int damage = 5 + new Random().nextInt(11);
        System.out.printf("[MutantAnimal - %s] ataca e causa %d de dano!%n", species, damage);
        player.takeDamage(damage);
    }

    @Override
    public String getType() { 
        return "MutantAnimal(" + species + ")"; 
    }
}
