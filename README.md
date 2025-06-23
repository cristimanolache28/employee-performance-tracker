# 📌 Employee Performance Tracker System (**SpringBoot** Backend API) 

--- 

## 📋 Project Overview 

A backend system built with Spring Boot for managing employees, performance evaluations, and skill progression within an organization.

The main goal is to track employee performance based on points earned through their skills, the level of each skill, and a sub-level associated with every skill level.

Based on total points earned, employees are assigned an organizational hierarchy level.

## 🧩 Database Relationships 

[![Database Relationships](images/database-relationships.png)](images/database-relationships.png)

## 🧠 Core Entities & Relationships

* **`User:`** `id`, `email`, `password`, `is_active`, `create_at`, `update_at` (One-to-One with Employee, Many-to-Many with Role via users_roles)

* **`Employee:`** `id`, `first_name`, `middle_name`, `last_name`, `CNP`, `general_level`, `address`, `gender`, `education_stage`, `birthDate`, `create_at`, `update_at`, `department_id`, `company_id`, `position_id`, `user_id`
* One-to-One with `**User**`
* Many-to-One with `**Department**`, `**Company**`, and `**Position**`
* Many-to-Many with `**Skill**` via employees_skills
* One-to-Many with `**PerformanceEvaluation**` (both evaluated and evaluator)

**Company**: id, name, country, location, address, industry, founded_date, description (One-to-Many with Department and Employee)

Department: id, name, description, company_id (One-to-Many with Employee and Position, Unique on (name, company_id))

Position: id, name, description, department_id (One-to-Many with Employee)

Skill: id, name, skill_type, description, skill_level_id (Many-to-One with SkillLevel, Many-to-Many with Employee via employees_skills)

SkillLevel: id, name, points, level_stage_id (Many-to-One with SkillLevelStage, One-to-Many with Skill)

SkillLevelStage: id, name, points, description (One-to-Many with SkillLevel)

PerformanceEvaluation: id, evaluation_date, score_before_evaluation, new_gain_point, total_score, efficiency_progress, notes, employee_id, evaluator_id (Many-to-One with Employee as both evaluated and evaluator)

Role: id, name, description (Many-to-Many with User via users_roles)

users_roles: user_id, role_id (Many-to-Many between User and Role)

employees_skills: employee_id, skill_id (Many-to-Many between Employee and Skill, Unique on (employee_id, skill_id))

📚 Enums

EducationLevel: NONE, PRIMARY, SECONDARY, BACHELOR, MASTER, DOCTORATE

SkillType: SOFT_SKILL, HARD_SKILL

GeneralLevel: L1, L2, L3, M1, M2, M3, H1, H2, H3, P1, P2, P3

Gender: MALE, FEMALE

Industry: TECHNOLOGY, FINANCE, HEALTHCARE, EDUCATION, MANUFACTURING, RETAIL, TRANSPORTATION, ENERGY, REAL_ESTATE, ENTERTAINMENT, TELECOMMUNICATIONS, AGRICULTURE, CONSTRUCTION, HOSPITALITY, PROFESSIONAL_SERVICES, GOVERNMENT, NON_PROFIT
