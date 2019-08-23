var app = angular.module("mainApp", []);

app.controller("searchCtrl", function($scope, $http) {
	$scope.checkDefinition = function(wordText) {
		$http({
			method : 'GET',
			url : "http://localhost:8080/define/" + wordText.toLowerCase()
		}).then(function successCallback(response) {
			if (response.data.definition == null) {
				$scope.val = "Definition unavailable.";
			} else {
				$scope.val = response.data.definition;
			}
			$scope.word = wordText;
		}, function errorCallback(response) {
			$scope.val = "Definition unavailable.";
			$scope.word = wordText;
		});
	}
});