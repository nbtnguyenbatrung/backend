package com.HUCE.miniblogs.search;

import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.QueryBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.StringTokenizer;

public class HibernateSearchUtil {

    public static final String REGEX = "[^a-zA-Z0-9_/-]";
    public static final String SPACE = " ";
    public static final String MORE_SPACE = "\\s+";
    private static final String WILDCARD = "*";

    public static String removeSpecialCharacter(String title) {
        title = title.replaceAll(REGEX, SPACE);

        title = title.replaceAll(MORE_SPACE, SPACE);

        return title.trim();
    }

    public static BooleanJunction<BooleanJunction> buildBooleanJunctionSearch(QueryBuilder qb,
                                                                              String searchtitle,
                                                                              String ... onFields) {
        BooleanJunction<BooleanJunction> booleanJunction = qb.bool();

        String name = removeSpecialCharacter(searchtitle);

        StringTokenizer st = new StringTokenizer(name, SPACE);

        booleanJunction.should(qb.keyword()
                .onFields(onFields)
                .ignoreFieldBridge()
                .matching(searchtitle.toLowerCase(Locale.US))
                .createQuery());


        while(st.hasMoreElements()) {
            String keyword = st.nextElement().toString();

            if (keyword.length() >= 3) {
                booleanJunction.should(qb.keyword().wildcard()
                        .onFields(onFields)
                        .ignoreFieldBridge()
                        .matching(WILDCARD + keyword.toLowerCase(Locale.US) + WILDCARD)
                        .createQuery());
            }
        }


        return booleanJunction;
    }

    public static String decodeUrl(String name) {
        try {
            return URLDecoder.decode(name, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return name;
    }

}
