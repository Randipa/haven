# Haven Project

This repository contains a Spring Boot backend and a React frontend.

## Email Notifications

The backend uses Spring Mail to send notification emails when:

- A user logs in.
- A user updates profile details.
- A user changes their password.
- A user deletes their profile.
- An admin deletes a user profile.
- A new adoption post is created.
- An adoption post is approved or rejected.

To enable email sending, configure the following environment variables before running the backend:

```
MAIL_HOST     # e.g. smtp.gmail.com
MAIL_PORT     # e.g. 587
MAIL_USERNAME # your SMTP username
MAIL_PASSWORD # your SMTP password or app password
```

If no variables are provided, the backend defaults to Gmail's SMTP host and port.

The configured `MAIL_USERNAME` (or `spring.mail.username`) is used as the sender
address for all outgoing emails.
