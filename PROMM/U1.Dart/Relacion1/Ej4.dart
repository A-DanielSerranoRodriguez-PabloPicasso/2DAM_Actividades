import 'dart:io';

void main(List<String> args) {
  print("Introduce un numero: ");
  var input = stdin.readLineSync();
  tabla(int.parse(input!));
}

void tabla(int num) {
  for (int i = 1; i <= 10; i++) {
    print(i * num);
  }
}
