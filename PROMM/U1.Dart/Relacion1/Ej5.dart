import 'dart:io';

void main(List<String> args) {
  print("Se recogeran numeros. Para parar, presione 'enter' sin valores.");
  var input = stdin.readLineSync();
  List? lista;
  int i = 0;

  if (input!.isNotEmpty) {
    lista = new List.filled(1, input, growable: true);
    input = stdin.readLineSync();

    while (input!.isNotEmpty) {
      lista.add(input);
      input = stdin.readLineSync();
      i++;
    }
  }

  print(lista);
}
