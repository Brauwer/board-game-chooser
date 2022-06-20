package brauwer.be.boardgamechooser.rest;

import brauwer.be.boardgamechooser.models.Mechanics;
import brauwer.be.boardgamechooser.repo.MechanicsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class MechanicsController {

    private final MechanicsRepository mechanicsRepository;

    @GetMapping("/mechanics")
    public List<Mechanics> allCategories(){
        return mechanicsRepository.findAll();
    }

    @GetMapping("mechanics/{id}")
    public Optional<Mechanics> findMechanicsById(@PathVariable String id){
        return mechanicsRepository.findById(id);
    }

    @GetMapping("mechanics/search/{name}")
    public List<Mechanics> findMechanicsByName(@PathVariable String name){
        return mechanicsRepository.findMechanicsByName(name);
    }
}
