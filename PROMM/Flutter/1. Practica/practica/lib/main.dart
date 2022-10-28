import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    title: 'Mi primera aplicación',
    home: Scaffold(
      appBar: AppBar(
        title: Center(
          child: Text('Barra superior'),
        ),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: [
          Column(
            children: [
              Image.asset(
                "assets/images/Amogus1.webp",
                width:150,
              ),
              Text("Primera")
            ],
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Column(
                children: [
                  Image.asset("assets/images/Amogus2.webp", width:150),
                  Text("Segunda 1")
                ],
              ),
              Column(
                children: [
                  Image.asset("assets/images/Amogus3.webp", width:150),
                  Text("Segunda 2")
                ],
              )
            ],
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Column(
                children: [
                  Image.asset("assets/images/Amogus4.webp", width:150),
                  Text("Tercera 1")
                ],
              ),
              Column(
                children: [
                  Image.asset("assets/images/Amogus5.webp", width:150),
                  Text("Tercera 2")
                ],
              ),
              Column(
                children: [
                  Image.asset("assets/images/Amogus6.webp", width:150),
                  Text("Tercera 3")
                ],
              )
            ],
          )
        ],
      ),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.add),
        onPressed: () {},
      ),
    ),
  ));
}
