package common.generator;

import net.datafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class BaseGenerator {
    public static final Faker FAKER = new Faker(Locale.forLanguageTag("ru"));

    public static final Random RANDOM = new Random();
}
