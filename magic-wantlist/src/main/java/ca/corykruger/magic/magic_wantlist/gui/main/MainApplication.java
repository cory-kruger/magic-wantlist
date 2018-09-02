package ca.corykruger.magic.magic_wantlist.gui.main;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
	
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void init() {
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO:  https://stackoverflow.com/a/41308995/3670821
		final Scene scene = new Scene(new MainController(primaryStage).getView());
		primaryStage.setScene(scene);
		primaryStage.show();
		
//		GridPane pane = new GridPane();
//		pane.setAlignment(Pos.CENTER);
//		pane.setHgap(10);
//		pane.setVgap(10);
//		pane.setPadding(new Insets(25, 25, 25, 25));
//		
//		Button btnUpdateSets = new Button("Update Sets");
//		Button btnUpdateWantlist = new Button("Update Wantlist");
//		Button btnExportWantlist = new Button("Export Wantlist");
//		Button btnExit = new Button("Exit");
//		
//		pane.add(btnUpdateSets, 0, 0);
//		pane.add(btnUpdateWantlist, 1, 0);
//		pane.add(btnExportWantlist, 0, 1);
//		pane.add(btnExit, 1, 1);
//		
//		Scene scene = new Scene(pane, 800, 600);
//		primaryStage.setScene(scene);
//
//		primaryStage.setTitle("Wantlist Manager");
//		primaryStage.show();
	}

	

}
