/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.yorum;
import utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class yorumDAO {

    private yorum yrm = null;
    private ArrayList<yorum> yrmlist = null;

//    public yorum getYrm(Long id){
//        Connection con =ConnectionManager.baglanti();
//        try{
//            Statement st =con.createStatement();
//            ResultSet rs =st.executeQuery("select * from yorum where y_id="+id);
//            rs.next();
//            this.yrm =new yorum(rs.getString("y_ad"),rs.getString("y_yorum"),rs.getLong("arayan_id"));
//        }
//        catch(SQLException ex){
//            System.out.println(ex.getMessage());
//            
//        }
//        return this.yrm;
//    }
//     public yorum getArayan(Long id){
//        Connection con =ConnectionManager.baglanti();
//        try{
//            Statement st =con.createStatement();
//            ResultSet rs =st.executeQuery("select * from yorum where arayan_id="+id);
//            rs.next();
//            this.yrm =new yorum(rs.getString("y_ad"),rs.getString("y_yorum"));
//        }
//        catch(SQLException ex){
//            System.out.println(ex.getMessage());
//            
//        }
//        return this.yrm;
//    }
    public ArrayList<yorum> list() {
        this.yrmlist = new ArrayList();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from yorum");
            while (rs.next()) {
                this.yrmlist.add(new yorum(rs.getLong("idyorum"), rs.getLong("filmler_idfilmler"), rs.getLong("user_iduser"), rs.getString("icerik")));
            }
            this.yrm = new yorum(rs.getLong("filmler_idfilmler"), rs.getLong("user_iduser"), rs.getString("icerik"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return this.yrmlist;
    }

    public void delete(Long id) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from yorum where idyorum=" + id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(yorum y) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update yorum set user_iduser='" + y.getUser_id() + "',icerik='" + y.getIcerik() + "',filmler_idfilmler='" + y.getFilm_id() + "' where idyorum=" + y.getYorum_id());
            System.out.print("güncelledi");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }
        public void create(yorum y){
              Connection con =ConnectionManager.getConnection();
        try{
            Statement st =con.createStatement();
            
            st.executeUpdate("insert into yorum(filmler_idfilmler,user_iduser,icerik) values ('"+y.getFilm_id()+"','"+y.getUser_id()+"','"+y.getIcerik()+"')");
            System.out.println("yorum eklendi");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }

    public static void main(String args[]) {
        yorumDAO yr = new yorumDAO();

    }

}
