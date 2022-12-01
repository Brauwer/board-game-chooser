import { Component, OnInit } from '@angular/core';
import { BoardGame } from '../model/board-game';
import { BoardgameService } from '../service/boardgame-service.service';

@Component({
  selector: 'app-boardgame-list',
  templateUrl: './boardgame-list.component.html',
  styleUrls: ['./boardgame-list.component.sass']
})
export class BoardgameListComponent implements OnInit {

  boardgames?: BoardGame[];

  constructor(private boardgameService: BoardgameService) { }

  ngOnInit() {
    this.boardgameService.findAll().subscribe(data => {
      this.boardgames = data;
    })
  }

}
