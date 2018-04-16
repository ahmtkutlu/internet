/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Yonetmen;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author idea
 */
public class YonetmenDao extends AbstractDao{
    
    
    public Yonetmen find(int idyonetmen) {

        Yonetmen y = null;
        try {

            Statement st2 = this.getConnection().createStatement();
            ResultSet rs2 = st2.executeQuery("select * from yonetmen where idyonetmen=" + idyonetmen);
            rs2.next();

            y = new Yonetmen();
            y.setYonetmen_id(rs2.getInt(1)/*getInt("idyapimci")*/);
            y.setYonetmen_ad(rs2.getString(2)/*getString("yapimci_adi")*/);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return y;
    }
    
}
