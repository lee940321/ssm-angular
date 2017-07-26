package app.map.services.impl;

import com.alibaba.fastjson.JSONObject;

import app.map.services.MapService;

public class MapServiceImpl implements MapService{

	@Override
	public JSONObject getCityByIP(String ip){
		//调用淘宝IP库API
		String url = "http://ip.taobao.com/service/getIpInfo.php?ip="+ip;
//		 HttpClient client = new HttpClient(new HttpClientParams(),new SimpleHttpConnectionManager(true));
//	     client.getHttpConnectionManager().getParams().setConnectionTimeout(15000); // 通过网络与服务器建立连接的超时时间
//	     client.getHttpConnectionManager().getParams().setSoTimeout(60000); // Socket读数据的超时时间，即从服务器获取响应数据需要等待的时间
//	     GetMethod method = new GetMethod(url);
//	     method.setRequestHeader("Content-Type", "text/html;charset=UTF-8"); // 防止乱码
//	     client.executeMethod(method);
//	     String jsonString = method.getResponseBodyAsString();
		return null;
	}
}
