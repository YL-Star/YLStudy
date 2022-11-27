自定义注解+反射 实现intent数据传递。自动获取参数值。

1.RUNTIME


#元注解#
在定义注解时，注解类也能够使用其他的注解声明。对注解类型进行注解的注解类，我们称之为 meta�annotation（元注解）。一般的，我们在定义自定义注解时，需要指定的元注解有两个 ：
package java.lang.annotation;
public interface Annotation {
boolean equals(Object obj);
int hashCode();
String toString();
Class<? extends Annotation> annotationType();
}
public @interface Lance{
}
另外还有@Documented 与 @Inherited 元注解，前者用于被javadoc工具提取成文档，后者表示允许子类
继承父类中定义的注解。
@Target
注解标记另一个注解，以限制可以应用注解的 Java 元素类型。目标注解指定以下元素类型之一作为其值：
ElementType.ANNOTATION_TYPE 可以应用于注解类型。
ElementType.CONSTRUCTOR 可以应用于构造函数。
ElementType.FIELD 可以应用于字段或属性。
ElementType.LOCAL_VARIABLE 可以应用于局部变量。
ElementType.METHOD 可以应用于方法级注解。
ElementType.PACKAGE 可以应用于包声明。
ElementType.PARAMETER 可以应用于方法的参数。
ElementType.TYPE 可以应用于类的任何元素。
@Retention
注解指定标记注解的存储方式：
RetentionPolicy.SOURCE - 标记的注解仅保留在源级别中，并被编译器忽略。
RetentionPolicy.CLASS - 标记的注解在编译时由编译器保留，但 Java 虚拟机(JVM)会忽略。
RetentionPolicy.RUNTIME - 标记的注解由 JVM 保留，因此运行时环境可以使用它。
@Retention 三个值中 SOURCE < CLASS < RUNTIME，即CLASS包含了SOURCE，RUNTIME包含SOURCE、
CLASS。下文会介绍他们不同的应用场景。
下面来看例子：
注解类型元素
在上文元注解中，允许在使用注解时传递参数。我们也能让自定义注解的主体包含 annotation type element (注解
类型元素) 声明，它们看起来很像方法，可以定义可选的默认值。
注意：在使用注解时，如果定义的注解中的类型元素无默认值，则必须进行传值。
//@Target(ElementType.TYPE) 只能在类上标记该注解
@Target({ElementType.TYPE,ElementType.FIELD}) // 允许在类与类属性上标记该注解
@Retention(RetentionPolicy.SOURCE) //注解保留在源码中
public @interface Lance {
}