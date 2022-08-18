import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Persona } from '../../persona';
import { ConexionService } from '../../service/conexion.service';

@Component({
  selector: 'app-contactoPage',
  templateUrl: './contactoPage.component.html',
  styleUrls: ['./contactoPage.component.css']
})
export class ContactoPageComponent implements OnInit {

  contactForm!: FormGroup;

  persona : Persona = new Persona();


  constructor(private readonly fb: FormBuilder, private router: Router, private conexion : ConexionService) {
    this.contactForm = fb.group({
      formularioNombre: ['', [Validators.required, Validators.minLength(3)]],
      formularioApellido: ['', [Validators.required, Validators.minLength(3)]],
      formularioEmail: ['', Validators.email],
      formularioMensaje: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(300)]]
    })
  }

  ngOnInit() {

  }

  onSubmit() {

    this.almacenarDatos();

    console.log(this.persona);

    this.limpiarFormulario();

  }

  almacenarDatos() {
    this.persona.nombre_formulario = this.contactForm.value.formularioNombre;
    this.persona.apellido_formulario = this.contactForm.value.formularioApellido;
    this.persona.email_formulario = this.contactForm.value.formularioEmail;
    this.persona.mensaje_formulario = this.contactForm.value.formularioMensaje;

    this.conexion.guardarFormulario(this.persona).subscribe(dato => {
      console.log(dato);

    }, error => console.log(error));
  }

  limpiarFormulario() {
    this.persona.nombre_formulario = " ";
    this.persona.apellido_formulario = " ";
    this.persona.email_formulario = " ";
    this.persona.mensaje_formulario = " ";

    this.contactForm.reset();
  }

}


