#lang racket/gui
(require racket/gui/base)

(define (main n)
    ;;grid 2^n x 2^n
    (define (generate-hole)
        (list (random (expt 2 n)) (random (expt 2 n))) ;int from 0 to 31 (which is how we will index the grid)
    )
    (generate-hole)

    (define (place-next-triangle)
        ()
    )
)