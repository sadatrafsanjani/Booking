(function(){

    'use strict';

    angular
    .module('app')
    .controller('BookingController',BookingController);

    BookingController.$inject = ['$http'];

    function BookingController($http){

        var vm = this;
        vm.bookings = [];
        vm.getAll = getAll;
        vm.getAffordable = getAffordable;
        vm.deleteBooking = deleteBooking;

        init();

        function init(){
            getAll();
        }

        function getAll(){
            var url = "/bookings";
            $http.get(url).then(function(response){
                vm.bookings = response.data;
            });
        }

        function getAffordable(){
            var url = "/affordable/" + 200;
            $http.get(url).then(function(response){
                vm.bookings = response.data;
            });
        }

        function deleteBooking(id){
            var url = "/remove/" + id;
            $http.post(url).then(function(response){
                vm.bookings = response.data;
            });
        }
    }

})();