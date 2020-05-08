package com.endava.soa.utils;

import com.endava.soa.constant.ScenarioKey;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static final ScenarioContext INSTANCE = new ScenarioContext();
    private Map<ScenarioKey, Object> context;

    private ScenarioContext() {
        this.context = new HashMap<>();
    }

    public static ScenarioContext getScenarioInstance() {
        return INSTANCE;
    }

    public void saveData(ScenarioKey key, Object object) {
        this.context.put(key, object);
    }

    public Object getData(ScenarioKey key) {
        return context.get(key);
    }
}
