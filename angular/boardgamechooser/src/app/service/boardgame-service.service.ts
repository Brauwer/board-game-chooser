import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BoardGame } from '../model/board-game';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BoardgameService {

  private boardGameUrl: string;

  constructor(private http: HttpClient) {
    this.boardGameUrl = 'http://localhost:8986/boardgames';
  }


  public findAll(): Observable<BoardGame[]> {
    return this.http.get<BoardGame[]>(this.boardGameUrl);
  }




}
