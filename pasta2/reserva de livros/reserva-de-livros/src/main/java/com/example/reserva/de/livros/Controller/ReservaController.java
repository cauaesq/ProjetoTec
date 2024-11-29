package com.example.reserva.de.livros.Controller;

import com.exemple.reserva.de.livros.model.Reserva;
import com.example.reserva.de.livros.repository.ReservaRepository;
import com.example.reserva.de.livros.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private LivroRepository livroRepository;

    // Criar uma reserva
    @PostMapping("/novaReserva") // URL personalizada
    public ResponseEntity<?> criarReserva(@RequestParam Long livroId, @RequestParam String usuario) {
        return livroRepository.findById(livroId)
                .map(livro -> {
                    if (livro.getReservado()) {
                        return ResponseEntity.badRequest().body("Livro já reservado.");
                    }

                    livro.setReservado(true);
                    livroRepository.save(livro);

                    Reserva reserva = new Reserva();
                    reserva.setNomeLivro(livro);
                    reserva.setNomeUsuario(usuario);
                    reserva.setDataReserva(LocalDate.now());
                    reserva.setDataDevolucao(LocalDate.now().plusDays(7)); // Exemplo: devolução em 7 dias

                    reservaRepository.save(reserva);
                    return ResponseEntity.ok(reserva);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todas as reservas
    @GetMapping
    public ResponseEntity<List<Reserva>> listarReservas() {
        return ResponseEntity.ok(reservaRepository.findAll());
    }

    @PutMapping("/{id}/confirmar")
    public ResponseEntity<?> confirmarReserva(@PathVariable Long id) {
        return reservaRepository.findById(id)
                .map(reserva -> {
                    if (reserva.isConfirmada()) {
                        return ResponseEntity.badRequest().body("A reserva já está confirmada.");
                    }
                    reserva.setConfirmada(true);
                    reservaRepository.save(reserva);
                    return ResponseEntity.ok(reserva);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para deletar reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarReserva(@PathVariable Long id) {
        return reservaRepository.findById(id)
                .map(reserva -> {
                    reservaRepository.delete(reserva);
                    return ResponseEntity.ok("Reserva deletada com sucesso.");
                })
                .orElse(ResponseEntity.notFound().build());
    }
}