import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { User } from '../model/user'
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private saveUserUrl: string;

  constructor(private http: HttpClient) {
    this.saveUserUrl = 'http://localhost:8986/users/save';
   }

  public saveUser(user: User): Observable<User> {
    return this.http.put<User>(this.saveUserUrl, user);
  }
}
