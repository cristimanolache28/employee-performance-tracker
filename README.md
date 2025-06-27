# 📌 Employee Performance Tracker System (**SpringBoot** Backend API) 

--- 

## 📋 Project Overview 

A backend system built with Spring Boot for managing employees, performance evaluations, and skill progression within an organization.

The main goal is to track employee performance based on points earned through their skills, the level of each skill, and a sub-level associated with every skill level.

Based on total points earned, employees are assigned an organizational hierarchy level.

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

