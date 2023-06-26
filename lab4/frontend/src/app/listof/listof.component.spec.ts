import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListofComponent } from './listof.component';

describe('ListofComponent', () => {
  let component: ListofComponent;
  let fixture: ComponentFixture<ListofComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListofComponent]
    });
    fixture = TestBed.createComponent(ListofComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
