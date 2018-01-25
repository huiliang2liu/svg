package com.xh.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * ���������� author:xh email:825378291@qq.com time��2017-1-23 ����09:33:48
 * 
 */
public class MethodManager extends XHReflect {
	/**
	 * ��ȡ���й������� author:xh email:825378291@qq.com time:2017-1-23 ����09:36:24
	 * 
	 * @param cl
	 * @return
	 */
	public static Method[] public_methods(Class cl) {
		if (cl == null)
			return null;
		return cl.getMethods();
	}

	/**
	 * ��ȡ�������� author:xh email:825378291@qq.com time:2017-1-23 ����09:39:35
	 * 
	 * @param cl
	 * @param name
	 * @param parameterTypes
	 * @return
	 */
	public static Method public_method(Class cl, String name,
			Class... parameterTypes) {
		if (cl == null || name == null || name.isEmpty())
			return null;
		try {
			cl.getMethod(name, parameterTypes);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * ��ȡָ�����ֵĹ������� author:xh email:825378291@qq.com time:2017-1-23 ����11:17:44
	 * 
	 * @param cl
	 * @param name
	 * @return
	 */
	public static Method[] public_method(Class cl, String name) {
		if (cl == null || name == null || name.isEmpty())
			return null;
		Method methods[] = public_methods(cl);
		if (methods == null || methods.length == 0)
			return null;
		List<Method> list = new ArrayList<Method>();
		for (Method method : methods) {
			if (method.getName().equals(name))
				list.add(method);
		}
		return list.toArray(new Method[list.size()]);
	}

	/**
	 * ��ȡ���з��� author:xh email:825378291@qq.com time:2017-1-23 ����09:37:55
	 * 
	 * @param cl
	 * @return
	 */
	public static Method[] methods(Class cl) {
		if (cl == null)
			return null;
		return cl.getDeclaredMethods();
	}

	/**
	 * ��ȡ��ָ�����ֵ����з��� author:xh email:825378291@qq.com time:2017-1-23 ����11:20:31
	 * 
	 * @param cl
	 * @param name
	 * @return
	 */
	public static Method[] methods(Class cl, String name) {
		if (cl == null || name == null || name.isEmpty())
			return null;
		Method methods[] = methods(cl);
		if (methods == null || methods.length == 0)
			return null;
		List<Method> list = new ArrayList<Method>();
		for (Method method : methods) {
			if (method.getName().equals(name))
				list.add(method);
		}
		return list.toArray(new Method[list.size()]);
	}

	/**
	 * ��ȡ���� author:xh email:825378291@qq.com time:2017-1-23 ����09:40:50
	 * 
	 * @param cl
	 * @param name
	 * @param parameterTypes
	 * @return
	 */
	public static Method method(Class cl, String name, Class... parameterTypes) {
		if (cl == null || name == null || name.isEmpty())
			return null;
		try {
			return cl.getDeclaredMethod(name, parameterTypes);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * ��ȡ���е�ע�� author:xh email:825378291@qq.com time:2017-1-23 ����09:48:56
	 * 
	 * @param method
	 * @return
	 */
	public static Annotation[] annotations(Method method) {
		if (method == null)
			return null;
		return method.getDeclaredAnnotations();
	}

	/**
	 * ��ȡָ����ע�� author:xh email:825378291@qq.com time:2017-1-23 ����09:51:50
	 * 
	 * @param method
	 * @param cl
	 * @return
	 */
	public static Annotation annotation(Method method,
			Class<? extends Annotation> cl) {
		if (method == null || cl == null || !method.isAnnotationPresent(cl))
			return null;
		return method.getAnnotation(cl);
	}

	/**
	 * ִ�з��� author:xh email:825378291@qq.com time:2017-1-23 ����10:10:06
	 * 
	 * @param method
	 * @param object
	 * @param objects
	 * @return
	 */
	public static Object invoke(Method method, Object object, Object[] objects) {
		if (method == null)
			return null;
		try {
			if (!method.isAccessible())
				method.setAccessible(true);
			return method.invoke(object, objects);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * ��ȡ�������� author:xh email:825378291@qq.com time:2017-1-23 ����11:23:59
	 * 
	 * @param method
	 * @return
	 */
	public static Class[] parameter_types(Method method) {
		if (method == null)
			return null;
		return method.getParameterTypes();
	}
}
