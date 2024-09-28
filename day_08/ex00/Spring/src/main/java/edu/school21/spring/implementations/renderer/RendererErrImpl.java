package edu.school21.spring.implementations.renderer;

import edu.school21.spring.services.preprocesor.PreProcessor;
import edu.school21.spring.services.renderer.Renderer;

public class RendererErrImpl implements Renderer {
    private PreProcessor preprocessor;

    public RendererErrImpl(PreProcessor preprocessor) {
        this.preprocessor = preprocessor;
    }

    @Override
    public void sendToConsole(String message) {
        System.err.println(preprocessor.preprocess(message));
    }
}
