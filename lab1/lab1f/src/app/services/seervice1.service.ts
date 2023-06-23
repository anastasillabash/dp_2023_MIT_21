import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Entity } from '../interfaces/entity';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Seervice1Service {
  url:string="http://localhost:8080/labb1/json"

  constructor(private http:HttpClient) { }

  getEntities():Observable<Entity[]>{
    return this.http.get<Entity[]>(this.url);
  }

}
