angular.module('app.services', []).factory('Player', function($resource) {
  return $resource('/api/v1/players/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
