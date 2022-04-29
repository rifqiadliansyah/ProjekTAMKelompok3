package com.example.projekkelompok3.MakananSehatPKG;

public class MakananItem {

    private String linkGambar;
    private String namaMakanan;
    private String idMakanan;
    public MakananItem(String linkGambar, String namaMakanan, String idMakanan) {
        this.linkGambar = linkGambar;
        this.namaMakanan = namaMakanan;
        this.idMakanan = idMakanan;
    }

    public String getIdMakanan() {
        return idMakanan;
    }

    public void setIdMakanan(String idMakanan) {
        this.idMakanan = idMakanan;
    }

    public String getLinkGambar() {
        return linkGambar;
    }

    public void setLinkGambar(String linkGambar) {
        this.linkGambar = linkGambar;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }


}
