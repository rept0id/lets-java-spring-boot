package gr.simplecode.letsjavaspringboot.repository;

import gr.simplecode.letsjavaspringboot.model.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
}
