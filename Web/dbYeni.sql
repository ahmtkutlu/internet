drop database sinema;
create database sinema; 
use sinema;

create table oyuncular (oyuncu_id int primary key,ad varchar(50),soyad varchar(50),yas int,cinsiyet varchar(5));

create table kategori(kategori_id int primary key,kategori_ad varchar(20));

create table film_yonetmeni(filmyonetmen_id int primary key,yonetmen_adi varchar(50),yonetmen_soyadi varchar(50),yonetmen_cinsiyeti varchar(5));

create table yapimci(yapimci_id int primary key,yapimci_adi varchar(50),kurulus_tarihi varchar(50),mail varchar(50));

create table salon(salon_id int primary key,title varchar(50),kapasite int);

create table duyuru(duyuru_id int primary key,title varchar(50),icerik varchar(1000),baslangicTarihi date,bitisTarihi date);

create table ses_yonetmeni(sesyonetmeni_id int primary key,sesyonetmeni_adi varchar(20),sesyonetmeni_soyadi varchar(20),sesyonetmeni_cinsiyet varchar(5));

create table isik_yonetmeni(isikyonetmeni_id int primary key,isikyonetmeni_adi varchar(20),isikyonetmeni_soyadi varchar(20),isikyonetmeni_cinsiyet varchar(5));

create table filmler(film_id int primary key,film_ad varchar(50),ımdb_puani float,sure int ,butce int,yil int,filmyonetmen_id int references film_yonetmeni(filmyonetmen_id),isikyonetmeni_id int references isik_yonetmeni(isikyonetmeni_id),sesyonetmeni_id int references ses_yonetmeni(sesyonetmeni_id),yapimci_id int references yapimci(yapimci_id),film_icerik varchar(1000) );

create table basrol(basrol_id int primary key,oyuncu_id int references oyuncular(oyuncu_id),film_id int references filmler(film_id));

create table film_oyuncu(film_oyuncu_id int primary key, oyuncu_id int references oyuncular(oyuncu_id),film_id int references filmler(film_id));

create table film_kategori(film_kategori_id int primary key,film_id int references filmler(film_id),kategori_id int references kategori(kategori_id));

create table seans(seans_id int primary key,salon_id int references salon(salon_id),saat float,film_id int references filmler(film_id),dil varchar(50));

create table user(user_id int primary key,user_ad varchar(50),user_soyad varchar(50),mail varchar(50),sifre varchar(50),admin int );

create table yorum(yorum_id int primary key,film_id int references filmler(film_id),user_id int references user(user_id),icerik varchar(200),yorum_basligi varchar(50),yorumolusturma_tarihi datetime);





insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (1,"Tim","Robbins",38,"Erkek");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (2,"John","Deep",35,"Erkek");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (3,"Morgan","Freman",50,"Erkek");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (4,"Leonardo","Digabrio",45,"Erkek");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (5,"Burice","Villis",34,"Erkek");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (6,"Paul","Walker",40,"Erkek");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (7,"Angelina","Julie",30,"Bayan");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (8,"Cem","Yilmaz",56,"Erkek");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (9,"Türkan","Soray",60,"Bayan");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (10,"Ata","Demirel",39,"Erkek");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (11,"Hülya","Avşar",59,"Bayan");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (12,"Brad","Pitt",29,"Erkek");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (13,"Sener","Sen",60,"Erkek");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (14,"Will","Simith",34,"Erkek");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (15,"Tom","Curuise",56,"Erkek");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (16,"Ajda","Pekkan",70,"Bayan");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (17,"Fatma","Girik",70,"Bayan");
insert into oyuncular(oyuncu_id,ad,soyad,yas,cinsiyet) values (18,"Beren","Saat",30,"Bayan");






insert into kategori(kategori_id,kategori_ad) values(1,"Aksiyon");
insert into kategori(kategori_id,kategori_ad) values(2,"Animasyon");
insert into kategori(kategori_id,kategori_ad) values(3,"Dram");
insert into kategori(kategori_id,kategori_ad) values(4,"Bilim Kurgu");
insert into kategori(kategori_id,kategori_ad) values(5,"Komedi");
insert into kategori(kategori_id,kategori_ad) values(6,"Gerilim");
insert into kategori(kategori_id,kategori_ad) values(7,"Savas");
insert into kategori(kategori_id,kategori_ad) values(8,"Mareca");
insert into kategori(kategori_id,kategori_ad) values(9,"Romantik");
insert into kategori(kategori_id,kategori_ad) values(10,"Polisiye");





