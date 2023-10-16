package gr.simplecode.letsjavaspringboot.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "match_odds")
public class MatchOddsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private MatchEntity match;

    private String specifier;
    private BigDecimal odd;

    // Constructors, getters, and setters
    // You may use your IDE or Lombok for generating these methods.

    public MatchOddsEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MatchEntity getMatch() {
        return match;
    }

    public void setMatch(MatchEntity match) {
        this.match = match;
    }

    public String getSpecifier() {
        return specifier;
    }

    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

    public BigDecimal getOdd() {
        return odd;
    }

    public void setOdd(BigDecimal odd) {
        this.odd = odd;
    }
}
