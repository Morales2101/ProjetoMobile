$( "#logradouro" )
  .focusout(function() {
    alert("focus");
  })
  .blur(function() {
	  alert("blur");
  });