package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        var date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity() {
        String cities = "Майкоп, Горно-Алтайск, Уфа, Улан-Удэ, Махачкала, Магас, Нальчик, Элиста, Черкесск, Петрозаводск, Сыктывкар, Симферополь, Йошкар-Ола, Саранск, Якутск, Владикавказ, Казань, Кызыл, Ижевск, Абакан, Грозный, Чебоксары, Барнаул, Чита, Петропавловск-Камчатский, Краснодар, Красноярск, Пермь, Владивосток, Ставрополь, Хабаровск, Благовещенск, Архангельск, Астрахань, Белгород, Брянск, Владимир, Волгоград, Вологда, Воронеж, Мелитополь, Иваново, Иркутск, Калининград, Калуга, Кемерово, Киров, Кострома, Курган, Курск, Санкт-Петербург, Липецк, Магадан, Красногорск, Мурманск, Нижний Новгород, Великий Новгород, Новосибирск, Омск, Оренбург, Орёл, Пенза, Псков, Ростов-на-Дону, Рязань, Самара, Саратов, Южно-Сахалинск, Екатеринбург, Смоленск, Тамбов, Тверь, Томск, Тула, Тюмень, Ульяновск, Челябинск, Ярославль, Москва, Санкт-Петербург, Севастополь, Биробиджан, Нарьян-Мар, Ханты-Мансийск, Анадырь, Салехард";
        String[] ary = cities.split(", ");
        Random generator = new Random();
        int randomIndex = generator.nextInt(ary.length);
        return ary[randomIndex];
    }

    public static String generateName(String locate) {
        Faker faker = new Faker(new Locale("ru"));
        var name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        var phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }
        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(),generateName(locale),generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}