package ca.corykruger.magic.magic_wantlist.gui.set_selector;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import ca.corykruger.magic.magic_wantlist.io.FileProcessor;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class SetSelectorView extends HBox {
	private final Button btnBack = new Button("Back");
	private final Button btnEdit = new Button("Edit Selected Set's Wantlist");
	private final ListView<String> lstSets = new ListView<String>();

	public SetSelectorView(final SetSelectorController setSelectorController) {
		FileProcessor fileProcessor = new FileProcessor();
		try {
			List<String> setCodes = new Gson().fromJson(fileProcessor.load(FileProcessor.SET_CODES), new TypeToken<List<String>>() {}.getType());
			lstSets.getItems().addAll(setCodes);
		} catch (JsonSyntaxException | IOException e) {
			throw new RuntimeException(e);
		}
		btnBack.setOnAction(setSelectorController);
		btnEdit.setOnAction(setSelectorController);
		this.getChildren().addAll(lstSets);
		this.getChildren().addAll(btnBack);
		this.getChildren().addAll(btnEdit);
	}
	
	public Button getBackButton() {
		return btnBack;
	}
	
	public Button getEditButton() {
		return btnEdit;
	}
	
	public ListView<String> getSetCodeList() {
		return lstSets;
	}
	
}
