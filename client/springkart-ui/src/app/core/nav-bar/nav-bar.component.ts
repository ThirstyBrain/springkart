import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {
  isAuthenticated:boolean;
  user:string="Shivam";
  basket$: Observable<number>;

  constructor() { }

  ngOnInit(): void {
    if(!this.isAuthenticated)
      this.user = "User";
    else
       this.user = "Shivam"
  }

  logout() {
    
  }

}
