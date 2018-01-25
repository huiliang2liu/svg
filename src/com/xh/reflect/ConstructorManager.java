package com.xh.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

/**
 * ���췽��������
 * author:xh 
 * email:825378291@qq.com
 * time��2017-1-23 ����10:21:09
 *
 */
@SuppressWarnings("unchecked")
public class ConstructorManager extends XHReflect {
	/**
	 * ��ȡ���еĹ��췽��
	 * author:xh
	 * email:825378291@qq.com
	 * time:2017-1-23 ����10:25:38
	 * @param <T>
	 * @param cl
	 * @return
	 */
public static <T> Constructor<T>[] public_constructors(Class<T> cl){
	if(cl==null)
	return null;
	return (Constructor<T>[]) cl.getConstructors();
}
/**
 * ��ȡָ�������Ĺ��췽��
 * author:xh
 * email:825378291@qq.com
 * time:2017-1-23 ����10:27:48
 * @param <T>
 * @param cl
 * @param classes
 * @return
 */
public static <T> Constructor<T> public_constructor(Class<T> cl,Class...classes){
	if(cl==null)
		return null;
try {
	return cl.getConstructor(classes);
} catch (Exception e) {
	// TODO: handle exception
}
return null;
}
/**
 * ��ȡ���еĹ��ŷ���
 * author:xh
 * email:825378291@qq.com
 * time:2017-1-23 ����10:32:14
 * @param <T>
 * @param cl
 * @return
 */
public static <T> Constructor<T>[] constructors(Class<T> cl){
	if(cl==null)
		return null;
	return (Constructor<T>[]) cl.getDeclaredConstructors();
}
/**
 * ��ȡָ���Ĺ��췽��
 * author:xh
 * email:825378291@qq.com
 * time:2017-1-23 ����10:33:31
 * @param <T>
 * @param cl
 * @param classes
 * @return
 */
public static <T> Constructor<T> constructor(Class<T> cl,Class...classes){
	if(cl==null)
		return null;
	try {
		cl.getDeclaredConstructor(classes);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}
/**
 * ��ȡ���췽���ϵ�����ע��
 * author:xh
 * email:825378291@qq.com
 * time:2017-1-23 ����10:36:12
 * @param constructor
 * @return
 */
public static  Annotation[] annotations(Constructor constructor){
	return constructor.getDeclaredAnnotations();
}
/**
 * ��ȡ���췽����ָ����ע��
 * author:xh
 * email:825378291@qq.com
 * time:2017-1-23 ����10:37:55
 * @param constructor
 * @param cl
 * @return
 */
public static Annotation annotation(Constructor constructor ,Class<? extends Annotation> cl){
	if(constructor==null||cl==null||!constructor.isAnnotationPresent(cl))
		return null;
	return constructor.getAnnotation(cl);
}
/**
 * �������
 * author:xh
 * email:825378291@qq.com
 * time:2017-1-23 ����10:39:41
 * @param <T>
 * @param constructor
 * @param objects
 * @return
 */
public static <T> T newInstance(Constructor<T> constructor, Object[] objects){
	if(constructor==null)
		return null;
	try {
		return constructor.newInstance(objects);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}
}
