package brauwer.be.boardgamechooser.repo.impl;

import brauwer.be.boardgamechooser.models.BoardGame;
import brauwer.be.boardgamechooser.repo.BoardGameRepoCustom;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.MongoRegexCreator;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BoardGameRepositoryImpl implements BoardGameRepoCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public BoardGameRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<BoardGame> findByCategories(@NotNull String category) {
        if(category.trim().isEmpty()){
            return new ArrayList<>();
        }
        final Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();
        criteria.add(Criteria.where("categories").regex(Objects.requireNonNull(MongoRegexCreator.INSTANCE.toRegularExpression(category, MongoRegexCreator.MatchMode.CONTAINING)), "i"));
        query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        return mongoTemplate.find(query, BoardGame.class);
    }
}
