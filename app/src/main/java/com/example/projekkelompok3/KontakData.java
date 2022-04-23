package com.example.projekkelompok3;

import java.util.ArrayList;

public class KontakData {
    public static String[][] data = new String[][]{
            {"Dwi Hasan", "https://randomuser.me/api/portraits/men/1.jpg"},
            {"Sarah Julianti", "https://randomuser.me/api/portraits/women/1.jpg"},
            {"Ilham Burhanudin", "https://randomuser.me/api/portraits/men/2.jpg"},
            {"Viana Afifah", "https://randomuser.me/api/portraits/women/2.jpg"},
            {"Rizki Atmajaya", "https://randomuser.me/api/portraits/men/3.jpg"},
            {"Namira Gunawan", "https://randomuser.me/api/portraits/women/3.jpg"},

    };
    public static ArrayList<Kontak> getListData(){
        Kontak contact = null;
        ArrayList<Kontak> list = new ArrayList<>();
        for (int i = 0; i <data.length; i++){
            contact = new Kontak();
            contact.setNama(data[i][0]);
            contact.setFoto(data[i][1]);
            list.add(contact);
            }
        return list;
        }
}


