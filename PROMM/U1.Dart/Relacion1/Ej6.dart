import 'dart:io';

void main(List<String> args) {
  print("Se recogeran numeros. Para parar, presione 'enter' sin valores.");
  var input = stdin.readLineSync();
  List? lista;
  int i = 0;

  if (input!.isNotEmpty) {
    bool yaPuesto = false;
    lista = new List.filled(1, input, growable: true);
    input = stdin.readLineSync();

    while (input!.isNotEmpty) {
      for (int i = 0, l = lista.length; i < l; i++) {
        if (lista[i] == input) yaPuesto = true;
      }
      if (!yaPuesto) {
        lista.add(input);
        i++;
      } else {
        print("Introduce un numero no repetido");
        yaPuesto = false;
      }

      input = stdin.readLineSync();
    }
  }

  print(lista);
}
