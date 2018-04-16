/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Yapimci;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author idea
 */
public class YapimciDao extends AbstractDao {

    public Yapimci find(int idyapimci) {

        Yapimci y = null;
        try {

            Statement st2 = this.getConnection().createStatement();
            ResultSet rs2 = st2.executeQuery("select * from yapimci where idyapimci=" + idyapimci);
            rs2.next();

            y = new Yapimci();
            y.setIdyapimci(rs2.getInt(1)/*getInt("idyapimci")*/);
            y.setYapimci_adi(rs2.getString(2)/*getString("yapimci_adi")*/);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return y;
    }

}
