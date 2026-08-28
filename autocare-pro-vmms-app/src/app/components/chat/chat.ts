import { Component } from '@angular/core';
   import { GptService } from '../../services/gpt';
   import { CommonModule } from '@angular/common';
   import { FormsModule } from '@angular/forms';

   @Component({
     selector: 'app-chat',
     standalone: true,
     imports: [CommonModule, FormsModule],
     templateUrl: './chat.html',
     styleUrls: ['./chat.scss']
   })
   export class ChatComponent {
     userInput: string = '';
     response: string = '';

     constructor(private gptService: GptService) {}

     sendPrompt(): void {
       this.gptService.generateResponse(this.userInput).subscribe(
         (data) => {
           this.response = data?.candidates?.[0]?.content?.parts?.[0]?.text.trim();
           console.log(this.response)
         },
         (error) => {
           console.error('Error:', error);
           this.response = 'Something went wrong. Please try again.';
         }
       );
     }
   }