insert into film_yonetmeni(filmyonetmen_id,yonetmen_adi,yonetmen_soyadi,yonetmen_cinsiyeti) values (1,"Martin","Scorsesse","Erkek");
insert into film_yonetmeni(filmyonetmen_id,yonetmen_adi,yonetmen_soyadi,yonetmen_cinsiyeti) values (2,"Steven","Spielperg","Erkek");
insert into film_yonetmeni(filmyonetmen_id,yonetmen_adi,yonetmen_soyadi,yonetmen_cinsiyeti) values (3,"Francis","Fordcoppola","Erkek");
insert into film_yonetmeni(filmyonetmen_id,yonetmen_adi,yonetmen_soyadi,yonetmen_cinsiyeti) values (4,"Woody","Allen","Erkek");
insert into film_yonetmeni(filmyonetmen_id,yonetmen_adi,yonetmen_soyadi,yonetmen_cinsiyeti) values (5,"Clint","Eastwood","Erkek");
insert into film_yonetmeni(filmyonetmen_id,yonetmen_adi,yonetmen_soyadi,yonetmen_cinsiyeti) values (6,"Ridley","Scot","Erkek");





insert into salon values(1,"Salon 1",30);
insert into salon values(2,"Salon 2",40);
insert into salon values(3,"Salon 3",45);
insert into salon values(4,"Salon 4",30);
insert into salon values(5,"Salon 5",50);


insert into duyuru values(1,"Duyuru 1","Bu bir denemedir.","2017-03-12","2017-04-12");



insert into yapimci values(1,"Ares Media",1972,"aresmedia@mail.com");
insert into yapimci values(2,"Arzu Film",1964,"arzufilm@mail.com");
insert into yapimci values(3,"At Production",1987,"atproduction@mail.com");
insert into yapimci values(4,"Halk Film",1983,"halkfilm@mail.com");
insert into yapimci values(5,"Mint",1965,"mint@mail.com");





insert into isik_yonetmeni values(1,"Roman","Polanski","Erkek");
insert into isik_yonetmeni values(2,"David","Lynch","Erkek");
insert into isik_yonetmeni values(3,"Brian","De Palma","Erkek");
insert into isik_yonetmeni values(4,"George","Lucas","Erkek");
insert into isik_yonetmeni values(5,"Peter","Jackson","Erkek");
insert into isik_yonetmeni values(6,"James","Cameron","Erkek");




INSERT INTO `sinema`.`ses_yonetmeni` (`sesyonetmeni_id`, `sesyonetmeni_adi`, `sesyonetmeni_soyadi`, `sesyonetmeni_cinsiyet`) VALUES ('1', 'William', 'Wyler', 'Erkek');

INSERT INTO `sinema`.`ses_yonetmeni` (`sesyonetmeni_id`, `sesyonetmeni_adi`, `sesyonetmeni_soyadi`, `sesyonetmeni_cinsiyet`) VALUES ('2', 'Akira', 'Kurosawa', 'Erkek');

INSERT INTO `sinema`.`ses_yonetmeni` (`sesyonetmeni_id`, `sesyonetmeni_adi`, `sesyonetmeni_soyadi`, `sesyonetmeni_cinsiyet`) VALUES ('3', 'Kathryn', 'Bigelow', 'Kadýn');

INSERT INTO `sinema`.`ses_yonetmeni` (`sesyonetmeni_id`, `sesyonetmeni_adi`, `sesyonetmeni_soyadi`, `sesyonetmeni_cinsiyet`) VALUES ('4', 'Alfonso Cuaron', 'Orozco', 'Erkek');

INSERT INTO `sinema`.`ses_yonetmeni` (`sesyonetmeni_id`, `sesyonetmeni_adi`, `sesyonetmeni_soyadi`, `sesyonetmeni_cinsiyet`) VALUES ('5', 'Ang ', 'Lee', 'Erkek');

INSERT INTO `sinema`.`ses_yonetmeni` (`sesyonetmeni_id`, `sesyonetmeni_adi`, `sesyonetmeni_soyadi`, `sesyonetmeni_cinsiyet`) VALUES ('6', 'Elia', 'Kazan', 'Erkek');






insert into filmler values (1,"Esaretin Bedeli",9.1,142,10000,1994,3,1,4,2,"Icerik 1");
insert into filmler values (2,"Yüzüklerin Efendisi",9.0,180,500,2003,1,2,3,5,"Icerik 2");
insert into filmler values (3,"Kara Sovalye",9.5,130,1900,2008,5,3,6,1,"Icerik 3");
insert into filmler values (4,"The Godfather",8.0,175,54000,1972,3,4,1,4,"Icerik 4");
insert into filmler values (5,"Inception ",8.9,150,8000,2013,1,5,5,1,"Icerik 5");
insert into filmler values (6,"Ucuz Roman",9.1,102,4000,1994,6,6,4,2,"Icerik 6");
insert into filmler values (7,"12 Kizgin Adam",7.1,242,6000,2016,2,1,1,3,"Icerik 7");
insert into filmler values (8,"Yüzüklerin Efendisi",5.1,179,7430,2010,2,2,2,6,"Icerik 8");
insert into filmler values (9,"İyi Kötü Cirkin",4.5,122,2345,1999,5,4,3,1,"Icerik 9");
insert into filmler values (10,"Dövüs Kulubü",7.3,132,7700,2006,3,3,4,2,"Icerik 10");
insert into filmler values (11,"Yildiz Savaslari",3.7,150,1400,2009,2,1,5,6,"Icerik 11");
insert into filmler values (12,"Forrest Gump",4.8,176,17070,2011,5,5,6,5,"Icerik 12");
insert into filmler values (13,"Guguk Kusu",8.5,154,14600,2013,6,6,6,1,"Icerik 13");
insert into filmler values (14,"Sıkı Dostlar",9.3,144,3000,2015,2,1,5,3,"Icerik 14");
insert into filmler values (15,"Matrix",4.1,142,10560,2017,1,4,3,2,"Icerik 15");




INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('1', '2', '1');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('2', '3', '2');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('3', '5', '6');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('4', '6', '2');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('5', '7', '9');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('6', '2', '3');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('7', '1', '4');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('8', '4', '5');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('9', '8', '1');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('10', '9', '10');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('11', '10', '11');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('12', '11', '12');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('13', '12', '13');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('14', '13', '14');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('15', '14', '15');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('16', '15', '15');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('17', '10', '10');
INSERT INTO `sinema`.`film_oyuncu` (`film_oyuncu_id`, `oyuncu_id`, `film_id`) VALUES ('18', '12', '8');













INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('1', '1', '1');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('2', '2', '4');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('3', '3', '2');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('4', '4', '8');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('5', '5', '6');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('6', '6', '7');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('7', '8', '9');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('8', '7', '6');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('9', '8', '6');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('10', '9', '10');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('11', '10', '1');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('12', '11', '2');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('13', '12', '3');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('14', '13', '4');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('15', '14', '5');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('16', '15', '6');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('17', '13', '7');
INSERT INTO `sinema`.`film_kategori` (`film_kategori_id`, `film_id`, `kategori_id`) VALUES ('18', '10', '2');







INSERT INTO `sinema`.`basrol` (`basrol_id`, `oyuncu_id`, `film_id`) VALUES ('1', '1', '1');
INSERT INTO `sinema`.`basrol` (`basrol_id`, `oyuncu_id`, `film_id`) VALUES ('2', '2', '4');
INSERT INTO `sinema`.`basrol` (`basrol_id`, `oyuncu_id`, `film_id`) VALUES ('3', '5', '12');
INSERT INTO `sinema`.`basrol` (`basrol_id`, `oyuncu_id`, `film_id`) VALUES ('4', '6', '13');
INSERT INTO `sinema`.`basrol` (`basrol_id`, `oyuncu_id`, `film_id`) VALUES ('5', '7', '9');
INSERT INTO `sinema`.`basrol` (`basrol_id`, `oyuncu_id`, `film_id`) VALUES ('6', '15', '11');
INSERT INTO `sinema`.`basrol` (`basrol_id`, `oyuncu_id`, `film_id`) VALUES ('7', '1', '7');








INSERT INTO `sinema`.`seans` (`seans_id`, `salon_id`, `saat`, `film_id`, `dil`) VALUES ('1', '2', '12', '5', 'Türkce');
INSERT INTO `sinema`.`seans` (`seans_id`, `salon_id`, `saat`, `film_id`, `dil`) VALUES ('2', '5', '14.30', '10', 'İngilizce');








INSERT INTO `sinema`.`user` (`user_id`, `user_ad`, `user_soyad`, `mail`, `sifre`, `admin`) VALUES ('1', 'emrah', 'sarikaya', 'emrah@inonu.edu.tr', '1234', '1');
INSERT INTO `sinema`.`user` (`user_id`, `user_ad`, `user_soyad`, `mail`, `sifre`, `admin`) VALUES ('2', 'Osman', 'Sahin', 'osman@inonu.edu.tr', '1234', '0');
INSERT INTO `sinema`.`user` (`user_id`, `user_ad`, `user_soyad`, `mail`, `sifre`, `admin`) VALUES ('3', 'Yunus', 'Topuz', 'yunus@inonu.edu.tr', '1234', '0');
INSERT INTO `sinema`.`user` (`user_id`, `user_ad`, `user_soyad`, `mail`, `sifre`, `admin`) VALUES ('4', 'Ahmet', 'Kutlu', 'ahmet@inonu.edu.tr', '1234', '0');
INSERT INTO `sinema`.`user` (`user_id`, `user_ad`, `user_soyad`, `mail`, `sifre`, `admin`) VALUES ('5', 'Talha', 'Fakıoglu', 'talha.inonu.edu.tr', '1234', '0');
INSERT INTO `sinema`.`user` (`user_id`, `user_ad`, `user_soyad`, `mail`, `sifre`, `admin`) VALUES ('6', 'Nurcihan', 'Kılıc', 'nur@inonu.edu.tr', '1234', '0');




INSERT INTO `sinema`.`yorum` (`yorum_id`, `film_id`, `user_id`, `icerik`, `yorum_basligi`, `yorumolusturma_tarihi`) VALUES ('1', '2', '2', 'Flimi cok begendim', 'Flim Konusu', '2018-02-24');





