package brauwer.be.boardgamechooser;

import brauwer.be.boardgamechooser.repo.BoardGameRepository;
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

	@Autowired
	public BoardGameChooserApplication(BoardGameRepository boardGameRepository){
		this.boardGameRepository = boardGameRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(BoardGameChooserApplication.class, args);
	}

	@Override
	public void run(String... args) {
		ImportBoardGames importBoardGames = new ImportBoardGames();
		importBoardGames.importBoardGames(boardGameRepository);
		logger.info("Import of boardgames finished");
	}
}
