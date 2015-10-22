package com.leassy.studiodd.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.*;

/**
 * Created by Omar on 29/09/2015.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper
    {
        public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
        @Override
        public void onCreate(SQLiteDatabase base) {

            base.execSQL("create table categorias(id INTEGER,area TEXT);");

            base.execSQL("INSERT INTO categorias VALUES (0,'Básicas');");
            base.execSQL("INSERT INTO categorias VALUES (1,'En la ciudad ');");
            base.execSQL("INSERT INTO categorias VALUES (2,'Emergencias'); ");
            base.execSQL("INSERT INTO categorias VALUES (3,'Viajar'); ");
            base.execSQL("INSERT INTO categorias VALUES (4,'Comer y beber'); ");
            base.execSQL("INSERT INTO categorias VALUES (5,'Hoteles y hospedaje'); ");
            base.execSQL("INSERT INTO categorias VALUES (6,'En el trabajo'); ");
            base.execSQL("INSERT INTO categorias VALUES (7,'Ir de compras'); ");
            base.execSQL("INSERT INTO categorias VALUES (8,'Ocio y tiempo libre '); ");




            base.execSQL("create table FRASES(ID INTEGER,area INTEGER,fraseesp TEXT,fraseing TEXT,audio TEXT,imagen TEXT);");

            //Area Basicas
            base.execSQL("INSERT INTO FRASES VALUES (0,0,'Hola, mi nombre es juan','Hi, my name is john','aud000','imagenbasic'); ");
            base.execSQL("INSERT INTO FRASES VALUES (1,0,'¡qué tengas un buen día!','have a nice day!','aud001','imagenbasic'); ");
            base.execSQL("INSERT INTO FRASES VALUES (2,0,'creo que no','I don''t think so','aud002','imagenbasic'); ");
            base.execSQL("INSERT INTO FRASES VALUES (3,0,'Muchas gracias','thank you very much','aud003','imagenbasic'); ");
            base.execSQL("INSERT INTO FRASES VALUES (4,0,'de nada','you''re welcome','aud004','imagenbasic'); ");
            base.execSQL("INSERT INTO FRASES VALUES (5,0,'buenos días','good morning','aud005','imagenbasic'); ");
            base.execSQL("INSERT INTO FRASES VALUES (6,0,'buenas tardes','good afternoon','aud006','imagenbasic'); ");
            base.execSQL("INSERT INTO FRASES VALUES (7,0,'buenas noches','goodnight','aud007','imagenbasic'); ");
            base.execSQL("INSERT INTO FRASES VALUES (8,0,'¡nos vemos pronto!','see you soon!','aud008','imagenbasic'); ");
            base.execSQL("INSERT INTO FRASES VALUES (9,0,'no hay problema','no problem','aud009','imagenbasic'); ");
            base.execSQL("INSERT INTO FRASES VALUES (10,0,'está bien','it''s OK ','aud010','imagenbasic'); ");
            base.execSQL("INSERT INTO FRASES VALUES (11,0,'no te preocupes','don''t worry about it','aud011','imagenbasic'); ");
            base.execSQL("INSERT INTO FRASES VALUES (12,0,'¿habla usted inglés?','do you speak English?','aud012','imagenbasic'); ");
            base.execSQL("INSERT INTO FRASES VALUES (13,0,'no hablo inglés','I don''t speak English','aud013','imagenbasic'); ");
            base.execSQL("INSERT INTO FRASES VALUES (14,0,'no lo sé','I don''t know','aud014','imagenbasic'); ");


            //Area Ciudad
            base.execSQL("INSERT INTO FRASES VALUES (0,1,'¿dónde puedo conseguir un taxi?','where can I get a taxi?','aud101','imagencity'); ");
            base.execSQL("INSERT INTO FRASES VALUES (1,1,'¿hay algún banco cerca de aquí?','is there a bank near here?','aud102','imagencity'); ");
            base.execSQL("INSERT INTO FRASES VALUES (2,1,'¿sabe usted dónde hay un cafe Internet?','do you know where there is an internet café?','aud103','imagencity'); ");
            base.execSQL("INSERT INTO FRASES VALUES (3,1,'¿disculpe, dónde está la estacion de autobuses?','excuse me, where is the bus station','aud104','imagencity'); ");
            base.execSQL("INSERT INTO FRASES VALUES (4,1,'¿hay algún supermercado cerca de aquí?','is there a supermarket near here?','aud105','imagencity'); ");
            base.execSQL("INSERT INTO FRASES VALUES (5,1,'¿disculpe, dónde está la comisaría de policía?','excuse me, where is the police station?','aud106','imagencity'); ");

            //Area Emergencias
            base.execSQL("INSERT INTO FRASES VALUES (0,2,'¡ayuda!','help!','aud201','imagenemer'); ");
            base.execSQL("INSERT INTO FRASES VALUES (1,2,'¡ten cuidado!','be careful!','aud202','imagenemer'); ");
            base.execSQL("INSERT INTO FRASES VALUES (2,2,'por favor, ayúdeme','please help me','aud203','imagenemer'); ");
            base.execSQL("INSERT INTO FRASES VALUES (3,2,'¡llame a una ambulancia!','call an ambulance!','aud204','imagenemer'); ");
            base.execSQL("INSERT INTO FRASES VALUES (4,2,'necesito un médico','I need a doctor','aud205','imagenemer'); ");
            base.execSQL("INSERT INTO FRASES VALUES (5,2,'¡llame a la policía!','call the police!','aud206','imagenemer'); ");
            base.execSQL("INSERT INTO FRASES VALUES (6,2,'estoy perdido','I''m lost','aud207','imagenemer'); ");
            base.execSQL("INSERT INTO FRASES VALUES (7,2,'por favor, déjame en paz','please leave me alone','aud208','imagenemer'); ");

            //Area Viajar
            base.execSQL("INSERT INTO FRASES VALUES (0,3,'¿dónde está la oficina de venta de billetes?','where is the ticket office?','aud301','imagenvia'); ");
            base.execSQL("INSERT INTO FRASES VALUES (1,3,'¿desde dónde puedo coger el autobús a Southampton??','where do I get the bus to Southampton from?','aud302','imagenvia'); ");
            base.execSQL("INSERT INTO FRASES VALUES (2,3,'¿has estado alguna vez en Italia?','have you ever been to Italy?','aud303','imagenvia'); ");
            base.execSQL("INSERT INTO FRASES VALUES (3,3,'¿cuánto dura el viaje?','how long does the journey take?','aud304','imagenvia'); ");
            base.execSQL("INSERT INTO FRASES VALUES (4,3,'¡qué tengas un buen viaje!','have a good journey!','aud305','imagenvia'); ");
            base.execSQL("INSERT INTO FRASES VALUES (5,3,'¿cuánto cuestan los billetes de avión?','how much are the flights?','aud306','imagenvia'); ");


            //Area comida
            base.execSQL("INSERT INTO FRASES VALUES (0,4,'¿sabe donde hay algún buen restaurante?','do you know any good restaurants?','aud401','imagencomi'); ");
            base.execSQL("INSERT INTO FRASES VALUES (1,4,'¿dónde está el restaurante más cercano?','where is the nearest restaurant?','aud402','imagencomi'); ");
            base.execSQL("INSERT INTO FRASES VALUES (2,4,'¿quieres tomarte una copa conmigo? ','do you fancy a quick drink?','aud403','imagencomi'); ");
            base.execSQL("INSERT INTO FRASES VALUES (3,4,'vamos a cenar fuera esta noche','let''s eat out tonight','aud404','imagencomi'); ");
            base.execSQL("INSERT INTO FRASES VALUES (4,4,'¿quieres ir a comer conmigo?','would you like to join me for lunch','aud405','imagencomi'); ");
            base.execSQL("INSERT INTO FRASES VALUES (5,4,'¿quieres tomarte algo después del trabajo?','would you like to come for a drink after work','aud406','imagencomi'); ");

            //Area Hotel
            base.execSQL("INSERT INTO FRASES VALUES (0,5,'¿me podrías recomendar algúnos buenos hoteles?','can you recommend any good hotel?','aud501','imagenhotel'); ");
            base.execSQL("INSERT INTO FRASES VALUES (1,5,'me gustaría alojarme en el centro de la ciudad','I''d like to stay in the city centre','aud502','imagenhotel'); ");
            base.execSQL("INSERT INTO FRASES VALUES (2,5,'¿a qué distancia está de el centro de la ciudad?','how far is it from the city centre?','aud503','imagenhotel'); ");
            base.execSQL("INSERT INTO FRASES VALUES (3,5,'¿dónde está el restaurante?','where''s the restaurant?','aud504','imagenhotel'); ");
            base.execSQL("INSERT INTO FRASES VALUES (4,5,'¿podría llamar a un taxi, por favor?','could you please call me a taxi?','aud505','imagenhotel'); ");
            base.execSQL("INSERT INTO FRASES VALUES (5,5,'no hay agua caliente','there isn''t any hot water','aud506','imagenhotel'); ");
            base.execSQL("INSERT INTO FRASES VALUES (6,5,'he perdido la llave de mi habitación','I''ve lost my room key','aud507','imagenhotel'); ");

            //Area Trabajo
            base.execSQL("INSERT INTO FRASES VALUES (0,6,'¿cuánto tiempo has trabajado aquí?','how long have you worked here?','aud601','imagentra'); ");
            base.execSQL("INSERT INTO FRASES VALUES (1,6,'voy a salir a almorzar','I''m going out for lunch','aud602','imagentra'); ");
            base.execSQL("INSERT INTO FRASES VALUES (2,6,'¿cómo vas a trabajar?','how do you get to work?','aud603','imagentra'); ");
            base.execSQL("INSERT INTO FRASES VALUES (3,6,'¡estás despedido!','you''re fired!','aud604','imagentra'); ");
            base.execSQL("INSERT INTO FRASES VALUES (4,6,'¿necesitas alguna ayuda?','do you need any help?','aud605','imagentra'); ");
            base.execSQL("INSERT INTO FRASES VALUES (5,6,'hay un problema con mi ordenador','there''s a problem with my computer','aud606','imagentra'); ");

            //Area Compras
            base.execSQL("INSERT INTO FRASES VALUES (0,7,'¿en qué horario están abiertos?','what times are you open?','aud701','imagencom'); ");
            base.execSQL("INSERT INTO FRASES VALUES (1,7,'¿a qué hora cierran?','what time do you close?','aud702','imagencom'); ");
            base.execSQL("INSERT INTO FRASES VALUES (2,7,'¿cuánto por esto?','how much is this?','aud703','imagencom'); ");
            base.execSQL("INSERT INTO FRASES VALUES (3,7,'¿puedo ayudarte?','Can i hepl you?','aud704','imagencom'); ");
            base.execSQL("INSERT INTO FRASES VALUES (4,7,'Estoy buscando el shampoo','I''m looking for the shampoo','aud705','imagencom'); ");
            base.execSQL("INSERT INTO FRASES VALUES (5,7,'¿tiene algo un poco más barato?','have you got anything cheaper?','aud706','imagencom'); ");

            //Area Ocio
            base.execSQL("INSERT INTO FRASES VALUES (0,8,'¿dónde está el cine?','where''s the cinema?','aud801','imagenocio'); ");
            base.execSQL("INSERT INTO FRASES VALUES (1,8,'¿quieres salir fuera esta noche?','do you want to go out tonight?','aud802','imagenocio'); ");
            base.execSQL("INSERT INTO FRASES VALUES (2,8,'¿vamos a dar una vuelta?','shall we go for a walk?','aud803','imagenocio'); ");
            base.execSQL("INSERT INTO FRASES VALUES (3,8,'¿donde esta el estadio?','where''s the stadium?','aud804','imagenocio'); ");
            base.execSQL("INSERT INTO FRASES VALUES (4,8,'Vamos al cine','let''s go to the cinema','aud805','imagenocio'); ");
            base.execSQL("INSERT INTO FRASES VALUES (5,8,'¿hay algo bueno?','is there anything good on?','aud806','imagenocio'); ");

        }

        @Override
        public void onUpgrade(SQLiteDatabase base, int oldVersion, int newVersion) {

        }
    }