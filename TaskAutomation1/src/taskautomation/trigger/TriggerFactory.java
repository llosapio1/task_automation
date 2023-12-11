/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.trigger;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
            case "CounterIsEqualToValue":
                trigger = new CounterIsEqualToValueTrigger();
                break;
            case "CounterIsGreaterThanValue":
                trigger = new CounterIsGreaterThanValueTrigger();
                break;
            case "CounterIsLessThanValue":
                trigger = new CounterIsLessThanValueTrigger();
                break;
            case "CounterIsEqualToCounter":
                trigger = new CounterIsEqualToCounterTrigger();
                break;
            case "CounterIsGreaterThanCounter":
                trigger = new CounterIsGreaterThanCounterTrigger();
                break;
            case "CounterIsLessThanCounter":
                trigger = new CounterIsLessThanCounterTrigger();
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
            // Registra l'errore utilizzando un logger
            Logger.getLogger(TriggerFactory.class.getName()).log(Level.SEVERE, "Error during the loading of the dialog", e);
            // Lancia un'eccezione per indicare l'errore
            throw new TimeDialogException("Unable to load the dialog for time selection", e);
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
            // Registra l'errore utilizzando un logger
            Logger.getLogger(TriggerFactory.class.getName()).log(Level.SEVERE, "Error during the loading of the dialog", e);
            // Lancia un'eccezione per indicare l'errore
            throw new TimeDialogException("Unable to load the dialog for day of the week selection", e);
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
            // Registra l'errore utilizzando un logger
            Logger.getLogger(TriggerFactory.class.getName()).log(Level.SEVERE, "Error during the loading of the dialog", e);
            // Lancia un'eccezione per indicare l'errore
            throw new TimeDialogException("Unable to load the dialog for day of month selection", e);
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
            // Registra l'errore utilizzando un logger
            Logger.getLogger(TriggerFactory.class.getName()).log(Level.SEVERE, "Error during the loading of the dialog", e);
            // Lancia un'eccezione per indicare l'errore
            throw new TimeDialogException("Unable to load the dialog for date selection", e);
        }
    }

}
