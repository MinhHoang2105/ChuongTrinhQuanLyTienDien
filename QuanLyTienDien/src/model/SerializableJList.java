/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minh
 */
import java.io.Serializable;
import javax.swing.JList;
import javax.swing.ListModel;

public class SerializableJList<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private T[] data;

    public SerializableJList(JList<T> jList) {
        ListModel<T> model = jList.getModel();
        int size = model.getSize();
        data = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            data[i] = model.getElementAt(i);
        }
    }

    public T[] getData() {
        return data;
    }

    public JList<T> getJList() {
        JList<T> jList = new JList<>(data);
        return jList;
    }
}
