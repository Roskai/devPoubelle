.text
.globl fibonacci
fibonacci:
	movq    %rdi, %rax					# rax = n
	cmpq	$0, %rax					# compare n avec 0
	jle		end						# si n <= 0, fin
	movq	$0, %rbx					# rbx = 0
	movq	$1, %rcx					# rcx = 1
	decq	%rax						# decremente n
	jmp		loop					# saut a loop

loop:
	movq	%rbx, %rdx					# rdx = rbx
	addq	%rcx, %rbx					# rbx = rcx + rbx
	movq	%rdx, %rcx					# rcx = rdx
	decq	%rax						# decremente n
	cmpq	$0, %rax					# compare n avec 0
	jg		loop					# si n > 0, saut a loop

end:
	ret								# retourne le resultat
