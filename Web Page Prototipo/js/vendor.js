$(document).ready(function() {

  $('#close').on("click", showDialog);
  $('#add').on("click", function (e) {
    $('#id-tx').addClass("show");
    $('#id-input').addClass("show");
    showDialog(e);
  });
  $('#edit').on("click", function (e) {
    $('#id-tx').removeClass("show");
    $('#id-input').removeClass("show");
    showDialog(e);
  });

  function showDialog(e){
    e.preventDefault();
    $('#dialog').toggleClass("display-block")
  }

});
