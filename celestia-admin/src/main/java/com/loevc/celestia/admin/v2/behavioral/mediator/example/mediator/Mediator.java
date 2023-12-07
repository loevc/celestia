package com.loevc.celestia.admin.v2.behavioral.mediator.example.mediator;

import com.loevc.celestia.admin.v2.behavioral.mediator.example.components.Component;

import javax.swing.*;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 10:44
 * @Description TODO
 * @Version 1.0
 */
public interface Mediator {

    void addNewNote(Note note);
    void deleteNote();
    void getInfoFromList(Note note);
    void saveChanges();
    void markNote();
    void clear();
    void sendToFilter(ListModel listModel);
    void setElementsList(ListModel list);
    void registerComponent(Component component);
    void hideElements(boolean flag);
    void createGUI();

}
