format PE console
entry _start

include 'Win32a.inc'

;constants
str_fmt: db "The result is %d",0


section '.text' code readable executable

_start:
    push    ebp
    mov     ebp, esp

    mov     eax, 10
    push    eax
