package com.proje.CardList.Service.impl;

import com.proje.CardList.Common.GeneralException;
import com.proje.CardList.Entity.Card;
import com.proje.CardList.Entity.Enum.Derece;
import com.proje.CardList.Repository.CardRepository;
import com.proje.CardList.Service.ICardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService implements ICardService {

    private CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }
    @Override
    public Card getById(Long id) {
        Optional<Card> userOptional = cardRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new GeneralException("User not found!");
        }
        return userOptional.get();
    }
    @Override
    public List<Card> getAll() {
        return cardRepository.findAll();
    }
    @Override
    public Page<Card> getAll(Pageable pageable) {
        return cardRepository.findAll(pageable);
    }
    @Override
    public void delete(Long id) {
        if (!cardRepository.existsById(id)){
            throw new GeneralException("Böyle bir görev kartı yok!");
        }
        cardRepository.deleteById(id);
    }

    @Override
    public List<Card> getUserByDerece(Derece derece) {
        return cardRepository.findAllByDerece(derece);
    }
}
