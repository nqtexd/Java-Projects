package com.todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Todo List");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JButton addTask = new JButton("Add Task");

        addTask.addActionListener(e -> {
            String task = JOptionPane.showInputDialog(frame, "Enter a new task");

            if (task != null && !task.trim().isEmpty()) {

                JCheckBox taskCheckBox = new JCheckBox(task.trim());

                taskCheckBox.addItemListener(ev -> {
                    if (ev.getStateChange() == ItemEvent.SELECTED) {
                        taskCheckBox.setForeground(Color.GRAY);
                    } else {
                        frame.remove(taskCheckBox);
                    }

                    frame.revalidate();
                    frame.repaint();
                });

                frame.add(taskCheckBox);
                frame.revalidate();
            }
        });

        frame.add(addTask);
        frame.setVisible(true);
    }
}
