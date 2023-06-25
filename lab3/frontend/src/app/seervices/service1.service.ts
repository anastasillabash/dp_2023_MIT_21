import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Entity } from '../interfaces/entity';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {
  url:string = "http://localhost:8070/backend/servlet"

  list = new BehaviorSubject<Entity[]>([]);

  constructor(private http:HttpClient) { }

  getEntities():Observable<Entity[]>{
    return this.http.get<Entity[]>(this.url);
  }

  /*public doPut(name: Object, places: Object, price: Object){
    this.http.put(this.url + "?name="+name+"&places="+places+"&price="+price, price).subscribe(data => {console.log(data)});
  } */

  putEntities(item: Entity): Observable<Entity[]> {
    return this.http.put<Entity[]>(this.url+"/"+item.id, item);
  }

  postEntities(item: Entity): Observable<Entity[]>{
    return this.http.post<Entity[]>(this.url, item);
  }

  deleteEntities(item: Entity): Observable<Entity[]>{
    return this.http.delete<Entity[]>(this.url+"/"+item.id);
  }

  setList(list: Entity[]){
    this.list.next(list);
  }
}
