$(document).ready(function() {

  $('#add').on("click", showDialog);
  $('#close').on("click", showDialog);

  function showDialog(e){
    console.log("da");
    e.preventDefault();
    $('#dialog').toggleClass("display-block")
  }


});
