import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BoardgameListComponent } from './boardgame-list/boardgame-list.component';
import { AppRoutingModule } from './app-routing.module';

import { BoardgameService } from './service/boardgame-service.service';
import { UserComponent } from './user/user.component';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    BoardgameListComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [BoardgameService],
  bootstrap: [AppComponent]
})
export class AppModule { }
