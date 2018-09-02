package ca.corykruger.magic.magic_wantlist.wantlist;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Set {
	
	private String name;
	private LocalDate releaseDate;
	private List<Card> cards;
	
	public Set(String name, LocalDate releaseDate) {
		this.name = name;
		this.releaseDate = releaseDate;
		this.cards = new ArrayList<Card>();
	}
	
	public Set(String name, String releaseDate) {
		this.name = name;
		this.releaseDate = LocalDate.parse(releaseDate, DateTimeFormatter.ISO_DATE);
		this.cards = new ArrayList<Card>();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (obj instanceof Set) {
			Set aSet = (Set) obj;
			if (StringUtils.equals(name, aSet.getName())
					&& Objects.equals(releaseDate, aSet.getReleaseDate())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(181, 113)
				.append(name)
				.append(releaseDate)
				.toHashCode();
	}
	
	@Override
	public String toString() {
		return name + " (" + releaseDate + ")";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Card> getCards() {
		return ListUtils.unmodifiableList(cards);
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void removeCard(Card card) {
		cards.remove(card);
	}

	public void addMultipleCards(Collection<Card> cards) {
		this.cards.addAll(cards);
	}

}
