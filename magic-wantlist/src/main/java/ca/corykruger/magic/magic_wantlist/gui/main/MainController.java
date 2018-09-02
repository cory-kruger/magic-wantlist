package ca.corykruger.magic.magic_wantlist.gui.main;

import java.io.IOException;

import ca.corykruger.magic.magic_wantlist.gui.set_selector.SetSelectorController;
import ca.corykruger.magic.magic_wantlist.io.WantlistExporter;
import ca.corykruger.magic.magic_wantlist.mtgjson.SetsUpdater;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController implements EventHandler {
	
	private final Stage primaryStage;
	private final MainView view = new MainView(this);
	
	public MainController(final Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void handle(Event event) {
		final Object source = event.getSource();
		
		if (source.equals(view.getUpdateSetsButton())) {
			try {
				new SetsUpdater().updateSetCodes();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException(e);
			}
		} else if (source.equals(view.getUpdateWantlistButton())) {
			final SetSelectorController setSelectorController = new SetSelectorController(primaryStage);
			final Scene scene = new Scene(setSelectorController.getView());
			primaryStage.setScene(scene);
		} else if (source.equals(view.getExportWantlistButton())) {
			try {
				new WantlistExporter().export();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException(e);
			}
			System.out.println("Export button activated");
		} if (source.equals(view.getExitButton())) {
			primaryStage.close();
		}
	}

	
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public MainView getView() {
		return view;
	}

}
