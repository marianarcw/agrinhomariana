document.addEventListener('DOMContentLoaded', () => {
    // ---- Funcionalidade do Pop-up para "clique aqui!" ----
    // Seleciona o elemento que contém o texto "Para ter uma experiência incrível clique aqui!"
    const ctaText = document.querySelector('.cta-text');
    // Seleciona o pop-up que deve aparecer/desaparecer
    const popupInfo = document.getElementById('popupInfo');

    // Verifica se os elementos existem na página antes de adicionar os listeners
    if (ctaText && popupInfo) {
        // Adiciona um 'ouvinte de evento' para o clique no texto do CTA
        ctaText.addEventListener('click', () => {
            // Alterna a propriedade 'display' do pop-up
            // Se estiver 'block' (visível), muda para 'none' (invisível)
            // Se estiver 'none' (invisível), muda para 'block' (visível)
            if (popupInfo.style.display === 'block') {
                popupInfo.style.display = 'none';
            } else {
                popupInfo.style.display = 'block';
            }
        });

        // Opcional: Esconde o pop-up quando o usuário clica em qualquer lugar FORA do texto do CTA e do próprio pop-up
        document.addEventListener('click', (event) => {
            // 'event.target' é o elemento onde o clique ocorreu
            // 'ctaText.contains(event.target)' verifica se o clique foi DENTRO do ctaText
            // 'popupInfo.contains(event.target)' verifica se o clique foi DENTRO do popupInfo
            // Se o clique NÃO foi dentro de nenhum deles, então esconde o pop-up
            if (!ctaText.contains(event.target) && !popupInfo.contains(event.target)) {
                popupInfo.style.display = 'none';
            }
        });
    }

    // ---- Funcionalidade de Navegação para mostrar/esconder seções ----
    // Seleciona todos os links dentro da seção de navegação
    const navLinks = document.querySelectorAll('.navigation-section ul li a');
    // Seleciona todas as seções que inicialmente estão escondidas (elas têm a classe 'hidden-section')
    const hiddenSections = document.querySelectorAll('.hidden-section');

    // Itera sobre cada link de navegação
    navLinks.forEach(link => {
        // Adiciona um ouvinte de evento para cada link
        link.addEventListener('click', (event) => {
            event.preventDefault(); // Impede o comportamento padrão do link (que seria rolar para a âncora imediatamente)

            // Pega o ID da seção alvo a partir do atributo 'href' do link (ex: '#cursos' -> 'cursos')
            const targetId = link.getAttribute('href').substring(1);
            // Encontra o elemento da seção alvo usando o ID
            const targetSection = document.getElementById(targetId);

            // Verifica se a seção alvo realmente existe
            if (targetSection) {
                // Primeiro, esconde todas as outras seções escondidas para que apenas uma fique visível por vez
                hiddenSections.forEach(section => {
                    if (section.id !== targetId) { // Esconde todas, exceto a que foi clicada
                        section.style.display = 'none';
                    }
                });

                // Agora, alterna o display da seção clicada
                if (targetSection.style.display === 'block') {
                    targetSection.style.display = 'none'; // Se já estiver visível, esconde
                } else {
                    targetSection.style.display = 'block'; // Se estiver escondida, mostra
                }

                // Opcional: Rola a página suavemente para a seção se ela se tornar visível
                if (targetSection.style.display === 'block') {
                    targetSection.scrollIntoView({ behavior: 'smooth', block: 'start' });
                }
            }
        });
    });
});