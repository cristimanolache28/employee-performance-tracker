# 📌 Employee Performance Tracker System (**SpringBoot** Backend API) 

--- 

## 📋 Project Overview 
A backend system built with Spring Boot for managing employees, performance evaluations, and skill progression within an organization.
The main goal is to track employee performance based on points earned through their skills, the level of each skill, and a sub-level associated with every skill level.
Based on total points earned, employees are assigned an organizational hierarchy level.

## 💻 Technologies Used 
* **Programming Language:** Java
* **Framework:** Spring Boot (Spring Data JPA, Spring Security, Spring Web, Spring Validation, Spring Test)
* **Database:** MySQL
* **ORM:** Hibernate
* **Security:** Spring Security, JSON Web Tokens (JWT)
* **Build Tool:** Maven
* **Testing:** JUnit, Mockito

## 🧩 Database Relationships 
[![Database Relationships](images/database-relationships.png)](images/database-relationships.png)

## 🧠 Core Entities & Relationships
* **User:** `id`, `email`, `password`, `is_active`, `create_at`, `update_at`
* **Employee:** `id`, `first_name`, `middle_name`, `last_name`, `CNP`, `general_level`, `address`, `gender`, `education_stage`, `birthDate`, `create_at`, `update_at`, `department_id`, `company_id`, `position_id`, `user_id`
* **Company**: `id`, `name`, `country`, `location`, `address`, `industry`, `founded_date`, `description`
* **Department**: `id`, `name`, `description`, `company_id`
* **Position**: `id`, `name`, `description`, `department_id` 
* **Skill**: `id`, `name`, `skill_type`, `description`, `skill_level_id`
* **SkillLevel**: `id`, `name`, `points`, `level_stage_id` 
* **SkillLevelStage**: `id`, `name`, `points`, `description` 
* **PerformanceEvaluation**: `id`, `evaluation_date`, `score_before_evaluation`, `new_gain_point`, `total_score`, `efficiency_progress`, `notes`, `employee_id`, `evaluator_id` 
* **Role**: `id`, `name`, `description` 

### 📚 Enums
* **EducationLevel**: `NONE`, `PRIMARY`, `SECONDARY`, `BACHELOR`, `MASTER`, `DOCTORATE`
* **SkillType**: `SOFT_SKILL`, `HARD_SKILL`
* **GeneralLevel**: `NOVICE`, `ASSOCIATE`, `PROFESSIONAL`, `SENIOR`, `LEAD`, `PRINCIPAL`, `EXECUTIVE`
* **Gender**: `MALE`, `FEMALE`
* **SkillLevelName**: `BIGINNER`, `INTERMEDIATE`, `ADVANCED`, `EXPERT`, `MASTER`
* **SkillLevelStageName**:
  * *BEGINNER*: `AWARE`, `LEARNING`, `APPLYING`
  * *INTERMEDIATE*: `COMFORTABLE`, `INDEPENDENT`, `CONSISTENT`
  * *ADVANCED*: `OPTIMIZING`, `MENTORING`, `OWNING`
  * *EXPERT*: `INNOVATING`, `LEADING`, `STRATEGIC`
  * *MASTER*: `VISIONARY`, `INFLUENTIAL`, `TRAILBLAZER`
* **Industry**: `TECHNOLOGY`, `FINANCE`, `HEALTHCARE`, `EDUCATION`, `MANUFACTURING`, `RETAIL`, `TRANSPORTATION`, `ENERGY`, `REAL_ESTATE`, `ENTERTAINMENT`, `TELECOMMUNICATIONS`, `AGRICULTURE`, `CONSTRUCTION`, `HOSPITALITY`, `PROFESSIONAL_SERVICES`, `GOVERNMENT`, `NON_PROFIT`

### 🔒 Authentication & Authorization

## 🚦 Getting Started
### Prerequisites
Make sure you have these installed:
* **Java Development Kit (JDK) 17**
* **Maven**
* **MySQL** database instance

### Installation & Configuration
1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/<YourUsername>/employee-performance-tracker.git](https://github.com/<YourUsername>/employee-performance-tracker.git)
    cd employee-performance-tracker
    ```
    Note: Replace "YourUsername" with your GitHub username
    
3.  **Configure your database:**
    * Create a new MySQL database (e.g., `asset_db`).
    * Open `src/main/resources/application.properties` and update your database connection details:
        ```properties
        # Example for MySQL
        spring.datasource.url=jdbc:mysql://localhost:3306/employee_performance_tracker?useSSL=false&serverTimezone=UTC
        spring.datasource.username=your_username
        spring.password=your_password
        spring.jpa.hibernate.ddl-auto=update 
        spring.jpa.show-sql=true
        ```
4.  **Build and run the application:**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
    Your application will typically start on `http://localhost:8080`.

## 💡 Possible Future Enhancements
