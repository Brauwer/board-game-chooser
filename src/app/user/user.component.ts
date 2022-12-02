import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user',
  template: `
    <p>
      user works!
    </p>
  `,
  styles: [
  ]
})
export class UserComponent {

  checkoutForm = this.formBuilder.group({
    username: '',
    email: '',
    password: ''
  });

  constructor(
    private userService: UserService,
    private formBuilder: FormBuilder
  ) {}

  onSubmit(): void {
    user: User(this.checkoutForm.get);
    this.userService.saveUser()
  }

}
