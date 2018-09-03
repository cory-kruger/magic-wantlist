package ca.corykruger.magic.magic_wantlist.gui.set_editor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ca.corykruger.magic.magic_wantlist.io.WantlistFetcher;
import ca.corykruger.magic.magic_wantlist.mtgjson.SetFactory;
import ca.corykruger.magic.magic_wantlist.wantlist.Card;
import ca.corykruger.magic.magic_wantlist.wantlist.CardNumberComparator;
import ca.corykruger.magic.magic_wantlist.wantlist.Set;
import ca.corykruger.magic.magic_wantlist.wantlist.Wantlist;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class SetEditorView extends HBox {
	
	private final Button btnBack = new Button("Back");
	private final Button btnSave = new Button("Save");
	private final Button btnRemoveOne = new Button("<");
	private final Button btnRemoveAll = new Button("<<");
	private final Button btnAddOne = new Button(">");
	private final Button btnAddAll = new Button(">>");
	private final ListView<Card> lstAllCards = new ListView<Card>();
	private final ListView<Card> lstWantedCards = new ListView<Card>();
	
	public SetEditorView(final SetEditorController setEditorController, String setCode) {
		btnBack.setOnAction(setEditorController);
		btnSave.setOnAction(setEditorController);
		btnRemoveOne.setOnAction(setEditorController);
		btnRemoveAll.setOnAction(setEditorController);
		btnAddOne.setOnAction(setEditorController);
		btnAddAll.setOnAction(setEditorController);
		
		try {
			Set set = new SetFactory().getSet(setCode);
			List<Card> setCards = new ArrayList<Card>(set.getCards());
			
			Wantlist wantlist = new WantlistFetcher().fetch();
			List<Card> wantedCards = wantlist.getCardsInSet(set.getCode());
			setCards.removeAll(wantedCards);
			
			setCards.sort(new CardNumberComparator());
			wantedCards.sort(new CardNumberComparator());
			
			lstAllCards.getItems().addAll(setCards);
			lstWantedCards.getItems().addAll(wantedCards);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		
		this.getChildren().addAll(btnBack, btnSave, btnRemoveOne, btnRemoveAll, btnAddOne, btnAddAll, lstAllCards, lstWantedCards);
	}
	
	public Button getBackButton() {
		return btnBack;
	}
	
	public Button getSaveButton() {
		return btnSave;
	}
	
	public Button getRemoveOneButton() {
		return btnRemoveOne;
	}
	
	public Button getRemoveAllButton() {
		return btnRemoveAll;
	}
	
	public Button getAddOneButton() {
		return btnAddOne;
	}
	
	public Button getAddAllButton() {
		return btnAddAll;
	}
	
	public ListView<Card> getAllCardsList() {
		return lstAllCards;
	}
	
	public ListView<Card> getWantedCardsList() {
		return lstWantedCards;
	}

}
