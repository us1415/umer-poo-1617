import java.io.Serializable;

/**
 * Classe que é subclasse de User, e que
 * guarda a informação específica ao condutor.
 * O Driver tem fulfillment, rating, numberOfEvaluations, kms e available.
 */
public class Driver extends User implements Serializable {

    private static final long serialVersionUID = -7388682787774554843L;

    // Grau de cumprimento de horário estabelecido com o cliente, dado por um factor entre 0 e 100
    private double fulfillment;

    // Classificação do motorista, dado numa escala de 0 a 100,
    // calculada com base na classificação dada pelo cliente no final de cada viagem
    private double rating;
    private int numberOfEvaluations;

    // Total de kms feitos na empresa
    private double kms;

    // Se o motorista se encontra disponível
    private boolean available;

    /**
     * Constructor for objects of class Driver
     */
    public Driver(String newEmail, String newName, String newPassword, String newAddress, String newBirthdate) {
        this.email = newEmail;
        this.name = newName;
        this.password = newPassword;
        this.address = newAddress;
        this.birthdate = newBirthdate;
        this.fulfillment = (double) 100;
        this.rating = (double) 100;
        this.numberOfEvaluations = (int) 1;
        this.kms = (double) 0;
        this.available = false;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getAddress() {
        return this.address;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public double getFulfillment() {
        return this.fulfillment;
    }

    public double getRating() {
        return ((double) Math.round((this.rating / this.numberOfEvaluations) * 10d) / 10d);
    }

    public void addRating(double newRating) {
        this.rating += newRating;
        this.numberOfEvaluations++;
    }

    public double getKms() {
        return this.kms;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailability(boolean availability) {
        this.available = availability;
    }

    public void toggleAvailable() {
        this.available = !this.available;
    }

    @Override
    public String toString() {
    return "<html>Email: " + this.email
         + "<br>Name: " + this.name
         + "<br>Password: " + this.password
         + "<br>Address: " + this.address
         + "<br>Birthdate: " + this.birthdate
         + "<br>Fulfillment: " + this.fulfillment
         + "<br>Rating: " + this.rating
         + "<br>Kms: " + this.kms
         + "<br>Available: " + this.available;
    }

    public String infoString() {
        return "<html>Name: " + this.name + ", "
             + "Email: " + this.email + ", "
             + "<br>Rating: " + this.rating + ", "
             + "Available: " + this.available;
    }
}
