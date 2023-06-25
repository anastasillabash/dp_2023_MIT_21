import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Entity } from '../interfaces/entity';
import { Service1Service } from '../seervices/service1.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit{

  @Input() enti?: Entity
  @Output() updated: EventEmitter<null> = new EventEmitter();


  constructor(private service:Service1Service){}



  ngOnInit(): void {
    
  }

  updateEntities(){
    if(this.enti){
      this.service.putEntities(this.enti).subscribe(
        ()=>{this.updated.emit();}
      );
    }
    this.refreshPage();
  }

  refreshPage(): void{
    window.location.reload();
  }


}
