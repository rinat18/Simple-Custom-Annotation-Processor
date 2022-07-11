package bean;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("bean.WritingStyle")
@SupportedSourceVersion(SourceVersion.RELEASE_15)
public class SimpleAnnotationProcessor extends AbstractProcessor {
    @Override
    public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv) {
        System.out.println("processor is executed");

        for (final Element element : roundEnv.getElementsAnnotatedWith(WritingStyle.class)) {
            String varName = element.getSimpleName().toString();
            if (!varName.startsWith("teacher")) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "variable name must start with teacher");
                return false;
            }
            System.out.println("elements" + element.getClass().getName());
        }
        return true;
    }
}

