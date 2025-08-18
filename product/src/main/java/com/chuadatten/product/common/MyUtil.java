package com.chuadatten.product.common;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

public class MyUtil {
    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    private MyUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static String toSlug(String input) {
        if (input == null)
            return null;

        // Bỏ dấu tiếng Việt → Unicode Normalizer
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);

        // Remove ký tự không phải chữ/số
        String slug = NONLATIN.matcher(normalized).replaceAll("");

        // Viết thường và trim dấu "-"
        slug = slug.toLowerCase(Locale.ENGLISH);
        slug = slug.replaceAll("-{2,}", "-"); // bỏ double dấu '-'
        slug = slug.replaceAll("^-|-$", ""); // bỏ '-' đầu/cuối

        return slug;
    }
}
