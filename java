
document.addEventListener('DOMContentLoaded', () => {
    // Pega o botão "clique aqui!"
    const clickMeButton = document.getElementById('clickMeButton');

    // Adiciona um listener de evento de clique ao botão
    if (clickMeButton) {
        clickMeButton.addEventListener('click', () => {
            alert('Você clicou para ter uma experiência incrível! 🎉');
            // Aqui você pode adicionar funcionalidades mais complexas, por exemplo:
            // - revelar uma nova seção na página
            // - carregar conteúdo dinamicamente
            // - redirecionar para outra página, etc.
        });
    }

    // Pega o rótulo "Sementes" e seu conteúdo oculto
    const sementesLabel = document.getElementById('sementes-label');
    const sementesDetails = document.getElementById('sementes-details');

    // Adiciona um listener de evento de clique ao rótulo "Sementes"
    if (sementesLabel && sementesDetails) {
        sementesLabel.addEventListener('click', () => {
            // Alterna a exibição do conteúdo oculto
            if (sementesDetails.style.display === 'block') {
                sementesDetails.style.display = 'none';
            } else {
                sementesDetails.style.display = 'block';
            }
        });
    }

    // Funcionalidade opcional: Dropdown básico para itens de navegação (aparece no hover)
    const navItems = document.querySelectorAll('.nav-item');
    navItems.forEach(item => {
        item.addEventListener('mouseenter', () => {
            const dropdown = item.querySelector('.dropdown-content');
            if (dropdown) {
                dropdown.style.display = 'block';
            }
        });

        item.addEventListener('mouseleave', () => {
            const dropdown = item.querySelector('.dropdown-content');
            if (dropdown) {
                dropdown.style.display = 'none';
            }
        });
    });

    // Para o campo de entrada "Pesquisa"
    const searchInput = document.querySelector('.search-box input[type="text"]');
    if (searchInput) {
        searchInput.addEventListener('focus', () => {
            console.log('Teclado virtual pode aparecer aqui ou foco visual.');
            // Em uma aplicação real, você poderia:
            // - Acionar um teclado virtual personalizado.
            // - Mudar a aparência do input para indicar que está focado.
        });

        searchInput.addEventListener('input', (event) => {
            console.log('Pesquisando por:', event.target.value);
            // Em uma aplicação real, isso desencadearia uma função de busca
            // para filtrar conteúdo ou buscar resultados.
        });
    }

    // A funcionalidade "Linha verde" que menciona "aparece 2 linhas"
    // Atualmente, está apenas no dropdown de texto. Se for para revelar
    // algo mais dinâmico, seria necessário adicionar lógica aqui
    // similar à de "Sementes".
});
