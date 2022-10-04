void main(List<String> args) {
  int numero;

  // Esta línea no se puede ejecutar, ya que la característica de Null Safety
  // no nos permite utilizar una variable que reconozca como nula
  // print(numero);

  // Para ello, decalaramos la variable como null-able con '?'
  int? num2;
  print(num2);
}
