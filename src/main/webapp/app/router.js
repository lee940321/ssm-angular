'use strict';

app
.run( function ($rootScope,   $state,   $stateParams) {
          $rootScope.$state = $state;
          $rootScope.$stateParams = $stateParams;        
      }
  )
.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) {
	  $urlRouterProvider.otherwise('/login');
	  
	  $stateProvider
		  .state('login', {
				url: "/login",
				templateUrl: "app/views/login/login.html",
				resolve: {
					deps: ['$ocLazyLoad',function ($ocLazyLoad) {
						return $ocLazyLoad.load(['app/js/login/loginCtrl.js','app/js/login/service/loginService.js']);
					}]
				}
			})
	      .state('app', {
	          abstract: true,
	          url: '/app',
	          templateUrl: 'app/views/home/home.html',
//	          resolve: {
//					deps: ['$ocLazyLoad',function ($ocLazyLoad) {
//						return $ocLazyLoad.load(['app/js/home/homeCtrl.js','app/js/home/service/homeService.js']);
//					}]
//	          }
	      })
	      .state('app.test', {
	          url: '/test',
	          templateUrl: 'app/views/test/test.html',
	      })
	      //Others
	      .state('app.weather', {
              url: '/weather',
              templateUrl: 'app/views/apps/weather/weather.html',
              resolve: {
                  deps: ['$ocLazyLoad',
                    function( $ocLazyLoad ){
                      return $ocLazyLoad.load(
                          {
                              name: 'angular-skycons',
                              files: ['resources/js/modules/angular-skycons/skycons.js',
                                      'resources/js/util/moment.min.js', 
                                      'resources/js/modules/angular-skycons/angular-skycons.js',
                                      'app/js/apps/weather/weatherCtrl.js',
                                      'app/js/apps/weather/service/weatherService.js'] 
                          }
                      );
                  }]
              }
          })
}]);