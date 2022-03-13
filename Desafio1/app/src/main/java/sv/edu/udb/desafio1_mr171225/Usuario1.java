package sv.edu.udb.desafio1_mr171225;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Usuario1 {
    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd="BDDesafio1";
    String tabla="create table if not exists usuario (id integer primary key autoincrement, usuario text, contra text, nombre text, apellido text)";

    public Usuario1 (Context c){
        this.c=c;
        sql= c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u=new  Usuario();

    }

    public boolean insertarUsuario (Usuario u){

            ContentValues cv=new ContentValues();
            cv.put("usuario" , u.getUsuario());
            cv.put("contra", u.getContraseña());
            cv.put("nombre", u.getNombre());
            cv.put("apellido", u.getApellidos());
            return (sql.insert("usuario", null, cv)>0);

        }

        public ArrayList<Usuario>selectUsuarios(){
        ArrayList<Usuario>lista=new ArrayList<Usuario>();
        lista.clear();
        Cursor cr=sql.rawQuery("select * from usuario", null);
        if (cr!=null &&cr.moveToFirst()){
            do{
                Usuario u=new Usuario();
                u.setId(cr.getInt(0));
                u.setUsuario(cr.getString(1));
                u.setContraseña(cr.getString(2));
                u.setNombre(cr.getString(3));
                u.setApellidos(cr.getString(4));
                lista.add(u);
            }while (cr.moveToNext());
        }
        return lista;
    }

        public int login (String u, String p){
        int a=0;
            Cursor cr=sql.rawQuery("select * from usuario", null);
            if (cr!=null&&cr.moveToFirst()){
                do {
                    if (cr.getString(1).equals(u) && cr.getString(2).equals(p)){
                        a++;
                    }
                }while (cr.moveToNext());
            }
            return a;
        }

        public Usuario getUsuario (String u, String p){
        lista=selectUsuarios();
        for (Usuario us:lista){
            if (us.getUsuario().equals(u)&&us.getContraseña().equals(p)){
                return us;
            }
        }
        return null;
        }

        public Usuario getUsuarioById(int id){
        lista=selectUsuarios();
        for (Usuario us:lista){
            if (us.getId()==id){
                return us;
            }
        }
        return null;
        }

    }

