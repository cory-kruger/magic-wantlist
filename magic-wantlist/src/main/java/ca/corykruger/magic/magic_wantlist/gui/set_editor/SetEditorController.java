package ca.corykruger.magic.magic_wantlist.gui.set_editor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import ca.corykruger.magic.magic_wantlist.gui.set_selector.SetSelectorController;
import ca.corykruger.magic.magic_wantlist.io.FileProcessor;
import ca.corykruger.magic.magic_wantlist.wantlist.Card;
import ca.corykruger.magic.magic_wantlist.wantlist.Wantlist;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class SetEditorController implements EventHandler {

	private final Stage primaryStage;
	private final SetEditorView view;
	
	public SetEditorController(final Stage primaryStage, String setCode) {
		this.primaryStage = primaryStage;
		view = new SetEditorView(this, setCode);
	}
	
	public Stage getStage() {
		return primaryStage;
	}
	
	public SetEditorView getView() {
		return view;
	}

	@Override
	public void handle(Event event) {
		final Object source = event.getSource();
		
		if (source.equals(view.getBackButton())) {
			// TODO:  Add save prompt
			final SetSelectorController setSelectorController = new SetSelectorController(primaryStage);
			final Scene scene = new Scene(setSelectorController.getView());
			primaryStage.setScene(scene);
		} else if (source.equals(view.getSaveButton())) {
			try {
				FileProcessor fileProcessor = new FileProcessor();
				List<Card> wantedCards = view.getWantedCardsList().getItems();
				Gson gson = new Gson();
				Wantlist wantlist;
				try {
				wantlist = gson.fromJson(fileProcessor.load("wantlist"), Wantlist.class);
				} catch (FileNotFoundException fnfe) {
					wantlist = new Wantlist();
				}
				for (Card card : wantedCards) {
					card.setWanted(true);
				}
				wantlist.addAllCards(wantedCards);
				fileProcessor.save("wantlist.json", new Gson().toJson(wantlist));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} else if (source.equals(view.getOneLeftButton())) {
			
		} else if (source.equals(view.getAllLeftButton())) {
			
		} else if (source.equals(view.getOneRightButton())) {
			ListView<Card> lstAllCards = view.getAllCardsList();
			ListView<Card> lstWantedCards = view.getWantedCardsList();
			Card selectedCard = lstAllCards.getSelectionModel().getSelectedItem();
			lstAllCards.getItems().remove(selectedCard);
			lstWantedCards.getItems().add(selectedCard);
			lstAllCards.refresh();
			lstWantedCards.refresh();
		} else if (source.equals(view.getAllRightButton())) {
			
		}
	}
}
