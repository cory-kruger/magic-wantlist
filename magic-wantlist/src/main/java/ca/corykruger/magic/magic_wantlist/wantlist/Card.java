package ca.corykruger.magic.magic_wantlist.wantlist;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Card {
	
	private String set;
	private String name;
	private String number;
	
	public Card(String set, String name, String number) {
		this.set = set;
		this.name = name;
		this.number = number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (obj instanceof Card) {
			Card aCard = (Card) obj;
			if (StringUtils.equals(set, aCard.getSet())
					&& StringUtils.equals(name, aCard.getName())
					&& StringUtils.equals(number, aCard.getNumber())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(101, 23)
				.append(set)
				.append(name)
				.append(number)
				.toHashCode();
	}
	
	@Override
	public String toString() {
		return number + ":  " + name;
	}
	
	public String getSet() {
		return set;
	}
	
	public void setSet(String set) {
		this.set = set;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
