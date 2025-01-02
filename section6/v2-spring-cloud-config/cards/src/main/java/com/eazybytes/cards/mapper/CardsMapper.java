package com.eazybytes.cards.mapper;

import com.eazybytes.cards.dto.CardsDto;
import com.eazybytes.cards.entity.Cards;

public class CardsMapper {
    public static CardsDto toCardsDto(Cards cards) {
        return  CardsDto.builder()
                .mobileNumber(cards.getMobileNumber())
                .cardNumber(cards.getCardNumber())
                .cardType(cards.getCardType())
                .totalLimit(cards.getTotalLimit()).build();
    }

    public static Cards toCards(CardsDto cardsDto) {
        return  Cards.builder()
                .mobileNumber(cardsDto.getMobileNumber())
                .cardNumber(cardsDto.getCardNumber())
                .cardType(cardsDto.getCardType())
                .totalLimit(cardsDto.getTotalLimit()).build();
    }

    public static CardsDto toCardsDto(Cards cards, CardsDto cardsDto) {
        cardsDto.setMobileNumber(cards.getMobileNumber());
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setTotalLimit(cards.getTotalLimit());
        return cardsDto;
    }

    public static Cards toCards(CardsDto cardsDto, Cards cards) {
        cards.setMobileNumber(cardsDto.getMobileNumber());
        cards.setCardNumber(cardsDto.getCardNumber());
        cards.setCardType(cardsDto.getCardType());
        cards.setTotalLimit(cardsDto.getTotalLimit());
        return cards;
    }
}
