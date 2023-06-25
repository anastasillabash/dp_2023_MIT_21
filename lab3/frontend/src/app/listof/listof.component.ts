import { Component, OnInit } from '@angular/core';
import { Entity } from '../interfaces/entity';
import { Service1Service } from '../seervices/service1.service';

@Component({
  selector: 'app-listof',
  templateUrl: './listof.component.html',
  styleUrls: ['./listof.component.scss']
})
export class ListofComponent implements OnInit{

  title:string="List of products";
  entityList:Entity[]=[];
  showAddForm:boolean=false;
  selectedItem?: Entity;
  
  constructor(private service:Service1Service){}

  ngOnInit(): void{
    this.updateEntities();
    this.service.list.subscribe(
      (list:Entity[])=>{this.entityList=list}
    );
  }

  updateEntities(){
    this.service.getEntities().subscribe(
      (entities)=>{
        this.service.setList(entities);
      }
    );
  }

  addItems(item:Entity){
    this.service.postEntities(item).subscribe(
      (entities)=>{
        this.updateEntities();
      }
    )
    this.refreshPage();
  }

  onSelect(item:Entity){
    if(this.selectedItem && item.id==this.selectedItem.id){
      this.selectedItem=undefined;
    } else{
      this.selectedItem=item;
    }
  }

  deleteEntities(item:Entity){
    this.service.deleteEntities(item).subscribe(
      ()=>{
        this.updateEntities();
      }
    );
    this.refreshPage();
  }

  refreshPage(): void{
    window.location.reload();
  }

}
