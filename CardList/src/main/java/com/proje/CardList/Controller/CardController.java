package com.proje.CardList.Controller;

import com.proje.CardList.Entity.Card;
import com.proje.CardList.Entity.Enum.Derece;
import com.proje.CardList.Service.impl.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/cards")
public class CardController {
    private CardService cardService;
    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }
    @GetMapping
    ResponseEntity<Page<Card>> getCards(@RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "10") Integer pageSize ){
        return ResponseEntity.ok(cardService.getAll(PageRequest.of(page,pageSize, Sort.by("basTarih"))));
    }
    @GetMapping("/card-derece")
    public ResponseEntity<List<Card>> getCardsByDerece(@RequestParam Derece derece){
        return ResponseEntity.ok(cardService.getUserByDerece(derece));
    }
    @GetMapping("/{id}")
    ResponseEntity<Card> getCardsById(@PathVariable Long id){
        return ResponseEntity.ok(cardService.getById(id));
    }
    @PostMapping
    ResponseEntity<Card> createCard(@RequestBody Card card){
        return ResponseEntity.ok(cardService.save(card));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> getDeleteCardsById(@PathVariable Long id){
        cardService.delete(id);
        return ResponseEntity.ok().build();
    }
}
