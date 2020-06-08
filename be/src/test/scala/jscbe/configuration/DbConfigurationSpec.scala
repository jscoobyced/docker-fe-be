package jscbe.configuration

import jscbe.BaseTest

class DbConfigurationSpec extends BaseTest {

  describe("DbConfiguration") {
    it("should load the default values") {
      val password = DbConfiguration.getPassword
      val username = DbConfiguration.getUsername
      val url      = DbConfiguration.getUrl
      assert(password == "test")
      assert(username == "test")
      assert(url == "test")
    }
  }
}
