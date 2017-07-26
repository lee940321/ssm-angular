app.factory('globalService',['$http',function($http){
	
	
	return{
		
		logOut:function(){
			return $http.get('user/logOut.action');
		}
		
	}
	

}]);