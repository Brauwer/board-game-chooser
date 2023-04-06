package brauwer.be.boardgamechooser;

import brauwer.be.boardgamechooser.repo.BoardGameRepository;
import brauwer.be.boardgamechooser.repo.CategoryRepository;
import brauwer.be.boardgamechooser.repo.MechanicsRepository;
import brauwer.be.boardgamechooser.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardGameChooserApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(BoardGameChooserApplication.class);
	private final BoardGameRepository boardGameRepository;
	private final CategoryRepository categoryRepository;
	private final MechanicsRepository mechanicsRepository;
  private final UserRepository userRepository;

	@Autowired
	public BoardGameChooserApplication(BoardGameRepository boardGameRepository,
                                     CategoryRepository categoryRepository,
                                     MechanicsRepository mechanicsRepository,
                                     UserRepository userRepository){
		this.boardGameRepository = boardGameRepository;
		this.categoryRepository = categoryRepository;
		this.mechanicsRepository = mechanicsRepository;
    this.userRepository = userRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(BoardGameChooserApplication.class, args);
	}

	@Override
	public void run(String... args) {
//		ImportCategories importCategories = new ImportCategories();
//		importCategories.importCategories(categoryRepository);
//		ImportMechanics importMechanics = new ImportMechanics();
//		importMechanics.importMechanics(mechanicsRepository);
//		ImportBoardGames importBoardGames = new ImportBoardGames();
//		importBoardGames.importBoardGames(boardGameRepository);
//		logger.info("Import of boardgames finished");
		logger.info("Application started");
	}
}
