package ru.vitaSoft.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    //Ввести N строк. Упорядочить и вывести строки в порядке возрастания значений их длины.
    // В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке
    @PostMapping("json")
    public List<String> getMessages(@RequestBody List<String> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j).length() == list.get(j + 1).length()) {
                    Collections.sort(list);
                    break;
                }
            }
        }
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j).length() > list.get(j + 1).length()) {
                    String tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }

        List<String> resultList = new ArrayList<>();
        for (String value : list) {
            resultList.add(value.length() + ":" + value);
        }

        return resultList;
    }

    //Ввести число от 1 до 12. Вернуть строку с названием месяца.
    //Осуществить проверку корректности ввода числа.
    @GetMapping("month")
    public String getMonth(@RequestParam int month) {

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
