import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params} from '@angular/router';
import { TokenService } from 'src/app/services/Auth/token.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  usuario:string

  constructor(private router:ActivatedRoute, private tokenService:TokenService) { }

  ngOnInit(): void {
  }

}
