package com.xh.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * �ֶι����� author:xh email:825378291@qq.com time��2017-1-22 ����10:25:23
 * 
 */
public class FieldManager extends XHReflect {
	/**
	 * ��ȡ���� author:xh email:825378291@qq.com time:2017-1-22 ����10:28:48
	 * 
	 * @param cl
	 * @param name
	 * @return
	 */
	public static Field field(Class cl, String name) {
		if (cl == null || name == null || name.isEmpty())
			return null;
		try {
			Field field = cl.getDeclaredField(name);
			field.setAccessible(true);
			return field;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * ��ȡ�������� author:xh email:825378291@qq.com time:2017-1-22 ����10:32:40
	 * 
	 * @param cl
	 * @param name
	 * @return
	 */
	public static Field public_field(Class cl, String name) {
		if (cl == null || name == null || name.isEmpty())
			return null;
		try {
			return cl.getField(name);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * ��ȡ���еı��� author:xh email:825378291@qq.com time:2017-1-22 ����10:36:40
	 * 
	 * @param cl
	 * @return
	 */
	public static Field[] fields(Class cl) {
		if (cl == null)
			return null;
		try {
			return cl.getDeclaredFields();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * ��ȡ���еĹ������� author:xh email:825378291@qq.com time:2017-1-22 ����10:37:41
	 * 
	 * @param cl
	 * @return
	 */
	public static Field[] public_fields(Class cl) {
		if (cl == null)
			return null;
		try {
			return cl.getFields();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * ��ȡָ�����η��ı��� author:xh email:825378291@qq.com time:2017-1-22 ����10:42:52
	 * 
	 * @param cl
	 * @param modifier
	 * @return
	 */
	public static Field[] modifier_fields(Class cl, int modifier) {
		if (cl == null)
			return null;
		Field[] fields = fields(cl);
		if (fields == null || fields.length == 0 || modifier == 0)
			return null;
		List<Field> list = new ArrayList<Field>();
		for (Field field : fields) {
			if ((field.getModifiers() & modifier) != 0)
				list.add(field);
		}
		return list.toArray(new Field[list.size()]);
	}

	/**
	 * ��ȡָ�����η��ı��� author:xh email:825378291@qq.com time:2017-1-22 ����10:42:52
	 * 
	 * @param cl
	 * @param modifier
	 * @return
	 */
	public static Field[] modifier_fields(Class cl, Type modifier) {
		if (modifier == null)
			return null;
		return modifier_fields(cl, modifier.get_type());
	}

	/**
	 * ��ȡָ�����η�����ı��� author:xh email:825378291@qq.com time:2017-1-22 ����10:46:51
	 * 
	 * @param cl
	 * @param modifier
	 * @return
	 */
	public static Field[] no_modifier_fields(Class cl, int modifier) {
		if (cl == null)
			return null;
		Field[] fields = fields(cl);
		if (fields == null || fields.length == 0 || modifier == 0)
			return null;
		List<Field> list = new ArrayList<Field>();
		for (Field field : fields) {
			if ((field.getModifiers() & modifier) != 0)
				continue;
			list.add(field);
		}
		return list.toArray(new Field[list.size()]);
	}

	/**
	 * ��ȡָ�����η�����ı��� author:xh email:825378291@qq.com time:2017-1-22 ����10:46:51
	 * 
	 * @param cl
	 * @param modifier
	 * @return
	 */
	public static Field[] no_modifier_fields(Class cl, Type modifier) {
		if (modifier == null)
			return null;
		return no_modifier_fields(cl, modifier.get_type());
	}

	/**
	 * ���ñ�����ֵ author:xh email:825378291@qq.com time:2017-1-22 ����10:51:50
	 * 
	 * @param object
	 * @param field
	 * @param value
	 * @return
	 */
	public static boolean set_field(Object object, Field field, Object value) {
		if (field == null || is_final(field.getModifiers()))
			return false;
		try {
			if (!field.isAccessible())
				field.setAccessible(true);
			field.set(object, value);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	/**
	 * ��ȡ������ֵ author:xh email:825378291@qq.com time:2017-1-22 ����10:54:05
	 * 
	 * @param object
	 * @param field
	 * @return
	 */
	public static Object get_field(Object object, Field field) {
		if (field == null)
			return null;
		try {
			if (!field.isAccessible())
				field.setAccessible(true);
			return field.get(object);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * ��ȡ������ author:xh email:825378291@qq.com time:2017-1-22 ����10:55:39
	 * 
	 * @param field
	 * @return
	 */
	public static String name(Field field) {
		if (field == null)
			return "";
		return field.getName();
	}

	/**
	 * ��ȡ��������Ӧ������ author:xh email:825378291@qq.com time:2017-1-22 ����11:26:31
	 * 
	 * @param field
	 * @return
	 */
	public static Class field_class(Field field) {
		if (field == null)
			return null;
		return field.getType();
	}

	/**
	 * ��ȡ���е�ע�� author:xh email:825378291@qq.com time:2017-1-22 ����11:28:14
	 * 
	 * @param field
	 * @return
	 */
	public static Annotation[] annotations(Field field) {
		if (field == null)
			return null;
		return field.getAnnotations();
	}

	/**
	 * ��ȡ��Ӧע�� author:xh email:825378291@qq.com time:2017-1-22 ����11:30:01
	 * 
	 * @param field
	 * @param acl
	 * @return
	 */
	public static Annotation annotation(Field field,
			Class<? extends Annotation> acl) {
		if (field == null || acl == null || !field.isAnnotationPresent(acl))
			return null;
		return field.getAnnotation(acl);
	}

	/**
	 * ��ȡ�������ݷ��� author:xh email:825378291@qq.com time:2017-1-22 ����11:31:33
	 * 
	 * @param field
	 * @return
	 */
	public static java.lang.reflect.Type[] generics_super(Field field) {
		return ClassManager.generics_super(field_class(field));
	}

	/**
	 * ��ȡ�������ݷ��� author:xh email:825378291@qq.com time:2017-1-22 ����11:32:33
	 * 
	 * @param field
	 * @return
	 */
	public static Class generic_super(Field field) {
		return ClassManager.generic_super(field_class(field));
	}

	/**
	 * ��ȡ���ݷ��� author:xh email:825378291@qq.com time:2017-1-22 ����04:51:49
	 * 
	 * @param field
	 * @return
	 */
	public static Class[] generics(Field field) {
		if (field == null)
			return null;
		String[] types = field.getGenericType().toString().split("<");
		if (types.length == 1)
			return null;
		String ss = types[1].split(">")[0];
		String t[] = ss.split(",");
		Class[] cs = new Class[t.length];
		for (int i = 0; i < cs.length; i++) {
			try {
				cs[i] = Class.forName(t[i].trim());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cs;
	}

	/**
	 * ��ȡ���ݷ��� author:xh email:825378291@qq.com time:2017-1-22 ����04:53:25
	 * 
	 * @param field
	 * @return
	 */
	public static Class generic(Field field) {
		Class[] cs = generics(field);
		if (cs == null || cs.length == 0)
			return null;
		return cs[0];
	}
}
