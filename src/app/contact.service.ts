import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Contact } from './contact';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root',
})
export class ContactService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {}

  public getContacts(): Observable<Contact[]> {
    return this.http.get<Contact[]>(`${this.apiServerUrl}/contacts`);
  }

  public addContact(data: any): Observable<any> {
    return this.http.post<Contact>(`${this.apiServerUrl}/contacts/add`, data);
  }

  public updateContact(contact: any) {
    return this.http.put(`${this.apiServerUrl}/contacts/update`, contact);
  }

  public deleteContact(contactId: number): Observable<void> {
    return this.http.delete<void>(
      `${this.apiServerUrl}/contacts/delete/${contactId}`
    );
  }
}
