app.controller('homeCtrl',['$scope','$sessionStorage','$state','$timeout','$interval','homeService',function($scope,$sessionStorage,$state,$timeout,$interval,homeService){
	
	
	$scope.user = $sessionStorage.user;
	
	//注销
	//此处修改，注销时，后台对应的session要清除
	$scope.logOut = function(){
		homeService.logOut().then(function(resp){
			$scope.user= null;
			$sessionStorage.user = null;
		});
		$state.go('login');
	}
	
	
}]);