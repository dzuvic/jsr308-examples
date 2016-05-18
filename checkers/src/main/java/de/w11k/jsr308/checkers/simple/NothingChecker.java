package de.w11k.jsr308.checkers.simple;


import com.sun.source.util.JavacTask;
import com.sun.source.util.TaskEvent;
import com.sun.source.util.TaskListener;
import com.sun.tools.javac.comp.CompileStates;
import com.sun.tools.javac.main.JavaCompiler;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.util.Context;


import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;
import java.util.*;

/**
 * Copyright 2016 Dragan Zuvic
 */
public class NothingChecker extends AbstractProcessor {

    private List<Name> elements = new ArrayList<>();

    public NothingChecker() {
        super();
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        JavacTask.instance(processingEnv).addTaskListener(new SimpleTaskListner(processingEnv));
        Context ctx = ((JavacProcessingEnvironment) processingEnv).getContext();
        JavaCompiler compiler = JavaCompiler.instance(ctx);
        compiler.shouldStopPolicyIfNoError = CompileStates.CompileState.max(compiler.shouldStopPolicyIfNoError,
                                                           CompileStates.CompileState.FLOW);
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return new HashSet<>(Arrays.asList(
                Simple.class.getName()
        ));
    }

    @Override
    public Set<String> getSupportedOptions() {
        return  Collections.emptySet();
    }

    /*
    For TYPE_USE and TYPE_PARAM this is not called...
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Process: " + roundEnv.processingOver());

        for (TypeElement elem : ElementFilter.typesIn(roundEnv.getRootElements())) elements.add(elem.getQualifiedName());

        return true;
    }
}

class SimpleTaskListner implements TaskListener {

    final ProcessingEnvironment processingEnvironment;

    SimpleTaskListner(ProcessingEnvironment processingEnvironment) {
        this.processingEnvironment = processingEnvironment;
    }


    @Override
    public void started(TaskEvent taskEvent) {
    }

    @Override
    public void finished(TaskEvent taskEvent) {

    }
}
