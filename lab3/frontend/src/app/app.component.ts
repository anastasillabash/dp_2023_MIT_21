import { Component, OnInit} from '@angular/core';
import { Entity } from './interfaces/entity';
import { Service1Service } from './seervices/service1.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = "frontend";
  entityList:Entity[]=[];

  

  constructor(private service:Service1Service){}
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  getEntities():void{
    this.service.getEntities().subscribe(
      (entities)=>{
        this.entityList = entities;
      }
    )
  }

  name:string = "";
  places:string = "";
  price:string = "";

  getName(value:string){
    this.name=value;
  }

  getPlaces(value:string){
    this.places=value;
  }

  getPrice(value:string){
    this.price=value;
  }

  OnClick(): void {
    console.log(this.name);
    console.log(this.places);
    console.log(this.price);

    //this.service.doPut(this.name, this.places, this.price);
  }

  


}
