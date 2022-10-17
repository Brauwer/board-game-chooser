import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BoardGame } from '../model/board-game';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BoardgameService {

  private boardGameUrl: string;
  private byCategory: string;
  private byName: string;


  constructor(private http: HttpClient) {
    this.boardGameUrl = 'http://localhost:8986/boardgames';
    this.byName = this.boardGameUrl + "/search/";
    this.byCategory = this.boardGameUrl + "/category/";
  }


  public findAll(): Observable<BoardGame[]> {
    return this.http.get<BoardGame[]>(this.boardGameUrl);
  }

  public findById(id: string): Observable<BoardGame> {
    var byId = this.boardGameUrl+"/"+id;
    return this.http.get<BoardGame>(byId);
  }

  public findByName(name: string): Observable<BoardGame[]> {
    var byNameUrl = this.byName + name;
    return this.http.get<BoardGame[]>(byNameUrl);
  }

  public findByCategory(category: string): Observable<BoardGame[]> {
    var byCategoryUrl = this.byCategory + category;
    return this.http.get<BoardGame[]>(byCategoryUrl);
  }




}
