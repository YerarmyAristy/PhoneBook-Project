import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContactAddEditDeleteComponent } from './contact-add-edit-delete.component';

describe('ContactAddEditDeleteComponent', () => {
  let component: ContactAddEditDeleteComponent;
  let fixture: ComponentFixture<ContactAddEditDeleteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ContactAddEditDeleteComponent]
    });
    fixture = TestBed.createComponent(ContactAddEditDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
