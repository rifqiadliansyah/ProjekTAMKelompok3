package com.example.projekkelompok3;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.core.app.ActivityScenario;

import org.junit.Before;
import org.junit.Test;

public class HitungMineralTest {
    private final double dummyBerat = 50;
    private final double dummyJumlahAir = 2100;
    private final double dummyJumlahAirKurang = 1000;
    private final double dummyJumlahAirLebih = 3000;
    private final double hasilPerhitungan = 2100.0;
    private String dummyhasilSesuai =
            "Kadar minum anda sudah cukup, yaitu minimal "+hasilPerhitungan+" ml";
    private String dummyhasilTidakSesuai =
            "Kadar minum kurang, yaitu minimal "+hasilPerhitungan+" ml";


    @Before
    public void setup(){
        ActivityScenario.launch(HitungMineral.class);
    }

    @Test
    public void assertHasilKurang(){
        onView(withId(R.id.jumlahbbmineral)).perform(typeText(String.valueOf(dummyBerat)),
                closeSoftKeyboard());
        onView(withId(R.id.kadar)).perform(typeText(String.valueOf(dummyJumlahAirKurang)),
                closeSoftKeyboard());
        onView(withId(R.id.btnhitung)).check(matches(isDisplayed()));
        onView(withId(R.id.btnhitung)).perform(click());
        onView(withId(R.id.hasilmineral)).check(matches(isDisplayed()));
        onView(withId(R.id.hasilmineral)).check(matches(withText(String.valueOf(dummyhasilTidakSesuai))));
    }

    @Test
    public void assertHasilSama(){
        onView(withId(R.id.jumlahbbmineral)).perform(typeText(String.valueOf(dummyBerat)),
                closeSoftKeyboard());
        onView(withId(R.id.kadar)).perform(typeText(String.valueOf(dummyJumlahAir)),
                closeSoftKeyboard());
        onView(withId(R.id.btnhitung)).check(matches(isDisplayed()));
        onView(withId(R.id.btnhitung)).perform(click());
        onView(withId(R.id.hasilmineral)).check(matches(isDisplayed()));
        onView(withId(R.id.hasilmineral)).check(matches(withText(String.valueOf(dummyhasilSesuai))));

    }
    @Test
    public void assertHasilLebih(){
        onView(withId(R.id.jumlahbbmineral)).perform(typeText(String.valueOf(dummyBerat)),
                closeSoftKeyboard());
        onView(withId(R.id.kadar)).perform(typeText(String.valueOf(dummyJumlahAirLebih)),
                closeSoftKeyboard());
        onView(withId(R.id.btnhitung)).check(matches(isDisplayed()));
        onView(withId(R.id.btnhitung)).perform(click());
        onView(withId(R.id.hasilmineral)).check(matches(isDisplayed()));
        onView(withId(R.id.hasilmineral)).check(matches(withText(String.valueOf(dummyhasilSesuai))));
    }

}