app.controller("weatherCtrl", ['$scope','$http', "weatherService",  function($scope, $http, weatherService) {
	 $scope.userSearchText = '';
	 $scope.place = '';
	 $scope.list = {};
	 
	// get locations
    $scope.getLocations = function () {
    	$scope.getWeather($scope.userSearchText);
    };
	
    // get weather
    $scope.getWeather = function(city){
    	weatherService.searchWeather(city).then(function(res){
    		if(res.status == "success" ){
    			$scope.place = city;
    			console.log($scope.place);
    			var forecast = new Array();
    			res.results[0].weather_data.forEach(function(i, v) {
    		          i.icon = weatherService.getWeatherIcon(i.weather);
    		          if(v>0){
    		        	  forecast.push(i);
    		          }
		        });
    			$scope.list = forecast;
    			//当日天气情况
    			$scope.todayWeather = res.results[0].weather_data[0];
    			$scope.todayWeather.city = res.results[0].currentCity;
    			$scope.todayWeather.today = res.date;
    			$scope.todayWeather.icon = weatherService.getWeatherIcon(res.results[0].weather_data[0].weather);
    		}else{
    			alert("输入信息有误！");
    		}
    	});
    }
}]);