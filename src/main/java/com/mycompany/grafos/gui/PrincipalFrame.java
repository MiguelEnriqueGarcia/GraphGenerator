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

    public enum SETUP_TYPES {SIMPLE, COMPONENT_TESTER}
    
    private Graph graph;
    
    public PrincipalFrame(Graph graph) {
        super("Simulación 2D");
        
        this.graph = graph;
        
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

//        this.setIgnoreRepaint(true);

        this.setVisible(true);
    }
    
    public void setUp(SETUP_TYPES type){
        if (type == SETUP_TYPES.SIMPLE) {
            this.add(graph);
        }else if (type == SETUP_TYPES.COMPONENT_TESTER) {
            this.add(new ComponentTester(this, graph));
        }
    }

    public Graph getGraph() {
        return graph;
    }
    
    
    
}
