function verPassword()
{
    var tipo = document.getElementById("txtPassword");
    if(tipo.type == "password")
    {
        tipo.type = "text";
    }
    else
    {
        tipo.type = "password";
    }
}

function cambiar(){
    var pdrs = document.getElementById('archivo').files[0].name;
    document.getElementById('info').innerHTML = pdrs;
}

function cargarArchivo(elemento){
	var file = elemento.files[0];
	var objHidden = document.formulario.nombre;
	objHidden.value = file.name;
	document.formulario.action = "ProductosSevlet";
	document.formulario.submit();
	alert("se proceso");
}
