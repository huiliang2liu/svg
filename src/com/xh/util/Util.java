package com.xh.util;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Matrix;
import android.graphics.Path;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

/**
 * 系統常用类
 * 
 */
public class Util {

	/**
	 * 提示
	 * 
	 * @param context
	 *            上下文
	 * @param text
	 *            提示内容
	 * @param duration
	 *            显示时常
	 */
	public static void toast(Context context, String text, int duration) {
		if (context == null)
			return;
		if (text == null)
			return;
		if (duration < Toast.LENGTH_SHORT)
			duration = Toast.LENGTH_SHORT;
		else if (duration > Toast.LENGTH_SHORT)
			duration = Toast.LENGTH_LONG;
		Toast.makeText(context, text, duration).show();
	}

	/**
	 * /** 获取布局
	 * 
	 * @param context上下文
	 * @param layout_id
	 *            布局id
	 * @return
	 */
	public static View get_view(Context context, int layout_id) {
		return View.inflate(context, layout_id, null);
	}

	/**
	 * 启动一个服务
	 * 
	 * @param context
	 * @param service
	 */
	public static void start_service(Context context, String service_name,
			String action) {
		if (context == null || (service_name == null && action == null))
			return;
		Intent service = new Intent();
		if (service_name != null)
			service.setClassName(context, service_name);
		if (action != null)
			service.setAction(action);
		context.startService(service);
	}

	/**
	 * 启动一个服务
	 * 
	 * @param context
	 * @param service
	 */
	public static void start_service(Context context, String service_name) {
		start_service(context, service_name, null);
	}

	/**
	 * 启动一个服务
	 * 
	 * @param context
	 * @param service
	 */
	public static void start_service_action(Context context, String action) {
		start_service(context, null, action);
	}

	/**
	 * 启动一个服务
	 * 
	 * @param context
	 * @param service
	 */
	public static void bind_service_action(Context context, String action,
			String service_name, ServiceConnection conn) {
		if (context == null || (action == null && service_name == null))
			return;
		Intent service = new Intent();
		if (action != null)
			service.setAction(action);
		if (service_name != null)
			service.setClassName(context, service_name);
		context.bindService(service, conn, Service.BIND_AUTO_CREATE);
	}

	/**
	 * 启动一个服务
	 * 
	 * @param context
	 * @param service
	 */
	public static void bind_service_action(Context context, String action,
			ServiceConnection conn) {
		bind_service_action(context, action, null, conn);
	}

	/**
	 * 启动一个服务
	 * 
	 * @param context
	 * @param service
	 */
	public static void bind_service(Context context, String service_name,
			ServiceConnection conn) {
		bind_service_action(context, null, service_name, conn);
	}

	/**
	 * 停止一个服务
	 * 
	 * @param context
	 * @param action
	 */
	public static void stop_service(Context context, String service_name,
			String action) {
		if (context == null || (service_name == null && action == null))
			return;
		Intent service = new Intent();
		if (service_name != null)
			service.setClassName(context, service_name);
		if (action != null)
			service.setAction(action);
		context.stopService(service);
	}

	/**
	 * 停止一个服务
	 * 
	 * @param context
	 * @param action
	 */
	public static void stop_service_action(Context context, String action) {
		stop_service(context, null, action);
	}

	/**
	 * 停止一个服务
	 * 
	 * @param context
	 * @param action
	 */
	public static void stop_service(Context context, String service_name) {
		stop_service(context, service_name, null);
	}

	/**
	 * 停止一个服务
	 * 
	 * @param context
	 * @param service
	 */
	public static void unbind_service_action(Context context,
			ServiceConnection conn) {
		if (context == null)
			return;
		context.unbindService(conn);
	}

	/**
	 * 发送广播
	 * 
	 * @param context
	 * @param action
	 * @param params
	 */
	private static void send_broadcast(Context context, String action,
			String broadcast_name, Map<String, Serializable> params) {
		if (context == null || (action == null && broadcast_name == null))
			return;
		Intent intent = new Intent();
		if (action != null)
			intent.setAction(action);
		if (broadcast_name != null)
			intent.setClassName(context, broadcast_name);
		if (params != null && params.size() > 0) {
			Set<Entry<String, Serializable>> set = params.entrySet();
			Iterator<Entry<String, Serializable>> iterable = set.iterator();
			while (iterable.hasNext()) {
				Entry<String, Serializable> entry = iterable.next();
				intent.putExtra(entry.getKey(), entry.getValue());
			}
		}
		context.sendBroadcast(intent);
	}

