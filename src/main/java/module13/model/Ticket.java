package module13.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @JoinColumn(name = "client_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @JoinColumn(name = "from_planet_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Planet fromPlanet;

    @JoinColumn(name = "to_planet_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Planet toPlanet;

    public Ticket(Client client, Planet fromPlanet, Planet toPlanet) {
    this.createdAt = LocalDateTime.now();
    this.client = client;
    this.fromPlanet = fromPlanet;
    this.toPlanet = toPlanet;
    }

    public Ticket() {

    }
}
