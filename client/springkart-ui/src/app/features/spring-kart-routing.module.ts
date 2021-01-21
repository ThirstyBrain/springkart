import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductCatalogComponent } from './product-catalog/product-catalog.component';

const routes: Routes = [
    { path: '', redirectTo : 't-shirt', pathMatch:'full' },
    {
        path:'t-shirt',
        component:ProductCatalogComponent
    }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SpringkartRoutingModule { }
