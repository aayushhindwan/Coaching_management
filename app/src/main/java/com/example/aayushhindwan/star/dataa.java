package com.example.aayushhindwan.star;

public class dataa {
    float star;
    String nm;
    String tm;
    String ro;

    public dataa(float star,String ro,String tm,String nm)
    {
        this.star=star;
        this.ro=ro;
        this.tm=tm;
        this.nm=nm;
    }

    public float getStar()
    {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public String getNm() {
        return nm;
    }

    public String getTm() {
        return tm;
    }

    public String getRo() {
        return ro;
    }

    public dataa() {
    }
}
