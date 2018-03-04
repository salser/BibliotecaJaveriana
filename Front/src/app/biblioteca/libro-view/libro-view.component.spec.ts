import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LibroViewComponent } from './libro-view.component';

describe('LibroViewComponent', () => {
  let component: LibroViewComponent;
  let fixture: ComponentFixture<LibroViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LibroViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LibroViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
