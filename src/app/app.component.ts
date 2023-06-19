import { Component, OnInit } from '@angular/core';
import { AnunciosService } from './anuncios.service';
import { Anuncios } from './anuncios';
import { FormBuilder, FormGroup } from '@angular/forms';


@Component({
  selector: 'app-anuncios',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title(title: any) {
    throw new Error('Method not implemented.');
  }

  anuncios: Anuncios[] = [];
  formGroupClient : FormGroup;
  isEditing: boolean = false;

  constructor (private anunciosService: AnunciosService,
               private formBuilder: FormBuilder 
              ){
    
    this.formGroupClient = formBuilder.group({
          id : [''],
          name : [''],
          imagem : [''],
          produto : [''],
          tipo : [''],
    });

  }

  ngOnInit(): void {
    this.loadAnuncios();
  }

  loadAnuncios(){
      this.anunciosService.getAnuncios().subscribe(
        {
            next:  data =>  this.anuncios = data,
            error: msg  => console.log("Erro ao chamar o endpont " + msg)
        }
      )
  }

  save(){
    if(this.isEditing){
      
      this.anunciosService.update(this.formGroupClient.value).subscribe(
        {
          next: () => {
            this.loadAnuncios();
            this.formGroupClient.reset();
            this.isEditing = false;  
          }
        }
      );
    }
    else{
      this.anunciosService.cadastrar(this.formGroupClient.value).subscribe(
        {
          next: data => {
              this.anuncios.push(data);
              this.formGroupClient.reset();    
          }
        }
      );
    }
  }
}





















