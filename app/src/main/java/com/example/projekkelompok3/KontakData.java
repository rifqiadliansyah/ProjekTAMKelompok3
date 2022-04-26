package com.example.projekkelompok3;

import java.util.ArrayList;

public class KontakData {
    public static String[] data = new String[]{"RS Mitra Keluarga","RS Siloam","RS Awal Bros",
                                                "RS Eka Hospital"};


    public static String[] dataTelepon = new String[]{"(021)8853333","(021)29962888","(0761)47333","(021)50855555"};



    public static String [] dataFoto = new String []{
            "https://media.suara.com/pictures/970x544/2021/11/01/13210-rs-mitra-keluarga.jpg",
            "https://images.bisnis-cdn.com/posts/2021/05/01/1388957/siloam-semanggi-1.jpg",
            "https://pasien.smarterhealth.id/wp-content/uploads/2019/09/awal-bros-makassar.jpg",
            "https://pasien.smarterhealth.id/wp-content/uploads/2020/11/Eka-Hospital.jpg"
    };
    public static ArrayList<Kontak> getListData(){

        ArrayList<Kontak> list = new ArrayList<>();
        for (int i = 0; i <data.length; i++){
            Kontak contact = new Kontak();
            contact.setNama(data[i]);
            contact.setFoto(dataFoto[i]);
            contact.setNumber(dataTelepon[i]);
            list.add(contact);
            }
        return list;
        }
}


