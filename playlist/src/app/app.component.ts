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
  public musicType: Array<any> = [];
  public name: any;
  public singer: any;
  public nameGenre: any;
  public musicBean: any;
  public musicGenre: any;
  public isMusic = false;
  public isGenre = false;
  
  constructor(private httpService: HttpClientService) {
  }

  ngOnInit() {
    this.getMusicPlayList();
  }

  getMusicPlayList(){
    let url = "get/all"
    this.httpService.getService(url).subscribe(data=>{
      if(data.status == 200 && data.data != null && data.data != undefined && data.data.length > 0){
        this.musicPlayList = data.data;
      }
    });
  }

  removeMusic(music: any){
    let url = "delete/"+music.id;
    this.httpService.deleteService(url).subscribe(data=>{
      if(data.status == 200 && data.data == null){
        this.getMusicPlayList();
      }
    });
  }

  removeTypeOfMusic(music: any){
    let url = "delete/genre/"+music.bean.id;
    this.httpService.deleteService(url).subscribe(data=>{
      if(data.status == 200 && data.data == null){
        this.getMusicPlayList();
      }
    });
  }

  addNewPlayList(music: any){
    this.isMusic = true;
    this.isGenre = false;
    this.getMusicGenreList();
  }

  getMusicGenreList(){
    let url = "get/all/genre";
    this.httpService.getService(url).subscribe(data=>{
      if(data.status == 200 && data.data != null && data.data != undefined && data.data.length > 0){
        this.musicType = data.data;
      }
    });
  }

  addNewGenreWithPlayList(){
    this.isMusic = false;
    this.isGenre = true;
  }

  onChangeType(event: any){
    this.musicType.forEach(item=>{
      if(item.name == event.target.value){
        this.musicGenre = item;
      }
    });
  }

  addMusic(){
    let url = 'save';
    let bean = {
      name: this.name,
      singer : this.singer,
      musicTypeId: this.musicGenre.id
    }
    this.httpService.postService(url, bean).subscribe(data=>{
      if(data.status == 200 && data.data != null && data.data != undefined){
        this.getMusicPlayList(); 
        this.clearAll();
      }
    });
  }
  
  addGenre(){
    let url = 'save/type';
    let bean = {
      name: this.nameGenre
    }
    this.httpService.postService(url, bean).subscribe(data=>{
      if(data.status == 200 && data.data != null && data.data != undefined){
        this.getMusicPlayList(); 
        this.clearAll();
      }
    });
  }

  clearAll(){
    this.name = null;
    this.singer = null;
    this.isMusic = false;
    this.isGenre = false;
    this.nameGenre = null;
  }
}
