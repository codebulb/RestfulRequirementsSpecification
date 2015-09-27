'use strict';

angular.module('restfulRequirementsSpecificationclientApp')
        .controller("OrdersListCtrl", function ($scope, $route, $routeParams, $location, Restangular) {
            $scope.init = function() {
                $scope.created = $routeParams.created;
                Restangular.one("users", $routeParams.userId).get().then(function(entity) {
                    $scope.user = entity;
                });
                Restangular.one("users", 0).all("orders").getList().then(function(entities) {
                  $scope.entities = entities;
                });
            };
            
            $scope.delete = function(id) {
                Restangular.one("users", $scope.user.id).one("orders", id).remove().then(function() {
                    $scope.errors = null;
                    // remove search parameters
                    $location.url($location.path());
                    $route.reload();
                }, function (response) {
                    $scope.errors = response.data;
                });
            };
            
            $scope.init();
        });
