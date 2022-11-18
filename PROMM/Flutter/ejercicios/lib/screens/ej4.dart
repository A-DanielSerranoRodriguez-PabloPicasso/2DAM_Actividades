import 'package:flutter/material.dart';

class Ej4 extends StatelessWidget {
  const Ej4({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text("Ejercicio 4"),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: const [
              Contenedor(
                color: Colors.red,
                alto: 300,
                ancho: 200,
                texto: "Contenedor como clase",
                padding: EdgeInsets.symmetric(horizontal: 10, vertical: 20),
                alineacion: Alignment.center,
              ),
              SizedBox(
                height: 10,
              ),
              Contenedor(
                color: Colors.teal,
                alto: 200,
                ancho: 300,
                texto: "Otro contenedor",
                padding: EdgeInsets.all(10),
                alineacion: Alignment.centerLeft,
              )
            ],
          ),
        ));
  }
}

class Contenedor extends StatelessWidget {
  final Color color;
  final double alto;
  final double ancho;
  final EdgeInsets padding;
  final AlignmentGeometry alineacion;
  final String texto;

  const Contenedor({
    super.key,
    required this.color,
    required this.alto,
    required this.ancho,
    required this.texto,
    required this.padding,
    required this.alineacion,
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      color: color,
      width: ancho,
      height: alto,
      padding: padding,
      alignment: alineacion,
      child: Center(
        child: Text(texto),
      ),
    );
  }
}
