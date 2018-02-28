package com.liuyq.contacts;

/**
 * Created by Administrator on 2017-10-15.
 * 用于处理Contact对象的持久化
 */
//@Repository  //  它用于将数据访问层 (DAO 层 ) 的类标识为 Spring Bean
public class ContactRepository {
   /* private JdbcTemplate jdbc;

    @Autowired
    public ContactRepository(JdbcTemplate jdbc){   //注入JdbcTemplate
        this.jdbc = jdbc;
    }
    public List<Contact> findAll() {
        return jdbc.query("select id,firstName,lastName,phoneNumber,emailAddress from contacts order by lastName",
                new RowMapper<Contact>() {
                    @Override
                    public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
                       Contact contact = new Contact();
                       contact.setId(resultSet.getLong(1));
                       contact.setFirstName(resultSet.getString(2));
                       contact.setLastName(resultSet.getString(3));
                       contact.setPhoneNumber(resultSet.getNString(4));
                       contact.setEmailAddress(resultSet.getString(5));
                       return contact;
                    }
                });
    }

    public void save(Contact contact) {
        jdbc.update("insert into contacts (firstName, laseName, phoneNumber, emailAddress) VALUES (?,?,?,?)",
                contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getEmailAddress() );
    }*/
}
