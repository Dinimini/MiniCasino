package pa.minicasino.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private int balance;

    public String getUsername() {
        return username;
    }

    public int getBalance() {
        return balance;
    }

    public void changeBalance(int balanceChange) {
        this.balance += balanceChange;
    }

    // Getterek, setterek, konstruktorok szükség szerint
}