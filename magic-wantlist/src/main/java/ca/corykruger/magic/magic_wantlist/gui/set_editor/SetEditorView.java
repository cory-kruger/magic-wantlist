package ca.corykruger.magic.magic_wantlist.gui.set_editor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import ca.corykruger.magic.magic_wantlist.io.FileProcessor;
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
	private final Button btnOneLeft = new Button("<");
	private final Button btnAllLeft = new Button("<<");
	private final Button btnOneRight = new Button(">");
	private final Button btnAllRight = new Button(">>");
	private final ListView<Card> lstAllCards = new ListView<Card>();
	private final ListView<Card> lstWantedCards = new ListView<Card>();
	
	public SetEditorView(final SetEditorController setEditorController, String setCode) {
		btnBack.setOnAction(setEditorController);
		btnSave.setOnAction(setEditorController);
		btnOneLeft.setOnAction(setEditorController);
		btnAllLeft.setOnAction(setEditorController);
		btnOneRight.setOnAction(setEditorController);
		btnAllRight.setOnAction(setEditorController);
		
		FileProcessor fileProcessor = new FileProcessor();
		Gson gson = new Gson();
		try {
			Set set = new SetFactory().getSet(setCode);
			List<Card> setCards = new ArrayList<Card>(set.getCards());
			
			Wantlist wantlist;
			try {
				String wantlistFile = fileProcessor.load("wantlist");
				wantlist = gson.fromJson(wantlistFile, Wantlist.class);
			} catch (FileNotFoundException fnfe) {
				wantlist = new Wantlist();
			}
			List<Card> wantedCards = wantlist.getCardsInSet(set.getCode());
			setCards.removeAll(wantedCards);
			
			setCards.sort(new CardNumberComparator());
			wantedCards.sort(new CardNumberComparator());
			
			lstAllCards.getItems().addAll(setCards);
			lstWantedCards.getItems().addAll(wantedCards);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		
		this.getChildren().addAll(btnBack, btnSave, btnOneLeft, btnAllLeft, btnOneRight, btnAllRight, lstAllCards, lstWantedCards);
	}
	
	public Button getBackButton() {
		return btnBack;
	}
	
	public Button getSaveButton() {
		return btnSave;
	}
	
	public Button getOneLeftButton() {
		return btnOneLeft;
	}
	
	public Button getAllLeftButton() {
		return btnAllLeft;
	}
	
	public Button getOneRightButton() {
		return btnOneRight;
	}
	
	public Button getAllRightButton() {
		return btnAllRight;
	}
	
	public ListView<Card> getAllCardsList() {
		return lstAllCards;
	}
	
	public ListView<Card> getWantedCardsList() {
		return lstWantedCards;
	}

}
