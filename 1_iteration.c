#include <stdio.h>

char reverse_iteration(char *char_array, int current){
	//int current = 0;
	char c = char_array[current % 100];
	while (c != NULL){
		//c = 'd';
		putc(c, stdout);
		current++;
		c = char_array[current % 100];
		//printf("%c", c);
		//putc(c, stdout);
		//current++;
	}
}
	
int main(void){
	char char_array[100] = { NULL };;
	int i = 99;
	char c = getc(stdin);
	
	while (c != '\n'){
		char_array[i] = c;
		c = getc(stdin);
		i--;
	}
		
	reverse_iteration(char_array, i+1);
}

	
	