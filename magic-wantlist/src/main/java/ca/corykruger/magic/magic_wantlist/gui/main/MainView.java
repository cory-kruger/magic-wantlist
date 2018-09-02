package ca.corykruger.magic.magic_wantlist.gui.main;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class MainView extends HBox {
	
	private final Button btnUpdateSets = new Button("Update Sets");
	private final Button btnUpdateWantlist = new Button("Update Wantlist");
	private final Button btnExportWantlist = new Button("Export Wantlist");
	private final Button btnExit = new Button("Exit");
	
	public MainView(final MainController mainController) {
		btnUpdateSets.setOnAction(mainController);
		btnUpdateWantlist.setOnAction(mainController);
		btnExportWantlist.setOnAction(mainController);
		btnExit.setOnAction(mainController);
		this.getChildren().addAll(btnUpdateSets);
		this.getChildren().addAll(btnUpdateWantlist);
		this.getChildren().addAll(btnExportWantlist);
		this.getChildren().addAll(btnExit);
	}
	
	public Button getUpdateSetsButton() {
		return btnUpdateSets;
	}
	
	public Button getExitButton() {
		return btnExit;
	}

	public Button getUpdateWantlistButton() {
		return btnUpdateWantlist;
	}

	public Object getExportWantlistButton() {
		return btnExportWantlist;
	}

}
