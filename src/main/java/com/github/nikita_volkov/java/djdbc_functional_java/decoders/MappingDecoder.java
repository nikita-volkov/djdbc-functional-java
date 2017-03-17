package com.github.nikita_volkov.java.djdbc_functional_java.decoders;

import djdbc.Decoder;
import fj.F;

import java.sql.*;

public final class MappingDecoder<result1, result2> extends Decoder.Rows<result2> {

  private final F<result1, result2> mapping;
  private final Rows<result1> initialDecoder;

  public MappingDecoder(F<result1, result2> mapping, Rows<result1> initialDecoder) {
    this.mapping = mapping;
    this.initialDecoder = initialDecoder;
  }

  @Override
  public result2 run(ResultSet resultSet) throws SQLException {
    return mapping.f(initialDecoder.run(resultSet));
  }

}
