package ru.vitaSoft.service;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("sv")
public class VitaService {

    //Ввести N строк. Упорядочить и вывести строки в порядке возрастания значений их длины.
    // В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке
    public List<String> getMessages(List<String> list) {

        Collections.sort(list);
        list.sort((String s1, String s2) -> s1.length() - s2.length());

        List<String> resultList = new ArrayList<>();
        for (String value : list) {
            resultList.add(value.length() + ":" + value);
        }

        return resultList;
    }

    //Ввести число от 1 до 12. Вернуть строку с названием месяца.
    //Осуществить проверку корректности ввода числа.
    public String getMonth(int month) {

        switch (month) {
            case 1:
                return "Я-Н-В-А-Р-Ь";
            case 2:
                return "Ф-Е-В-Р-А-Л-Ь";
            case 3:
                return "М-А-Р-Т";
            case 4:
                return "А-П-Р-Е-Л-Ь";
            case 5:
                return "М-А-Й";
            case 6:
                return "И-Ю-Н-Ь";
            case 7:
                return "И-Ю-Л-Ь";
            case 8:
                return "А-В-Г-У-С-Т";
            case 9:
                return "С-Е-Н-Т-Я-Б-Р-Ь";
            case 10:
                return "О-К-Т-Я-Б-Р-Ь";
            case 11:
                return "Н-О-Я-Б-Р-Ь";
            case 12:
                return "Д-Е-К-А-Б-Р-Ь";

        }

        return "NCORRECT INPUT DATA";
    }
}
