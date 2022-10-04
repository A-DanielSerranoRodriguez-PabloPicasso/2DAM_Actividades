void main(List<String> args) {
  int entero = 1, en2 = 5;
  double decim = 1.5, decim2 = 3.2;
  String palabra = "Hola";
  bool verdad = false;
  dynamic loquesea = 3;
  loquesea = "choco";

  /*
  Entre ellos mismos si se pueden realizar operaciones, como es de esperar. 
  Por lo que comprobaremos si pueden operar los unos con los otros.
  */

  // ################ Strings
  // No se puede sumar/restar/dividir un entero/decimal/booleano a un String
  // print(loquesea + entero);
  // print(loquesea + decim2);
  // print(loquesea + verdad);
  // print(loquesea - entero);
  // print(loquesea - decim2);
  // print(loquesea - verdad);
  // print(loquesea / entero);
  // print(loquesea / decim2);
  // print(loquesea / verdad);

  // Si multiplicamos un entero n por un String, nos pondrá ese String n veces
  print(loquesea * en2);

  // Podemos concatenar Strings con otros
  print(loquesea + loquesea);

  // Aunque no podemos multiplicar un String por otro, ni por un decimal
  // Descomentar para comprobar
  //print(loquesea * loquesea);
  //print(loquesea * decim);
}
