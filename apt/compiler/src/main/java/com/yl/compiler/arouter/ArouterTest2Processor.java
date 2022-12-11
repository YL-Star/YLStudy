//package com.yl.compiler.arouter;
//
//import com.google.auto.service.AutoService;
//import com.yl.annotation.arouter.ARouter;
//
//import java.io.IOException;
//import java.io.Writer;
//import java.util.Map;
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
//import javax.lang.model.element.TypeElement;
//import javax.lang.model.util.Elements;
//import javax.lang.model.util.Types;
//import javax.tools.Diagnostic;
//import javax.tools.JavaFileObject;
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
//public class ArouterTest2Processor extends AbstractProcessor {
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
//    private Map<String, String> options;
//
//
//    @Override
//    public synchronized void init(ProcessingEnvironment processingEnv) {
//        super.init(processingEnv);
//        elementUtils = processingEnv.getElementUtils();
//        messager = processingEnv.getMessager();
//        filer = processingEnv.getFiler();
//        typeUtils = processingEnv.getTypeUtils();
//        messager.printMessage(Diagnostic.Kind.NOTE, "tag-======================================= init ====================");
//        options = processingEnv.getOptions();
//        String packageNameForAPT = (String) options.get("packageNameForAPT");
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
//        Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(ARouter.class);
//
//
//        Writer writer = null;
//        try {
//            String moduleName = options.get("moduleName");
//            String className = "ARouterPathImpl" + moduleName;
//            String packageName = options.get("packageNameForAPT");
//            JavaFileObject javaFileObject = processingEnv.getFiler().createSourceFile("com.yl." + moduleName + ".arouter.impl." + className);
//            writer = javaFileObject.openWriter();
//            writer.write("package com.yl.arouter.impl;\n\n");
//            writer.write("import com.yl.annotation.arouter.ARouterBean;\n");
//            writer.write("import com.yl.arouter_api.IARouterPath;\n");
//            // *********难点：提前不知道哪些Activity.class需要导包,多级目录的问题*************
//            writer.write("import " + packageName + ".*;\n");
//            writer.write("import java.util.HashMap;\n");
//            writer.write("import java.util.Map;\n\n");
//            writer.write(String.format("public class %s implements IARouterPath {\n", className));
//            writer.write("  private final Map<String, ARouterBean> map = new HashMap<>();\n");
//            writer.write("\n");
//            writer.write("      @Override\n");
//            writer.write("      public Map<String, ARouterBean> getPathMap() {\n");
//            for (Element element : elementsAnnotatedWith) {
//                //获取被注解类的类名
//                String className_ = element.getSimpleName().toString();
//                // 获取注解、获取注解上的参数
//                ARouter aRouter = element.getAnnotation(ARouter.class);
//                String path = aRouter.path();
//                String group = aRouter.group();
//                writer.write("          ARouterBean aRouterBean"+className_+" = new ARouterBean(ARouterBean.TypeEnum.ACTIVITY, " + className_ + ".class, \"" + path + "\", \"" + group + "\");\n");
//                writer.write("          map.put(\"" + path + "\", aRouterBean"+className_+");\n");
//            }
//            writer.write("          return map;\n");
//            writer.write("      }\n");
//            writer.write("}\n");
//            writer.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//            messager.printMessage(Diagnostic.Kind.NOTE, e.toString());
//        } finally {
//            try {
//                if (writer != null) writer.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        return true;
//    }
//
//}
