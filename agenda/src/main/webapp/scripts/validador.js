/**
 * Validacao de formularios
 * @author Hericles Rocha
 */

 function validador(){
	 let nome = frmContato.nome.value 
	 let phone = frmContato.phone.value
	 
	 if(nome === ""){
		 alert("Preencha o campo nome")
		 frmContato.nome.focus()
		 return false
		 
	 }else if(phone === ""){
		 alert("Preencha o campo phone")
		 frmContato.phone.focus()
		 return false
		 
	 }else{
		 document.forms["frmContato"].submit()
	 }
 }