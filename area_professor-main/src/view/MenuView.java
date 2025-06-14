package view;
import controller.*;
import factory.*;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import util.PreCarga;

public class MenuView {

    static Scanner sc = new Scanner(System.in);
    static Aluno[] alunos = {
            new Aluno("Ana", "A001"),
            new Aluno("Bruno", "A002"),
            new Aluno("Carla", "A003")
    };

    public static void main(String[] args) {
        ProfessorController professorController = new ProfessorController();
        FaltaController faltaController = new FaltaController();
        NotaController notaController = new NotaController();
        AtividadeController atividadeController = new AtividadeController();

        PreCarga.initializeData(professorController, faltaController, notaController, atividadeController);

        int op;
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Professores");
            System.out.println("2. Faltas");
            System.out.println("3. Notas");
            System.out.println("4. Atividades");
            System.out.println("0. Sair");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 ->
                    crudProfessores(professorController);
                case 2 ->
                    crudFaltas(faltaController);
                case 3 ->
                    crudNotas(notaController);
                case 4 ->
                    crudAtividades(atividadeController);
                case 0 ->
                    System.out.println("Saindo..");
                default ->
                    System.out.println("Escolha uma opção válida!");
            }
        } while (op != 0);
    }

    static void crudProfessores(ProfessorController pc) {
        int op;
        do {
            System.out.println("\n-- Professores --");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Editar");
            System.out.println("4. Excluir");
            System.out.println("0. Voltar");

            op = sc.nextInt();
            sc.nextLine();

            try {
                switch (op) {
                    case 1 -> {
                        try {
                            System.out.print("Nome: ");
                            String nome = sc.nextLine();
                            System.out.print("CPF: ");
                            String cpf = sc.nextLine();
                            System.out.print("Disciplina: ");
                            String disciplina = sc.nextLine();
                            pc.cadastrar(nome, cpf, disciplina);
                            System.out.println("Professor cadastrado com sucesso!");
                        } catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        ArrayList<Professor> list = pc.listar();
                        if (list.isEmpty()) {
                            System.out.println("Não há professores cadastrados!");
                            break;
                        }
                        for (int i = 0; i < list.size(); i++) {
                            Professor p = list.get(i);
                            System.out.println("[" + (i + 1) + "] " + p.getNome() + " - " + p.getCpf() + " - "
                                    + p.getDisciplina());
                        }
                    }
                    case 3 -> {

                        ArrayList<Professor> list = pc.listar();
                        if (list.isEmpty()) {
                            System.out.println("Não há professores cadastrados para editar!");
                            break;
                        }
                        for (int i = 0; i < list.size(); i++) {
                            Professor p = list.get(i);
                            System.out.println("[" + (i + 1) + "] " + p.getNome() + " - " + p.getCpf() + " - "
                                    + p.getDisciplina());
                        }

                        try {
                            System.out.print("Índice: ");
                            int idx = MenuController.lerIndiceValido(list.size(), sc);
                            System.out.print("Nome: ");
                            String nome = sc.nextLine();
                            System.out.print("CPF: ");
                            String cpf = sc.nextLine();
                            System.out.print("Disciplina: ");
                            String disc = sc.nextLine();
                            pc.editar(idx, nome, cpf, disc);
                            System.out.println("Professor editado com sucesso!");
                        } catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                        }

                    }
                    case 4 -> {
                        ArrayList<Professor> list = pc.listar();
                        if (list.isEmpty()) {
                            System.out.println("Não há professores cadastrados para excluir!");
                            break;
                        }
                        for (int i = 0; i < list.size(); i++) {
                            Professor p = list.get(i);
                            System.out.println("[" + (i + 1) + "] " + p.getNome() + " - " + p.getCpf() + " - "
                                    + p.getDisciplina());
                        }

                        System.out.print("Índice: ");
                        int idx = MenuController.lerIndiceValido(list.size(), sc);
                        pc.excluir(idx);
                        System.out.println("Professor excluído com sucesso!");
                    }
                    case 0 -> System.out.println("Voltando...");
                    default -> System.out.println("Escolha uma opção válida!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (op != 0);
    }

    static void crudFaltas(FaltaController fc) {
        int op;
        do {
            try {
                System.out.println("\n-- Faltas --");
                System.out.println("1. Cadastrar");
                System.out.println("2. Listar");
                System.out.println("3. Editar");
                System.out.println("4. Excluir");
                System.out.println("0. Voltar");
                op = sc.nextInt();
                sc.nextLine();

                try {
                    switch (op) {
                        case 1 -> {
                            try {
                                String mat = escolherAluno();
                                System.out.print("Motivo: ");
                                String motivo = sc.nextLine();
                                fc.cadastrar(FaltaFactory.criar(mat, motivo));
                                System.out.println("Falta cadastrada com sucesso!");
                            } catch (Exception e) {
                                System.out.println("Erro ao cadastrar falta: " + e.getMessage());
                            }
                        }
                        case 2 -> {
                            try {
                                var list = fc.listar();
                                if (list.isEmpty()) {
                                    System.out.println("Não há faltas cadastradas!");
                                    break;
                                }
                                for (int i = 0; i < list.size(); i++) {
                                    System.out.println("[" + (i + 1) + "] " + list.get(i).exibir());
                                }
                            } catch (Exception e) {
                                System.out.println("Erro ao listar faltas: " + e.getMessage());
                            }
                        }
                        case 3 -> {
                            try {

                                var list = fc.listar();
                                if (list.isEmpty()) {
                                    System.out.println("Não há faltas cadastradas para editar!");
                                    break;
                                }
                                for (int i = 0; i < list.size(); i++) {
                                    System.out.println("[" + (i + 1) + "] " + list.get(i).exibir());
                                }

                                System.out.print("Índice: ");
                                int idx = MenuController.lerIndiceValido(list.size(), sc);
                                System.out.print("Nova descrição: ");
                                fc.editar(idx, sc.nextLine());
                                System.out.println("Falta editada com sucesso!");
                            } catch (Exception e) {
                                System.out.println("Erro ao editar falta: " + e.getMessage());
                            }
                        }
                        case 4 -> {
                            try {
                                var list = fc.listar();
                                if (list.isEmpty()) {
                                    System.out.println("Não há faltas cadastradas para excluir!");
                                    break;
                                }
                                for (int i = 0; i < list.size(); i++) {
                                    System.out.println("[" + (i + 1) + "] " + list.get(i).exibir());
                                }

                                System.out.print("Índice: ");
                                int idx = MenuController.lerIndiceValido(list.size(), sc);
                                fc.excluir(idx);
                                System.out.println("Falta excluida com sucesso!");

                            } catch (Exception e) {
                                System.out.println("Erro ao excluir falta: " + e.getMessage());
                            }
                        }
                        case 0 -> System.out.println("Voltando...");
                        default -> System.out.println("Escolha uma opção válida!");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } catch (Exception e) {
                System.out.println("Erro no menu de faltas: " + e.getMessage());
                sc.nextLine();
                op = -1;
            }
        } while (op != 0);
    }

    static void crudNotas(NotaController nc) {
        int op;
        do {
            try {
                System.out.println("\n-- Notas --");
                System.out.println("1. Cadastrar");
                System.out.println("2. Listar");
                System.out.println("3. Editar");
                System.out.println("4. Excluir");
                System.out.println("0. Voltar");
                op = sc.nextInt();
                sc.nextLine();

                switch (op) {
                    case 1 -> {
                        try {
                            String mat = escolherAluno();
                            System.out.print("Descrição: ");
                            String desc = sc.nextLine();
                            System.out.print("Valor: ");
                            double val = sc.nextDouble();
                            sc.nextLine();
                            nc.cadastrar(NotaFactory.criar(mat, desc, val));
                            System.out.println("Nota cadastrada com sucesso!");

                        } catch (Exception e) {
                            System.out.println("Erro ao cadastrar nota: " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        try {
                            var list = nc.listar();
                            if (list.isEmpty()) {
                                System.out.println("Não há notas cadastradas!");
                                break;
                            }
                            for (int i = 0; i < list.size(); i++) {
                                System.out.println("[" + (i + 1) + "] " + list.get(i).exibir());
                            }

                        } catch (Exception e) {
                            System.out.println("Erro ao listar notas: " + e.getMessage());
                        }
                    }
                    case 3 -> {
                        try {
                            var list = nc.listar();
                            if (list.isEmpty()) {
                                System.out.println("Não há notas cadastradas para editar!");
                                break;
                            }
                            for (int i = 0; i < list.size(); i++) {
                                System.out.println("[" + (i + 1) + "] " + list.get(i).exibir());
                            }

                            System.out.print("Índice: ");
                            int idx = MenuController.lerIndiceValido(list.size(), sc);
                            System.out.print("Nova descrição: ");
                            String desc = sc.nextLine();
                            System.out.print("Novo valor: ");
                            double val = sc.nextDouble();
                            sc.nextLine();
                            nc.editarNota(idx, desc, val);
                            System.out.println("Nota editada com sucesso!");

                        } catch (Exception e) {
                            System.out.println("Erro ao editar nota: " + e.getMessage());
                        }
                    }
                    case 4 -> {
                        try {
                            var list = nc.listar();
                            if (list.isEmpty()) {
                                System.out.println("Não há notas cadastradas para excluir!");
                                break;
                            }
                            for (int i = 0; i < list.size(); i++) {
                                System.out.println("[" + (i + 1) + "] " + list.get(i).exibir());
                            }

                            System.out.print("Índice: ");
                            int idx = MenuController.lerIndiceValido(list.size(), sc);
                            nc.excluir(idx);
                            System.out.println("Nota excluida com sucesso!");

                        } catch (Exception e) {
                            System.out.println("Erro ao excluir nota: " + e.getMessage());
                        }
                    }
                    case 0 -> System.out.println("Voltando...");
                    default -> System.out.println("Escolha uma opção válida!");
                }

            } catch (Exception e) {
                System.out.println("Erro no menu de notas: " + e.getMessage());
                sc.nextLine();
                op = -1;
            }
        } while (op != 0);
    }

    static void crudAtividades(AtividadeController ac) {
        int op;
        do {
            System.out.println("\n-- Atividades --");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Editar");
            System.out.println("4. Excluir");
            System.out.println("5. Lançar para turma");
            System.out.println("0. Voltar");
            op = sc.nextInt();
            sc.nextLine();
            try {
                switch (op) {
                    case 1 -> {
                        try {
                            String mat = escolherAluno();
                            System.out.print("Descrição: ");
                            String desc = sc.nextLine();
                            ac.cadastrar(AtividadeFactory.criar(mat, desc));
                            System.out.println("Atividade cadastrada com sucesso!");

                        } catch (Exception e) {
                            System.out.println("Erro ao cadastrar atividade: " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        try {
                            var list = ac.listar();
                            if (list.isEmpty()) {
                                System.out.println("Não há atividades cadastradas!");
                                break;
                            }
                            for (int i = 0; i < list.size(); i++) {
                                System.out.println("[" + (i + 1) + "] " + list.get(i).exibir());
                            }

                        } catch (Exception e) {
                            System.out.println("Erro ao listar atividades: " + e.getMessage());
                        }
                    }
                    case 3 -> {
                        try {
                            var list = ac.listar();
                            if (list.isEmpty()) {
                                System.out.println("Não há atividades cadastradas para editar!");
                                break;
                            }
                            for (int i = 0; i < list.size(); i++) {
                                System.out.println("[" + (i + 1) + "] " + list.get(i).exibir());
                            }

                            System.out.print("Índice: ");
                            int idx = MenuController.lerIndiceValido(list.size(), sc);
                            System.out.print("Nova descrição: ");
                            ac.editar(idx, sc.nextLine());
                            System.out.println("Atividade editada com sucesso!");

                        } catch (Exception e) {
                            System.out.println("Erro ao editar atividade: " + e.getMessage());
                        }
                    }
                    case 4 -> {
                        try {
                            var list = ac.listar();
                            if (list.isEmpty()) {
                                System.out.println("Não há atividades excluir!");
                                break;
                            }
                            for (int i = 0; i < list.size(); i++) {
                                System.out.println("[" + (i + 1) + "] " + list.get(i).exibir());
                            }

                            System.out.print("Índice: ");
                            int idx = MenuController.lerIndiceValido(list.size(), sc);
                            ac.excluir(idx);
                            System.out.println("Atividade excluida com sucesso!");

                        } catch (Exception e) {
                            System.out.println("Erro ao excluir atividade: " + e.getMessage());
                        }
                    }
                    case 5 -> {
                        try {
                            System.out.print("Descrição: ");
                            ac.lancarParaTurma(alunos, sc.nextLine());
                            System.out.println("Atividade lançada para toda a turma!");

                        } catch (Exception e) {
                            System.out.println("Erro ao lançar atividade para turma: " + e.getMessage());
                        }
                    }
                    case 0 -> System.out.println("Voltando...");
                    default -> System.out.println("Escolha uma opção válida!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (op != 0);
    }

    static String escolherAluno() {
        for (Aluno a : alunos) {
            System.out.println(a.getMatricula() + " - " + a.getNome());
        }
        System.out.print("Escolha matrícula: ");
        return sc.nextLine();
    }
}