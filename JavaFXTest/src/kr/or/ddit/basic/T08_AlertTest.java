package kr.or.ddit.basic;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class T08_AlertTest extends Application{
	
	@Override
	public void start(Stage parimaryStage) throws Exception{
		Alert alertInformation = new Alert(AlertType.INFORMATION);
		
		alertInformation.setTitle("INFORMATION");
		alertInformation.setTitle("INFORMATION Alert창 입니다.");
		alertInformation.setTitle(""); //창 띄우기
		
		//========================================================
		
		Alert alertError = new Alert(AlertType.ERROR);
		
		alertError.setTitle("ERROR");
		alertError.setContentText("ERROR Alert 창 입니다.");
		alertError.showAndWait();
		
		//=========================================================
		
		Alert alretWarning = new Alert(AlertType.WARNING);
		
		alretWarning.setTitle("WARNING");
		alretWarning.setContentText("WARNING Alert 창 입니다.");
		alretWarning.showAndWait();
		
		//=========================================================
		
		
		Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
		alertConfirm.setTitle("CONFIRMATION");
		alertConfirm.setContentText("CONFIRMATION Alert 창 입니다.");
		
		// Alert 창을 보여주고 사용자가 누른 버튼 값 읽어오기.
		ButtonType confirmResult = alertConfirm.showAndWait().get();
		
		
		if(confirmResult == ButtonType.OK) {
			System.out.println("OK 버튼을 눌렀습니다.");
		}else if(confirmResult == ButtonType.CANCEL){
			System.out.println("취소버튼을 눌렀습니다.");
		}
		
		//=========================================================
		
		
		//JavaScript 의 prompt창과 같은기능
		TextInputDialog javaPrompt = new TextInputDialog("기본값");
		javaPrompt.setTitle("PROMPT 창"); //창제목
		javaPrompt.setHeaderText("TextInputDialog 창 입니다.");
		
		//창을 보이고 입력한 값을 읽어오기.
		Optional<String> result = javaPrompt.showAndWait();
		String strResult = null; // 입력한 값이 저장 될 변수.
		
		//입력한 값이 있는지 검사.(값 입력 후 'OK' 버튼 눌렀는지 검사.)
		if(result.isPresent()) {
			strResult = result.get(); // 값 읽어오기
		}
		
		System.out.println("읽어온 값 : " + strResult);
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}





















