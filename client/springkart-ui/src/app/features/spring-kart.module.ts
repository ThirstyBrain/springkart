import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SpringkartRoutingModule } from './spring-kart-routing.module';
import { ProductCatalogComponent } from './product-catalog/product-catalog.component';



@NgModule({
  declarations: [ProductCatalogComponent],
  imports: [
    CommonModule,
    SpringkartRoutingModule,
    
  ]
})
export class SpringKartModule { }
