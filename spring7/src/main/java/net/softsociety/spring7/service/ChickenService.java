package net.softsociety.spring7.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.softsociety.spring7.domain.Chicken;

import java.util.Map;

public interface ChickenService {
    public Map<String, Object> chicken(Chicken chicken) throws JsonProcessingException;
}
