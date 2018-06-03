/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utility.Connector;
import java.sql.Connection;

/**
 *
 * @author idea
 */
public class AbstractDAO {
    
    private Connector connector;
    private Connection connection;

    public Connector getConnector() {
        if(this.connector==null)
            this.connector=new Connector();
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    public Connection getConnection() {
        if(this.connection==null)
            this.connection=this.getConnector().connect();         
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
}
