import 'dart:io';

void main(List<String> args) {
  var input;

  print("Calculadora\n");

  while (input != "s") {
    print("1. Sumar");
    print("2. Restar");
    print("3. Dividir");
    print("4. Multiplicar");
    print("\n[1/2/3/4/s]: ");
    input = stdin.readLineSync();
    String? sNum1, sNum2;

    if (input != "s") {
      print("Numero 1:");
      sNum1 = stdin.readLineSync();
      print("Numero 2:");
      sNum2 = stdin.readLineSync();

      if (sNum1 == null || sNum2 == null) {
        print("Introduce numeros\n\n");
      } else if (sNum1.contains(RegExp(r'[A-Za-z]')) ||
          sNum2.contains(RegExp(r'[A-Za-z]'))) {
        print("Introduce numeros\n\n");
      } else {
        int num1 = int.parse(sNum1), num2 = int.parse(sNum2);
        switch (input) {
          case "1":
            print(num1 + num2);
            break;
          case "2":
            print(num1 - num2);
            break;
          case "3":
            if (num2 == 0)
              print("No se puede dividir entre 0");
            else
              print(num1 / num2);
            break;
          case "4":
            print(num1 * num2);
            break;
          case "s":
            break;
          default:
            print("Introduce valor admitido\n\n");
        }
      }
    }
  }
}
