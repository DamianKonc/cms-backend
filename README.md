# CMS – Backend + Database (Learning Project)

## 📌 About the project

This repository contains a **learning / educational backend project** built with:

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose

The goal of this project is to **learn backend development**, clean architecture, authentication, and database integration.

This is **NOT a production-ready application**.

---

## ⚠️ Important – Usage Restrictions

🚨 **THIS PROJECT IS FOR EDUCATIONAL PURPOSES ONLY**

- ❌ Not intended for production use
- ❌ Not security-hardened
- ❌ No SLA, guarantees, or support
- ❌ No responsibility for damages caused by misuse

If you plan to:
- use this code commercially
- integrate it into a production system
- distribute it as part of a paid product

👉 **you must obtain explicit permission from the author**.

---

## © Copyright & License

Copyright © 2025 Damian

All rights reserved.

This code may **NOT** be:
- sold
- sublicensed
- used commercially
- redistributed as your own work

without **written permission from the author**.

For commercial licensing or cooperation, contact the author directly.

---

## 🧪 Local Development Only

This project is designed to run **locally** using Docker:

```bash
docker compose up -d

## Environment variables

This project uses environment variables.

Create a `.env` file based on `.env.example`:

```bash
cp .env.example .env