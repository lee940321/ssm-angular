app.factory('weatherService', ['$http', '$q', function($http, $q) {
	
	var weatherApiUrl = 'http://api.map.baidu.com/telematics/v3/weather';
    return {
    	//访问百度api查询天气预报
    	searchWeather:function(city){
    		var deferred = $q.defer();
    		$http({
    			url: weatherApiUrl,
    			method: 'jsonp',
    			params: {
    				location: city,
    				output: 'json',
    				ak: '0A5bc3c4fb543c8f9bc54b77bc155724',
    				callback: 'JSON_CALLBACK'
    			}
    		}).success(function(data, status) {
				deferred.resolve(data);
			}).error(function(data, status) {
				deferred.reject(null);
			});
    		return deferred.promise;
    	},
    	//根据天气情况获取图标
    	getWeatherIcon:function(weather){
    		var icon = "";
    		var hour = new Date().getHours();
    		if(weather.indexOf("晴")>=0){
    			if(hour>=6 && hour<18)
    				icon = "clear-day";
    			else
    				icon = "clear-night";
    			return icon;
    		}else if(weather.indexOf("雨")>=0){
    			if(weather.indexOf("雨夹雪")>=0 || weather.indexOf("冰雹")>=0 || weather.indexOf("冻雨")>=0)
    				icon = "sleet";
    			else
    				icon = "rain";
    			return icon;
    		}else if(weather.indexOf("多云")>=0 || weather.indexOf("阴")>=0){
    			if(hour>=6 && hour<18)
    				icon = "partly-cloudy-day";
    			else
    				icon = "partly-cloudy-night";
    			return icon;
    		}else if(weather.indexOf("雾")>=0){
    			icon = "fog";
    			return icon;
    		}else{
    			return icon;
    		}
    	}
    }
  }
]);





