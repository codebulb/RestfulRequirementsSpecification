'use strict';

angular.module('restfulRequirementsSpecificationclientApp')
        .controller("BooksListCtrl", function ($scope, $route, $routeParams, $location, Restangular) {
            Restangular.all("books").getList().then(function(entities) {
              $scope.entities = entities;
            });
            
            $scope.show = function(entity) {
                $location.path("/books/" + entity.id);
            };
        });
