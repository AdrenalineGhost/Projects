format ELF64 executable 3

segment readable executable

entry main

main:
    lea     rdi, [msg]      ;add msg into rdi register
    mov     rax, 13         ;put lenth of msg into rax
    mov     rdx, rax        ;mov rax to rdx
    mov     rsi, rdi        ;mov rdi to rsi
    mov     rdi, 1          ;stdout
    mov     rax, 1          ;sys_write
    syscall
    xor     rdi, rdi        ;exit code 0
    mov     rax, 60         ;sys_exit
    syscall

segment readable writable
;data
msg     db 'hello world', 10, 0
