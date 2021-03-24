import { Component } from '@angular/core';
import { HttpClientService } from './services/http-client.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'playlist';
  public musicPlayList: Array<any> = [];

  constructor(private httpService: HttpClientService) {
  }

  ngOnInit() {
    this.getMusicPlayList();
  }

  getMusicPlayList(){
    let url = "get/all"
    this.httpService.getService(url).subscribe(data=>{
      console.log(data);
      if(data.status == 200 && data.data != null && data.data != undefined && data.data.length > 0){
        this.musicPlayList = data.data;
        console.log(this.musicPlayList);
      }
    });
  }
}
