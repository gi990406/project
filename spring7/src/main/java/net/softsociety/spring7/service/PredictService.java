package net.softsociety.spring7.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.softsociety.spring7.domain.Iris;

import java.util.Map;

public interface PredictService {
    public Map<String, Object> predict(Iris iris) throws JsonProcessingException;
}
