package com.proje.CardList.Service;

import com.proje.CardList.Entity.Card;
import com.proje.CardList.Entity.Enum.Derece;

import java.util.List;

public interface ICardService extends IService<Card>{
    List<Card> getUserByDerece(Derece derece);
}
