package com.example.lenovo.placement_portal;

import android.widget.TextView;

public class Model {
   String  card1,card2;

    public String getCard1() {
        return card1;
    }

    public void setCard1(String card1) {
        this.card1 = card1;
    }

    public String getCard2() {
        return card2;
    }

    public void setCard2(String card2) {
        this.card2 = card2;
    }

    public Model(String card1, String card2) {
        this.card1 = card1;
        this.card2 = card2;
    }

    public Model(){

}


}
