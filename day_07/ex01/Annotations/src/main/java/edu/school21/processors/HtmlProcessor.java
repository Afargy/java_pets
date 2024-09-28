package edu.school21.processors;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.Element;

import com.google.auto.service.AutoService;

import edu.school21.annotations.HtmlForm;
import edu.school21.annotations.HtmlInput;

@SupportedAnnotationTypes("edu.school21.annotations.HtmlForm")
@AutoService(Processor.class)
public class HtmlProcessor extends AbstractProcessor {
    private String outDir = "target/classes/";

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv) {

        for (Element elem : roundEnv.getElementsAnnotatedWith(HtmlForm.class)) {
            StringBuilder output = new StringBuilder();
            HtmlForm htmlForm = elem.getAnnotation(HtmlForm.class);

            outDir += htmlForm.fileName();

            output.append("<form action = \"").append(htmlForm.action())
                    .append("\" method = \"").append(htmlForm.method())
                    .append("\">\n");

            for (Element field : elem.getEnclosedElements()) {
                HtmlInput htmlInput = field.getAnnotation(HtmlInput.class);

                if (htmlInput != null) {
                    output.append("\t<input type = \"").append(htmlInput.type())
                            .append("\" name = \"").append(htmlInput.name())
                            .append("\" placeholder = \"")
                            .append(htmlInput.placeholder()).append("\">\n");
                }
            }

            output.append("</form>");

            new Writer().writeToFile(outDir, output.toString());
        }

        return false;
    }
}
