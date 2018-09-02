package ca.corykruger.magic.magic_wantlist.wantlist;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Wantlist {
	
	private Instant updated;
	private List<Set> sets;
	
	public Wantlist() {
		updated = Instant.now();
		sets = new ArrayList<Set>();
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
	
	public List<Set> getWantedCards() {
		return ListUtils.unmodifiableList(sets);
	}
	
	public void addSet(Set set) {
		sets.add(set);
		updated = Instant.now();
	}
	
	public void removeSet(Set set) {
		sets.remove(set);
		updated = Instant.now();
	}

}
