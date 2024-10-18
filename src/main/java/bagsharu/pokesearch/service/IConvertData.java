package bagsharu.pokesearch.service;

public interface IConvertData {

    <T> T convertData(String json, Class<T> classe);
}