import { Injectable } from '@angular/core';
   import { HttpClient } from '@angular/common/http';
   import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

   @Injectable({
     providedIn: 'root',
   })
   export class GptService {
     //private apiUrl = 'https://generativelanguage.googleapis.com/v1beta/models/gemini-3.1-flash-lite:generateContent';
     private apiKey = environment.openAiApiKey;
     private apiUrl = `https://generativelanguage.googleapis.com/v1beta/models/gemini-3.1-flash-lite:generateContent?key=${this.apiKey}`;

     constructor(private http: HttpClient) {}

     generateResponse(prompt: string): Observable<any> {
       const headers = {
         //Authorization: `Bearer ${this.apiKey}`,
         'Content-Type': 'application/json',
       };
       const body = {
         model: 'gemini-3.1-flash-lite',
         contents: [
           { role: 'system', parts: [{text: 'You are a helpful assistant.'}] },
           { role: 'user', parts: [{text: prompt}] },
         ],
         generationConfig: {
          maxOutputTokens: 100 // Note the camelCase and location inside generationConfig
         }
       };
       return this.http.post(this.apiUrl, body, { headers });
     }
   }