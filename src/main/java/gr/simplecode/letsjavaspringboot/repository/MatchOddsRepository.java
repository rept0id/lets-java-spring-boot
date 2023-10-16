package gr.simplecode.letsjavaspringboot.repository;

import gr.simplecode.letsjavaspringboot.model.MatchOddsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchOddsRepository extends JpaRepository<MatchOddsEntity, Long> {
}
