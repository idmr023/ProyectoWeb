
$(document).ready(function () {
    //cuando se escriba caracteres en la caja de texto  
    $(document).on('keyup', '#txtnom', function () {
        let valor = $(this).val();
        listado(valor);

    });

    function listado(consulta) {
        opc = "5";
        $.get("control", {opc, consulta}, (response) => {
            const misDatos = JSON.parse(response);//recuperar la informacion q envio el controlador  
            let template = "";
            console.log(misDatos);

            template += `  
             <table class="table table-hover">  
                                    <thead class="text-white bg-dark">  
                                        <tr>  
                                            <th>Codigo</th>  
                                            <th>Nombre</th>  
                                            <th>apellido</th> 
                                            <th>Sexo</th> 
                                            <th>Celular</th>
                                            <th>Dias</th>
                                            <th>Fecha</th>
                                            <th>Habutacion</th>
                                           </tr>  
                                    </thead>  
                                    <tbody>`;
            misDatos.forEach(midato => {
                template += `  
                <tr>  
                <td>${midato.cli_dni}</td>  
                    <td>${midato.cli_nombre}</td>  
                    <td>${midato.cli_apellido}</td> 
                    <td>${midato.cli_genero}</td> 
                    <td>${midato.cli_celular}</td> 
                    <td>${midato.cli_num_dias}</td> 
                    <td>${midato.cli_fech_reg}</td> 
                    <td>${midato.cli_tipo_habitacion}</td> 
                    <td><a href="javascript:pasaSeleccion('${midato.cli_dni}', '${midato.cli_nombre}', 
'${midato.cli_apellido}', '${midato.cli_genero}', '${midato.cli_celular}', '${midato.cli_num_dias}', '${midato.cli_fech_reg}', '${midato.cli_tipo_habitacion}');"> 
</a> 
                                </tr>`;

            })
            template += `</tbody></table>`;
            $("#tablares").html(template);

        })
    } //fin de listado 

})
    