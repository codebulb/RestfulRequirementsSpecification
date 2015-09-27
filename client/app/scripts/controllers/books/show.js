'use strict';

angular.module('restfulRequirementsSpecificationclientApp')
        .controller("BooksShowCtrl", function ($scope, $route, $routeParams, $location, Restangular) {
            Restangular.one("books", $routeParams.id).get().then(function (entity) {
                $scope.entity = entity;
            });
            
            $scope.execute = function() {
                $location.path("/users/0/orders/new").search({bookId: $scope.entity.id});
            }
        });
