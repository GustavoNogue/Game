// Classe abstrata que define o Factory Method
// Cada subclasse deve implementar como criar um inimigo da região
public abstract class EnemyFactory {
    protected String locationName; // nome da região (Amazônia, Sertão, Rio...)

    public EnemyFactory(String locationName) { 
        this.locationName = locationName; 
    }

    // Método fábrica — cada região cria seus inimigos específicos
    public abstract Enemy createEnemy();
}
