package gr.simplecode.letsjavaspringboot.controller;

import gr.simplecode.letsjavaspringboot.model.MatchOddsEntity;
import gr.simplecode.letsjavaspringboot.repository.MatchOddsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/match-odd")
public class MatchOddsController {

    private final MatchOddsRepository matchOddsRepository;

    @Autowired
    public MatchOddsController(MatchOddsRepository matchOddsRepository) {
        this.matchOddsRepository = matchOddsRepository;
    }

    @GetMapping
    public List<MatchOddsEntity> getAllMatchOdds() {
        return matchOddsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchOddsEntity> getMatchOddsById(@PathVariable Long id) {
        Optional<MatchOddsEntity> matchOdds = matchOddsRepository.findById(id);
        return matchOdds.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MatchOddsEntity createMatchOdds(@RequestBody MatchOddsEntity matchOdds) {
        return matchOddsRepository.save(matchOdds);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchOddsEntity> updateMatchOdds(@PathVariable Long id, @RequestBody MatchOddsEntity updatedMatchOdds) {
        Optional<MatchOddsEntity> existingMatchOdds = matchOddsRepository.findById(id);
        if (existingMatchOdds.isPresent()) {
            updatedMatchOdds.setId(id); // Ensure the ID is set to the existing value
            MatchOddsEntity savedMatchOdds = matchOddsRepository.save(updatedMatchOdds);
            return ResponseEntity.ok(savedMatchOdds);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMatchOdds(@PathVariable Long id) {
        Optional<MatchOddsEntity> matchOdds = matchOddsRepository.findById(id);
        if (matchOdds.isPresent()) {
            matchOddsRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
