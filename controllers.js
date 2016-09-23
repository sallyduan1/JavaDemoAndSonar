angular.module('app.controllers', []).controller('PlayerListController', function($scope, $state, popupService, $window, Player) {
  $scope.players = Player.query(); //fetch all players. Issues a GET to /api/vi/player

  $scope.deletePlayer = function(player) { // Delete a Player. Issues a DELETE to /api/v1/players/:id
    if (popupService.showPopup('Really delete this?')) {
      player.$delete(function() {
        $scope.players = Player.query(); 
        $state.go('players');
      });
    }
  };
}).controller('PlayerViewController', function($scope, $stateParams, Player) {
  $scope.player = Player.get({ id: $stateParams.id }); //Get a single player.Issues a GET to /api/v1/players/:id
}).controller('PlayerCreateController', function($scope, $state, $stateParams, Player) {
  $scope.player = new Player();  //create new player instance. Properties will be set via ng-model on UI

  $scope.addPlayer = function() { //create a new player. Issues a POST to /api/v1/players
    $scope.player.$save(function() {
      $state.go('players'); // on success go back to the list i.e. player state.
    });
  };
}).controller('PlayerEditController', function($scope, $state, $stateParams, Player) {
  $scope.updatePlayer= function() { //Update the edited player. Issues a PUT to /api/v1/players/:id
    $scope.player.$update(function() {
      $state.go('players'); // on success go back to the list i.e. players state.
    });
  };

  $scope.loadPlayer = function() { //Issues a GET request to /api/v1/players/:id to get a player to update
    $scope.player= Player.get({ id: $stateParams.id });
  };

  $scope.loadPlayer(); // Load a player which can be edited on UI
});
