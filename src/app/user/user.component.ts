import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';

import { User } from '../model/user';
import { UserService } from '../service/user.service';

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styles: []
})

export class UserComponent {

  emailFormControl = new FormControl('', [Validators.required, Validators.email]);
  matcher = new MyErrorStateMatcher();

  model = new User('', '', '');


  userForm = this.formBuilder.group({
    username: ['', Validators.required],
    email: ['', Validators.email],
    password: ['', Validators.minLength(8)]
  })

  constructor(
    private userService: UserService,
    private formBuilder: FormBuilder
  ) {}

  onSubmit(): void {

  }

}
