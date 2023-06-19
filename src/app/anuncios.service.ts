import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Anuncios } from './anuncios';

@Injectable({
  providedIn: 'root'
})
export class AnunciosService {

  url = "http://localhost:8080/clients";

  constructor(private http: HttpClient) { }

  getAnuncios(): Observable<Anuncios[]> {
    return this.http.get<Anuncios[]>(this.url);
  }

  cadastrar(anuncios: Anuncios): Observable<Anuncios> {
    return this.http.post<Anuncios>(this.url, anuncios);
  }

  remove(anuncios: Anuncios): Observable<void> {
    return this.http.delete<void>(`${this.url}/${anuncios.id}`);
  }

  update(anuncios: Anuncios): Observable<Anuncios> {
    return this.http.put<Anuncios>(`${this.url}/${anuncios.id}`,anuncios);
  }


}


















