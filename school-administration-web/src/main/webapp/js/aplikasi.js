angular.module('belajar', ['ui', 'belajar.controller'])
    .config(['$routeProvider', function($routeProvider){
        $routeProvider
            .when('/', {templateUrl: 'pages/home.html'})
            .when('/401', {templateUrl: 'pages/404.html', controller: 'LoginRedirectorController'})
            .when('/system/config', {templateUrl: 'pages/system/config.html', controller: 'ApplicationConfigController'})
            .when('/system/sessions', {templateUrl: 'pages/system/sessions.html', controller: 'ApplicationSessionsController'})
            .when('/system/user', {templateUrl: 'pages/system/user.html', controller: 'UserController'})
            .when('/system/role', {templateUrl: 'pages/system/role.html', controller: 'RoleController'})
            .when('/system/permission', {templateUrl: 'pages/system/permission.html', controller: 'PermissionController'})
            .when('/system/menu', {templateUrl: 'pages/system/menu.html', controller: 'SystemMenuController'})
            .when('/notifications/sms', {templateUrl: 'pages/notifications/sms.html'})
            .when('/notifications/email', {templateUrl: 'pages/notifications/email.html'})
            .when('/list/student', {templateUrl: 'pages/list/student.html'})
            .when('/notifications/email', {templateUrl: 'pages/notifications/email.html'})
            .when('/master/student', {templateUrl: 'pages/master/student.html', controller: 'StudentController'})
            .when('/report/student', {templateUrl: 'pages/report/student.html', controller: 'StudentController'})
            .when('/master/teacher', {templateUrl: 'pages/master/teacher.html'})
            .when('/report/teacher', {templateUrl: 'pages/report/teacher.html'})
            .when('/master/class', {templateUrl: 'pages/master/class.html'})
            .when('/report/class', {templateUrl: 'pages/report/class.html'})
            .when('/master/ekskul', {templateUrl: 'pages/master/ekskul.html'})
            .when('/report/ekskul', {templateUrl: 'pages/report/ekskul.html'})
            .when('/master/competency', {templateUrl: 'pages/master/competency.html'})
            .when('/master/value', {templateUrl: 'pages/master/value.html'})
            .when('/report/competency', {templateUrl: 'pages/report/competency.html'})
            .when('/master/lesson', {templateUrl: 'pages/master/lesson.html'})
            .when('/report/lesson', {templateUrl: 'pages/report/lesson.html'})
			.when('/master/job', {templateUrl: 'pages/master/job.html'})
            .when('/master/school', {templateUrl: 'pages/master/school.html', controller: 'SchoolController'})
            .when('/report/school', {templateUrl: 'pages/report/school.html', controller: 'SchoolController'})
            .when('/about', {templateUrl: 'pages/about.html', controller: 'AboutController'})
            .otherwise({templateUrl: 'pages/404.html'});
    }])
    .config(['$httpProvider', function($httpProvider){
        var sessionTimeoutInterceptor = ['$rootScope', '$location', '$q', function($rootScope, $location, $q){
            function success(response){
                return response;
            }
            
            function error(response){
                if (response.status === 401) {
                    $location.path('/401');
                }
            }
            
            return function(promise) {
                return promise.then(success, error);
            }
        }];
        
        
        $httpProvider.responseInterceptors.push(sessionTimeoutInterceptor);
        $httpProvider.responseInterceptors.push('httpLoadingSpinner');
        var spinnerFunction = function (data, headersGetter) {
            $('#loading').show();
            return data;
        };
        $httpProvider.defaults.transformRequest.push(spinnerFunction);
    }])
    .factory('httpLoadingSpinner', function ($q, $window) {
        return function (promise) {
            return promise.then(function (response) {
                // do something on success
                $('#loading').hide();
                return response;

            }, function (response) {
                // do something on error
                $('#loading').hide();
                return $q.reject(response);
            });
        };
    })
;
