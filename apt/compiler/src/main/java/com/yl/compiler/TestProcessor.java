//package com.yl.compiler;
//
//import com.google.auto.service.AutoService;
//import com.squareup.javapoet.JavaFile;
//import com.squareup.javapoet.MethodSpec;
//import com.squareup.javapoet.TypeSpec;
//
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
////----@AutoService(Process.class)//启用服务 --------写错了  很郁闷的。。。。。。。。。。。。。。。。
//@AutoService(Processor.class)//启用服务 ------对的。
//@SupportedAnnotationTypes({"com.yl.annotation.arouter.ARouter"})//注解
//@SupportedSourceVersion(SourceVersion.RELEASE_8)//环境版本
//@SupportedOptions({"packageNameForAPT"})//android app gradle 传递过来的参数。
//public class TestProcessor extends AbstractProcessor {
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
//        // 说明：使用javapoet生成的类文件：
//        //package com.yl.test;
//        //
//        //import java.lang.System;
//        //
//        //public final class Test {
//        //  public static void main(System[] args) {
//        //    System.out.println("hello word !");
//        //  }
//        //}
//        // 1.方法
//        MethodSpec methodSpec = MethodSpec
//                .methodBuilder("main")
//                .addParameter(System[].class, "args")
//                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
////                ----.addStatement("$T.out.println($s)", System.class, "hello word !")容易错的位置。。
//                .addStatement("$T.out.println($S)", System.class, "hello word !")
////                ----.returns(Void.class) 容易错的位置。。。
//                .returns(void.class)
//                .build();
//        // 2.类
//        TypeSpec typeSpec = TypeSpec
//                .classBuilder("Test")
//                .addMethod(methodSpec)
//                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
//                .build();
//        // 3.包
//        JavaFile javaFile = JavaFile.builder("com.yl.test", typeSpec).build();
//        try {
////            // 查看路径 app/build/generated/source/kapt/debug/
//            javaFile.writeTo(filer);
//        } catch (Exception e) {
//            e.printStackTrace();
//            messager.printMessage(Diagnostic.Kind.NOTE, "tag->>>>>>>>>>>>文件生产失败>>>>>>>>>>>>>>>>>");
//        }
//        return false;
//    }
//
//}
