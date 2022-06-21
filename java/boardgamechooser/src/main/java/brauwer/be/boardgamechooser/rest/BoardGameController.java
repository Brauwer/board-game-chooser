package brauwer.be.boardgamechooser.rest;

import brauwer.be.boardgamechooser.models.BoardGame;
import brauwer.be.boardgamechooser.repo.BoardGameRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@AllArgsConstructor
public class BoardGameController {

    private final BoardGameRepository repository;

    @GetMapping("/boardgames")
    List<BoardGame> allBoardGames(){
        return repository.findAll();
    }

    @GetMapping("/boardgames/{id}")
    Optional<BoardGame> findBoardGame(@PathVariable String id){
        return repository.findById(id);
    }

    @GetMapping("/boargames/{category}")
    List<BoardGame> findBoardGamesByCategory(@PathVariable String category){
        return repository.findByCategories(category);
    }
}
