package ca.corykruger.magic.magic_wantlist.wantlist;

import java.util.Comparator;

import org.apache.commons.lang3.StringUtils;

public class CardNumberComparator implements Comparator<Card> {
	
	@Override
	public int compare(Card c1, Card c2) {
		try {
			int num1 = Integer.parseInt(c1.getNumber());
			int num2 = Integer.parseInt(c2.getNumber());
			return Integer.compare(num1, num2);
		} catch (NumberFormatException nfe) {
			return StringUtils.compare(c1.getNumber(), c2.getNumber());
		}
	}

}
