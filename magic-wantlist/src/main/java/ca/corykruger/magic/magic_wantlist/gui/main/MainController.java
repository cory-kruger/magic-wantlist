package ca.corykruger.magic.magic_wantlist.gui.main;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ca.corykruger.magic.magic_wantlist.io.FileProcessor;
import javafx.event.Event;
import javafx.event.EventHandler;
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
			System.out.println("Update Sets button was pressed");
			FileProcessor fileProcessor = new FileProcessor();
			try {
				fileProcessor.fetch(FileProcessor.SET_CODES, true);
			} catch (IOException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException(e);
			}
			String setCodesFile;
			try {
				setCodesFile = fileProcessor.load(FileProcessor.SET_CODES);
			} catch (IOException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException(e);
			}
			List<String> setCodes = new Gson().fromJson(setCodesFile, new TypeToken<List<String>>() {}.getType());
			for (String setCode : setCodes) {
				try {
					fileProcessor.fetch(setCode, false);
				} catch (IOException e) {
					System.out.println(e.getMessage());
					throw new RuntimeException(e);
				}
			}
		} else if (source.equals(view.getUpdateWantlistButton())) {
			System.out.println("Wantlist update button activated");
		} else if (source.equals(view.getExportWantlistButton())) {
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
