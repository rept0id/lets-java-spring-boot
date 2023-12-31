package gr.simplecode.letsjavaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.simplecode.letsjavaspringboot.model.StatusEntity;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Long> {
}
