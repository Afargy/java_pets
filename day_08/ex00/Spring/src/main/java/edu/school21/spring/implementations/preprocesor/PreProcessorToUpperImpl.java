package edu.school21.spring.implementations.preprocesor;

import edu.school21.spring.services.preprocesor.PreProcessor;

public class PreProcessorToUpperImpl implements PreProcessor {
    @Override
    public String preprocess(String message) {
        return message.toUpperCase();
    }
}
