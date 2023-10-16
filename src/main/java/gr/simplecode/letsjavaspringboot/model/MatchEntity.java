package gr.simplecode.letsjavaspringboot.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "match")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date matchDate;
    private String matchTime;
    private String teamA;
    private String teamB;
    private SportEnum sport;

    // Constructors, getters, and setters
    // You may use your IDE or Lombok for generating these methods.

    public MatchEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public SportEnum getSport() {
        return sport;
    }

    public void setSport(SportEnum sport) {
        this.sport = sport;
    }
}
