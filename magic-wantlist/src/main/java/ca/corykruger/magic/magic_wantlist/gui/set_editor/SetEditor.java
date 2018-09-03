package ca.corykruger.magic.magic_wantlist.gui.set_editor;

import ca.corykruger.magic.magic_wantlist.wantlist.Card;
import javafx.scene.control.ListView;

public class SetEditor {
	
	private ListView<Card> setCards;
	private ListView<Card> wantedCards;
	
	public SetEditor(ListView<Card> setCards, ListView<Card> wantedCards) {
		this.setCards = setCards;
		this.wantedCards = wantedCards;
	}
	
	public void removeOne() {
		Card selectedCard = wantedCards.getSelectionModel().getSelectedItem();
		setCards.getItems().add(selectedCard);
		wantedCards.getItems().remove(selectedCard);
		updateDisplay();
	}
	
	public void removeAll() {
		setCards.getItems().addAll(wantedCards.getItems());
		wantedCards.getItems().clear();
		updateDisplay();
	}
	
	public void addOne() {
		Card selectedCard = setCards.getSelectionModel().getSelectedItem();
		wantedCards.getItems().add(selectedCard);
		setCards.getItems().remove(selectedCard);
		updateDisplay();
	}
	
	public void addAll() {
		wantedCards.getItems().addAll(setCards.getItems());
		setCards.getItems().clear();
		updateDisplay();
	}
	
	void updateDisplay() {
		setCards.refresh();
		wantedCards.refresh();
	}

}
