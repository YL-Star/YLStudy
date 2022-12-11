//package com.yl.compiler;
//
//import com.google.auto.service.AutoService;
//import com.squareup.javapoet.ClassName;
//import com.squareup.javapoet.JavaFile;
//import com.squareup.javapoet.MethodSpec;
//import com.squareup.javapoet.TypeSpec;
//import com.yl.annotation.arouter.ARouter;
//
//import java.io.IOException;
//import java.util.Set;
//
//import javax.annotation.processing.AbstractProcessor;
//import javax.annotation.processing.Filer;
//import javax.annotation.processing.Messager;
//import javax.annotation.processing.ProcessingEnvironment;
//import javax.annotation.processing.Processor;
//import javax.annotation.processing.RoundEnvironment;
//import javax.annotation.processing.SupportedAnnotationTypes;
//import javax.annotation.processing.SupportedOptions;
//import javax.annotation.processing.SupportedSourceVersion;
//import javax.lang.model.SourceVersion;
//import javax.lang.model.element.Element;
//import javax.lang.model.element.Modifier;
//import javax.lang.model.element.TypeElement;
//import javax.lang.model.util.Elements;
//import javax.lang.model.util.Types;
//import javax.tools.Diagnostic;
//
///**
// * @date: $ $
// * @author: yanglei
// * @description
// */
//@AutoService(Processor.class)//启用服务
//@SupportedAnnotationTypes({"com.yl.annotation.arouter.ARouter"})//注解
//@SupportedSourceVersion(SourceVersion.RELEASE_8)//环境版本
//@SupportedOptions({"packageNameForAPT"})//android app gradle 传递过来的参数。
//public class ArouterTestProcessor extends AbstractProcessor {
//
//    /**
//     * 操作element的工具类。类、函数、属性
//     */
//    private Elements elementUtils;
//    /**
//     * 用来打印日志，
//     */
//    private Messager messager;
//    /**
//     * 文件生产器
//     */
//    private Filer filer;
//    /**
//     * 类信息的工具
//     */
//    private Types typeUtils;
//
//    @Override
//    public synchronized void init(ProcessingEnvironment processingEnv) {
//        super.init(processingEnv);
//        elementUtils = processingEnv.getElementUtils();
//        messager = processingEnv.getMessager();
//        filer = processingEnv.getFiler();
//        typeUtils = processingEnv.getTypeUtils();
//        messager.printMessage(Diagnostic.Kind.NOTE, "tag-======================================= init ====================");
//        String packageNameForAPT = processingEnv.getOptions().get("packageNameForAPT");
//        messager.printMessage(Diagnostic.Kind.NOTE, "tag->>>>>>>>>>>>>>>>>>>>>packageNameForAPT = >>>>>>>>>>>" + packageNameForAPT);
//
//    }
//
//    /**
//     * @param annotations
//     * @param roundEnv
//     * @return
//     */
//    @Override
//    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//        messager.printMessage(Diagnostic.Kind.NOTE, "tag->>>>>>>>>>>>>>>>>>>>> process >>>>>>>>>>>");
//        if (annotations.isEmpty()) {
//            return false;
//        }
//
//        Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(ARouter.class);
//        for (Element element : elementsAnnotatedWith) {
//            String path = element.getAnnotation(ARouter.class).path();
//            String className = element.getSimpleName().toString();
//            messager.printMessage(Diagnostic.Kind.NOTE, "tag-=======================被ARouter注解的类：" + className);
//            MethodSpec methodSpec = MethodSpec
//                    .methodBuilder("getClass")
//                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
//                    .addParameter(String.class, "path")
//                    .addStatement("return path.equals($S) ? $T.class : null", path, ClassName.get((TypeElement) element))
//                    .returns(Class.class)
//                    .build();
//            TypeSpec typeSpec = TypeSpec
//                    .classBuilder(className + "Processor")
//                    .addMethod(methodSpec)
//                    .addModifiers(Modifier.PUBLIC)
//                    .build();
//            JavaFile javaFile = JavaFile.builder("com.yl.processor",typeSpec).build();
//            try {
//                javaFile.writeTo(filer);
//            } catch (IOException e) {
//                e.printStackTrace();
//                messager.printMessage(Diagnostic.Kind.NOTE, "tag->>>>>>>>>>>>文件生产失败>>>>>>>>>>>>>>>>>");
//            }
//        }
//        return true;
//    }
//
//}
