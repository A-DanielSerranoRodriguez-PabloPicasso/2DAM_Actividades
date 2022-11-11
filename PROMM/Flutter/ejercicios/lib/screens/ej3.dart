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
                decoration: BoxDecoration(color: Colors.red),
                padding:
                    const EdgeInsets.symmetric(horizontal: 5, vertical: 10),
                child: Column(
                  children: [
                    Image.asset("assets/images/chad.png"),
                    const SizedBox(
                      height: 20,
                    ),
                    const Text("Chad")
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