	/**
	 * 发送广播
	 * 
	 * @param context
	 * @param action
	 * @param params
	 */
	private static void send_ordered_broadcast(Context context, String action,
			String broadcast_name, Map<String, Serializable> params,
			String receiverPermission) {
		if (context == null || (action == null && broadcast_name == null))
			return;
		Intent intent = new Intent();
		if (action != null)
			intent.setAction(action);
		if (broadcast_name != null)
			intent.setClassName(context, broadcast_name);
		if (params != null && params.size() > 0) {
			Set<Entry<String, Serializable>> set = params.entrySet();
			Iterator<Entry<String, Serializable>> iterable = set.iterator();
			while (iterable.hasNext()) {
				Entry<String, Serializable> entry = iterable.next();
				intent.putExtra(entry.getKey(), entry.getValue());
			}
		}
		context.sendOrderedBroadcast(intent, receiverPermission);
	}

	/**
	 * 发送广播
	 * 
	 * @param context
	 * @param action
	 * @param params
	 */
	public static void send_broadcast(Context context, String action,
			Map<String, Serializable> params) {
		send_broadcast(context, action, null, params);
	}

	/**
	 * 发送广播
	 * 
	 * @param context
	 * @param action
	 * @param params
	 */
	public static void send_ordered_broadcast(Context context, String action,
			Map<String, Serializable> params) {
		send_ordered_broadcast(context, action, null, params, null);
	}

	/**
	 * 发送广播
	 * 
	 * @param context
	 * @param action
	 * @param params
	 */
	public static void send_ordered_broadcast(Context context, String action,
			Map<String, Serializable> params, String receiverPermission) {
		send_ordered_broadcast(context, action, null, params,
				receiverPermission);
	}

	/**
	 * 注册广播
	 * 
	 * @param context
	 * @param receiver
	 * @param filter
	 * @param broadcastPermission
	 * @param scheduler
	 */
	public static void register_broadcast(Context context,
			BroadcastReceiver receiver, IntentFilter filter,
			String broadcastPermission, Handler scheduler) {
		if (context == null || filter == null || filter.countActions() == 0)
			return;
		context.registerReceiver(receiver, filter, broadcastPermission,
				scheduler);
	}

	/**
	 * 注册广播
	 * 
	 * @param context
	 * @param receiver
	 * @param actions
	 * @param priority
	 * @param receiver_permissions
	 * @param scheduler
	 */
	public static void register_broadcast(Context context,
			BroadcastReceiver receiver, List<String> actions, int priority,
			String receiver_permissions, Handler scheduler) {
		if (actions == null || actions.size() == 0 || receiver == null)
			return;
		IntentFilter filter = new IntentFilter();
		if (priority < 0)
			priority = 0;
		else if (priority > 1000)
			priority = 1000;
		filter.setPriority(priority);
		for (String action : actions) {
			filter.addAction(action);
		}
		register_broadcast(context, receiver, filter, receiver_permissions,
				scheduler);
	}

	/**
	 * 
	 * lhl 2017-12-28 上午11:47:27 说明：注册广播
	 * 
	 * @param context
	 * @param receiver
	 * @param actions
	 *            void
	 */
	public static void register_broadcast(Context context,
			BroadcastReceiver receiver, List<String> actions) {
		register_broadcast(context, receiver, actions, 500, null, null);
	}

	/**
	 * 注销广播
	 * 
	 * @param receiver
	 * @param actions
	 */
	public static void un_register_broadcast(Context context,
			BroadcastReceiver receiver) {
		if (context != null && receiver != null)
			context.unregisterReceiver(receiver);

	}

	/**
	 * 终结广播
	 * 
	 * @param broadcastReceiver
	 */
	public static void end_broadcast(BroadcastReceiver broadcastReceiver) {
		broadcastReceiver.abortBroadcast();
	}

	/**
	 * 
	 * lhl 2018-1-8 下午6:43:36 说明：path变化
	 * 
	 * @param path
	 * @param factor
	 * @return Path
	 */
	public static Path factorPath(Path path, float factor) {
		Matrix matrix = new Matrix();
		matrix.setValues(new float[] { 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f,
				0.0f, 0.0f, 1.0f });
		matrix.postScale(factor, factor);
		Path path1 = new Path();
		path1.addPath(path, matrix);
		return path1;
	}
}
