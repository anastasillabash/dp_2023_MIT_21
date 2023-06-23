import { Component } from '@angular/core';
import { Entity } from './interfaces/entity';
import { Seervice1Service } from './services/seervice1.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'lab1f';
  entityList: Entity[]=[];

  constructor(private service:Seervice1Service){};

  getEntities(): void{
    this.service.getEntities().subscribe(
      (entities)=>{
        this.entityList=entities;
      }
    )
  }
  
}
