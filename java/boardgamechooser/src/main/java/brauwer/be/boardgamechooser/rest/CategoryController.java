package brauwer.be.boardgamechooser.rest;

import brauwer.be.boardgamechooser.models.Category;
import brauwer.be.boardgamechooser.repo.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Category> allCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("categories/{id}")
    public Optional<Category> findCategoryById(@PathVariable String id){
        return categoryRepository.findById(id);
    }

    @GetMapping("categories/search/{name}")
    public List<Category> findCategoryByName(@PathVariable String name){
        return categoryRepository.findCategoryByName(name);
    }
}
