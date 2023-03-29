.section .data
msg:
    .ascii "Hello, World!\n"
 
.section .text
.globl _start
_start:
    mov $4, %rax
    mov $1, %rbx
    mov $msg, %rcx
    mov $14, %rdx
    int $0x80
 
    mov $1, %rax
    xor %rbx, %rbx
    int $0x80
