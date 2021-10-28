/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.reto34.reto34.service;

import co.usa.ciclo3.reto34.reto34.modelo.Score;
import co.usa.ciclo3.reto34.reto34.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pavilion
 */
@Service
public class ServiceScore {
    @Autowired
    private ScoreRepository scoreService;
	
    public List<Score> getAll(){
	return scoreService.getAll();
    }
	
    public Optional<Score> getScore(int idScore) {
	return scoreService.getScore(idScore);
    }
	
    public Score save(Score score){
	if(score.getIdScore()==null){
	    return scoreService.save(score);
	}else{
	    Optional<Score> scoreAux=scoreService.getScore(score.getIdScore());
	    if(scoreAux.isEmpty()){
	        return scoreService.save(score);
	    }else{
	        return score;
                 }
            }
    }
	
    public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> scoreAux= scoreService.getScore(score.getIdScore());
            if(!scoreAux.isEmpty()){
                if(score.getStars()!=null){
                    scoreAux.get().setStars(score.getStars());   
                }
                scoreService.save(scoreAux.get());
                return scoreAux.get();
            }else{
                return score;
            }
        }else{
            return score;
        }
    }

    public boolean delete(int idScore) {
        Boolean aBoolean = getScore(idScore).map(score -> {
            scoreService.delete(score);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
