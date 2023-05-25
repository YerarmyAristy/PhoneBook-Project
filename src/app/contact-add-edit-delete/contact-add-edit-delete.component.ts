import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ContactService } from '../contact.service';

@Component({
  selector: 'app-contact-add-edit-delete',
  templateUrl: './contact-add-edit-delete.component.html',
  styleUrls: ['./contact-add-edit-delete.component.css'],
})
export class ContactAddEditDeleteComponent implements OnInit {
  public contactForm: FormGroup;

  constructor(
    private _fb: FormBuilder,
    private _contactServ: ContactService,
    private _dialogRef: MatDialogRef<ContactAddEditDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    this.contactForm = this._fb.group({
      firstName: '',
      middleInitial: '',
      lastName: '',
      phoneNumber: '',
      email: '',
      address: '',
    });
  }
  ngOnInit(): void {
    console.log(this.data);
    this.contactForm.patchValue(this.data);
  }
  OnFormSubmit() {
    if (this.contactForm.valid) {
      if (this.data) {
        this.contactForm.value.id = this.data.id;
        this._contactServ.updateContact(this.contactForm.value).subscribe({
          next: () => {
            this._contactServ.getContacts();
            this._dialogRef.close(true);
          },
          error: (err: any) => {
            console.error(err);
          },
        });
      } else {
        this._contactServ.addContact(this.contactForm.value).subscribe({
          next: () => {
            this._dialogRef.close(true);
          },
          error: (err: any) => {
            console.error(err);
          },
        });
      }
    }
  }
}
