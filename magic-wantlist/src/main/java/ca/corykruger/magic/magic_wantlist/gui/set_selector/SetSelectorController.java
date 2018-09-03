package ca.corykruger.magic.magic_wantlist.gui.set_selector;

import ca.corykruger.magic.magic_wantlist.gui.main.MainController;
import ca.corykruger.magic.magic_wantlist.gui.set_editor.SetEditorController;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SetSelectorController implements EventHandler {
	
	private final Stage primaryStage;
	private final SetSelectorView view = new SetSelectorView(this);
	
	public SetSelectorController(final Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public SetSelectorView getView() {
		return view;
	}

	@Override
	public void handle(Event event) {
		final Object source = event.getSource();
		
		if (source.equals(view.getBackButton())) {
			final MainController mainController = new MainController(primaryStage);
			final Scene scene = new Scene(mainController.getView());
			primaryStage.setScene(scene);
		} else if (source.equals(view.getEditButton())) {
			String selectedSet = view.getSetCodeList().getSelectionModel().getSelectedItem();
			final SetEditorController setEditorController = new SetEditorController(primaryStage, selectedSet);
			final Scene scene = new Scene(setEditorController.getView());
			primaryStage.setScene(scene);
		}
	}

}
