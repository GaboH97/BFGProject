$(document).ready(function() {
var state="students";
addStudents();

$('#add').on('click',function (){
    if(state=='students'){
        location.href ="add/indexUsers.html";
    }else if(state=='trainers'){
        location.href ="add/indexTrainner.html";        
    }else{
        location.href ="add/indexTransactions.html";                
    }
});

$('#btn-students').on('click',function (){
    addStudents();
});

$('#btn-trainers').on('click',function (){
    addTrainers();
});

$('#btn-movements').on('click',function (){
    addMovements();
});

$('#add-trainner').on('click',function(e){
    e.preventDefault();
    var form = $('#form-trainer').serializeFormJSON();
    console.log(form);
    $.ajax({
            url: 'http://localhost:8181/trainner',
            method: "POST",
            dataType: 'json',
            data: form,
            success: function(result){
                if(result=='ok'){
                    location.href ="../index.html";                                
                }else{
                    $("#alert").html("");
                    $("#alert").append('<div class="alert alert-danger"><strong>Danger!  </strong>'+result+'</div>');
                }
            },
            error: function(er){
                $("#alert").append('<div class="alert alert-danger"><strong>Danger!</strong>'+er+'</div>');                
            }
    });
});

    function addStudents(){
        $.ajax({
            url: 'http://localhost:8181/users',
            dataType: 'json',
            success: function(data){
              $('#table').html('');              
              $('#table').append('<thead><tr> <th>Identification</th><th>Name</th><th>Phone</th> <th>email</th><th>Image</th></tr></thead><tbody>');
             var bodyTable='';
              for (var i = 0; i < data.length; i++) {
                 var element = data[i];
                 bodyTable+='<tr><th>'+element.identification+'</th><td>'+element.name+'</td><td>'+element.phone+'</td><td>'+element.eMail+'</td><td><img src="'+element.imgURL +'" alt="" class="img-responsive img-circle" ></td></tr>';
             }
             $('#table').append(bodyTable);
             $('#title').html('');                          
             $('#title').append('Students');
             state="students";
             $('#btn-students').addClass('active');
             $('#btn-trainers').removeClass('active');
             $('#btn-movements').removeClass('active');
             
            }
        });
    }

    function addTrainers(){
        $.ajax({
            url: 'http://localhost:8181/trainners',
            dataType: 'json',
            success: function(data){
              $('#table').html('');
              $('#table').append('<thead><tr> <th>Identification</th><th>Name</th><th>Phone</th> <th>email</th><th>Programs</th><th>Image</th></tr></thead><tbody>');
             var bodyTable='';
              for (var i = 0; i < data.length; i++) {
                 var element = data[i];
                 bodyTable+='<tr><th>'+element.identification+'</th><td>'+element.name+'</td><td>'+element.phone+'</td><td>'+element.eMail+'</td><td>'+element.programs+'</td><td><img src="'+element.imgURL +'" alt="" class="img-responsive img-circle" ></td></tr>';
             }
             $('#table').append(bodyTable);
             $('#title').html('');             
             $('#title').append('Trainers');
             state="trainers";
             $('#btn-students').removeClass('active');
             $('#btn-trainers').addClass('active');
             $('#btn-movements').removeClass('active');
                          
            }
        });
    }

    function addMovements(){
        $.ajax({
            url: 'http://localhost:8181/movements',
            dataType: 'json',
            success: function(data){
              $('#table').html('');
              $('#table').append('<thead><tr> <th>Id</th><th>Type</th><th>Movement date</th> <th>Value</th><th>Description</th></tr></thead><tbody>');
             var bodyTable='';
              for (var i = 0; i < data.length; i++) {
                 var element = data[i];
                 bodyTable+='<tr><th>'+element.id+'</th><td>'+element.tipo+'</td><td>'+element.movement_date+'</td><td>'+element.value+'</td><td>'+element.value +'</tr>';
             }
             $('#table').append(bodyTable);
             $('#title').html('');             
             $('#title').append('Movements');
             state="movements";
             $('#btn-students').removeClass('active');
             $('#btn-trainers').removeClass('active');
             $('#btn-movements').addClass('active');             
            }
        });
    }
    (function ($) {
        $.fn.serializeFormJSON = function () {
    
            var o = {};
            var a = this.serializeArray();
            $.each(a, function () {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };
    })(jQuery);
});