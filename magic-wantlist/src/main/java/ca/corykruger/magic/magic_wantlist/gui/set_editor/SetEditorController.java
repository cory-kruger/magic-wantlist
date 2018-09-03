package ca.corykruger.magic.magic_wantlist.gui.set_editor;

import java.io.IOException;

import com.google.gson.Gson;

import ca.corykruger.magic.magic_wantlist.gui.set_selector.SetSelectorController;
import ca.corykruger.magic.magic_wantlist.io.FileProcessor;
import ca.corykruger.magic.magic_wantlist.io.WantlistFetcher;
import ca.corykruger.magic.magic_wantlist.wantlist.Wantlist;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SetEditorController implements EventHandler {

	private final Stage primaryStage;
	private final SetEditorView view;
	
	private FileProcessor fileProcessor;
	private Gson gson;
	private SetEditor setEditor;
	
	public SetEditorController(final Stage primaryStage, String setCode) {
		this.primaryStage = primaryStage;
		view = new SetEditorView(this, setCode);
		fileProcessor = new FileProcessor();
		gson = new Gson();
		setEditor = new SetEditor(view.getAllCardsList(), view.getWantedCardsList());
	}
	
	SetEditorController(final Stage primaryStage, SetEditorView setEditorView, String setCode, FileProcessor fileProcessor, Gson gson, SetEditor setEditor) {
		this.primaryStage = primaryStage;
		view = setEditorView;
		this.fileProcessor = fileProcessor;
		this.gson = gson;
		this.setEditor = setEditor;
	}
	
	@Override
	public void handle(Event event) {
		final Object source = event.getSource();
		setEditor = new SetEditor(view.getAllCardsList(), view.getWantedCardsList());
		
		if (source.equals(view.getBackButton())) {
			// TODO:  Add save prompt
			final SetSelectorController setSelectorController = new SetSelectorController(primaryStage);
			final Scene scene = new Scene(setSelectorController.getView());
			primaryStage.setScene(scene);
		} else if (source.equals(view.getSaveButton())) {
			saveSet();
		} else if (source.equals(view.getRemoveOneButton())) {
			setEditor.removeOne();
		} else if (source.equals(view.getRemoveAllButton())) {
			setEditor.removeAll();
		} else if (source.equals(view.getAddOneButton())) {
			setEditor.addOne();
		} else if (source.equals(view.getAddAllButton())) {
			setEditor.addAll();
		}
	}

	void saveSet() {
		try {
			Wantlist wantlist = new WantlistFetcher().fetch();
			wantlist.addAllCards(view.getWantedCardsList().getItems());
			wantlist.removeAllCards(view.getAllCardsList().getItems());
			fileProcessor.save(FileProcessor.WANTLIST, FileProcessor.JSON, gson.toJson(wantlist));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Stage getStage() {
		return primaryStage;
	}
	
	public SetEditorView getView() {
		return view;
	}
}
