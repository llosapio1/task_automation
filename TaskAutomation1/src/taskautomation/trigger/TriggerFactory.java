/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.trigger;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import taskautomation.Factory;

/**
 *
 * @author alessandro
 */

public class TriggerFactory{

    public Trigger create(String triggerType) {
        Trigger trigger = null;
        if (null != triggerType) switch (triggerType) {
            case "TimeOfDay":
                LocalTime time = getTimeFromDialog();
                trigger = new TimeOfDayTrigger(time);
                break;
            case "DayOfWeek":
                DayOfWeek dayOfWeek = getDayOfWeekFromDialog();
                trigger =new DayOfWeekTrigger(dayOfWeek);
                break;
            case "DayOfMonth":
                int dayOfMonth = getDayOfMonthFromDialog();
                trigger = new DayOfMonthTrigger(dayOfMonth);
                break;
            case "Date":
                LocalDate date = getDateFromDialog();
                trigger = new DateTrigger(date);
                break;
            case "FileExists":
                trigger = new FileExistsTrigger();
                break;
            case "FileSizeIsGreater":
                trigger = new FileSizeIsGreaterTrigger();
                break;
            case "ReturnCodeIsEqual":
                trigger = new ReturnCodeIsEqualTrigger();
                break;
            case "OR":
                trigger = new TriggerCompositeOR();
                break;
            case "AND":
                trigger = new TriggerCompositeAND();
                break;
            case "NOT":
                trigger = new TriggerCompositeNOT();
                break;
            default:
                break;
        }

        return trigger;
    }
    
    private static LocalTime getTimeFromDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(TriggerFactory.class.getResource("TimeInputDialog.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            TimeInputDialogController controller = fxmlLoader.getController();
            controller.setStage(stage);

            return controller.showDialog();
        } catch (IOException e) {
            return null;
        }
    }
    
    private static DayOfWeek getDayOfWeekFromDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(TriggerFactory.class.getResource("DayOfWeekInputDialog.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            DayOfWeekInputDialogController controller = fxmlLoader.getController();
            controller.setStage(stage);

            return controller.showDialog();
        } catch (IOException e) {
            return null;
        }
    }
    
    private static int getDayOfMonthFromDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(TriggerFactory.class.getResource("DayOfMonthInputDialog.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            DayOfMonthInputDialogController controller = fxmlLoader.getController();
            controller.setStage(stage);

            return controller.showDialog();
        } catch (IOException e) {
            return -1;
        }
    }
    
    private static LocalDate getDateFromDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(TriggerFactory.class.getResource("DateInputDialog.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            DateInputDialogController controller = fxmlLoader.getController();
            controller.setStage(stage);

            return controller.showDialog();
        } catch (IOException e) {
            return null;
        }
    }

}
