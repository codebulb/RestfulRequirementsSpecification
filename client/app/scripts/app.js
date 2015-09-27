'use strict';

/**
 * @ngdoc overview
 * @name clientApp
 * @description
 * # clientApp
 *
 * Main module of the application.
 */
angular
  .module('restfulRequirementsSpecificationclientApp', [
            'ngCookies',
            'ngResource',
            'ngRoute',
            'ngSanitize',
            'restangular',
            'pascalprecht.translate',
            'ui.bootstrap.datetimepicker'
        ])
        .config(function ($routeProvider) {
            $routeProvider
                    .when('/books', {
                        templateUrl: 'views/books/list.html',
                        controller: 'BooksListCtrl'
                    })
                    .when('/books/:id', {
                        templateUrl: 'views/books/show.html',
                        controller: 'BooksShowCtrl'
                    })
                    .when('/users/:userId/orders', {
                        templateUrl: 'views/orders/list.html',
                        controller: 'OrdersListCtrl'
                    })
                    .when('/users/:userId/orders/:id', {
                        templateUrl: 'views/orders/edit.html',
                        controller: 'OrdersEditCtrl'
                    })
                    .otherwise({
                        redirectTo: '/books'
                    });
        })
        .config(function (RestangularProvider) {
            RestangularProvider.setBaseUrl('http://localhost:8080/RestfulRequirementsSpecification.server/');
            RestangularProvider.setRequestInterceptor(function(elem, operation) {
                // prevent "400 - bad request" error on DELETE
                if (operation === "remove") {
                   return undefined;
                } 
                return elem;
              });
        })
        .config(['$translateProvider', function ($translateProvider) {
            $translateProvider.translations('en', translations);
            $translateProvider.preferredLanguage('en');
            $translateProvider.useMissingTranslationHandlerLog();
            $translateProvider.useSanitizeValueStrategy('sanitize');
        }]);
