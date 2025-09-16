package be.vdab.todorestclient;

import java.time.LocalDateTime;

record TodoResponse(String tekst, int prioriteit, LocalDateTime gemaakt) {
}
