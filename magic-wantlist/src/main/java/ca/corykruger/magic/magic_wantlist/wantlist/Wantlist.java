package ca.corykruger.magic.magic_wantlist.wantlist;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.SetUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Wantlist {
	
	private Instant updated;
	private HashSet<Card> cards;
	
	public Wantlist() {
		updated = Instant.now();
		cards = new HashSet<Card>();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (obj instanceof Wantlist) {
			Wantlist aWantlist = (Wantlist) obj;
			if (Objects.equals(updated, aWantlist.getUpdated())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(199, 73)
				.append(updated)
				.toHashCode();
	}
	
	public Instant getUpdated() {
		return updated;
	}
	
	public HashSet<Card> getWantedCards() {
		return (HashSet<Card>) SetUtils.unmodifiableSet(cards);
	}
	
	public void addCard(Card card) {
		cards.add(card);
		updated = Instant.now();
	}
	
	public void addAllCards(Collection<Card> cards) {
		this.cards.addAll(cards);
		updated = Instant.now();
	}
	
	public void removeCard(Card card) {
		cards.remove(card);
		updated = Instant.now();
	}
	
	public List<Card> getCardsInSet(String set) {
		List<Card> matchedCards = new ArrayList<Card>();
		
		for (Card card : cards) {
			if (card.getSet().equals(set)) {
				matchedCards.add(card);
			}
		}
		
		return matchedCards;
	}

}
