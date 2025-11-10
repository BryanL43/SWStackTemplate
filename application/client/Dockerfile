# ======================================
# Base Stage
# ======================================
FROM node:24-alpine AS builder

WORKDIR /app

# Build args & environment
ARG VITE_STRICT_MODE=false
ENV VITE_STRICT_MODE=$VITE_STRICT_MODE

# Copy dependency files & clean install
COPY package*.json ./
RUN npm ci

# Copy the project & build
COPY . .
RUN npm run build

# ======================================
# Runtime Stage (for both dev & prod)
# ======================================
FROM alpine:latest AS export

WORKDIR /app

# Copy build output from previous stage
COPY --from=builder /app/dist ./dist
