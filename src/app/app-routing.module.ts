import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BoardgameListComponent } from './boardgame-list/boardgame-list.component'; 
import { UserComponent } from './user/user.component';

const routes: Routes = [
  { path: 'boardgames', component: BoardgameListComponent},
  { path: 'user/create', component: UserComponent} 
]

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
