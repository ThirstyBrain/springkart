import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarouselModule } from 'ngx-bootstrap/carousel';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { TextInputComponent } from './text-input/text-input.component';
import { BrowserModule } from '@angular/platform-browser';



@NgModule({
  declarations: [
    TextInputComponent
  ],
  imports: [
    CommonModule,
   
    CarouselModule.forRoot(),
    ReactiveFormsModule,
    FormsModule,
    RouterModule,
    
  ],
  exports:[
    TextInputComponent,
    CarouselModule,
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class SharedModule { }
