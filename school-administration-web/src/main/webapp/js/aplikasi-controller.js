angular.module('belajar.controller',['belajar.service'])
    .controller('LoginRedirectorController', ['$window', function($window){
        $window.location = 'login.html';
    }])
    .controller('MenubarController', ['$http', '$scope', function($http, $scope){
        $scope.userinfo = {};
        $http.get('homepage/userinfo').success(function(data){
            $scope.userinfo = data;
        });
    }])
    .controller('AboutController', ['$http', '$scope', function($http, $scope){
        $scope.appinfo = {};
        $http.get('homepage/appinfo').success(function(data){
            $scope.appinfo = data;
        });
    }])
    .controller('ApplicationSessionsController', ['ApplicationSessionsService', '$scope', function(ApplicationSessionsService, $scope){
        $scope.refresh = function(){
            ApplicationSessionsService.list().success(function(data){
                $scope.sessioninfo = data
            });
        }
        
        $scope.refresh();
        
        $scope.kick = function(user){
            ApplicationSessionsService.kick(user).success($scope.refresh);
        };
        
    }])
    .controller('ApplicationConfigController', ['$scope', 'ApplicationConfigService', function($scope, ApplicationConfigService){
        $scope.configs = ApplicationConfigService.query();
        $scope.edit = function(x){
            if(x.id == null){
                return; 
            }
            $scope.currentConfig = ApplicationConfigService.get({configId: x.id}, function(data){
                $scope.original = angular.copy(data);
            });
        };
        $scope.baru = function(){
            $scope.currentConfig = null;
            $scope.original = null;
        }
        $scope.simpan = function(){
            ApplicationConfigService.save($scope.currentConfig)
            .success(function(){
                $scope.configs = ApplicationConfigService.query();
                $scope.baru();
            });
        }
        $scope.remove = function(x){
            if(x.id == null){
                return;
            }
            ApplicationConfigService.remove(x).success(function(){
                $scope.configs = ApplicationConfigService.query();
            });
        }
        $scope.isClean = function(){
            return angular.equals($scope.original, $scope.currentConfig);
        }
        $scope.isConfigNameAvailable = function(value){
            if($scope.currentConfig != null && $scope.currentConfig.id != null){
                return true;
            }
            for(var i = 0; i < $scope.configs.length; i++){
                var u = $scope.configs[i];
                if(u.name === value){
                    return false;
                }
            }
            return true;
        }
    }])
    .controller('SystemMenuController', ['$scope', 'SystemMenuService', function($scope, SystemMenuService){
        $scope.reloadMenupage = function(page){
            if(!page) {
                page = 0;
            }

            $scope.menupage = SystemMenuService.query(page, function(){
                $scope.pages = _.range(1, ($scope.menupage.totalPages+1));
            });
        }

        $scope.reloadMenupage(); 

        $scope.edit = function(x){
            if(x.id == null){
                return; 
            }
            $scope.currentMenu = SystemMenuService.get({id: x.id}, function(data){
                $scope.original = angular.copy(data);
            });
            
            $scope.parentSelection = _.filter($scope.menus, function(m){
                return m.id != x.id;
            });
        };
        $scope.baru = function(){
            $scope.currentMenu = null;
            $scope.original = null;
        }
        $scope.simpan = function(){
            SystemMenuService.save($scope.currentMenu)
            .success(function(){
                $scope.reloadMenupage();
                $scope.baru();
            });
        }
        $scope.remove = function(x){
            if(x.id == null){
                return;
            }
            SystemMenuService.remove(x).success(function(){
                $scope.reloadMenupage();
            });
        }
        $scope.isClean = function(){
            return angular.equals($scope.original, $scope.currentMenu);
        }
    }])
    .controller('PermissionController', ['$scope', 'PermissionService', function($scope, PermissionService){
        $scope.permissions = PermissionService.query();
        $scope.edit = function(x){
            if(x.id == null){
                return; 
            }
            $scope.currentPermission = PermissionService.get({id: x.id}, function(data){
                $scope.original = angular.copy(data);
            });
        };
        $scope.baru = function(){
            $scope.currentPermission = null;
            $scope.original = null;
        }
        $scope.simpan = function(){
            PermissionService.save($scope.currentPermission)
            .success(function(){
                $scope.permissions = PermissionService.query();
                $scope.baru();
            });
        }
        $scope.remove = function(x){
            if(x.id == null){
                return;
            }
            PermissionService.remove(x).success(function(){
                $scope.permissions = PermissionService.query();
            });
        }
        $scope.isClean = function(){
            return angular.equals($scope.original, $scope.currentPermission);
        }
        $scope.isPermissionValueAvailable = function(value){
            if($scope.currentPermission != null && $scope.currentPermission.id != null){
                return true;
            }
            for(var i = 0; i < $scope.permissions.length; i++){
                var u = $scope.permissions[i];
                if(u.value === value){
                    return false;
                }
            }
            return true;
        }
    }])
    .controller('RoleController', ['$scope', 'RoleService', function($scope, RoleService){
        $scope.roles = RoleService.query();
        
        $scope.unselectedPermission = [];
        $scope.unselectedMenu = [];
        
        $scope.selectedPermission = [];
        $scope.selectedMenu = [];
        
        $scope.edit = function(x){
            if(x.id == null){
                return; 
            }
            $scope.currentRole = RoleService.get({id: x.id}, function(data){
                $scope.original = angular.copy(data);
            });
            RoleService.unselectedPermission(x).success(function(data){
                $scope.unselectedPermission = data;
            });
            RoleService.unselectedMenu(x).success(function(data){
                $scope.unselectedMenu = data;
            });
        };
        $scope.baru = function(){
            $scope.currentRole = null;
            $scope.original = null;
        }
        $scope.simpan = function(){
            RoleService.save($scope.currentRole)
            .success(function(){
                $scope.roles = RoleService.query();
                $scope.baru();
            });
        }
        $scope.remove = function(x){
            if(x.id == null){
                return;
            }
            RoleService.remove(x).success(function(){
                $scope.roles = RoleService.query();
            });
        }
        
        
        $scope.isClean = function(){
            return angular.equals($scope.original, $scope.currentRole);
        }

        $scope.isRoleNameAvailable = function(value){
            if($scope.currentRole != null && $scope.currentRole.id != null){
                return true;
            }
            for(var i = 0; i < $scope.roles.length; i++){
                var u = $scope.roles[i];
                if(u.name === value){
                    return false;
                }
            }
            return true;
        }
        
        $scope.selectAllPermission = function($event){
            if($event.target.checked){
                for ( var i = 0; i < $scope.unselectedPermission.length; i++) {
                    var p = $scope.unselectedPermission[i];
                    if($scope.selectedPermission.indexOf(p.id) < 0){
                        $scope.selectedPermission.push(p.id);
                    }
                }
            } else {
                $scope.selectedPermission = [];
            }
        }
        
        $scope.updateSelectedPermission = function($event, id){
            var checkbox = $event.target;
            if(checkbox.checked  && $scope.selectedPermission.indexOf(id) < 0){
                $scope.selectedPermission.push(id);
            } else {
                $scope.selectedPermission.splice($scope.selectedPermission.indexOf(id), 1);
            }
        }
        
        $scope.isPermissionSelected = function(id){
            return $scope.selectedPermission.indexOf(id) >= 0;
        }

        $scope.isAllPermissionSelected = function(){
            return $scope.unselectedPermission.length === $scope.selectedPermission.length;
        }
        
        $scope.saveSelectedPermission = function(){
            console.log($scope.selectedPermission);
            for ( var i = 0; i < $scope.selectedPermission.length; i++) {
                var p = {id: $scope.selectedPermission[i]};
                $scope.currentRole.permissionSet.push(p);
            }
            RoleService.save($scope.currentRole)
            .success(function(){
                RoleService.unselectedPermission($scope.currentRole)
                .success(function(data){
                    $scope.unselectedPermission = data;
                    $scope.currentRole = RoleService.get({
                        id: $scope.currentRole.id
                    });
                });
            });
            $scope.showPermissionDialog = false;
        }
        
        $scope.cancelSelectedPermission = function(){
            $scope.selectedPermission = [];
            console.log($scope.selectedPermission);
            $scope.showPermissionDialog = false;
        }

        $scope.removeSelectedPermission = function(x){
            if(x.id == null){
                return;
            }
            var ixPermission = -1;
            for(var i = 0; i < $scope.currentRole.permissionSet.length; i++){
                if(x.id === $scope.currentRole.permissionSet[i].id){
                    ixPermission = i;
                    break;
                }
            }
            if(ixPermission >= 0){
                $scope.currentRole.permissionSet.splice(ixPermission, 1);
                RoleService.save($scope.currentRole)
                .success(function(){
                    RoleService.unselectedPermission($scope.currentRole)
                    .success(function(data){
                        $scope.unselectedPermission = data;
                        $scope.currentRole = RoleService.get({
                            id: $scope.currentRole.id
                        });
                    });
                });
            }
        }
        
        $scope.selectAllMenu = function($event){
            if($event.target.checked){
                for ( var i = 0; i < $scope.unselectedMenu.length; i++) {
                    var p = $scope.unselectedMenu[i];
                    if($scope.selectedMenu.indexOf(p.id) < 0){
                        $scope.selectedMenu.push(p.id);
                    }
                }
            } else {
                $scope.selectedMenu = [];
            }
        }
        
        $scope.updateSelectedMenu = function($event, id){
            var checkbox = $event.target;
            if(checkbox.checked  && $scope.selectedMenu.indexOf(id) < 0){
                $scope.selectedMenu.push(id);
            } else {
                $scope.selectedMenu.splice($scope.selectedMenu.indexOf(id), 1);
            }
        }
        
        $scope.isMenuSelected = function(id){
            return $scope.selectedMenu.indexOf(id) >= 0;
        }

        $scope.isAllMenuSelected = function(){
            return $scope.unselectedMenu.length === $scope.selectedMenu.length;
        }
        
        $scope.saveSelectedMenu = function(){
            console.log($scope.selectedMenu);
            for ( var i = 0; i < $scope.selectedMenu.length; i++) {
                var p = {id: $scope.selectedMenu[i]};
                $scope.currentRole.menuSet.push(p);
            }
            RoleService.save($scope.currentRole)
            .success(function(){
                RoleService.unselectedMenu($scope.currentRole)
                .success(function(data){
                    $scope.unselectedMenu = data;
                    $scope.currentRole = RoleService.get({
                        id: $scope.currentRole.id
                    });
                });
            });
            $scope.showMenuDialog = false;
        }
        
        $scope.cancelSelectedMenu = function(){
            $scope.selectedMenu = [];
            console.log($scope.selectedMenu);
            $scope.showMenuDialog = false;
        }

        $scope.removeSelectedMenu = function(x){
            if(x.id == null){
                return;
            }
            var ixMenu = -1;
            for(var i = 0; i < $scope.currentRole.menuSet.length; i++){
                if(x.id === $scope.currentRole.menuSet[i].id){
                    ixMenu = i;
                    break;
                }
            }
            if(ixMenu >= 0){
                $scope.currentRole.menuSet.splice(ixMenu, 1);
                RoleService.save($scope.currentRole)
                .success(function(){
                    RoleService.unselectedMenu($scope.currentRole)
                    .success(function(data){
                        $scope.unselectedMenu = data;
                        $scope.currentRole = RoleService.get({
                            id: $scope.currentRole.id
                        });
                    });
                });
            }
        }
    }])
    .controller('UserController', ['$scope', 'UserService', 'RoleService', function($scope, UserService, RoleService){
        $scope.users = UserService.query();
        $scope.roles = RoleService.query();
        $scope.edit = function(x){
            if(x.id == null){
                return; 
            }
            $scope.currentUser = UserService.get({id: x.id}, function(data){
                $scope.original = angular.copy(data);
            });
        };
        $scope.baru = function(){
            $scope.currentUser = null;
            $scope.original = null;
        }
        $scope.simpan = function(){
            if($scope.currentUser.active == null){
                $scope.currentUser.active = false;
            }
            UserService.save($scope.currentUser)
            .success(function(){
                $scope.users = UserService.query();
                $scope.baru();
            });
        }
        $scope.remove = function(x){
            if(x.id == null){
                return;
            }
            UserService.remove(x).success(function(){
                $scope.users = UserService.query();
            });
        }
        $scope.isClean = function(){
            return angular.equals($scope.original, $scope.currentUser);
        }
        $scope.isUsernameAvailable = function(value){
            if($scope.currentUser != null && $scope.currentUser.id != null){
                return true;
            }
            for(var i = 0; i < $scope.users.length; i++){
                var u = $scope.users[i];
                if(u.username === value){
                    return false;
                }
            }
            return true;
        }
    }])

    .controller('TeacherController', ['$scope', 'TeacherService', function($scope, TeacherService){
        $scope.teachers = TeacherService.query();
        $scope.edit = function(x){
            if(x.id == null){
                return; 
            }
            $scope.currentTeacher = TeacherService.get({id: x.id}, function(data){
                $scope.original = angular.copy(data);
            });
        };
        $scope.baru = function(){
            $scope.currentTeacher = null;
            $scope.original = null;
        }
        $scope.simpan = function(){
            TeacherService.save($scope.currentTeacher)
            .success(function(){
                $scope.teachers = TeacherService.query();
                $scope.baru();
            });
        }
        $scope.remove = function(x){
            if(x.id == null){
                return;
            }
            TeacherService.remove(x).success(function(){
                $scope.teachers = TeacherService.query();
            });
        }
        $scope.isClean = function(){
            return angular.equals($scope.original, $scope.currentTeacher);
        }
    }])

    .controller('SchoolController', ['$scope', 'SchoolService', function($scope, SchoolService){
        $scope.schools = SchoolService.query();
        $scope.edit = function(x){
            if(x.id == null){
                return; 
            }
            $scope.currentSchool = SchoolService.get({id: x.id}, function(data){
                $scope.original = angular.copy(data);
            });
        };
        $scope.baru = function(){
            $scope.currentSchool = null;
            $scope.original = null;
        }
        $scope.simpan = function(){
            SchoolService.save($scope.currentSchool)
            .success(function(){
                $scope.schools = SchoolService.query();
                $scope.baru();
            });
        }
        $scope.remove = function(x){
            if(x.id == null){
                return;
            }
            SchoolService.remove(x).success(function(){
                $scope.schools = SchoolService.query();
            });
        }
        $scope.isClean = function(){
            return angular.equals($scope.original, $scope.currentSchool);
        }
    }])

    .controller('StudentController', ['$scope', 'StudentService', function($scope, StudentService){
        $scope.students = StudentService.query();
        $scope.edit = function(x){
            if(x.id == null){
                return; 
            }
            $scope.currentStudent = StudentService.get({id: x.id}, function(data){
                $scope.original = angular.copy(data);
            });
        };
        $scope.baru = function(){
            $scope.currentStudent = null;
            $scope.original = null;
        }
        $scope.simpan = function(){
            SchoolStudent.save($scope.currentStudent)
            .success(function(){
                $scope.students = StudentService.query();
                $scope.baru();
            });
        }
        $scope.remove = function(x){
            if(x.id == null){
                return;
            }
            StudentService.remove(x).success(function(){
                $scope.students = StudentService.query();
            });
        }
        $scope.isClean = function(){
            return angular.equals($scope.original, $scope.currentStudent);
        }
    }])

    .controller('MajorController', ['$scope', 'MajorService', function($scope, MajorService){
        $scope.majors = MajorService.query();
        $scope.edit = function(x){
            if(x.id == null){
                return; 
            }
            $scope.currentMajor = MajorService.get({id: x.id}, function(data){
                $scope.original = angular.copy(data);
            });
        };
        $scope.baru = function(){
            $scope.currentMajor = null;
            $scope.original = null;
        }
        $scope.simpan = function(){
            MajorService.save($scope.currentMajor)
            .success(function(){
                $scope.majors = MajorService.query();
                $scope.baru();
            });
        }
        $scope.remove = function(x){
            if(x.id == null){
                return;
            }
            MajorService.remove(x).success(function(){
                $scope.schools = MajorService.query();
            });
        }
        $scope.isClean = function(){
            return angular.equals($scope.original, $scope.currentMajor);
        }
    }])
;