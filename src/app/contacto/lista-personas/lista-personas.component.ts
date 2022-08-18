import { Component, OnInit } from '@angular/core';
import { ConexionService } from 'src/app/service/conexion.service';
import { Persona } from '../../persona';


@Component({
  selector: 'app-lista-personas',
  templateUrl: './lista-personas.component.html',
  styleUrls: ['./lista-personas.component.css']
})
export class ListaPersonasComponent implements OnInit {

  personas: Persona[];

  constructor(private conexion: ConexionService) { }

  ngOnInit(): void {
    this.obtenerPersonas();
  }

  private obtenerPersonas(){
    this.conexion.obtenerListaDelFormulario().subscribe(dato => {
      this.personas = dato;
    })
  }

}
