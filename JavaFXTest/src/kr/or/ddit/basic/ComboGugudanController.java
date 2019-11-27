package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ComboGugudanController implements Initializable{

	@FXML 
	private ComboBox<Integer> cmbDan;
	
	@FXML 
	private Button btmDan;
	
	@FXML 
	private TextArea txtResult;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Integer> list = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9);
		cmbDan.setItems(list);
		
		/*btmDan.setOnAction(e->{
			int dan = cmbDan.getSelectionModel().getSelectedItem();
			
			txtResult.setText(dan + "단\n\n");
			for(int i=1; i<=9; i++) {
				int r = dan * i;
				txtResult.appendText(dan + " * " + i + " = " + r + "\n");
			}
		});*/
	
	}

	/**
	 * 단 버튼이 클릭되었을때 처리하는 메서드
	 * @param e
	 */
	@FXML
	void btnDanClick(ActionEvent e) {
		
		int dan = cmbDan.getSelectionModel().getSelectedItem();
			
			txtResult.setText(dan + "단\n\n");
			for(int i=1; i<=9; i++) {
				int r = dan * i;
				txtResult.appendText(dan + " * " + i + " = " + r + "\n");
			}
		
	}
}






























