package com.qsoft.kata5;

import com.qsoft.kata5.ui.controller.HistoryController;
import com.qsoft.kata5.ui.controller.MainController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

/**
 * User: tienhd
 * Date: 8/8/13
 * Time: 8:28 AM
 */
public class MainApp
{
    public static Calendar timeSystem = Calendar.getInstance();
    public static MainController mainController;

    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        mainController = (MainController) applicationContext.getBean("mainController");
        mainController.setTimeSystem(timeSystem);
        mainController.showMainFrame();

        HistoryController historyController = (HistoryController) applicationContext.getBean("historyController");
    }
}
