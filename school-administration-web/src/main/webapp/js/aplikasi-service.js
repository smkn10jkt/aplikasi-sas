angular.module('belajar.service', ['ngResource'])
    .factory('ApplicationConfigService', ['$resource', '$http', function($resource, $http){
        var service = {
            applicationConfig: $resource('config/:configId'),
            get: function(param, callback){
                return this.applicationConfig.get(param, callback)
            }, 
            query: function(){
                return this.applicationConfig.query()
            },
            save: function(obj){
                if(obj.id == null){
                    return $http.post('config', obj);
                } else {
                    return $http.put('config/'+obj.id, obj);
                }
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('config/'+obj.id);
                }
            }
        };
            
        return service;
    }])
    .factory('ApplicationSessionsService', ['$http', function($http){
        var service = {
            list: function(){ 
                return $http.get('homepage/sessioninfo');
            }, 
            kick: function(user){
                return $http.delete('homepage/kick/'+user.sessionid);
            }
        };
            
        return service;
    }])
    .factory('SystemMenuService', ['$resource', '$http', function($resource, $http){
        var service = {
            menu: $resource('menu/:id', {}, {
                queryPage: {
                    method:'GET', 
                    isArray: false
                }
            }),
            get: function(param, callback){
                return this.menu.get(param, callback)
            }, 
            query: function(p, callback){
                return this.menu.queryPage({
                    "page.page": p, 
                    "page.size": 10
                }, callback)
            },
            save: function(obj){
                if(obj.id == null){
                    return $http.post('menu', obj);
                } else {
                    return $http.put('menu/'+obj.id, obj);
                }
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('menu/'+obj.id);
                }
            }
        };
            
        return service;
    }])
    .factory('PermissionService', ['$resource', '$http', function($resource, $http){
        var service = {
            permission: $resource('permission/:id'),
            get: function(param, callback){
                return this.permission.get(param, callback)
            }, 
            query: function(){
                return this.permission.query()
            },
            save: function(obj){
                if(obj.id == null){
                    return $http.post('permission', obj);
                } else {
                    return $http.put('permission/'+obj.id, obj);
                }
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('permission/'+obj.id);
                }
            }
        };
            
        return service;
    }])
    .factory('RoleService', ['$resource', '$http', function($resource, $http){
        var service = {
            role: $resource('role/:id'),
            get: function(param, callback){
                return this.role.get(param, callback)
            }, 
            query: function(){
                return this.role.query()
            },
            save: function(obj){
                if(obj.id == null){
                    return $http.post('role', obj);
                } else {
                    return $http.put('role/'+obj.id, obj);
                }
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('role/'+obj.id);
                }
            },
            unselectedPermission: function(obj){
                return $http.get('role/'+obj.id+'/unselected-permission');
            },
            unselectedMenu: function(obj){
                return $http.get('role/'+obj.id+'/unselected-menu');
            }
        };
            
        return service;
    }])
    .factory('UserService', ['$resource', '$http', function($resource, $http){
        var service = {
            user: $resource('user/:id'),
            get: function(param, callback){
                return this.user.get(param, callback)
            }, 
            query: function(){
                return this.user.query()
            },
            save: function(obj){
                if(obj.id == null){
                    return $http.post('user', obj);
                } else {
                    return $http.put('user/'+obj.id, obj);
                }
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('user/'+obj.id);
                }
            }
        };
            
        return service;
    }])
    
    .factory('SchoolService', ['$resource', '$http', function($resource, $http){
        var service = {
            school: $resource('master/school/:id', {}, {
                queryPage: {
                    method:'GET', 
                    isArray: false
                }
            }),
            get: function(param, callback){
                return this.school.get(param, callback)
            }, 
            query: function(p, callback){
                return this.school.queryPage({
                    "page.page": p, 
                    "page.size": 10
                }, callback)
            },
            save: function(obj){
                return $http.post('master/school', obj);
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('master/school/'+obj.id);
                }
            }
        };
            
        return service;
    }])
    
    .factory('StudentService', ['$resource', '$http', function($resource, $http){
        var service = {
            student: $resource('master/student/:id', {}, {
                queryPage: {
                    method:'GET', 
                    isArray: false
                }
            }),
            get: function(param, callback){
                return this.student.get(param, callback)
            }, 
            query: function(p, callback){
                return this.student.queryPage({
                    "page.page": p, 
                    "page.size": 10
                }, callback)
            },
            save: function(obj){
                return $http.post('master/student', obj);
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('master/student/'+obj.id);
                }
            }
        };
            
        return service;
    }])
    
    .factory('TeacherService', ['$resource', '$http', function($resource, $http){
        var service = {
            teacher: $resource('master/teacher/:id', {}, {
                queryPage: {
                    method:'GET', 
                    isArray: false
                }
            }),
            get: function(param, callback){
                return this.teacher.get(param, callback)
            }, 
            query: function(p, callback){
                return this.teacher.queryPage({
                    "page.page": p, 
                    "page.size": 10
                }, callback)
            },
            save: function(obj){
                return $http.post('master/teacher', obj);
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('master/teacher/'+obj.id);
                }
            }
        };
            
        return service;
    }]) 
    
    .factory('MajorService', ['$resource', '$http', function($resource, $http){
        var service = {
            major: $resource('master/major/:id', {}, {
                queryPage: {
                    method:'GET', 
                    isArray: false
                }
            }),
            get: function(param, callback){
                return this.major.get(param, callback)
            }, 
            query: function(p, callback){
                return this.major.queryPage({
                    "page.page": p, 
                    "page.size": 10
                }, callback)
            },
            save: function(obj){
                return $http.post('master/major', obj);
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('master/major/'+obj.id);
                }
            }
        };
            
        return service;
    }]) 
    
    .factory('KelasService', ['$resource', '$http', function($resource, $http){
        var service = {
            kelas: $resource('master/class/:id', {}, {
                queryPage: {
                    method:'GET', 
                    isArray: false
                }
            }),
            get: function(param, callback){
                return this.kelas.get(param, callback)
            }, 
            query: function(p, callback){
                return this.kelas.queryPage({
                    "page.page": p, 
                    "page.size": 10
                }, callback)
            },
            save: function(obj){
                return $http.post('master/class', obj);
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('master/class/'+obj.id);
                }
            }
        };
            
        return service;
    }])
.factory('LessonService', ['$resource', '$http', function($resource, $http){
        var service = {
            lesson: $resource('master/lesson/:id', {}, {
                queryPage: {method:'GET', isArray: false}
            }),
            get: function(param, callback){ return this.lesson.get(param, callback) }, 
            query: function(p, callback){ return this.lesson.queryPage({"page.page": p, "page.size": 10}, callback) },
            save: function(obj){
                    return $http.post('master/lesson', obj);
            }, 
            remove: function(obj){
                if(obj.id != null){
                    return $http.delete('master/lesson/'+obj.id);
                }
            }
        };
            
        return service;
    }])

;