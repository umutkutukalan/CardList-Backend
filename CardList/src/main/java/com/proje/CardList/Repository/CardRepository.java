package com.proje.CardList.Repository;

import com.proje.CardList.Entity.Card;
import com.proje.CardList.Entity.Enum.Derece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findAllByDerece(Derece derece);
}
