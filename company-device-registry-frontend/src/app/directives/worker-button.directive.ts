import {Directive, ElementRef, HostListener} from '@angular/core';


@Directive({
  selector: '[workerButton]'
})
export class WorkerButtonDirective {

  constructor(public elementRef: ElementRef) {
    this.setBgColor("#F3F9E7");
  }

  setBgColor(color:string){
    this.elementRef.nativeElement.style.backgroundColor = color;
  }

  @HostListener('mouseenter') onMouseEnter(){
    this.setBgColor("#74D242");
  }
  @HostListener('mouseleave') onMouseLeave(){
    this.setBgColor("#F3F9E7");
  }
}
