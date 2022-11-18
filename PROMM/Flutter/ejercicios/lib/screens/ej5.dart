import 'dart:math';

import 'package:flutter/material.dart';

class Ej5 extends StatefulWidget {
  const Ej5({super.key});

  @override
  State<Ej5> createState() => _Ej5State();
}

class _Ej5State extends State<Ej5> {
  double _width = 100, _height = 100;
  Color _color = Colors.red;

  void _cambiarForma() {
    _width = Random().nextInt(400).toDouble() + 50;
    _height = Random().nextInt(400).toDouble() + 50;
    _color = Color.fromRGBO(Random().nextInt(256), Random().nextInt(256),
        Random().nextInt(256), 100);
    setState(() {});
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Ejercicio")),
      body: Transform.translate(
        offset: Offset(_width, _height),
        child: Container(
          width: 200,
          height: 200,
          decoration: BoxDecoration(
            color: _color,
            borderRadius: BorderRadius.circular(20),
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () => _cambiarForma(),
        child: const Icon(Icons.circle),
      ),
    );
  }
}
