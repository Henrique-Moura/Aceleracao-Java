package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
	public List<Team> teamList = new ArrayList<>();
	public List<Player> playerList = new ArrayList<>();


	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if(teamExists(id)) {
			throw new IdentificadorUtilizadoException();
		}

		Team newTime = new Team(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);

		teamList.add(newTime);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if(playerExists(id)) {
			throw new IdentificadorUtilizadoException();
		}

		if (!teamExists(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		Player newPlayer = new Player(id, idTime, nome, dataNascimento, nivelHabilidade, salario);

		playerList.add(newPlayer);
	}

	public void definirCapitao(Long idJogador) {
		if (!playerExists(idJogador)) {
			throw new JogadorNaoEncontradoException();
		}
		for (Player player : playerList) {
			if (player.getId().equals(idJogador)) {
				player.setCapitao(true);
			}
		}

	}

	public Long buscarCapitaoDoTime(Long idTime) {

		if(!teamExists(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		for (Player player : playerList) {
			if (!player.getIdTime().equals(idTime)) {
				throw new TimeNaoEncontradoException();
			}

			if (player.getIdTime().equals(idTime) && !player.getCapitao()) {
				throw new CapitaoNaoInformadoException();
			}

			if(player.getIdTime().equals(idTime) && player.getCapitao()) {
				return player.getId();
			}
		}
		throw new CapitaoNaoInformadoException();
	}

	public String buscarNomeJogador(Long idJogador) {
		String playerName = "";
		if (!playerExists(idJogador)) {
			throw new JogadorNaoEncontradoException();
		}
		for (Player player : playerList) {
			if (player.getId().equals(idJogador)) {
				playerName = player.getNome();
			}
		}
		return  playerName;
	}

	public String buscarNomeTime(Long idTime) {
		String timeName = "";
		if(!teamExists(idTime)) {
			throw new TimeNaoEncontradoException();
		}
		for (Team time : teamList) {
			if (time.getId().equals(idTime)){
				timeName = time.getNome();
			}
		}
		return timeName;
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		List<Long> idPlayers = new ArrayList<>();

		if(!teamExists(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		for (Player player : playerList) {
			if (player.getIdTime().equals(idTime)) {
				idPlayers.add(player.getId());
			}
		}

		idPlayers.sort(Comparator.naturalOrder());
		return idPlayers;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		int overall = 0;
		Long bestPlayer = 0L;

		if(!teamExists(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		for (Player player : playerList) {
			if(player.getIdTime().equals(idTime)) {
				if (player.getNivelHabilidade() > overall) {
					overall = player.getNivelHabilidade();
					bestPlayer = player.getId();
				}
			}
		}

		return bestPlayer;
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		Long olderPlayer = 0L;
		int year = 9999;

		if(!teamExists(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		for (Player player : playerList) {
			if(player.getIdTime().equals(idTime)) {
				if (player.getDataNascimento().getYear() < year) {
					year = player.getDataNascimento().getYear();
					olderPlayer = player.getId();
				}
			}
		}

		return olderPlayer;
	}

	public List<Long> buscarTimes() {
		List<Long> idTeams = new ArrayList<>();
		for (Team time: teamList) {
			idTeams.add(time.getId());
		}
		return idTeams;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		BigDecimal salary = BigDecimal.valueOf(0);
		Long highestSalary = 0L;

		if(!teamExists(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		for (Player player : playerList) {
			if(player.getIdTime().equals(idTime)) {
				if (player.getSalario().compareTo(salary) > 0) {
					salary = player.getSalario();
					highestSalary = player.getId();
				}
			}
		}

		return highestSalary;
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		BigDecimal playerSalary = BigDecimal.valueOf(0);
		if (!playerExists(idJogador)) {
			throw new JogadorNaoEncontradoException();
		}
		for (Player player : playerList) {
			if (player.getId().equals(idJogador)) {
				playerSalary = player.getSalario();
			}
		}
		return  playerSalary;
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> idTopPlayers = new ArrayList<>();
		int overall = 0;

		if (playerList.size() == 0) {
			return idTopPlayers;
		}

		for (Player player : playerList) {
			if (player.getNivelHabilidade() > overall) {
				overall = player.getNivelHabilidade();
				idTopPlayers.add(player.getId());
				idTopPlayers.sort(Comparator.reverseOrder());
			}
		}

		idTopPlayers = idTopPlayers.subList(0, top);
		return idTopPlayers;
	}

	public Boolean teamExists(Long id) {
		for (Team team : teamList) {
			if (team.getId().equals(id)) {
				return true;
			}
		}

		return false;
	}

	public Boolean playerExists(Long id) {
		for (Player player : playerList) {
			if (player.getId().equals(id)) {
				return true;
			}
		}

		return false;
	}

}
