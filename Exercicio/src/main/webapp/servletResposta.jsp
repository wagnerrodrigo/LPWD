<%-- 
    Document   : servletResposta
    Created on : 27/09/2019, 21:44:58
    Author     : alunoces
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Questionario </h1>
        
        <form method="POST">
            <div>
                    <p>Perguntas fechadas, com a escala de 1 a 5:</p>
                <div>
                    <h5>De forma geral, como você avaliaria o curso<h5>
                    <select>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>                  
                </div>
                
                <div>
                    <h5>De forma geral, como você avaliaria o instrutor?</h5>
                        <select>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>  
                </div>                   
                    
                <div> <h5>Qual a chance de você indicar esse curso?</h5>
                    <select>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>  
                </div>
                    
                <div>
                    <h5>O conteúdo é aplicável no seu dia-a-dia?</h5>
                    <select>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>  
                </div>

            </div>

            <div>
                <h1>Afirmativas para marcação entre verdadeira/falsa:</h1>
                <div>
                    <label>Posso aplicar o que aprendi imediatamente no meu dia a dia</label>
                    <label>
                        <input type="radio" name="ops" id="ops">V
                        <input type="radio" name="ops" id="ops">F
                    </label> 
                </div>
                  <div>
                    <label>O instrutor dominava o conteudo apresentado</label>
                    <label>
                        <input type="radio" name="ops" id="ops2">V
                        <input type="radio" name="ops" id="ops2">F
                    </label> 
                </div>
                  <div>
                    <label>Todos ficaram atentos ao curso durante toda sua duração</label>
                    <label>
                        <input type="radio" name="ops" id="ops3">V
                        <input type="radio" name="ops" id="ops3">F
                    </label> 
                </div>
                  <div>
                    <label>Poucas pessoas faltaram ou se ausentaram durante o treinamento</label>
                    <label>
                        <input type="radio" name="ops" id="ops4">V
                        <input type="radio" name="ops" id="ops4">F
                    </label> 
                </div>
                  <div>
                    <label>Gostaria que houvesse outros treinamentos como esse.</label>
                    <label>
                        <input type="radio" name="ops" id="ops5">V
                        <input type="radio" name="ops" id="ops5">F
                    </label> 
                </div>
                  <div>
                    <label>Precisamos de mais aprofundamento no tema apresentado.</label>
                    <label>
                        <input type="radio" name="ops" id="ops">V
                        <input type="radio" name="ops" id="ops">F
                    </label> 
                </div>
            </div>
        </form>
    </body>
</html>
