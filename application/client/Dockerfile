# ======================================
# Base Stage
# ======================================
FROM node:24-alpine AS base
WORKDIR /app

# Build args & environment
ARG VITE_STRICT_MODE=false
ENV VITE_STRICT_MODE=$VITE_STRICT_MODE

# Install dependencies
COPY package*.json ./
RUN npm ci

# Copy source code
COPY . .

# ======================================
# Build Stage (for production)
# ======================================
FROM base AS builder
RUN npm run build

# ======================================
# Runtime Stage (for both dev & prod)
# ======================================
FROM node:24-alpine AS runtime
WORKDIR /app

# Copy node_modules for dev server & dist for prod
COPY --from=base /app/node_modules ./node_modules
COPY --from=base /app/package*.json ./
COPY --from=base /app/vite.config.* ./
COPY --from=base /app/index.html ./
COPY --from=base /app/src ./src
COPY --from=base /app/public ./public
COPY --from=builder /app/dist ./dist

# Environment-controlled mode (default = prod)
ARG MODE=prod
ENV MODE=$MODE

EXPOSE 5173

# Run dev server or do nothing (build mode handled by Compose)
CMD ["sh", "-c", "if [ \"$MODE\" = 'local' ]; then npm run dev; else echo 'Production build ready in /app/dist'; fi"]
