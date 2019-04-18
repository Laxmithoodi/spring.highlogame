package com.zipcodewilmington.casino.services.cardgames.highlo;

import com.zipcodewilmington.casino.models.cardgames.highlo.HighLowGame;
import com.zipcodewilmington.casino.models.cardgames.utils.Deck;
import com.zipcodewilmington.springutils.AbstractService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HighLoGameService extends AbstractService<HighLowGame, Long> {
    public HighLoGameService(CrudRepository<HighLowGame, Long> repository) {
        super(repository);
    }

    @Override
    public HighLowGame update(Long gameId, HighLowGame newHighLowGame) {
        HighLowGame originalHighLowGame = super.read(gameId);
        originalHighLowGame.setId(newHighLowGame.getId());
        originalHighLowGame.setDeck(newHighLowGame.getDeck());
        return super.repository.save(originalHighLowGame);
    }

    public HighLowGame create() {
        HighLowGame newGame = new HighLowGame();
        Deck newDeck = new Deck();
        newDeck.setCardList(new ArrayList<>());
        newDeck.populate();
        newGame.setDeck(newDeck);
        newGame.setPlayerList(new ArrayList<>());
        return super.create(newGame);
    }
}
