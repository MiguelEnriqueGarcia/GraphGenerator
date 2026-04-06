/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos.gui;

import com.mycompany.grafos.service.PrinterService;
import javax.swing.JFrame;

/**
 *
 * @author migue
 */
public class PrincipalFrame extends JFrame{

    public PrincipalFrame(Graph graph) {
        super("Simulación 2D");
        
        this.add(graph);
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setIgnoreRepaint(true);

        this.setVisible(true);
    }
    
}
