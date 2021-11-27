package com.HUCE.miniblogs.validator;

import com.HUCE.miniblogs.exception.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class NewSearchValidator {

    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 100;

    private static final String TERM_INPUT_INVALID_MSG =
            "Title input is invalid. Please in put at least 3 normal characters";

    public void validateTermSearch(String title) {

        if (title.length() >= MIN_LENGTH && title.length() <= MAX_LENGTH) {
            return;
        }

        throw new BadRequestException(TERM_INPUT_INVALID_MSG);
    }

}
