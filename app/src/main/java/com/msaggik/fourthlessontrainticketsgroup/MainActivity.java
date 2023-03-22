package com.msaggik.fourthlessontrainticketsgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.msaggik.fourthlessontrainticketsgroup.model.RailwayTicket;
import com.msaggik.fourthlessontrainticketsgroup.model.RailwayTicketChild;
import com.msaggik.fourthlessontrainticketsgroup.model.RailwayTicketOld;

public class MainActivity extends AppCompatActivity {

    // создание объекта сущности взрослых билетов (стоимость билета, количество билетов)
    RailwayTicket railwayTicket = new RailwayTicket(70, 9);
    // создание объекта сущности детских билетов (стоимость билета, количество билетов, скидка)
    RailwayTicket railwayTicketChild = new RailwayTicketChild(70, 5, 50);
    RailwayTicket railwayTicketOld = new RailwayTicketOld(70, 11, 30);

    // создание полей для вывода на экран нужных значений
    private TextView railwayTicketOut; // поле вывода общей стоимости взрослых билетов
    private TextView railwayTicketOldOut; // для пенсионеров
    private TextView railwayTicketChildOut; // поле вывода общей стоимости детских билетов
    private TextView railwayTicketTotalOut; // поле вывода общей стоимости всех билетов

    // вывод на экран полученных значений
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        railwayTicketOut = findViewById(R.id.railwayTicketOut); // вывод информации стоимости всех взрослых билетов
        railwayTicketOldOut = findViewById(R.id.railwayTicketOldOut);
        railwayTicketChildOut = findViewById(R.id.railwayTicketChildOut); // вывод информации стоимости всех детских билетов
        railwayTicketTotalOut = findViewById(R.id.railwayTicketTotalOut); // вывод информации стоимости всех билетов

        // запонение экрана
        // 1) заполнение первого поля воспользовавшись методом подсчёта стоимости взрослых билетов ticketPriceAll()
        // С помощью метода Float.toString() мы конвертировали данные из типа float в String
        railwayTicketOut.setText(Float.toString(railwayTicket.ticketPriceAll()) + " монет");
        // 2) заполнение второго поля воспользовавшись переопределённым методом подсчёта стоимости детских билетов ticketPriceAll()
        railwayTicketOldOut.setText(Float.toString(railwayTicketOld.ticketPriceAll()) + " монет");
        railwayTicketChildOut.setText(Float.toString(railwayTicketChild.ticketPriceAll()) + " монет");
        // 3) заполнение третьего поля стоимостью всех билетов
        railwayTicketTotalOut.setText(Float.toString(railwayTicket.ticketPriceAll() + railwayTicketChild.ticketPriceAll()) + " монет");

    }
}