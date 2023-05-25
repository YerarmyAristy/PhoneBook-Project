import { DialogRef } from '@angular/cdk/dialog';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Contact } from './contact';
import { ContactAddEditDeleteComponent } from './contact-add-edit-delete/contact-add-edit-delete.component';
import { ContactService } from './contact.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title(title: any) {
    throw new Error('Method not implemented.');
  }

  public contacts!: Contact[];

  constructor(
    private contactService: ContactService,
    private _dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.getContacts();
  }
  public getContacts(): void {
    this.contactService.getContacts().subscribe({
      next: (response: Contact[]) => {
        this.contacts = response;
        console.log(this.contacts);
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }

  deleteContact(contactId: number) {
    this.contactService.deleteContact(contactId).subscribe({
      next: (res) => {
        this.getContacts();
      },
      error: console.log,
    });
  }
  editContact(data: any) {
    this.contactService.updateContact(data).subscribe({
      next: (res) => {
        const myDialog = this._dialog.open(ContactAddEditDeleteComponent, {
          data: data,
        });
        myDialog.afterClosed().subscribe(() => {
          this.getContacts();
        });

        this.getContacts();
      },
      error: console.log,
    });
  }

  openCrudOpForm() {
    const dialogRef = this._dialog.open(ContactAddEditDeleteComponent);
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        this.getContacts();
      },
    });
  }
}
