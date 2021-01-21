import { Component, OnInit } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'; 

export interface Product{
  id:number;
  productCategory:string;
  imageUrl:string;
  price:number;
  productTitle:string;
  productSubtitle:string;
}


export interface IBasket {
  id: string;
  items: IBasketItem[];
  clientSecret?: string;
  paymentIntentId?: string;
  deliveryMethodId?: number;
  shippingPrice?: number;
}

export interface IBasketItem {
  id: number;
  productName: string;
  price: number;
  quantity: number;
  pictureUrl: string;
  brand: string;
  type: string;
}

@Component({
  selector: 'app-product-catalog',
  templateUrl: './product-catalog.component.html',
  styleUrls: ['./product-catalog.component.scss']
})
export class ProductCatalogComponent implements OnInit {

  public productList:Product[] = [
    {
      id: 1, 
      productCategory: 'T-Shirt',
      imageUrl:'https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/12812916/2020/11/12/3866973c-104e-4ea7-b94a-dd92563016ee1605157351755-Tommy-Hilfiger-Men-Tshirts-611605157350147-1.jpg',
      price:750,
      productTitle:'Tommy Hilfiger',
      productSubtitle:'Black Round Neck T Shirt'
    },
    {
      id: 2, 
      productCategory: 'T-Shirt',
      imageUrl:'https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/11207114/2020/2/25/21bd6343-2612-4da6-bc32-c17641a897781582630557373-Jack--Jones-Men-Tshirts-3161582630555889-1.jpg',
      price:1500,
      productTitle:'Jack Jones',
      productSubtitle:'Green Round Neck'
    },
    {
      id: 3, 
      productCategory: 'T-Shirt',
      imageUrl:'https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/11710934/2020/9/16/dd768d01-4fae-4bff-b4bf-ec5a2dbf9a0a1600245760449-Tommy-Hilfiger-Men-Tshirts-4531600245758594-1.jpg',
      price:1560,
      productTitle:'Tommy Hilfiger',
      productSubtitle:'Polo'
    },
    {
      id: 4, 
      productCategory: 'T-Shirt',
      imageUrl:'https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/11206770/2020/3/18/730bf81e-6d81-4442-9430-f18a4a6667f61584507138187-Jack--Jones-Men-Tshirts-9341584507136735-1.jpg',
      price:3000,
      productTitle:'Puma',
      productSubtitle:'Round Neck'
    },
    {
      id: 5, 
      productCategory: 'T-Shirt',
      imageUrl:'https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/productimage/2019/12/18/f3a65492-266f-4eb6-928f-49adbaa447821576631681827-1.jpg',
      price:576,
      productTitle:'Jack Jones',
      productSubtitle:'Round Neck'
    },
    {
      id: 6, 
      productCategory: 'T-Shirt',
      imageUrl:'https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/12352424/2020/10/12/2a9a2d2c-c63e-42c0-a2f9-60ba3701c8fc1602494718120-Puma-Men-Tshirts-2521602494716179-1.jpg',
      price:3500,
      productTitle:'Puma',
      productSubtitle:'Round Neck'
    },
    {
      id: 7, 
      productCategory: 'T-Shirt',
      imageUrl:'https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/11468516/2020/10/5/3e38fb04-6223-46ca-8e39-72de27213d1d1601879909910-Nautica-Men-Tshirts-2601601879908094-1.jpg',
      price:3500,
      productTitle:'CK',
      productSubtitle:'Polo T-Shirt'
    },
    {
      id: 8, 
      productCategory: 'T-Shirt',
      imageUrl:'https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/7021924/2018/8/28/8ceaa45d-692e-43c1-bcf2-487c09da03ce1535446812076-Mast--Harbour-Men-Mustard-Solid-Polo-Collar-T-shirt-19015354-1.jpg',
      price:3500,
      productTitle:'T Shirt',
      productSubtitle:'Round Neck'
    },
   
   
];

private basketSource = new BehaviorSubject<number>(null);
basket$ = this.basketSource.asObservable();

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.getJSON().subscribe(data => {
      console.log(data);
      console.log(this.productList)
  });

  }

  public getJSON(): Observable<any> {
      return this.http.get("./assets/product.json");
    
}

addItemToCart(){
  this.basketSource.next(1);
  alert("hi");
}
}
