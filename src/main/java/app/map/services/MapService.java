package app.map.services;

import com.alibaba.fastjson.JSONObject;

public interface MapService {

	JSONObject getCityByIP(String ip);
}
