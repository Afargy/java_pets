package edu.school21.spring.implementations.renderer;

import edu.school21.spring.services.preprocesor.PreProcessor;
import edu.school21.spring.services.renderer.Renderer;

public class RendererStandardImpl implements Renderer {
    private PreProcessor preprocessor;

    public RendererStandardImpl(PreProcessor preprocessor) {
        this.preprocessor = preprocessor;
    }

    @Override
    public void sendToConsole(String message) {
        System.out.println(preprocessor.preprocess(message));
    }
}
