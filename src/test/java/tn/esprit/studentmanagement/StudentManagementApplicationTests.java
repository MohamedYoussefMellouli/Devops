package tn.esprit.studentmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")  // ← Utilise application-test.properties
class StudentManagementApplicationTests {

    @Test
    void contextLoads() {
        // Test de base pour vérifier que le contexte Spring se charge correctement
    }

}
