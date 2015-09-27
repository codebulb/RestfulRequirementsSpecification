'use strict';

angular.module('restfulRequirementsSpecificationclientApp')
        .controller("OrdersEditCtrl", function ($scope, $route, $routeParams, $location, Restangular) {
            $scope.initEntity = function() {
                if ($routeParams.id === "new") {
                    $scope.entity = Restangular.one("users/0/orders/");
                    if (typeof $routeParams.bookId !== 'undefined') {
                        $scope.entity.deliveryDate = moment().add(1, 'days').toDate();
                        $scope.entity.book = Restangular.one("books", $routeParams.bookId).get().$object;
                    }
                }
            };
            
            $scope.back = function() {
                $location.path("/books/" + $scope.entity.book.id);
            }
            
            $scope.execute = function() {
                $scope.entity.put().then(function(response) {
                    $scope.errors = null;
                    $location.path("/users/" + $routeParams.userId + "/orders/").search({created: response.id});
                }, function (response) {
                    $scope.errors = response.data;
                });
            }
            
            $scope.initEntity();
        });
