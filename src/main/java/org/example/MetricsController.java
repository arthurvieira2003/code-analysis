package org.example;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class MetricsController {
    public static Map<String,Integer> metrics=new HashMap<>(); // Variável pública e estática
    private static final int MAX_METRICS = 1000;
    
    @GetMapping("/metrics")
    public Map<String,Integer> getMetrics(){return metrics;} // Retorno direto do estado interno
    
    @PostMapping("/metrics/{name}")
    public void incrementMetric(@PathVariable String name){
        if(metrics.containsKey(name)){metrics.put(name,metrics.get(name)+1);}else{metrics.put(name,1);}
    } // Formatação ruim e lógica complexa
    
    @DeleteMapping("/metrics/{name}")
    public void deleteMetric(@PathVariable String name) {
        metrics.remove(name);
    }
}
