package com.endava.soa.constant;

public enum Messages {
    MAX_UPDATE_EMAIL_ERROR("Превышено максимальное кол-во запросов кода для данного пользователя"),
    UPDATE_WRONG_PHONE_NUMBER_ERROR("недействительный номер телефона"),
    UPDATE_EXISTING_PHONE_NUMBER_ERROR("Это ваш номер? Подтвердите его."),
    SUCCESS_UPDATE("СОХРАНЕНО");
    private String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
