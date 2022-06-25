import PySimpleGUI as sg

layout = [
    [
        sg.Button('text' , key='-STOP-'),
        sg.Button('make other window' , key='-WINDOW-'),
        sg.Button('change theme' , key='-THEME-')
        
    ]
]
layoutsecond = [
    [
        sg.Button('End this' , key= '-STOP-')
    ]
]
window = sg.Window('title' , layout)
sg.theme('DarkRed1')
while True:
    event , values = window.read()
    match event:
        case sg.WIN_CLOSED | '-STOP-':
            break
        case '-WINDOW-':
            window.close()
            window = sg.Window('New Window' , layoutsecond, size=(200,200) , finalize=True)   
        case '-THEME-':
            window['-THEME-'].update(text="Fuck You")