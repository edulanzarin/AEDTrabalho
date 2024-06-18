package project.functions;

import project.model.ConteudoHtml;
import project.model.TagIncorreta;
import project.model.TagOcorrencia;
import project.core.ListaEncadeada;
import project.core.NoLista;
import project.core.PilhaLista;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe para análise de tags HTML em um conteúdo HTML.
 */
public class AnalisarHtml {
    private PilhaLista<String> tagsEncontradas;
    private TagOcorrencia ocorrenciasCorretas;
    private ListaEncadeada<TagIncorreta> tagsIncorretas;
    private String[] singletonTags;

    /**
     * Construtor padrão da classe AnalisarHtml.
     * Inicializa as estruturas de dados necessárias.
     */
    public AnalisarHtml() {
        tagsEncontradas = new PilhaLista<>();
        ocorrenciasCorretas = new TagOcorrencia();
        tagsIncorretas = new ListaEncadeada<>();
        inicializarSingletonTags();
    }

    /**
     * Inicializa o array de singleton tags.
     */
    private void inicializarSingletonTags() {
        singletonTags = new String[]{
            "meta", "base", "br", "col", "command", "embed", "hr", "img",
            "input", "link", "param", "source", "!doctype"
        };
    }

    /**
     * Verifica se a tag é uma singleton tag.
     * 
     * @param tagName Nome da tag a ser verificada
     * @return true se a tag for singleton, false caso contrário
     */
    private boolean isSingletonTag(String tagName) {
        for (String tag : singletonTags) {
            if (tag.equals(tagName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Extrai as tags HTML corretas e incorretas de um conteúdo HTML.
     *
     * @param conteudoHtml Conteúdo HTML a ser analisado.
     */
    public void analisarTags(ConteudoHtml conteudoHtml) {
        if (conteudoHtml.estaVazio()) {
            return;
        }

        String htmlContent = conteudoHtml.getConteudo();

        // Expressão regular para encontrar tags HTML
        String regexTag = "<\\s*(\\w+)([^>]*)>|<\\s*/\\s*(\\w+)\\s*>";

        Pattern patternTag = Pattern.compile(regexTag, Pattern.DOTALL);
        Matcher matcher = patternTag.matcher(htmlContent);

        // Limpar as estruturas antes de iniciar uma nova análise
        tagsEncontradas.limpar();
        tagsIncorretas.limpar();
        ocorrenciasCorretas.limpar();

        while (matcher.find()) {
            String tagAbertura = matcher.group(1);
            String tagFechamento = matcher.group(3);

            if (tagAbertura != null) {
                String tagName = tagAbertura.toLowerCase();
                if (!isSingletonTag(tagName)) {
                    tagsEncontradas.push(tagName);
                }
            } else if (tagFechamento != null) {
                String tagName = tagFechamento.toLowerCase();

                if (!tagsEncontradas.estaVazia()) {
                    String tagAberta = tagsEncontradas.pop();
                    if (!tagName.equals(tagAberta)) {
                        tagsIncorretas.adicionar(new TagIncorreta(2, tagName));
                        tagsIncorretas.adicionar(new TagIncorreta(1, tagAberta));
                    } else {
                        ocorrenciasCorretas.contarOcorrencias(tagName);
                    }
                } else {
                    tagsIncorretas.adicionar(new TagIncorreta(2, tagName));
                }
            }
        }

        // Adiciona as tags abertas sem fechamento na lista de tags incorretas
        while (!tagsEncontradas.estaVazia()) {
            String tagAbertaSemFechamento = tagsEncontradas.pop();
            tagsIncorretas.adicionar(new TagIncorreta(1, tagAbertaSemFechamento));
        }
    }

    /**
     * Obtém as tags HTML corretas encontradas durante a análise.
     *
     * @return Array de Strings com as tags corretas.
     */
    public String[] getTagsCorretas() {
        return ocorrenciasCorretas.getTags();
    }

    /**
     * Obtém as ocorrências das tags HTML corretas encontradas.
     *
     * @return Array de inteiros com as ocorrências das tags corretas.
     */
    public int[] getOcorrenciasCorretas() {
        return ocorrenciasCorretas.getOcorrencias();
    }

    /**
     * Obtém as tags HTML incorretas encontradas durante a análise.
     *
     * @return Vetor de objetos TagIncorreta com os erros de tags.
     */
    public TagIncorreta[] getTagsIncorretas() {
        return toArrayTagsIncorretas(tagsIncorretas);
    }

    /**
     * Converte uma ListaEncadeada de TagIncorreta em um array de TagIncorreta.
     *
     * @param lista Lista encadeada de TagIncorreta.
     * @return Array de TagIncorreta.
     */
    private TagIncorreta[] toArrayTagsIncorretas(ListaEncadeada<TagIncorreta> lista) {
        TagIncorreta[] array = new TagIncorreta[lista.obterComprimento()];
        NoLista<TagIncorreta> noAtual = lista.getPrimeiro();
        int i = 0;
        while (noAtual != null) {
            array[i++] = noAtual.getInfo();
            noAtual = noAtual.getProximo();
        }
        return array;
    }
}
