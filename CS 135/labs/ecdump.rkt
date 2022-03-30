#lang racket/gui

;merge sort

;;split court into fours recursively till there aint none
;;place a triple facing the quadrant with the black tile (such that each tile is in all the quadrants except for the one w black one)
;;for each smaller quadrant, repeat this; split quadrant into four subquadrants, and place a triple facing the quadrant with
;;the tile from the original triple.

;;TODO
;; draw a 2^n x 2^n canvas of squares based on n (set thru dialog)

; default frame resolution

; form popup window
(define dialog 
    (instantiate dialog% ("form"))
)

; input label
(new text-field% 
    [parent dialog] 
    [label "enter n (2^n x 2^n): "]
)

; input form
(define panel 
    (new horizontal-panel% 
        [parent dialog]
    )
)

; frame (window)
(define frame 
    (new frame% 
        [label "tiling the courtyard"]
        ; tiles 25x25 pixels: canvas 25*2^n pixels
        [width x-size] 
        [height y-size]
    )   
)

; set resolution of frame/canvas based on n
(define (set-res n)
    (define x-size (* 25 (expt 2 n)))
    (define y-size (* 25 (expt 2 n)))
    ""
)

; title label
(define msg 
    (new message% 
        [parent frame]
        [label "tiling the courtyard"]
    )
)

; button to prompt dialog
(new button% 
    [parent frame]
    [label "start"]
    ; Callback procedure for a button click:
    [callback 
        (lambda (button event)
            (send dialog show #t)
        )
    ]
)
 
; define a canvas class
(define my-canvas%
    (class canvas% ; The base class is canvas%
        (super-new) ; call the superclass init, passing on all init args
    )
)

; instantiate canvas
(new my-canvas% 
    [parent frame]
    [paint-callback
            (lambda (canvas dc) ; canvas drawing context
                ;(send dc set-scale 3 3)
                (send dc set-brush 
                    (new brush% 
                        [style 'solid]
                        [color "red"]    
                    )
                )
                (send dc draw-rectangle 0 0 25 25)
            )
    ]
)

; close window button
(new button%
    [parent frame]
    [label "exit"]
    [callback
        (lambda (button event)
            (send frame show #f)    
        )
    ]
)

; Show the frame by calling its show method
(send frame show #t)