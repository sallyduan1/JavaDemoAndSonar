package Controllers;

import Model.Player;
import Repository.PlayerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;


@RestController
@RequestMapping("api/v1/")

public class PlayerController {
@Autowired
private PlayerRepository playerRepository;

    @RequestMapping(value = "players", method = RequestMethod.GET)
    public List<Player> list(){
       return FakePlayers.list();
        //return  playerRepository.findAll();
    }

    @RequestMapping(value = "players", method = RequestMethod.POST)
    public Player create(@RequestBody Player player){
       return FakePlayers.create(player);
       // return playerRepository.saveAndFlush(player);
    }

    @RequestMapping(value = "players/{id}", method = RequestMethod.GET)
    public Player get(@PathVariable Integer id){
        return FakePlayers.get(id);
        //return playerRepository.findOne(id);
    }

    @RequestMapping(value = "players/{id}", method = RequestMethod.PUT)
    public Player update(@PathVariable Integer id, @RequestBody Player player){
       // return PlayerStub.update(id, player);
        Player p1 = playerRepository.findOne(id);
        BeanUtils.copyProperties(player, p1);
        return playerRepository.saveAndFlush(p1);
    }

    @RequestMapping(value = "players/{id}", method = RequestMethod.DELETE)
    public Player delete(@PathVariable Integer id) {
       // return PlayerStub.delete(id);
        Player p1 = playerRepository.findOne(id);
        playerRepository.delete(p1);
        return p1;
    }
}