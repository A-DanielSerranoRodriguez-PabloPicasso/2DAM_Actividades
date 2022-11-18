import 'package:flutter/material.dart';

class Ej3 extends StatelessWidget {
  const Ej3({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Ej3. Contenedor"),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Container(
                clipBehavior: Clip.antiAlias,
                decoration: BoxDecoration(
                    color: Colors.red, borderRadius: BorderRadius.circular(20)),
                padding:
                    const EdgeInsets.symmetric(horizontal: 55, vertical: 10),
                child: Column(
                  children: [
                    Container(
                      decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(20)),
                      clipBehavior: Clip.antiAlias,
                      child: Image.asset("assets/images/chad.png"),
                    ),
                    const SizedBox(
                      height: 20,
                    ),
                    const Text("Persona del meme 'Chad'")
                  ],
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}
