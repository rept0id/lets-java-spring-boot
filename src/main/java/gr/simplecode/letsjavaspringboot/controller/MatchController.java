package gr.simplecode.letsjavaspringboot.controller;

import gr.simplecode.letsjavaspringboot.model.MatchEntity;
import gr.simplecode.letsjavaspringboot.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping
    public List<MatchEntity> getAllMatches() {
        return matchRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchEntity> getMatchById(@PathVariable Long id) {
        Optional<MatchEntity> match = matchRepository.findById(id);
        return match.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MatchEntity createMatch(@RequestBody MatchEntity match) {
        return matchRepository.save(match);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchEntity> updateMatch(@PathVariable Long id, @RequestBody MatchEntity updatedMatch) {
        Optional<MatchEntity> existingMatch = matchRepository.findById(id);
        if (existingMatch.isPresent()) {
            updatedMatch.setId(id); // Ensure the ID is set to the existing value
            MatchEntity savedMatch = matchRepository.save(updatedMatch);
            return ResponseEntity.ok(savedMatch);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMatch(@PathVariable Long id) {
        Optional<MatchEntity> match = matchRepository.findById(id);
        if (match.isPresent()) {
            matchRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
