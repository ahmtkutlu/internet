
package Dao;

import Entity.Film;
import Entity.Yapimci;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FilmDao extends AbstractDao{
    
    private YapimciDao yapimciDao; 
    
    private YonetmenDao yonetmenDao;
    
    public List<Film> findAll(){
    
    List<Film> filmList =new ArrayList<>();
    
    try{
        Statement st=this.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from filmler");
        
        while(rs.next()){
        Film f=new Film();
        f.setIdfilmler(rs.getInt("idfilmler"));
        f.setFilm_adi(rs.getString("film_adi"));
        f.setIcerik(rs.getString("icerik"));
//        Statement st2=this.getConnection().createStatement();
//        ResultSet rs2=st2.executeQuery("select * from yapimci where idyapimci="+rs.getInt(1) /*getInt("idyapimci")*/);
//        rs2.next();
//        
//        Yapimci y=new Yapimci();
//        y.setIdyapimci(rs2.getInt(1)/*getInt("idyapimci")*/);
//        y.setYapimci_adi(rs2.getString(2)/*getString("yapimci_adi")*/);

        f.setYonetmen(this.getYonetmenDao().find(rs.getInt(1)));
       
        
        f.setYapimci(this.getYapimciDao().find(rs.getInt(1)));
        
        filmList.add(f);
        }
    
    } catch(SQLException e){
        System.out.println(e.getMessage());
    
    }
    
    
      return filmList;  
    }

    public YapimciDao getYapimciDao() {
        if(this.yapimciDao==null)
            this.yapimciDao=new YapimciDao();
        return yapimciDao;
    }

    public void setYapimciDao(YapimciDao yapimciDao) {
        this.yapimciDao = yapimciDao;
    }

    public YonetmenDao getYonetmenDao() {
        if(this.yonetmenDao==null)
            this.yonetmenDao=new YonetmenDao();
        return yonetmenDao;
    }

    public void setYonetmenDao(YonetmenDao yonetmenDao) {
        this.yonetmenDao = yonetmenDao;
    }
    
    
    
}
