import 'dart:math';

void main(List<String> args) {
  Random rndm = new Random();
  for (var i = 0; i < 10; i++) {
    print(rndm.nextInt(11));
  }
}
