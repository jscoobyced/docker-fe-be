package jscbe.models.http

abstract class AbstractResponse[T](data: Option[T] = None, error: Option[String] = None)
