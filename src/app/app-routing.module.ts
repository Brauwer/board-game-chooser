import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BoardgameListComponent } from './boardgame-list/boardgame-list.component'; 

const routes: Routes = [
  { path: 'boardgames', component: BoardgameListComponent} 
]

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
