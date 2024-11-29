package com.example.reserva.de.livros.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exemple.reserva.de.livros.model.*;
import com.example.reserva.de.livros.repository.*;

import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Optional<Reserva> confirmarReservaPorLivro(Long livroId) {
        Optional<Reserva> reserva = reservaRepository.findById(livroId);
        reserva.ifPresent(r -> {
            r.setConfirmada(true);
            reservaRepository.save(r);
        });
        return reserva;
    }

    public void deletarReservaPorLivro(Long livroId) {
        Optional<Reserva> reserva = reservaRepository.findById(livroId);
        reserva.ifPresent(r -> reservaRepository.delete(r));
    }
}